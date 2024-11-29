#include <stdio.h>

int main() {
    float cache, preco;
    int qtd;

    printf("Digite o valor do cache do show: ");
    scanf("%f", &cache);

    printf("Digite o preco do ingresso: ");
    scanf("%f", &preco);

    qtd = cache / preco;


    printf("Quantidade de convites a serem vendidos: %d", qtd);
}