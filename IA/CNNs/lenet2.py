import tensorflow as tf
import matplotlib.pyplot as plt
import numpy as np
import os
from sklearn.metrics import confusion_matrix, ConfusionMatrixDisplay

# 1. Definir o caminho para o seu dataset local
base_dir = r"C:\Users\yguin\OneDrive\Documentos\GitHub\UNESPAR\IA\CNNs\ClassificadorDeVeiculos\dataset"

# Validar se o caminho existe para evitar erros
if not os.path.exists(base_dir):
    raise FileNotFoundError(
        f"O diretório especificado não foi encontrado: {base_dir}\n"
        f"Verifique se o caminho está correto e se a estrutura de pastas (com 'train' e 'validation') existe dentro dele."
    )

train_dir = os.path.join(base_dir, 'train')
validation_dir = os.path.join(base_dir, 'validation')

print(f"Usando diretório de treino: {train_dir}")
print(f"Usando diretório de validação: {validation_dir}")

# 2. Criar datasets de treino e validação
IMG_SIZE = (150, 150)
BATCH_SIZE = 32

train_ds = tf.keras.utils.image_dataset_from_directory(
    train_dir,
    image_size=IMG_SIZE,
    batch_size=BATCH_SIZE,
    label_mode='int'
)

test_ds = tf.keras.utils.image_dataset_from_directory(
    validation_dir,
    image_size=IMG_SIZE,
    batch_size=BATCH_SIZE,
    label_mode='int',
    shuffle=False
)

class_names = train_ds.class_names
NUM_CLASSES = len(class_names)
print("Classes encontradas:", class_names)
print(f"Número de classes: {NUM_CLASSES}")


# 3. Mostrar 1 exemplo de cada classe
plt.figure(figsize=(10, 5))
for images, labels in train_ds.take(1):
    for i, class_name in enumerate(class_names):
        idx_list = np.where(labels.numpy() == i)[0]
        if len(idx_list) > 0:
            idx = idx_list[0]
            plt.subplot(1, NUM_CLASSES, i + 1)
            plt.imshow(images[idx].numpy().astype("uint8"))
            plt.title(class_name)
            plt.axis("off")
plt.suptitle("Exemplos do Dataset")
plt.show()

# 4. Otimizar dataset para desempenho
AUTOTUNE = tf.data.AUTOTUNE
train_ds = train_ds.cache().shuffle(1000).prefetch(buffer_size=AUTOTUNE)
test_ds = test_ds.cache().prefetch(buffer_size=AUTOTUNE)

# 5. Criar modelo LeNet
model = tf.keras.Sequential([
    # Normaliza os pixels da imagem para o intervalo [0, 1]
    tf.keras.layers.Rescaling(1./255, input_shape=(IMG_SIZE[0], IMG_SIZE[1], 3)),
    tf.keras.layers.Conv2D(6, kernel_size=(5, 5), activation='sigmoid', padding='same'),     # 1ª Convolução: Extrai 6 tipos de características iniciais da imagem.
    tf.keras.layers.MaxPooling2D(pool_size=(2, 2)),                          # 1º Pooling: Reduz o tamanho da imagem, mantendo as características mais importantes.
    tf.keras.layers.Conv2D(16, kernel_size=(5, 5), activation='sigmoid'),           # 2ª Convolução: Extrai 16 características mais complexas dos mapas anteriores.
    tf.keras.layers.MaxPooling2D(pool_size=(2, 2)),                                      # 2º Pooling: Reduz a dimensionalidade novamente.
    tf.keras.layers.Flatten(),                                            # Flatten: Transforma a matriz de características em um vetor único para a classificação.
    tf.keras.layers.Dense(120, activation='sigmoid'),                          # 1ª Camada Densa: Combina as características para aprender padrões (120 neurônios).
    tf.keras.layers.Dense(84, activation='sigmoid'),                           # 2ª Camada Densa: Refina os padrões aprendidos pela camada anterior (84 neurônios).
    tf.keras.layers.Dense(NUM_CLASSES, activation='softmax')                   # Camada de Saída: Classifica a imagem na categoria mais provável (softmax).
])

model.summary()

# Configurar otimizador
optimizer = tf.keras.optimizers.Adam(learning_rate=0.001)

model.compile(optimizer=optimizer,
              loss='sparse_categorical_crossentropy',
              metrics=['accuracy'])

# 6. Treinar modelo
print("\nIniciando o treinamento do modelo...")
history = model.fit(train_ds, validation_data=test_ds, epochs=20)
print("Treinamento finalizado.")

# 7. Plotar Curva de Perda e Acurácia
acc = history.history['accuracy']
val_acc = history.history['val_accuracy']
loss = history.history['loss']
val_loss = history.history['val_loss']

epochs_range = range(len(acc))

plt.figure(figsize=(12, 5))
plt.subplot(1, 2, 1)
plt.plot(epochs_range, acc, label='Acurácia de Treino')
plt.plot(epochs_range, val_acc, label='Acurácia de Validação')
plt.legend(loc='lower right')
plt.title('Acurácia de Treino e Validação')

plt.subplot(1, 2, 2)
plt.plot(epochs_range, loss, label='Perda de Treino')
plt.plot(epochs_range, val_loss, label='Perda de Validação')
plt.legend(loc='upper right')
plt.title('Curva de Perda (Loss)')
plt.show()


# 8. Gerar Matriz de Confusão
print("\nGerando Matriz de Confusão...")
y_true = []
y_pred = []

for images, labels in test_ds:
    y_true.extend(labels.numpy())
    preds = model.predict(images)
    y_pred.extend(np.argmax(preds, axis=1))

cm = confusion_matrix(y_true, y_pred)
disp = ConfusionMatrixDisplay(confusion_matrix=cm, display_labels=class_names)

disp.plot(cmap=plt.cm.Blues)
plt.title("Matriz de Confusão - Veículos")
plt.show()