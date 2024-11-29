//Faça um programa que receba do usuário um arquivo texto e um caracter. Mostre na tela quantas vezes aquele caractere ocorre dentro do arquivo.

#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int main() {
	char texto[50];
	FILE *arq;
	char caractere;
	int contador = 0;
	char escolha;
	
	arq = fopen("atividade1.txt", "r");
	
	if(arq == NULL) {
		printf("Erro ao abrir o arquivo.\n");
	}

	printf("Digite o caractere a ser contado: ");
	scanf(" %c", &caractere);
	fflush(stdin);
	
	printf("Insira o texto: ");
	gets(texto);
	fflush(stdin);
	
	fputs(texto, arq);
	rewind(arq);
	
	for(int i = 0; i < 50; i++) {

		while ((escolha = fgetc(arq)) != EOF) {
        if (escolha == caractere) {
            contador++;
        	}
    	}
	}

	fclose(arq);

	printf("\nO numero de (%c) encontrados no texto foi de: %d", caractere, contador);
	
	}
	




