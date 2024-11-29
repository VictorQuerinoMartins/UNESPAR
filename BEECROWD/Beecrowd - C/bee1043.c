//Leia 3 valores reais (A, B e C) e verifique se eles formam ou não um triângulo. Em caso positivo, calcule o perímetro do triângulo e apresente a mensagem:


//Perimetro = XX.X


//Em caso negativo, calcule a área do trapézio que tem A e B como base e C como altura, mostrando a mensagem


//Area = XX.X

//Entrada
//A entrada contém três valores reais.

//Saída
//O resultado deve ser apresentado com uma casa decimal.

#include <stdio.h>

int main(){

    double a, b, c;

    scanf("%lf %lf %lf", &a, &b, &c);

    if (a + b > c && a + c > b && b + c > a) {
        printf("Perimetro = %.1lf\n", a + b + c);
    } else {
        printf("Area = %.1lf\n", ((a + b) * c) / 2);
    }

    return 0;
}