//Um vendedor recebe um salário fixo mais 6% de comissão sobre suas vendas. Crie um algoritmo que tenha um registro de vendedor, com o salário fixo, valor total de suas vendas, comissão e o salário final. Crie uma sub-rotina que receba um vendedor como parâmetro (por valor ou por referência). Na subrotina, peça ao usuário para digitar o valor do salário fixo, o valor total de vendas e calcule (na mesma subrotina) a comissão e o salário final. Na função principal, mostre todas as informações. Faça isso para dois funcionários diferentes.

#include <stdio.h>
#include <stdlib.h>

typedef struct vendedor{
    float salario;
    float valorT;
    float comissao;
    float salarioF;
}vendedor;

void calculo(vendedor *cleitin){
    printf("Digite o valor do seu salario fixo: \n");
    scanf("%f", &cleitin -> salario);

    printf("Digite o total de vendas: \n");
    scanf("%f", &cleitin -> valorT);

cleitin -> comissao =  cleitin -> valorT * 0.06;
cleitin -> salarioF = cleitin -> salario + cleitin -> comissao;
}

main(){

vendedor cleito[2];

for(int i = 0; i < 2; i++){

    printf("\n Informacoes do vendedor %d:\n", i +1);

    calculo(&cleito[i]);
    printf("\n Salario Fixo: %.2f", cleito[i].salario);
    printf("\n valorT: %.2f", cleito[i].valorT);
    printf("\n Comissao: %.2f", cleito[i].comissao);
    printf("\n Salario Final: %.2f", cleito[i].salarioF);
    }
}