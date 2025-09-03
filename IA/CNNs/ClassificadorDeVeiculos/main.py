import tensorflow as tf
import matplotlib.pyplot as plt
import numpy as np
import os
from sklearn.metrics import confusion_matrix, ConfusionMatrixDisplay

# --- AJUSTE O CAMINHO AQUI ---
# 1. Apontar para a pasta do dataset no seu computador.
# Use 'r' antes do caminho no Windows para evitar erros com a barra invertida (\).
base_dir = r'C:\Users\yguin\OneDrive\Documentos\GitHub\UNESPAR\IA\CNNs\ClassificadorDeVeiculos\dataset'

# Verificação para garantir que o caminho existe antes de prosseguir
if not os.path.exists(base_dir):
    raise FileNotFoundError(f"ERRO: O caminho '{base_dir}' não foi encontrado. Verifique se está correto.")
else:
    print(f"Dataset encontrado em: {base_dir}")
    print(f"Classes no diretório: {os.listdir(base_dir)}")

# --- DEFINIÇÃO DOS PARÂMETROS ---
# 2. Definir parâmetros para as imagens e o treinamento
IMG_SIZE = (150, 150)
BATCH_SIZE = 32
VALIDATION_SPLIT = 0.2 # Usaremos 20% dos dados para validação/teste

# --- CRIAÇÃO DOS DATASETS DE TREINO E TESTE ---
# 3. Criar os datasets a partir do mesmo diretório, dividindo-os em treino e teste.
# O TensorFlow fará a divisão automaticamente usando validation_split.

# Conjunto de dados para TREINAMENTO (80% dos dados)
train_ds = tf.keras.utils.image_dataset_from_directory(
    base_dir,
    validation_split=VALIDATION_SPLIT,
    subset="training",
    seed=123,
    label_mode='int',
    image_size=IMG_SIZE,
    batch_size=BATCH_SIZE
)

# Conjunto de dados para TESTE/VALIDAÇÃO (20% dos dados)
test_ds = tf.keras.utils.image_dataset_from_directory(
    base_dir,
    validation_split=VALIDATION_SPLIT,
    subset="validation",
    seed=123,
    label_mode='int',
    image_size=IMG_SIZE,
    batch_size=BATCH_SIZE
)

class_names = train_ds.class_names
print("Classes carregadas pelo TensorFlow:", class_names)
print("-" * 30)


# --- OTIMIZAÇÃO E CONSTRUÇÃO DO MODELO ---
# Otimizar os datasets para melhor desempenho durante o treinamento
AUTOTUNE = tf.data.AUTOTUNE
train_ds = train_ds.cache().shuffle(1000).prefetch(buffer_size=AUTOTUNE)
test_ds = test_ds.cache().prefetch(buffer_size=AUTOTUNE)

# Criar a arquitetura do modelo de Rede Neural Convolucional (CNN)
model = tf.keras.Sequential([
    tf.keras.layers.Rescaling(1./255, input_shape=(IMG_SIZE[0], IMG_SIZE[1], 3)),
    tf.keras.layers.Conv2D(32, 3, padding='same', activation='relu'),
    tf.keras.layers.MaxPooling2D(),
    tf.keras.layers.Conv2D(64, 3, padding='same', activation='relu'),
    tf.keras.layers.MaxPooling2D(),
    tf.keras.layers.Conv2D(128, 3, padding='same', activation='relu'),
    tf.keras.layers.MaxPooling2D(),
    tf.keras.layers.Flatten(),
    tf.keras.layers.Dense(128, activation='relu'),
    tf.keras.layers.Dense(len(class_names), activation='softmax') # Camada de saída com o número de classes
])

# Compilar o modelo, definindo o otimizador, a função de perda e as métricas
model.compile(optimizer='adam',
              loss='sparse_categorical_crossentropy',
              metrics=['accuracy'])

# Imprimir um resumo da arquitetura do modelo
model.summary()
print("-" * 30)

# --- TREINAMENTO E AVALIAÇÃO ---
# Treinar o modelo
epochs = 15
print(f"Iniciando o treinamento por {epochs} épocas...")
history = model.fit(train_ds, validation_data=test_ds, epochs=epochs)
print("Treinamento finalizado!")

# Gerar e exibir a Matriz de Confusão para avaliar o desempenho
print("Gerando a Matriz de Confusão...")
y_true = []
y_pred = []

# Extrai os rótulos e previsões do conjunto de teste
for images, labels in test_ds:
    preds = model.predict(images)
    y_true.extend(labels.numpy())
    y_pred.extend(np.argmax(preds, axis=1))

# Cria e plota a matriz
cm = confusion_matrix(y_true, y_pred)
disp = ConfusionMatrixDisplay(confusion_matrix=cm, display_labels=class_names)
disp.plot(cmap=plt.cm.Blues, xticks_rotation=45)
plt.title("Matriz de Confusão - Classificador de Veículos")
plt.show()