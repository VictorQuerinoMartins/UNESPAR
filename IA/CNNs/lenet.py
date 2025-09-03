# -*- coding: utf-8 -*-

import tensorflow as tf
import matplotlib.pyplot as plt
import numpy as np
import os
import zipfile
from sklearn.metrics import confusion_matrix, ConfusionMatrixDisplay


# 1. Baixar e extrair o dataset
dataset_url = "https://storage.googleapis.com/mledu-datasets/cats_and_dogs_filtered.zip"
archive = tf.keras.utils.get_file('cats_and_dogs.zip', origin=dataset_url, extract=True)

# Caminhos do dataset
base_dir = os.path.join(os.path.dirname(archive), 'cats_and_dogs_extracted', 'cats_and_dogs_filtered')

# Print os conteúdos dos diretorios para inspecionar a estrutura
print(f"Contents of {os.path.dirname(archive)}:")
print(os.listdir(os.path.dirname(archive)))

print(f"Contents of {base_dir}:")
print(os.listdir(base_dir))


train_dir = os.path.join(base_dir, 'train')
validation_dir = os.path.join(base_dir, 'validation')

# 2. Criar datasets de treino e teste
IMG_SIZE = (150, 150)
BATCH_SIZE = 32

train_ds = tf.keras.utils.image_dataset_from_directory(
    train_dir,
    image_size=IMG_SIZE,
    batch_size=BATCH_SIZE
)

test_ds = tf.keras.utils.image_dataset_from_directory( # Usando validation_dir como test_ds
    validation_dir,
    image_size=IMG_SIZE,
    batch_size=BATCH_SIZE
)

class_names = train_ds.class_names
print("Classes:", class_names)

# 3. Mostrar 1 exemplo de cada classe
plt.figure(figsize=(6, 3))
for images, labels in train_ds.take(1):
    for i, class_name in enumerate(class_names):
        idx = np.where(labels.numpy() == i)[0][0]
        plt.subplot(1, 2, i+1)
        plt.imshow(images[idx].numpy().astype("uint8"))
        plt.title(class_name)
        plt.axis("off")
plt.show()

# 4. Otimizar dataset para desempenho
AUTOTUNE = tf.data.AUTOTUNE
train_ds = train_ds.cache().shuffle(1000).prefetch(buffer_size=AUTOTUNE) #shuffle = embaralhando
test_ds = test_ds.cache().prefetch(buffer_size=AUTOTUNE)

# 5. Criar modelo LeNet
model = tf.keras.Sequential([
    tf.keras.layers.Conv2D(6, kernel_size=(5, 5), activation='sigmoid', padding='same'), #Adicionar bordas de 0      #Convolução
    tf.keras.layers.MaxPooling2D(pool_size=(2, 2)), #Informar o tamanho do polling                                   #Polling
    tf.keras.layers.Conv2D(16, kernel_size=(5, 5), activation='sigmoid'),                                            #Convolução
    tf.keras.layers.MaxPooling2D(pool_size=(2, 2)),                                                                  #Polling
    tf.keras.layers.Flatten(),                                                                                       #Flatten -> transforma tudo em um unico vetor
    tf.keras.layers.Dense(120, activation='sigmoid'),                                                                #Dense - Camada densa com 120 neuronios
    tf.keras.layers.Dense(84, activation='sigmoid'),
    tf.keras.layers.Dense(2, activation='softmax')                                                                   #Camada de saida -> 2 pq (gato ou dog)  , softmax para deixar e probabilidade
])

# Configurar otimizador com taxa de aprendizagem específica
optimizer = tf.keras.optimizers.Adam(learning_rate=0.001)

model.compile(optimizer=optimizer,
              loss='sparse_categorical_crossentropy',
              metrics=['accuracy'])

# 6. Treinar modelo
history = model.fit(train_ds, validation_data=test_ds, epochs=100)

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
plt.title("Matriz de Confusão - LeNet Gatos vs Cachorros")
plt.show()