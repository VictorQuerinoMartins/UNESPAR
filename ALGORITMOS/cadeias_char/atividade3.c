//Faça um programa que receba uma frase, calcule e mostre a quantidade de vogais da frase digitada. O programa deverá contar vogais maiúsculas e minúsculas.
//Exemplo:

//Entrada
//Frase: Eu moro em Apucarana.

//Saída
//Quantidade de vogais: 10.

#include <stdio.h>
#include <string.h>
#include <ctype.h>

int main() {
    int cont = 0;
    char frase[80];
    char vogais[] = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U', '\0'};

    printf("Informe uma frase:\n");
    gets(frase);

    for (int i = 0; i < strlen(frase); i++) {
        for (int j = 0; i < strlen(vogais); j++) {
            if (vogais[j] == frase[i]) {
               cont++;
               
            }
        }
    }

    printf("Quantidade de vogais encontradas: %d\n",cont);

}

