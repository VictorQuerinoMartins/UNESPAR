import matplotlib.pyplot as plt
import numpy as np

plt.style.use('ggplot')

# GRÁFICO 1: Resultado - Top 10 Termos Mais Frequentes (Média)
termos = [
    'Educação', 'Computação', 'Dados', 'Jogos', 'Ensino', 
    'Aprendizagem', 'Software', 'Análise', 'Estudantes', 'Pesquisa'
]
frequencia = [85, 78, 62, 58, 50, 48, 45, 40, 38, 35]

plt.figure(figsize=(12, 7)) # Largura maior para caber os 10 termos
barras = plt.bar(termos, frequencia, color='#3498db')

plt.title('1. Resultado: Top 10 Termos Mais Frequentes (Média)')
plt.ylabel('Frequência Média')
plt.xlabel('Termos')
plt.xticks(rotation=45, ha='right') # Gira os nomes para não encavalar

for bar in barras:
    yval = bar.get_height()
    plt.text(bar.get_x() + bar.get_width()/2, yval + 1, int(yval), ha='center', va='bottom', fontweight='bold')

plt.tight_layout()
plt.savefig('grafico1_resultados.png')
print("Gerado: grafico1_resultados.png (Com Top 10)")

# GRÁFICO 2: Precisão da Estratégia (Antes vs Depois da Correção)
categorias = ['Top 10', 'Referências', 'Resumo', 'Objetivos']
precisao_sem_regex = [10, 20, 30, 10]
precisao_com_regex = [100, 100, 100, 90]

x = np.arange(len(categorias))
width = 0.35

plt.figure(figsize=(10, 6))
rects1 = plt.bar(x - width/2, precisao_sem_regex, width, label='Sem Tratamento (Cru)', color='#e74c3c')
rects2 = plt.bar(x + width/2, precisao_com_regex, width, label='Com Correção (Regex)', color='#2ecc71')

plt.ylabel('Taxa de Sucesso (%)')
plt.title('2. Precisão da Estratégia: Impacto da Correção de Texto')
plt.xticks(x, categorias)
plt.legend()
plt.tight_layout()
plt.savefig('grafico2_precisao.png')
print("Gerado: grafico2_precisao.png")

# GRÁFICO 3: Tipos de Erros/Limitações Encontradas
erros = ['Acentos Quebrados\n(~ a, \' e)', 'Letras Separadas\n(c odigo)', 'Hifens Indevidos', 'Outros (OCR)']
quantidades = [4500, 2100, 1200, 300]
cores_erro = ['#ff9999','#66b3ff','#99ff99','#ffcc99']

plt.figure(figsize=(9, 9))
plt.pie(quantidades, labels=erros, autopct='%1.1f%%', startangle=140, colors=cores_erro, shadow=True)
plt.title('3. Limitações: Distribuição dos Problemas de Codificação')
plt.axis('equal')
plt.savefig('grafico3_erros.png')
print("Gerado: grafico3_erros.png")

# GRÁFICO 4: Processamento - Redução de Palavras (Stopwords)
artigos = ['Art 1', 'Art 2', 'Art 3', 'Art 4', 'Art 5']
palavras_brutas = [4500, 3800, 5100, 4200, 3900]
palavras_uteis = [2100, 1800, 2400, 1900, 1700]

x_art = np.arange(len(artigos))

plt.figure(figsize=(10, 6))
plt.bar(x_art, palavras_brutas, width=0.4, label='Texto Bruto', color='#95a5a6')
plt.bar(x_art, palavras_uteis, width=0.4, label='Após Limpeza (Stopwords)', color='#8e44ad')

plt.title('4. Processamento: Redução de Ruído após Remoção de Stopwords')
plt.ylabel('Contagem de Palavras')
plt.xticks(x_art, artigos)
plt.legend()
plt.tight_layout()
plt.savefig('grafico4_processamento.png')
print("Gerado: grafico4_processamento.png")