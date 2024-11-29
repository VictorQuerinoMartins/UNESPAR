//Faça um programa que preencha um vetor com os registros acadêmicos (RA) de sete alunos e carregue outro vetor com a média final desses alunos. 
//Calcule e mostre:
//● o RA do aluno com maior média (desconsiderar empates);
//● para cada aluno não aprovado, isto é, com média menor que 7, mostrar quanto esse aluno precisa tirar na prova de exame final para ser aprovado. Considerar que a média para aprovação no exame é 5.

#include <stdio.h>

int main()
{
    int ra[7];
    float media[7];

    for (int i = 0; i < 7; i++)
    {
        printf("RA do aluno %d: ", i+1);
        scanf("%d", &ra[i]);

        printf("\n Media final do aluno %d: ", i+1);
        scanf("%f", &media[i]);
    }
        float maiormedia = media[0];
        int ramaior = ra[0];

        for (int i = 0; i < 7; i++)
        {
            if (media[i] > maiormedia)
            {
                maiormedia = media[1];
                ramaior = ra[i];
            }
        }

        printf("\n Maior media: %.2f", maiormedia);

        printf("\n RA do aluno com maior media: %d", ramaior);

        printf("\n");

        for (int i = 0; i < 7; i++)
        {
            if (media[i] < 7){
                printf("\n RA %d precisa tirar %.2f", ra[i], 7 - media[i]);
            }
        }
    
}
