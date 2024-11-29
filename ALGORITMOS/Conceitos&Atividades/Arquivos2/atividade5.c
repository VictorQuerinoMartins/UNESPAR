//Faça um programa que receba como entrada o ano corrente e o nome de dois arquivos: um de entrada e outro de saída. Cada linha do arquivo de entrada contém o nome de uma pessoa (ocupando 40 caracteres) e o seu ano de nascimento. O programa deverá ler o arquivo de entrada e gerar um arquivo de saída onde aparece o nome da pessoa seguida por uma string que representa a sua idade. 
//• Se a idade for menor do que 18 anos, escreva “menor de idade”
//• Se a idade for maior do que 18 anos, escreva “maior de idade”
//• Se a idade for igual a 18 anos, escreva “entrando na maior idade”

#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int main() {
    FILE *arqE, *arqS;
    char nomeArqE[40], nomeArqS[40];
    char personName[40];
    int aniversario, anoAtual, idade;

    printf("Digite o ano atual: ");
    scanf("%d", &anoAtual);

    printf("Digite o nome do arquivo de entrada: ");
    scanf("%s", nomeArqE);

    printf("Digite o nome do arquivo de saída: ");
    scanf("%s", nomeArqS);

    arqE = fopen(nomeArqE, "r");
    arqS = fopen(nomeArqS, "w");

    if (arqE == NULL || arqS == NULL) {
        perror("Erro ao abrir o arquivo");
    }

    while (fscanf(arqE, "%39s %d", personName, &aniversario) == 2) {
        idade = anoAtual - aniversario;
        if (idade < 18) {
            fprintf(arqS, "%s: menor de idade\n", personName);
        } else if (idade > 18) {
            fprintf(arqS, "%s: maior de idade\n", personName);
        } else {
            fprintf(arqS, "%s: entrando na maior idade\n", personName);
        }
    }

    printf("Processo concluído. Verifique o arquivo de saída.\n");

    fclose(arqE);
    fclose(arqS);

    return 0;
}