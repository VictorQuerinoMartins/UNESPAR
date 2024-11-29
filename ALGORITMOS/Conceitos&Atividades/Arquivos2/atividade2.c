//Faça um programa que receba do usuário um arquivo texto. Crie outro arquivo texto contendo o texto do arquivo de entrada, mas com as vogais substitu ́ıdas por ‘*’.

#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int main() {
	char texto[30];
	FILE *arq;
    FILE *arq2;
	
	arq = fopen("atividade2_0.txt", "w+");
	
	if(arq == NULL) {
		printf("Erro ao abrir o arquivo.\n");
	}
	
	printf("Insira o texto: ");
	gets(texto);
	fflush(stdin);

	fclose(arq);

    arq2 = fopen("atividade2_1.txt", "w");

	char caract;
	 while ((caract = fgetc(arq)) != EOF) {

        if (caract == 'a' || caract == 'e' || caract == 'i' || caract == 'o' || caract == 'u' ||
            caract == 'A' || caract == 'E' || caract == 'I' || caract == 'O' || caract == 'U') {
            fputc('*', arq2);

        } else {
            fputc(caract, arq2);
        }
    }


}