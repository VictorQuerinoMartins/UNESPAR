#include <stdlib.h>
#include <stdio.h>

int main(){

    // Declarando variáveis
    int x, *ptrx, **pptrx;
    x = 0;

    // Imprimindo o valor e endereço de x
    printf("Valor de X: %d\n", x);   
    printf("Endereco de X: %x\n", &x);   

    // Atribuindo o endereço de x ao ponteiro ptrx
    ptrx = &x;

    // Atribuindo o endereço de ptrx ao ponteiro duplo pptrx
    pptrx = &ptrx;

    // Incrementando o valor de x através de ptrx
    *ptrx = *ptrx + 10;
    printf("\n Valor de x = %d", x);
    printf("\nEndereco apontado por ptrx: %x\n", ptrx);  
    printf("\nValor da variavel X que esta sendo apontada por ptrx: %d\n", *ptrx);    
    printf("\nEndereco de memoria da variavel ptrx: %x\n", &ptrx);

    // Incrementando o valor de x através de **pptrx
    **pptrx = **pptrx + 10;
    printf("\n Valor de x = %d", x);
    printf("\nEndereco apontado por **pptrx: %x\n", pptrx);  
    printf("\nValor da variavel para a qual pptrx faz referencia: %d", **pptrx);    
    printf("\nEndereco de memoria da variavel **ptrx: %x\n\n", &pptrx);

    return 0;
}
