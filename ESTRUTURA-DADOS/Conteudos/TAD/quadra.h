#ifndef QUADRA_H_INCLUDED
#define QUADRA_H_INCLUDED

typedef struct{
    float num;
    float num1;
    float num2;
} QuadradoEcubo;

QuadradoEcubo criarQuadrado(float num, float num1);
float calcularQuadrado(QuadradoEcubo);

QuadradoEcubo criarCubo(float num, float num1, float num2);
float calcularCubo(QuadradoEcubo);

#endif /* QUADRA_H_INCLUDED */

