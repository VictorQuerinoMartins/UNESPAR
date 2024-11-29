// Escreva um programa que declare um inteiro, um real e um char, e ponteiros para inteiro, real, e char. Associe as variáveis aos ponteiros (use &). Modifique os valores de cada variável usando os ponteiros. Imprima os valores das variáveis antes e após a modificação.

#include <stdio.h>

int main() {
    int inteiro = 10;
    double real = 3.14;
    char texto ='i';

    int *pint = &inteiro;
    double *preal = &real;
    char *ptexto = &texto;

    printf("Valores antes da modificacao:\n");
    printf("Inteiro: %d\nReal: %.2lf\nTexto: %c\n\n", inteiro, real, texto);

    *pint = 20;
    *preal = 6.28;
    *ptexto ='I';

    printf("Valores apos a modificacao:\n");
    printf("Inteiro: %d\nReal: %.2lf\nTexto: %c\n", inteiro, real, texto);

    return 0;
}
