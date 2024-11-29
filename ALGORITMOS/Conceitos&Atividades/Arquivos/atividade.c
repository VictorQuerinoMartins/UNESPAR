#include <stdio.h>
#include <stdlib.h>

main(){
    FILE *arq;
    char nome[80];

    arq = fopen("Victor.txt", "w");  

    fputs("Meu nome eh orangutango", arq);

     fclose (arq);
}