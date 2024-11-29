//  Escreva um programa que contenha duas variáveis inteiras. Compare seus endereços e exiba o maior endereço.

#include <stdio.h>

int main(){

int A;
int B;

printf("valor A %d\n",&A);
printf("valor B %d\n",&B);

if(&A>&B){
    printf("ponteiroA com valor maior \n");
    }else if(&A<&B){
        printf("ponteiroB com valor maior\n");
    }
}