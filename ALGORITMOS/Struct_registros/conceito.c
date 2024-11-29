// São estruturas que permitem o armazenamento de diferente tipos de dados
// Importante criar as struct fora do bloco main

#include <stdio.h>
// exemplo:
struct conta
{
    char titular[30];
    int numero;
    float saldo;
};
typedef struct conta Conta; // typedef  --> Serve para definir um nome nome para o registro

main()
{
    Conta m[10][6]; // Criando 60 contas

    Conta conta_individual;
    Conta conta_familiar;

    Conta conta_universitaria;
    conta_universitaria.numero = 100;
    strcpy(conta_universitaria.titular, "Henrique");
}
