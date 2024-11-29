#include <stdio.h>

struct tipo_pessoa{
    int idade;
    float peso;
    char nome[50];
};

typedef struct tipo_pessoa pessoa;

int main(){
    pessoa pes = {0, 0.0, "Teste"};

    printf("Inicio: \n");
    printf("pes.idade: %d \n", pes.idade);
    printf("pes.peso: %.2f \n",pes.peso);
    printf("pes.idade: %s \n", pes.nome);

    pes.idade = 10;
    pes.peso = 99.99;
    strcpy(pes.nome, "Texto");

    printf("\n Alterado os campos via codigo!!!\n");
    printf("pes.idade: %d \n", pes.idade);
    printf("pes.peso: %.2f \n",pes.peso);
    printf("pes.idade: %s \n", pes.nome);

// Usuário escolhe o conteudo

    printf("\n Isina um numero inteiro: \n");
    scanf("%d", &pes.idade);

    printf("\n Isina um numero real: \n");
    scanf("%f", &pes.peso);
    fflush(stdin);

    printf("\n Isina um nome: \n");
    scanf("%s", &pes.nome);

    printf("\n Alterado os campos via codigo!!!\n");
    printf("pes.idade: %d \n", pes.idade);
    printf("pes.peso: %.2f \n",pes.peso);
    printf("pes.idade: %s \n", pes.nome);

    }