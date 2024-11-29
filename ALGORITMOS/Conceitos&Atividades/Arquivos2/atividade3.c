//Faça um programa que receba dois arquivos do usuário, e crie um terceiro arquivo com o conteúdo dos dois primeiros juntos (o conteúdo do primeiro seguido do conteúdo do segundo).

#include <stdio.h>
#include <stdlib.h>

main(){
    FILE *arq;
    FILE *arq2;
    FILE *arq3;
    char a, b;

    arq = fopen ("atividade3.txt" , "r");

    if(arq == NULL){
        printf("Erro ao abrir o arquivo\n");
    }

    arq2 = fopen ("atividade3_1.txt", "r");

    if(arq2 == NULL){
        printf("Erro ao abrir o arquivo\n");
    }

    arq3 = fopen ("atividade3_2.txt", "w+");

     if(arq3 == NULL){
        printf("Erro ao abrir o arquivo\n");
    }

    while ((a = fgetc(arq)) != EOF) {
        fputc(a, arq3);
    }

    while ((b = fgetc(arq2)) != EOF) {
        fputc(b, arq3);
    }

    fclose(arq);
    fclose(arq2);
    fclose(arq3);
}
