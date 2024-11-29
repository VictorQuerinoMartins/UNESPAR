#include <string.h>
#include <stdio.h>

main(){

//strcpy(<destino>, <origem>); // Usado para alterar o conteúdo de uma string     destino = npme da string q quer mudar o conteúdo ou nome da variavel que recebe o texto.

char origem[20] = {"Ola, Mundo"};
char destino[20];

printf("Antes do strcpy: \n");
printf("%s", origem);
printf("\n%s", destino);

strcpy(destino,origem);

printf("\nDepois do strcpy: \n");
printf("%s", origem);
printf("\n%s", destino);

printf("\n\n");

//strcat(<destino>, <origem>); // Juntar duas strings,   destino + origem = destino

char string1[20] = {"Logica de"};
char string2[20] = {" Programacao"};

printf("Antes do strcat: \n");
printf("String1: %s\n", string1);
printf("String2: %s\n", string2);

strcat(string1,string2);

printf("Depois do strcat: \n");
printf("String1: %s\n", string1);

printf("\n\n");

//strlen(<destino>, <origem>); // Pegar o tamanho da string

char string[20];
int i;

printf("Digite um texto: \n");
gets(string);
i = strlen(string);
printf("Tamanho do texto: %d\n", i);

printf("Impressao de posicao a posicao: \n");

for(i=0; i < strlen(string); i++){
    printf("%c", string[i]);
}

printf("\n\n");

//strcmp(<destino>, <origem>); // Compara se a string 1 é igual a string 2, se sim retorna o valor 0

char texto[20] = {"/exit"};
char senha_urs[20];
int ok;

printf("Digite um texto: \n");
gets(senha_urs);

ok = strcmp(texto, senha_urs);

}