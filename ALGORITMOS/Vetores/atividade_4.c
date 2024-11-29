//Faça um programa que preencha um vetor com seis elementos numéricos inteiros. Calcule e mostre:
//● todos os números pares;
//● a quantidade de números pares;
//● todos os números ímpares;
//● a quantidade de números ímpares.

#include <stdio.h>

int main() {
    int vetor[6];
    int par = 0, impar = 0;

    
    for (int i = 0; i < 6; i++) {
        printf("Digite seis numeros inteiros:");
        scanf("%d", &vetor[i]);
    }

    for (int i = 0; i < 6; i++) {
        if (vetor[i] % 2 == 0) {
            printf("Par %d na posicao %d\n", vetor[i],i + 1);
            par++;
        } else {
            printf("Impar %d na posicao %d\n", vetor[i],i + 1);
            impar++;
        }
    }

    printf("\nQuantidade de numeros pares: %d\n", par);
    printf("\nQuantidade de numeros impares: %d\n", impar);

}