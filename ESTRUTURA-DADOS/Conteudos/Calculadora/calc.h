#ifndef CALC_H_INCLUDED
#define CALC_H_INCLUDED

typedef struct {
    int resultado;
}Calculadora;

// Funções da calculadora
Calculadora *criarCalculadora();
void destruirCalculadora(Calculadora* calc);
void somar(Calculadora* calc, int valor);
void subtrair(Calculadora* calc, int valor);
void multiplicar(Calculadora* calc, int valor);
void imprimirResultado(const Calculadora* calc);

#endif /* CALCULADORA_H */