//Leia 3 valores inteiros e ordene-os em ordem crescente. No final, mostre os valores em ordem crescente, uma linha em branco e em seguida, os valores na sequência como foram lidos.

//Entrada
//A entrada contem três números inteiros.

//Saída
//Imprima a saída conforme foi especificado.

#include <stdio.h>

int main() {
    int a, b, c;
    int menor, meio, maior;

    scanf("%d %d %d", &a, &b, &c);

    if (a <= b && a <= c) {
        menor = a;
        if (b <= c) {
            meio = b;
            maior = c;
        } else {
            meio = c;
            maior = b;
        }
    } else if (b <= a && b <= c) {
        menor = b;
        if (a <= c) {
            meio = a;
            maior = c;
        } else {
            meio = c;
            maior = a;
        }
    } else {
        menor = c;
        if (a <= b) {
            meio = a;
            maior = b;
        } else {
            meio = b;
            maior = a;
        }
    }

    printf("%d\n%d\n%d\n", menor, meio, maior);

    printf("\n");

    printf("%d\n%d\n%d\n", a, b, c);

    return 0;
}