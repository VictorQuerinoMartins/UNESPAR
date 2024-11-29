#include <stdio.h>
#include<stdlib.h>
#include "quadra.h"

QuadradoEcubo criarQuadrado(float num, float num1){
    QuadradoEcubo qua;
    qua.num = num;
    qua.num1 = num1;
    return qua;
}

QuadradoEcubo criarCubo(float num, float num1, float num2){
    QuadradoEcubo cubo;
    cubo.num = num;
    cubo.num1 = num1;
    cubo.num2 = num2;
    return cubo;
}

float calcularQuadrado(QuadradoEcubo qua){
    return qua.num * qua.num1;
}

float calcularCubo(QuadradoEcubo cubo){
    return cubo.num * cubo.num1 * cubo.num2;
}
