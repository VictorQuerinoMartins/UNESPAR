// Faça um programa que leia dois valores inteiros e chame uma função que receba estes 2 valores de entrada e insira o maior valor na primeira variável e o menor valor na segunda variável. No programa principal, escreva o conteúdo das 2 variáveis na tela.

#include <stdio.h>
#include <stdlib.h>

void OrdenarValores(int *a, int *b) {
    if (*a > *b){
    int temp = *a;
    *a = *b;
    *b = temp;
    }
}

main(){
int A, B;

printf("Digite um numero para armazenar em A: ");
scanf("%d", &A);

printf("Digite um numero para armazenar em B: ");
scanf("%d", &B);
    
OrdenarValores(&A,&B);

printf("Valor A: %d\n", A);
printf("Valor B: %d\n", B);
}
