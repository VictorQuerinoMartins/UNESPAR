//Faça um programa que preencha um vetor com nove números inteiros, calcule e mostre os números pares e suas respectivas posições no vetor (índice).

#include <stdio.h>

int main() {
    int vetor[9];

    for (int i = 0; i < 9; i++) {                                        // Preenchendo o vetor
        printf("Digite um numero inteiro: ");
        scanf("%d", &vetor[i]);
    }

    for (int i = 0; i < 9; i++) {                               // Verificação de par
        if (vetor[i] % 2 == 0) {
            printf("Numero par %d no indice %d\n", vetor[i], i);
    
        }
    }


}