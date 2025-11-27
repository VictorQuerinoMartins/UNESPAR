import pypdf
import nltk
import spacy
from nltk.corpus import stopwords
from string import punctuation
from sumy.parsers.plaintext import PlaintextParser
from sumy.nlp.tokenizers import Tokenizer
from sumy.summarizers.lsa import LsaSummarizer
import os
import sys
import re
import glob
import unicodedata

def config_ambiente():
    try:
        nltk.data.find('corpora/stopwords') # Verifica se as stopwords estão instaladas
    except LookupError:
        nltk.download('stopwords') # Baixa se der erro
    
    try:
        nltk.data.find('tokenizers/punkt')
        nltk.data.find('tokenizers/punkt_tab')
    except LookupError:
        nltk.download('punkt')
        nltk.download('punkt_tab')
        
    try:
        spacy.load("pt_core_news_sm") # Tenta carregar o modelo do Spacy
    except OSError:
        print("Baixando modelo Spacy...")
        os.system(f'"{sys.executable}" -m spacy download pt_core_news_sm') # Baixa automaticamente se não encontrar

config_ambiente()
nlp = spacy.load("pt_core_news_sm")

def reparar_texto_bugado(texto_entrada):
    texto_temp = texto_entrada # Função vital para PDFs antigos que separam acentos
    
    texto_temp = texto_temp.replace('-\n', '') # Remove hifens de quebra de linha
    texto_temp = texto_temp.replace('\n', ' ') # Junta linhas
    texto_temp = texto_temp.replace('\n\n', '{{PARAGRAFO}}') 
    
    # acentos separados (ex: ' ~ a' vira 'ã')
    texto_temp = re.sub(r',\s*~\s*ao', 'ão', texto_temp, flags=re.IGNORECASE) # Caso especifico c, ~ a
    texto_temp = re.sub(r',\s*~\s*a', 'ã', texto_temp, flags=re.IGNORECASE)
    texto_temp = re.sub(r'c\s*,', 'ç', texto_temp, flags=re.IGNORECASE) # Cedilha
    
    # Acento Agudo ( ' a -> á )
    texto_temp = re.sub(r"'\s*a", "á", texto_temp, flags=re.IGNORECASE)
    texto_temp = re.sub(r"'\s*e", "é", texto_temp, flags=re.IGNORECASE)
    texto_temp = re.sub(r"'\s*i", "í", texto_temp, flags=re.IGNORECASE)
    texto_temp = re.sub(r"'\s*o", "ó", texto_temp, flags=re.IGNORECASE)
    texto_temp = re.sub(r"'\s*u", "ú", texto_temp, flags=re.IGNORECASE)
    
    # Acento Circunflexo e Til
    texto_temp = re.sub(r"\^\s*a", "â", texto_temp, flags=re.IGNORECASE)
    texto_temp = re.sub(r"\^\s*e", "ê", texto_temp, flags=re.IGNORECASE)
    texto_temp = re.sub(r"\^\s*o", "ô", texto_temp, flags=re.IGNORECASE)
    texto_temp = re.sub(r"~\s*a", "ã", texto_temp, flags=re.IGNORECASE)
    texto_temp = re.sub(r"~\s*o", "õ", texto_temp, flags=re.IGNORECASE)
    
    # Cola palavras quebradas (ex: 'c' + 'odigo')
    texto_temp = re.sub(r'\b([a-zA-ZçÇ])\s+([a-zA-ZçÇáàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÔÕÖÚÇÑ]{3,})\b', r'\1\2', texto_temp)

    texto_temp = texto_temp.replace('{{PARAGRAFO}}', '\n\n')
    texto_saida = re.sub(r'\s+', ' ', texto_temp).strip() # Remove espaços duplos
    
    return texto_saida

def ler_pdf(caminho):
    texto_completo = ""
    try:
        leitor = pypdf.PdfReader(caminho) # Lê o PDF
        for pagina in leitor.pages:
            t = pagina.extract_text()
            if t:
                texto_completo += t + "\n" # Junta o texto de todas as páginas
        return texto_completo
    except Exception as e:
        return None

def filtrar_palavras(texto):
    stops = stopwords.words('portuguese') + stopwords.words('english') + list(punctuation) # Carrega stopwords
    extras = ['et', 'al', 'figura', 'tabela', 'http', 'doi', 'vol', 'pp', 'após', 'pode', 'ser', 'para', 'com', 'que', 'nas', 'nos', 'uma', 'uns', 'são', 'não', 'como']
    stops += extras # Adiciona termos extras de artigos
    
    palavras = texto.lower().split()
    limpas = []
    
    for p in palavras:
        p_limpa = p.strip(punctuation + "0123456789")
        nfkd = unicodedata.normalize('NFKD', p_limpa) # Remove acento para padronizar contagem
        p_sem_acento = nfkd.encode('ASCII', 'ignore').decode('ASCII')
        
        if len(p_sem_acento) > 2 and p_sem_acento not in stops: # Filtra palavras pequenas e irrelevantes
            limpas.append(p_sem_acento)
            
    return limpas

