//Crie uma sub-rotina que receba como parâmetro um valor inteiro e positivo e retorne a soma dos divisores desse valor. Utilize passagem por referência.

#include <stdio.h>
void soma_divisor(int valor, int *resultado){

    for(int i=1; i <= valor; i++){
        *resultado = 0;
        if(valor % i == 0 ){
            *resultado += i;
        }
    }
}

int main(){
    int numero, resultado;

printf("Insira um numero positivo: ");
    scanf("%d", &numero);

if(numero > 0){

    soma_divisor(numero, &resultado);
    printf("A soma dos divisores de %d valor eh igual a: %d ", numero, resultado);
}else{
    printf("Nao");

    return 0;
}
}