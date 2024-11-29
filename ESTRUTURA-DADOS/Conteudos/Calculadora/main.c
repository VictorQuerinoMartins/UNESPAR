#include <stdio.h>
#include <stdlib.h>
#include "calc.h"

int main() {
    // Exemplo de uso da calculadora
    Calculadora *calc =  criarCalculadora(); // inicia com zero a calculadora

    if (calc != NULL)
        {
        somar(calc, 5);
        multiplicar(calc, 3);
        subtrair(calc, 2);

        imprimirResultado(calc);
        destruirCalculadora(calc);
    }

    return 0;
}