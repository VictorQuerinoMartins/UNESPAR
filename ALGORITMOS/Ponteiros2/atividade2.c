
#include <stdio.h>
#include <stdlib.h>

Calculo(int *A, int *B){
    int dobro = 2* (*A);
    int dobro1 = 2* (*B);
    int soma = (dobro + dobro1);
    printf("A soma dos dobros das variaveis eh de : %d", soma);
}

main(){
    int A, B;
    printf("Insira um mvalor para A: ");
    scanf("%d",&A);

    printf("Insira um valor para B: ");
    scanf("%d", &B);

    Calculo(&A, &B);
}