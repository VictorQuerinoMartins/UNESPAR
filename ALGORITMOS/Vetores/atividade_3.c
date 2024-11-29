// Faça um programa que receba o número sorteado por um dado de seis lados jogado vinte vezes. Mostre os números sorteados e a frequência com que apareceram.


#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main() {
    int frequencia[6] = {0};
    int num;

    for (int i = 0; i < 20; i++) {
        printf("Digite o numero %d: ", i + 1);
        scanf("%d", &num);

        frequencia[num - 1]++; // Aumenta a contagem para o número sorteado
    }

    printf("\nFrequencia dos numeros sorteados:\n");
    for (int i = 0; i < 6; i++) {
        printf("Numero %d: %d vezes\n", i + 1, frequencia[i]);
    }

    return 0;
}