//Leia 3 valores de ponto flutuante e efetue o cálculo das raízes da equação de Bhaskara. Se não for possível calcular as raízes, mostre a mensagem correspondente “Impossivel calcular”, caso haja uma divisão por 0 ou raiz de numero negativo.

//Entrada
//Leia três valores de ponto flutuante (double) A, B e C.

//Saída
//Se não houver possibilidade de calcular as raízes, apresente a mensagem "Impossivel calcular". Caso contrário, imprima o resultado das raízes com 5 dígitos após o ponto, com uma mensagem correspondente conforme exemplo abaixo. Imprima sempre o final de linha após cada mensagem.

#include <stdio.h>
#include <math.h>

int main(){
    double A, B ,C;

    scanf("%lf %lf %lf", &A, &B, &C);

if((B * B) - 4 * A * C < 0 || A == 0){
    printf("Impossivel calcular\n");
}else{
double t = sqrt((B * B) - 4 * A * C);
  printf("R1 = %.5lf\nR2 = %.5lf\n", ((-B + t) / (2 * A)), ((-B - t) / (2 * A)));
}

    return 0;
}