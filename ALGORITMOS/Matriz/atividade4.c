//Crie um programa que leia um vetor vet contendo 18 elementos. A seguir, o programa deverá distribuir ordenadamente esses elementos em uma matriz 3 × 6 e, no final, mostrar a matriz.


#include <stdio.h>

int main() {
    int vet[18];
    int matriz[3][6];
    
   for (int i = 0; i < 18; i++) {

    printf("Preencha o vetor na sua posicao %d com valores inteiros: ", i);
     scanf("%d", &vet[i]);
    }
    
    int indice = 0;

    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 6; j++) {
            matriz[i][j] = vet[indice++];
        }
    }
    printf("Matriz 3x6 ordenada:");
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 6; j++) {
            printf("%d ", matriz[i][j]);
        }
    
    }
    
  
}
