//– Crie uma struct para controlar ações de uma bolsa de valores com as seguintes informações:
//● Nome da compania
//● Área de atuação da compania
//● Valor atual da ação (em reais)
//● Valor anterior
//● Variação da ação em porcentagem (double), ou seja, quanto a ação cresceu ou caiudesde a abertura a bolsa no dia.

//Faça um programa que:
//a) Preencha os campos da struct
//b) Imprima os campos da struct
//c) Com um laço, preencha 3 structs (vetor de structs)
//d) Dado um valor de ação pelo usuário, imprima as informações das ações queestão abaixo do valor informado.

#include <stdio.h>
#include <stdlib.h>

struct bolsavalor{

char nome[20];
char atuacao[20];
float valor;
float valorants;
int variacao;
};

typedef struct bolsavalor bolsa;

main(){

bolsa exemplo = {"Anatel", "Chipamze", 550, 200, 20};

    printf("Nome da compania: %s \n", exemplo.nome);
    printf("Area de atuacao: %s \n", exemplo.atuacao);
    printf("Valor atua da acao R$ %.2f ", exemplo.valor);
    printf("Valor anterior R$ %.2f ", exemplo.valorants);

    int porcentagem = (((exemplo.valor - exemplo.valorants) / exemplo.valorants) * 100);
    printf("A valorizacao da acao foi de %d porcento\n", porcentagem);

   bolsa acoes[3];

    for (int i = 0; i < 3; i++) {

        printf("\nDados da Acao %d:\n", i + 1);

        printf("Nome:\n ");
        scanf("%s", acoes[i].nome);

        printf("Area de Atuacao:\n ");
        scanf("%s", acoes[i].atuacao);
    
        printf("Valor Atual (R$): \n");
        scanf("%f", &acoes[i].valor);

        printf("Valor Anterior (R$): \n");
        scanf("%f", &acoes[i].valorants);

        int porcentagem2 = (((exemplo.valor - exemplo.valorants) / exemplo.valorants) * 100);
    printf("A valorizacao da acao foi de %d porcento\n", porcentagem2);
    }

}
