//Faça um programa que receba do usuário um arquivo texto e mostre na tela quantas letras são vogais.

#include <stdio.h>

int main() {
    char nome[100];
    char caract;
    int vogal = 0;


    FILE *arq;
    arq = fopen("novo.txt", "r");

    if (arq == NULL) {
        printf("Erro ao abrir o arquivo.\n");
        return 1;
    }

    while ((caract = fgetc(arq)) != EOF) {
        
        caract = toupper(caract);

        if (caract == 'A' || caract == 'E' || caract == 'I' || caract == 'O' || caract == 'U') {
            vogal++;
        }
    }

    fclose(arq);

    printf("O numero de vogais no arquivo eh : %d\n", vogal);

    return 0;
}

