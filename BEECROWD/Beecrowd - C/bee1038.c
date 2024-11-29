//Com base na tabela abaixo, escreva um programa que leia o código de um item e a quantidade deste item. A seguir, calcule e mostre o valor da conta a pagar.



//Entrada
//O arquivo de entrada contém dois valores inteiros correspondentes ao código e à quantidade de um item conforme tabela acima.

//Saída
//O arquivo de saída deve conter a mensagem "Total: R$ " seguido pelo valor a ser pago, com 2 casas após o ponto decimal.

#include <stdio.h>

int main(){
    int X, Y;
    float preco = 0;

    scanf("%d %d", &X, &Y);

    if (X == 1){
        preco = 4.00 * Y;
    }
    else if (X == 2){
        preco = 4.50 * Y;
    }
    else if (X == 3){
        preco = 5.00 * Y;
    }
    else if (X == 4){
        preco = 2.00 * Y;
    }
    else if (X == 5){
        preco = 1.50 * Y;
    }
    else {
        printf("Código do item inválido.\n");
        return 1;
    }

    printf("Total: R$ %.2f\n", preco);

    return 0;
}