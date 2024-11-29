//Faça um programa que leia três valores e apresente o maior dos três valores lidos seguido da mensagem “eh o maior”. Utilize a fórmula:

//MaiorAB = (a+b+abs(a-b)) / 2

//Obs.: a fórmula apenas calcula o maior entre os dois primeiros (a e b). Um segundo passo, portanto é necessário para chegar no resultado esperado.

//Entrada
//O arquivo de entrada contém três valores inteiros.

//Saída
//Imprima o maior dos três valores seguido por um espaço e a mensagem "eh o maior".

#include <stdio.h>

int main(){

int a, b, c, maior;

scanf("%d %d %d", &a, &b, &c);

maior = a;

if(a < b || a < c){
if(b < c){
    maior = c;
    }

    else{
        maior = b;
    }
}
    printf("%d eh o maior\n", maior);
    return 0;
}    