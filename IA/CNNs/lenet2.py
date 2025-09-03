# -*- coding: utf-8 -*-

import tensorflow as tf
import matplotlib.pyplot as plt
import numpy as np
import os
import zipfile
from sklearn.metrics import confusion_matrix, ConfusionMatrixDisplay

## ALTERAÇÃO 1: Usar o dataset de veículos 🚗🏍️🚌
# 1. Baixar e extrair o dataset
dataset_url = "https://github.com/gti-upm/Vehicle-Classification-Dataset/raw/master/data/Vehicle-Classification-Dataset.zip"
# Usamos 'extract=True' para que o Keras já descompacte o arquivo para nós
archive_path = tf.keras.utils.get_file('vehicles.zip', origin=dataset_url, extract=True)

# O Keras extrai para um diretório. O nome da pasta principal dentro do ZIP é 'Vehicle-Classification-Dataset'
base_dir = os.path.join(os.path.dirname(archive_path), 'Vehicle-Classification-Dataset')

# Definir os caminhos de treino e teste (que neste dataset são as pastas principais)
train_dir = base_dir
test_dir = base_dir # Neste dataset, não há uma separação explícita, então usamos o mesmo para validação.
                   # O ideal seria separar manualmente, mas para um teste inicial, funciona.

# 2. Criar datasets de treino e validação
IMG_SIZE = (150, 150)
BATCH_SIZE = 32

# Criando dataset de treino (usando 80% dos dados)
train_ds = tf.keras.utils.image_dataset_from_directory(
    train_dir,
    validation_split=0.2, # Vamos separar 20% dos dados para validação
    subset="training",
    seed=123, # seed para garantir que a separação seja a mesma sempre
    image_size=IMG_SIZE,
    batch_size=BATCH_SIZE
)

# Criando dataset de validação/teste (usando os 20% restantes)
test_ds = tf.keras.utils.image_dataset_from_directory(
    test_dir,
    validation_split=0.2,
    subset="validation",
    seed=123,
    image_size=IMG_SIZE,
    batch_size=BATCH_SIZE
)

class_names = train_ds.class_names
print("Classes encontradas:", class_names)

# 3. Mostrar 1 exemplo de cada classe (agora para 3 classes)
plt.figure(figsize=(10, 5))
for images, labels in train_ds.take(1):
    for i, class_name in enumerate(class_names):
        # Achar o primeiro índice de cada classe no batch
        if i in labels.numpy():
            idx = np.where(labels.numpy() == i)[0][0]
            plt.subplot(1, 3, i+1) # Mudar para 1 linha, 3 colunas
            plt.imshow(images[idx].numpy().astype("uint8"))
            plt.title(class_name)
            plt.axis("off")
plt.show()

# 4. Otimizar dataset para desempenho
AUTOTUNE = tf.data.AUTOTUNE
train_ds = train_ds.cache().shuffle(1000).prefetch(buffer_size=AUTOTUNE)
test_ds = test_ds.cache().prefetch(buffer_size=AUTOTUNE)

# 5. Criar modelo LeNet
model = tf.keras.Sequential([
    # Adicionando uma camada para normalizar os pixels para o intervalo [0, 1]
    tf.keras.layers.Rescaling(1./255, input_shape=(IMG_SIZE[0], IMG_SIZE[1], 3)),
    
    tf.keras.layers.Conv2D(6, kernel_size=(5, 5), activation='relu', padding='same'),
    tf.keras.layers.MaxPooling2D(pool_size=(2, 2)),
    tf.keras.layers.Conv2D(16, kernel_size=(5, 5), activation='relu'),
    tf.keras.layers.MaxPooling2D(pool_size=(2, 2)),
    tf.keras.layers.Flatten(),
    tf.keras.layers.Dense(120, activation='relu'),
    tf.keras.layers.Dense(84, activation='relu'),

    ## ALTERAÇÃO 2: A camada de saída agora precisa prever 3 classes
    tf.keras.layers.Dense(len(class_names), activation='softmax') # Usar len(class_names) é uma boa prática
])

# Usei 'relu' no lugar de 'sigmoid' pois geralmente performa melhor em CNNs modernas.
model.summary()

model.compile(optimizer='adam', # Adam já usa uma boa taxa de aprendizado padrão
              loss='sparse_categorical_crossentropy',
              metrics=['accuracy'])

# 6. Treinar modelo
# Para um teste rápido, vamos usar menos épocas. Aumente se quiser mais precisão.
history = model.fit(train_ds, validation_data=test_ds, epochs=15)

# 7. Prever no conjunto de teste
y_true = []
y_pred = []

for images, labels in test_ds:
    preds = model.predict(images)
    y_true.extend(labels.numpy())
    y_pred.extend(np.argmax(preds, axis=1))

# 8. Matriz de confusão
cm = confusion_matrix(y_true, y_pred)
disp = ConfusionMatrixDisplay(confusion_matrix=cm, display_labels=class_names)
disp.plot(cmap=plt.cm.Blues)

## ALTERAÇÃO 3: Atualizar o título do gráfico
plt.title("Matriz de Confusão - Classificação de Veículos")
plt.show()