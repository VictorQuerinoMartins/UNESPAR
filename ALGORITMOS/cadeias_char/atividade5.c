//Faça um programa que receba uma palavra e verifique se ela constitui um palíndromo, ou seja, se a palavra escrita do fim para o começo fica igual à palavra escrita do começo para o fim.
//Exemplos:
//ARARA
//ANA
//MIRIM

#include <stdio.h>
#include <string.h>
#include <ctype.h>

int main() {
    int i, x;
    char palavra[80], invertida[80];
	
    printf("Informe uma palavra:\n");
    gets(palavra);

    int tamanho = strlen(palavra);


    for (i = 0, x = tamanho - 1; i < tamanho; i++, x--) {
        invertida[i] = palavra[x];
    }
    invertida[i] = '\0'; 

    printf("Palavra original: %s\n", palavra);
    printf("Palavra invertida: %s\n", invertida);

    if (strcmp(palavra, invertida) == 0) {
        printf("A palavra e a mesma quando invertida.\n");
    } else {
        printf("A palavra nao e a mesma quando invertida.\n");
    }

}
