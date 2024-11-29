#include <stdio.h>
#include "retan.h"
int main(){
    //Exemplo do uso TAD retangulo
    Retangulo meuRetangulo = criarRetangulo(5.0, 3.0); //comprimento 5, largura 3

    //Calculando e exibindo a área do retângilo
    float area = calcularArea(meuRetangulo);
    printf("A area do meu retangulo eh: %.2f \n", area);

    return 0;
}