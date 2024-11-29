//Faça um programa que receba o nome de um arquivo de entrada e outro de saída. O arquivo de entrada contém em cada linha o nome de uma cidade (ocupando 40 caracteres) e o seu número de habitantes. O programa deverá ler o arquivo de entrada e gerar um arquivo de saída onde aparece o nome da cidade mais populosa seguida pelo seu número de habitantes.

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    FILE *arqE, *arqS;
    char arqEnome[40], arqSnome[40];
    char cidade[40];
    int populacao, populacaoM = 0;
    char cidadeNome[40];

    printf("Digite o nome do arquivo de entrada: ");
    scanf("%s", arqEnome);

    printf("Digite o nome do arquivo de saída: ");
    scanf("%s", arqSnome);

    arqE = fopen(arqEnome, "r");
    arqS = fopen(arqSnome, "w");

    if (arqE == NULL || arqS == NULL) {
        perror("Erro ao abrir o arquivo");
        exit(EXIT_FAILURE);
    }

    while (fscanf(arqE, "%39s %d", cidade, &populacao) == 2) {
        if (populacao > populacaoM) {
            populacaoM = populacao;
            strcpy(cidadeNome, cidade);
        }
    }

    fprintf(arqS, "Cidade mais populosa: %s, Número de habitantes: %d\n", cidadeNome, populacaoM);

    printf("Processo concluído. Verifique o arquivo de saída.\n");

    fclose(arqE);
    fclose(arqS);

    return 0;
}