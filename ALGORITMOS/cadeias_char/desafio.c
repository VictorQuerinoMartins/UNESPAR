//Faça um programa que receba o nome completo de uma pessoa e mostre os nomes intermediários entre o primeiro nome e o último sobrenome abreviados.
//Exemplo:
//Nome: Maria Silva Costa
//Saída: Maria S. Costa

//Nome: João Carlos Gomes Marques
//Saída: João C. G. Marques

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

main(){
    char nome[100];
    int qual;
    gets(nome);


    for(int i=0; i < strlen(nome); i++){
        if(nome[i] == ' '){
            nome [i + 2] = '.';
            qual = i+2;
        }
    }

    for( int k = qual+1; k < strlen(nome); k++){
        nome[k] = ' ';
    }
    printf(nome);
}