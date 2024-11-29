//Um vendedor recebe um salário fixo mais 6% de comissão sobre suas vendas. Crie um algoritmo que tenha um registro de vendedor, com o salário fixo, valor total de suas vendas, comissão e o salário final. Crie uma sub-rotina que receba um vendedor como parâmetro (por valor ou por referência). Na subrotina, peça ao usuário para digitar o valor do salário fixo, o valor total de vendas e calcule (na mesma subrotina) a comissão e o salário final. Na função principal, mostre todas as informações. Faça isso para dois funcionários diferentes.


#include <stdio.h>
#include <stdlib.h>

struct vendedor{
    float salario;
    float totalVendas;
    float comissao;
    float salarioF;
};

typedef struct vendedor vendedor;

void calculoComissao(vendedor *vendedor){
    printf("\n Digite o valor do seu salario fixo: ");
    scanf("%f", &vendedor -> salario);

    printf("\n Digite o valor do total de vendas: ");
    scanf("%f", &vendedor -> totalVendas);

    vendedor -> comissao =  0.60 * vendedor -> totalVendas;
    vendedor -> salarioF = vendedor -> comissao + vendedor -> salario;
}

main(){
    vendedor vend[2];

for(int i = 0; i < 2; i++){

    printf("Dados vendedor %d: ", i + 1);
    calculoComissao(&vend[i]);

    printf("Salario Fixo: %.2f\n", vend[i].salario);
    printf("Total de vendars: %.2f\n", vend[i].totalVendas);
    printf("Comissao: %.2f\n", vend[i].comissao);
    printf("Salario Final: %.2f\n", vend[i].salarioF);
}
}
