#include <stdio.h>
#include "quadra.h"
int main(){
    

 QuadradoEcubo meuQua = criarQuadrado(2.0, 2.0); 

    float quadrado = calcularQuadrado(meuQua);
    printf("O quadrado do meus numeros eh igual a: %.2f \n", quadrado);

QuadradoEcubo meuCubo = criarCubo(5.0, 3.0, 2.0); 

    float cubo = calcularCubo(meuCubo);
    printf("O valor ao cubo eh igual a: %.2f \n", cubo);

    return 0;
}