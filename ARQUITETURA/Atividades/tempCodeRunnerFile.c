#include <stdio.h>
#include <stdlib.h>

int main() {
    int cilindro;
    int qtdCilindro;
    int movimento;

    printf("Tamanho do cilindro: ");
    scanf("%d", &cilindro);
    
    printf("Informe a quantidade de pedidos : ");
    scanf("%d", &qtdCilindro); 

    int requisicoes[qtdCilindro];

    for (int i = 0; i < qtdCilindro; i++) {
        printf("Informe o %d pedido de cilindro: ", i + 1);
        scanf("%d", &requisicoes[i]);
    }

    int inicio;
    printf("Informe a posicao inicial : \n");
    scanf("%d", &inicio);

    int posicaoAtual = inicio;

    printf("FCFS:\n");
    printf("Atendimento: %d ", posicaoAtual);

    for (int i = 0; i < qtdCilindro; i++) {
        movimento += requisicoes[i] - posicaoAtual; 
        posicaoAtual = requisicoes[i];
        printf("-- %d --", posicaoAtual);
    }
    
    printf("\nMovimento total do disco: %d \n", movimento);

    return 0;
}