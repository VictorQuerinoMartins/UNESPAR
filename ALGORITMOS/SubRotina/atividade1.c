// Implemente  uma função que receba dois números inteiros e apresente o maior número.

#include <stdio.h>

void maior(int n1, int n2){
    if (n1 > n2){
        printf("O primeiro numero eh maior que o segundo.");
        }else{
        printf("O primeiro numero eh menor que o segundo.");
        }
}

int main(){
    int n1, n2;
    printf("\n Digite o numero 1 \n");
    scanf("%d", &n1);
    printf("\n Digite o numero 2 \n");
    scanf("%d", &n2);

    maior(n1,n2);

}
