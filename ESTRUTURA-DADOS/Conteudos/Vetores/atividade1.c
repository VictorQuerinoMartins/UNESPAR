//2- Altere o programa anaterior para calcular e apresentar a média dos valores entrados e aqueles que são maiores e menores que a média.


#include <stdio.h>
#include <stdlib.h>

int main() {
    int vetor[5];
    float media;

    printf("Digite 5 valores inteiros:\n");
    for (int i = 0; i < 5; i++) {
        scanf("%d", &vetor[i]);
    }

    int soma = 0;
    for (int i = 0; i < 5; i++) {
        soma += vetor[i];
    }

    media = (float)soma / 5; 

    printf("A soma dos valores eh: %d\n", soma);
    printf("A media dos valores eh: %.2f\n", media);

    int contMa = 0, ContMe = 0;
    for (int i = 0; i < 5; i++) {
        if (vetor[i] > media) {  
            contMa++;
        } else if (vetor[i] < media) {
            ContMe++;
        }
    }

    printf("Quantidade de valores maiores que a media: %d\n", contMa);
    printf("Quantidade de valores menores que a media: %d\n", ContMe);

    return 0;
}
