#include<stdio.h>
#include<stdlib.h>
#include<math.h>            // Biblioteca para funções matemáticas.

main(){
    float x, y;

    x=2;
    y= sqrt(x);
    printf("Raiz quadrada = %f \n", y);

    x=5;
    y= pow(x, 3);
    printf("Potencia = %f \n", y);

    x=1024;
    y= log2(x);
    printf("Logaritimo com base 2 = %f \n", y);

    x=1000;
    y= log(x);
    printf("Logaritmo natural %f \n", y);
    

}