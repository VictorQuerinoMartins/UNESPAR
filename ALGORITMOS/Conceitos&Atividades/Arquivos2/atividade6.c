//6. Uma loja possui 4 filiais, cada uma com um código de 1 a 4. Um arquivo contendo todas as vendas feitas durante o dia nas quatro filiais é gerado a partir de uma planilha, sendo que cada linha do arquivo contém o número da filial e o valor de uma venda efetuada, separados por vírgula. Ex.:
//•1,189.90
//•1,45.70
//•3,29.90
//•4,55.00
//No exemplo acima, a filial 1 fez duas vendas, a primeira totalizando R$ 189,90 e a segunda R$ 45,70. A filial 3 fez uma venda de R$ 29,90 e a 4 também uma de R$ 55,00. Faça um programa que leia este arquivo e informe, ao final, o total e o valor médio das vendas de cada filial.


#include <stdio.h>
#include <stdlib.h>


typedef struct {
    int filial;
    double valor;
} Venda;

int main() {
    FILE *arquivo;
    Venda vendas[4] = {{1, 0}, {2, 0}, {3, 0}, {4, 0}};
    int filial;
    double valor;
    int totalVendas[4] = {0};

    arquivo = fopen("vendas.txt", "r");

    if (arquivo == NULL) {
        perror("Erro ao abrir o arquivo");
        exit(EXIT_FAILURE);
    }

    while (fscanf(arquivo, "%d,%lf", &filial, &valor) != EOF) {
        if (filial == 1) {
            vendas[0].valor += valor;
            totalVendas[0]++;
        } else if (filial == 2) {
            vendas[1].valor += valor;
            totalVendas[1]++;
        } else if (filial == 3) {
            vendas[2].valor += valor;
            totalVendas[2]++;
        } else if (filial == 4) {
            vendas[3].valor += valor;
            totalVendas[3]++;
        }
    }

    printf("Total e valor médio das vendas por filial:\n");
    for (int i = 0; i < 4; i++) {
        printf("Filial %d: Total de vendas: R$ %.2lf, ", vendas[i].filial, vendas[i].valor);
        if (totalVendas[i] > 0) {
            printf("Valor médio: R$ %.2lf\n", vendas[i].valor / totalVendas[i]);
        } else {
            printf("Valor médio: R$ 0.00\n");
        }
    }

    fclose(arquivo);

    return 0;
}
