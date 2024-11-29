//Implemente um programa que receba o nome de uma música e um caractere qualquer. Percorra esta cadeia que armazenou o nome da música a procura do caractere informado e retorne o seu índice ou a mensagem: caractere não encontrado.
//Exemplo:

//Entradas
//Nome da música: Como uma onda no mar
//Caractere: a

//Saídas
//Ocorrência de caractere na posição 7
//Ocorrência de caractere na posição 12
//Ocorrência de caractere na posição 18

//Entradas
//Nome da música: Amor I love you
//Caractere: c

//Saídas
//Caractere nao encontrado.


#include <stdio.h>
#include <string.h>

int main() {
    char musica[80], caractere;

    printf("Informe o nome de uma musica:\n");
    gets(musica);
    fflush(stdin);
    
    printf("Informe um caractere:\n");
    scanf("%c", &caractere);
    int encontrado = 0;

    
    for (int i = 0; i < strlen(musica); i++) {       // strlen retorna o tamanho da string
        if (caractere == musica[i]) {
        	printf("Caractere encontrado na(s) posicao(oes):\n");
            printf("%d\n", i);
            encontrado = 1;
        }
    }
		if (!encontrado) {
        printf("O caractere nao foi encontrado na musica.\n");
    }

}
