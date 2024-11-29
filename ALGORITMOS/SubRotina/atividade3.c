// Implemente uma função que calcule o fatorial de um número.

#include <stdio.h>

int fatorial(int num){
    int fat;

    if (num <= 1){
        printf("Nao existe numero de fatorial negativo"); }

   fat = 1;
   for (int i=2; i <= num; i++){
      fat = (fat * i);}
   return (fat) ;
}

int main(){
    int x, resultado;

    printf("Digite um valor para saber seu fatorial: ");
    scanf("%d", &x);

    resultado = fatorial(x);
    printf("\n O fatorial eh: %d", resultado);

    return 0;
}