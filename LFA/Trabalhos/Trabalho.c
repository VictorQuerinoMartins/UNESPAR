#include <stdio.h>

int main() {
    int estadoI;
    int qtdEstado;
    int qtdEstadoF;
    int estadoF[50];
    int qtdAlfa;
    char alfa[10];
    int estadoA;
    char palavra[20];

    // Pedindo para o usuário inserir as entradas.
    printf("Estado Inicial: ");
    scanf("%d", &estadoI);

    printf("Quantidade de Estados: ");
    scanf("%d", &qtdEstado);

    printf("Quantidade de Estados Finais: ");
    scanf("%d", &qtdEstadoF);

    for (int i = 0; i < qtdEstadoF; i++) {  // For usado para repetir quantas vezes de estados finais o usuário inserir
        printf("Digite o %d estado final: ", i + 1);
        scanf("%d", &estadoF[i]);
    }

    printf("Quantidade de simbolos no alfabeto: ");
    scanf("%d", &qtdAlfa);

    for (int i = 0; i < qtdAlfa; i++) {  // For usado para repetir quantos simbolos o usuário inserir
        printf("Digite o %d simbolo: ", i + 1);
        scanf(" %c", &alfa[i]);
    }

    int tabela[qtdEstado][qtdAlfa];  // Criando matriz para a tabela

    printf("Preencha a Tabela de Transicao: \n");
    for (int i = 0; i < qtdEstado; i++) {  // For usado para preencher a matriz
        for (int j = 0; j < qtdAlfa; j++) {
            printf("(Q%d, %c): ", i + 1, alfa[j]);
            scanf("%d", &tabela[i][j]);
        }
    }

    // Printar a tabela
    printf("Estado   ");
    for (int i = 0; i < qtdAlfa; i++) {
        printf(" %c ", alfa[i]);
    }
    printf("\n");

    for (int i = 0; i < qtdEstado; i++) {
        printf("Q%d      ", i + 1);
        for (int j = 0; j < qtdAlfa; j++) {
            printf("%d  ", tabela[i][j]);
        }
        printf("\n");
    }

    // Verificação de palavras
    printf("Digite a palavra a ser verificada: ");
    scanf("%s", palavra);

    estadoA = estadoI;

    // Verificar se o caractere pertence ao alfabeto
    for (int i = 0; palavra[i] != '\0'; i++) {  // percorre a string até encontrar um caractere nulo 
        int indice = -1;  // -1 indica que o caractere não foi encontrado no alfabeto.
        for (int j = 0; j < qtdAlfa; j++) {
            if (palavra[i] == alfa[j]) {
                indice = j;  // para salvar o índice (caractere), em j
                break;
            }
        }

        // Se índice ainda é -1, não está presente no alfabeto.
        if (indice == -1) {
            printf("Palavra contem simbolo nao pertencente ao alfabeto.\n");
            return 1;
        }

        estadoA = tabela[estadoA - 1][indice];  // Atualiza o estado
    }

    // Verifica o estado, para ver se é um estado aceitável
    int aceita = 0;
    for (int i = 0; i < qtdEstadoF; i++) {
        if (estadoA == estadoF[i]) {
            aceita = 1;
            break;
        }
    }

    if (aceita) {
        printf("Palavra aceita !!!!.\n");
    } else {
        printf("Palavra nao aceita ;-;.\n");
    }

    return 0;
}
