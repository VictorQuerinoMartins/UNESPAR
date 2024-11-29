/// Faça um programa que leia 2 valores inteiros e chame uma função que receba estas 2 variáveis e troque o seu conteúdo, ou seja, esta função é chamada passando duas variáveis A e B por exemplo e, após a execução da função, A conterá o valor de B e B terá o valor de A. Realize essa troca utilizando ponteiros

#include <stdio.h>

void trocarValores(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

int main() {
    int valorA, valorB;

    printf("Digite o valor de A: ");
    scanf("%d", &valorA);

    printf("Digite o valor de B: ");
    scanf("%d", &valorB);

    printf("\nValores antes da troca:\nA: %d\nB: %d\n", valorA, valorB);

    trocarValores(&valorA, &valorB);

    printf("\nValores depois da troca:\nA: %d\nB: %d\n", valorA, valorB);

    return 0;
}
