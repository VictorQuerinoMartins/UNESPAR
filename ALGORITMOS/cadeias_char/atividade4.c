//Faça um programa para criptografar uma frase dada pelo usuário (a criptografia troca as vogais da frase por *). Mostre a mensagem criptografada na tela.
//Exemplo:

//Frase: EU ESTOU NA ESCOLA
//Saída: ** * ST** N* *SC*L*

#include <stdio.h>
#include <string.h>
#include <ctype.h>

int main() {
    char frase[80];
    char vogais[] = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U', '\0'};

    printf("Informe uma frase:\n");
    gets(frase);

    for (int i = 0; i < strlen(frase); i++) {
        for (int j = 0; i < strlen(vogais); j++) {
            if (tolower(vogais[j]) == tolower(frase[i])) {
                frase[i] = '*';
            }
        }
    }

    printf("Frase criptografada: %s\n", frase);
}
