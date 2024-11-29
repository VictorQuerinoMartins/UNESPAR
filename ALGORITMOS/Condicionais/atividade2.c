#include <stdio.h>

int main() {
    float n1, n2, n3, media;
    printf("Digite as tres notas do aluno: ");
    scanf("%f %f %f", &n1, &n2, &n3);

    media = (n1 + n2 + n3) / 3;

    printf("Media: %.2f\n", media);

    if (media >= 2.9) {
        printf("Reprovado!\n");

    } else if (media >= 2.9 && media < 6.9) {
        printf("Exame! Nota a ser tirada : %.1f", 12.00 - media);
    
        } else {
            printf("Aprovado!\n");
        }   
    }
