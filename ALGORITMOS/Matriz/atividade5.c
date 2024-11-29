//Crie um programa que receba as vendas semanais (de um mês com quatro semanas) de três vendedores de uma loja e armazene essas vendas em uma matriz. O programa deverá calcular e mostrar:
//● o total de vendas do mês de cada vendedor;
//● o total de vendas de cada semana (todos os vendedores juntos);
//● o total de vendas do mês somando todos os vendedores.

#include <stdio.h>

int main() {
    int matrizVendas[3][4]; // 3 vendedores e 4 semanas
    int vendedores[3] = {0}; // Inicializar os totais de cada vendedor com zero
    int semana[4] = {0}; // Inicializar os totais de cada semana com zero
    int totalGeral = 0; // Inicializar o total geral com zero
    
    // Preencher a matriz de vendas
    printf("Digite as vendas semanais dos vendedores:\n");

    for (int i = 0; i < 3; i++) {
        printf("Vendedor %d: \n", i + 1);
         printf("\n");   
        for (int j = 0; j < 4; j++) {

            printf("Semana %d: ", j + 1);
            scanf("%d", &matrizVendas[i][j]);
            
            vendedores[i] += matrizVendas[i][j];
            semana[j] += matrizVendas[i][j];
            totalGeral += matrizVendas[i][j];
        }
    }
    
    printf("\nTotal de vendas do mes de cada vendedor:\n");
    for (int i = 0; i < 3; i++) {
        printf("Vendedor %d: %d\n", i + 1, vendedores[i]);
    }

    printf("\nTotal de vendas de cada semana:\n");
    for (int j = 0; j < 4; j++) {
        printf("Semana %d: %d\n", j + 1, semana[j]);
    }
    
    printf("\nTotal de vendas do mes somando todos os vendedores: %d\n", totalGeral);
}