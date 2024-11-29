// Implemente uma função que receba um número e apresente a raiz quadrada do mesmo.

#include <stdio.h>
#include <math.h>

double raiz(int x){
    double raiz;
    raiz = sqrt(x);
    return raiz;
}

int main(){
    int x;
    double r;

    printf("Digite um valor para saber a raiz quadrada: ");
    scanf("%d", &x);

    r = raiz(x);
    printf("\n A raiz eh: %.1lf", r);

    return 0;
}