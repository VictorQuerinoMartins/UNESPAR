//Faça um programa que cria uma estrutura livro, que contém os elementos nome, editora, isbn, ano de edição, número de páginas e preço. Criar uma variável desta estrutura que é um vetor de 5 elementos. Ler os valores para a estrutura e imprimir a média do número de páginas dos livros.

#include <stdio.h>
#include <stdlib.h>

typedef struct livro{
    char nome[30];
    char editora[30];
    float isbn;
    int ano;
    int npag;
    float preco;

} livro;


main(){
livro liv[2];
int pag = 0;

for(int i = 0; i < 5; i++){
printf("Livro %d \n", i + 1);

    printf("\nInsira o nome do livro:");
    scanf("%s", liv[i].nome);

    printf("\nInsira a editora do livro:");
    scanf("%s", liv[i].editora);

    printf("\nInsira isbn do livro:");
    scanf("%f", &liv[i].isbn);

    printf("\nInsira ano do livro:");
    scanf("%d", &liv[i].ano);

    printf("\nInsira o numero de paginas do livro:");
    scanf("%d", &liv[i].npag);

    printf("\nInsira preco do livro:");
    scanf("%f", &liv[i].preco);

     pag += liv[i].npag;

    }

    float media =  pag / 5;
    printf("\nA media do numero de paginas dos livros: %.2f\n", media);

}