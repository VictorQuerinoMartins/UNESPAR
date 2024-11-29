//1- Faça um programa que leia 5 valores inteiros, armazene-os em um vetor, calcule e apresente a soma dos valores.

#include <stdio.h>
#include <stdlib.h>

int main() {
    int vetor[5];
    
    printf("Digite 5 valores inteiros:\n");
    for (int i = 0; i < 5; i++) {
        scanf("%d", &vetor[i]);
    }

    int soma = 0;
    for (int i = 0; i < 5; i++) {
        soma = (soma + vetor[i]);
    }

    printf("A soma dos valores eh: %d\n", soma);

    return 0;
}
