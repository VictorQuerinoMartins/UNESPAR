import pandas as pd
import numpy as np
from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score, precision_score, recall_score, f1_score, confusion_matrix

# --- Pré-processamento ---

colunas = [
    'Pregnancies', 'Glucose', 'BloodPressure', 'SkinThickness',
    'Insulin', 'BMI', 'DiabetesPedigreeFunction', 'Age', 'Outcome'
]

df = pd.read_csv("diabetes.csv")

colunas_para_tratar = ['Glucose', 'BloodPressure', 'SkinThickness', 'Insulin', 'BMI']

for coluna in colunas_para_tratar:
    mediana = df[df[coluna] != 0][coluna].median()
    df[coluna] = df[coluna].replace(0, mediana)

def categorizar_idade(idade):
    if idade <= 12:
        return 'crianca'
    elif idade <= 17:
        return 'adolescente'
    elif idade <= 59:
        return 'adulto'
    else:
        return 'idoso'

df['FaixaEtaria'] = df['Age'].apply(categorizar_idade)

X = df.drop(columns=['Outcome'])
y = df['Outcome']

X = pd.get_dummies(X, columns=['FaixaEtaria'])

X_treino, X_teste, y_treino, y_teste = train_test_split(X, y, test_size=0.3, random_state=42)

X_train_np = X_treino.values
y_train_np = y_treino.values
X_test_np = X_teste.values
y_test_np = y_teste.values

# --- Funções para cálculo das métricas para árvore ---

def gini_index(y):
    classes, contagem = np.unique(y, return_counts=True)
    prob = contagem / contagem.sum()
    return 1 - np.sum(prob ** 2)

def entropia(y):
    classes, contagem = np.unique(y, return_counts=True)
    prob = contagem / contagem.sum()
    ent = -np.sum(prob * np.log2(prob + 1e-9))  # +1e-9 evita log(0)
    return ent

def info_gain(parent_y, left_y, right_y):
    total_len = len(parent_y)
    ent_parent = entropia(parent_y)
    ent_left = entropia(left_y)
    ent_right = entropia(right_y)
    peso_left = len(left_y) / total_len
    peso_right = len(right_y) / total_len
    gain = ent_parent - (peso_left * ent_left + peso_right * ent_right)
    return gain

def gain_ratio(parent_y, left_y, right_y):
    gain = info_gain(parent_y, left_y, right_y)
    total_len = len(parent_y)
    peso_left = len(left_y) / total_len
    peso_right = len(right_y) / total_len
    split_info = - (peso_left * np.log2(peso_left + 1e-9) + peso_right * np.log2(peso_right + 1e-9))
    if split_info == 0:
        return 0
    return gain / split_info

# --- Nó da árvore ---

class No:
    def _init_(self, feature_index=None, limiar=None, left=None, right=None, *, valor_predito=None):
        self.feature_index = feature_index
        self.limiar = limiar
        self.left = left
        self.right = right
        self.valor_predito = valor_predito

# --- Função para dividir dataset ---

def dividir_dataset(X, y, feature_index, limiar):
    esquerda_mask = X[:, feature_index] < limiar
    direita_mask = ~esquerda_mask
    return X[esquerda_mask], y[esquerda_mask], X[direita_mask], y[direita_mask]

# --- Função para encontrar melhor split baseada em critério dado ---

def melhor_split(X, y, criterio):
    melhor_valor = -np.inf if criterio != gini_index else np.inf
    melhor_feature = None
    melhor_limiar = None

    n_features = X.shape[1]

    for feature_index in range(n_features):
        valores = np.unique(X[:, feature_index])
        for limiar in valores:
            _, y_esq, _, y_dir = dividir_dataset(X, y, feature_index, limiar)
            if len(y_esq) == 0 or len(y_dir) == 0:
                continue

            if criterio == gini_index:
                gini_esq = gini_index(y_esq)
                gini_dir = gini_index(y_dir)
                peso_esq = len(y_esq) / len(y)
                peso_dir = len(y_dir) / len(y)
                valor = peso_esq * gini_esq + peso_dir * gini_dir  # Quer minimizar Gini
                if valor < melhor_valor:
                    melhor_valor = valor
                    melhor_feature = feature_index
                    melhor_limiar = limiar
            elif criterio == info_gain:
                valor = info_gain(y, y_esq, y_dir)  # Quer maximizar IG
                if valor > melhor_valor:
                    melhor_valor = valor
                    melhor_feature = feature_index
                    melhor_limiar = limiar
            elif criterio == gain_ratio:
                valor = gain_ratio(y, y_esq, y_dir)  # Quer maximizar Gain Ratio
                if valor > melhor_valor:
                    melhor_valor = valor
                    melhor_feature = feature_index
                    melhor_limiar = limiar

    return melhor_feature, melhor_limiar

# --- Construção da árvore ---

def construir_arvore(X, y, criterio, profundidade_max=None, profundidade_atual=0):
    if len(np.unique(y)) == 1:
        return No(valor_predito=y[0])
    if profundidade_max is not None and profundidade_atual >= profundidade_max:
        valores, contagem = np.unique(y, return_counts=True)
        return No(valor_predito=valores[np.argmax(contagem)])

    feature, limiar = melhor_split(X, y, criterio)
    if feature is None:
        valores, contagem = np.unique(y, return_counts=True)
        return No(valor_predito=valores[np.argmax(contagem)])

    X_esq, y_esq, X_dir, y_dir = dividir_dataset(X, y, feature, limiar)
    esquerda = construir_arvore(X_esq, y_esq, criterio, profundidade_max, profundidade_atual + 1)
    direita = construir_arvore(X_dir, y_dir, criterio, profundidade_max, profundidade_atual + 1)

    return No(feature_index=feature, limiar=limiar, left=esquerda, right=direita)



def prever_amostra(no, x):
    if no.valor_predito is not None:
        return no.valor_predito
    if x[no.feature_index] < no.limiar:
        return prever_amostra(no.left, x)
    else:
        return prever_amostra(no.right, x)

def prever(no, X):
    return np.array([prever_amostra(no, x) for x in X])



def avaliar_modelo(y_true_train, y_pred_train, y_true_test, y_pred_test, nome_modelo):
    print(f"\n--- Métricas para {nome_modelo} ---")

    for label, y_true, y_pred in [("Treinamento", y_true_train, y_pred_train), ("Teste", y_true_test, y_pred_test)]:
        acc = accuracy_score(y_true, y_pred)
        prec = precision_score(y_true, y_pred)
        rec = recall_score(y_true, y_pred)
        f1 = f1_score(y_true, y_pred)
        cm = confusion_matrix(y_true, y_pred)

        print(f"\n{label}:")
        print(f"Acurácia: {acc:.4f}")
        print(f"Precisão: {prec:.4f}")
        print(f"Recall: {rec:.4f}")
        print(f"F1-score: {f1:.4f}")
        print("Matriz de Confusão:")
        print(cm)

# --- Executa treino/teste para as 3 medidas ---

criterios = {
    "Gini": gini_index,
    "Information Gain": info_gain,
    "Gain Ratio": gain_ratio
}

profundidade_max = 5  

for nome, criterio in criterios.items():
    print(f"\nTreinando modelo com critério: {nome}")
    arvore = construir_arvore(X_train_np, y_train_np, criterio, profundidade_max=profundidade_max)
    y_pred_train = prever(arvore, X_train_np)
    y_pred_test = prever(arvore, X_test_np)
    avaliar_modelo(y_train_np, y_pred_train, y_test_np, y_pred_test, nome)