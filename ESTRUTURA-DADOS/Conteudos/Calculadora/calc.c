#include "calc.h"
#include <stdio.h>
#include <stdlib.h>

Calculadora* criarCalculadora() {// inicia a calculadora

    Calculadora *calc = (Calculadora*)malloc(sizeof(Calculadora));
    if (calc != NULL) {
        calc->resultado = 0;
    }
    return calc;
}

void destruirCalculadora(Calculadora *calc) {
    free(calc);
}

void somar(Calculadora* calc, int valor) {
    calc->resultado += valor;
}

void subtrair(Calculadora* calc, int valor) {
    calc->resultado -= valor;
}

void multiplicar(Calculadora* calc, int valor) {
    calc->resultado *= valor;
}

void imprimirResultado(const Calculadora* calc) {
    printf("Resultado: %d\n", calc->resultado);
}