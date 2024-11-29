#include <stdio.h>
#include <stdlib.h>

int main() {
    int Tcilindro;
    int qtdPedidos;

    printf("Tamanho do cilindro: ");
    scanf("%d", &Tcilindro);

    printf("Informe a quantidade de pedidos: ");
    scanf("%d", &qtdPedidos);

    int pedidos[qtdPedidos];
    int posicaoAtual = 0;

    for (int i = 0; i < qtdPedidos; i++) {
        printf("Informe o %d pedido de cilindro: ", i + 1);
        scanf("%d", &pedidos[i]);
    }

    printf("SSF:\n");
    printf("Atendimento: %d\n", qtdPedidos);

    for (int i = 0; i < qtdPedidos; i++) {
        int indiceP = -1;                       //indece mais proximo = indeceP
        int distanM = 10000; 

       
        for (int j = 0; j < qtdPedidos; j++) {
            if (pedidos[j] != -1) {
                int distancia = (pedidos[j] - posicaoAtual);
                
                if (distancia < distanM) {
                    distanM = distancia;
                    indiceP = j;
                }
            }
        }
        posicaoAtual = pedidos[indiceP];
        pedidos[indiceP] = -1;

        printf("\nMarcando pedido na posicao: %d\n", posicaoAtual);
        
        for (int j = 0; j < Tcilindro; j++) {
            if (j == posicaoAtual) {
                printf("| %d:XX |", j);
            } else {
                printf(" %d:00 |", j);
            }
        }
        printf("\n");
    }

    return 0;
}
