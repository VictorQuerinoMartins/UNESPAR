#include<stdio.h>
#include<stdlib.h>

main(){

    float r,pi,A;
    printf("Insira o valor do raio: ");
    scanf("%f",&r);
    pi=3.14;
    A=pi*r*r;

    printf("Area do circulo =  %.2f",A);

}


// M_pi ---> Constante global de pi.