def top10(palavras):
    dic = {}
    for p in palavras:
        dic[p] = dic.get(p, 0) + 1 # Conta frequência manualmente
    
    ordenado = sorted(dic.items(), key=lambda x: x[1], reverse=True) # Ordena do maior para o menor
    return ordenado[:10]

def extrair_keywords_autor(texto_completo):
    texto_limpo = reparar_texto_bugado(texto_completo)
    # Procura pela linha específica "Palavras-chave:" ou "Keywords:"
    match = re.search(r'(Palavras-chave|Keywords)[:\s]+(.*?)(?:\.|Abstract|Resumo|$)', texto_limpo, re.IGNORECASE | re.DOTALL)
    
    if match:
        return match.group(2).strip()
    return "Não identificadas explicitamente."

def encontrar_refs(texto):
    texto_limpo = reparar_texto_bugado(texto)
    inicio = texto_limpo.lower().rfind("referências") # Procura a seção no final
    
    if inicio > len(texto_limpo) * 0.7: # Valida se está nos últimos 30% do arquivo
        bloco = texto_limpo[inicio:]
        linhas = bloco.split('\n')
        return [l.strip() for l in linhas if len(l.strip()) > 20] # Filtra linhas curtas
    
    return ["Seção de referências não encontrada."]

def analisar_conteudo(texto):
    texto_limpo = reparar_texto_bugado(texto)
    doc = nlp(texto_limpo[:200000]) # Usa IA (Spacy) e limita tamanho
    
    res = {"Objetivo": [], "Problema": [], "Contribuição": []}
    
    keys_obj = ["objetivo", "proposta", "visamos", "goal"]
    keys_prob = ["problema", "desafio", "dificuldade", "lacuna"]
    keys_con = ["contribuição", "resultado", "conclusão"]
    
    for sent in doc.sents: # Analisa frase por frase
        txt = sent.text.lower()
        
        for k in keys_obj:
            if k in txt and len(sent.text) > 50:
                res["Objetivo"].append(sent.text.strip())
                break
        
        for k in keys_prob:
            if k in txt and len(sent.text) > 50:
                res["Problema"].append(sent.text.strip())
                break
                
        for k in keys_con:
            if k in txt and len(sent.text) > 50:
                res["Contribuição"].append(sent.text.strip())
                break
                
    return {k: v[:2] for k, v in res.items()}

def resumo(texto):
    try:
        texto_limpo = reparar_texto_bugado(texto)
        parser = PlaintextParser.from_string(texto_limpo, Tokenizer("portuguese"))
        resumidor = LsaSummarizer()
        summary = resumidor(parser.document, 3) # Gera resumo automático de 3 frases
        return "\n".join([str(s) for s in summary])
    except:
        return "Erro ao gerar resumo."

def main():
    diretorio_script = os.path.dirname(os.path.abspath(__file__)) 
    pasta_artigos = os.path.join(diretorio_script, "artigos")
    arquivo_saida = os.path.join(diretorio_script, "RESULTADOS_COMPLETOS.txt")
    
    if not os.path.exists(pasta_artigos):
        print(f"ERRO: Crie a pasta 'artigos' aqui: {pasta_artigos}")
        return

    arquivos = glob.glob(os.path.join(pasta_artigos, "*.pdf")) 
    
    if not arquivos:
        print("Nenhum PDF encontrado.")
        return

    print(f"Processando {len(arquivos)} artigos... Aguarde.")

    with open(arquivo_saida, 'w', encoding='utf-8') as f: 
        f.write(f"RELATÓRIO FINAL - {len(arquivos)} ARTIGOS\n")
        f.write("="*60 + "\n\n")

        for arq in arquivos:
            nome = os.path.basename(arq)
            print(f"Lendo: {nome}...")
            
            txt_bruto = ler_pdf(arq)
            
            if not txt_bruto:
                f.write(f"ERRO DE LEITURA: {nome}\n\n")
                continue
            
            txt_final = reparar_texto_bugado(txt_bruto) 
            
            f.write(f"ARQUIVO: {nome}\n")
            f.write("="*60 + "\n")
            
            f.write("\n--- 1. Palavras-Chave (Do Autor) ---\n")
            f.write(f"{extrair_keywords_autor(txt_bruto)}\n") 

            f.write("\n--- 2. Top 10 Termos ---\n")
            top = top10(filtrar_palavras(txt_final))
            for i, (t, freq) in enumerate(top, 1):
                f.write(f"{i}. {t}: {freq}\n")
                
            f.write("\n--- 3. Referências ---\n")
            refs = encontrar_refs(txt_bruto)
            for r in refs[:3]:
                f.write(f"- {r[:200]}...\n")
                
            f.write("\n--- 4. Análise Semântica ---\n")
            analise = analisar_conteudo(txt_bruto)
            for k, v in analise.items():
                f.write(f"\n> {k.upper()}:\n")
                if not v: f.write("  (Vazio)\n")
                for frase in v: f.write(f"  • {frase}\n")
                
            f.write("\n--- 5. Resumo Automático ---\n")
            f.write(resumo(txt_bruto) + "\n")
            f.write("\n" + "-"*60 + "\n\n")

    print("\nCONCLUÍDO! Abra o arquivo 'RESULTADOS_COMPLETOS.txt'.")

if __name__ == "__main__":
    main()