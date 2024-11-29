#include <stdio.h>
#include <stdlib.h>

typedef struct no {
    int conteudo;
    struct no *esquerda, *direita;
} No;

typedef struct {
    No *raiz;
} ArvB;

void inserir(No **no, int valor) {
    if (*no == NULL) {
        No *novo = (No*)malloc(sizeof(No));
        novo->conteudo = valor;
        novo->esquerda = NULL;
        novo->direita = NULL;
        *no = novo;
    } else {
        if (valor < (*no)->conteudo)
            inserirEsquerda(&(*no)->esquerda, valor);
        else
            inserirDireita(&(*no)->direita, valor);
    }
}

void inserirEsquerda(No **no, int valor) {
    if (*no == NULL) {
        No *novo = (No*)malloc(sizeof(No));
        novo->conteudo = valor;
        novo->esquerda = NULL;
        novo->direita = NULL;
        *no = novo; // Aponta para o novo nó
    } else {
        if (valor < (*no)->conteudo)
            inserirEsquerda(&(*no)->esquerda, valor);
        else
            inserirDireita(&(*no)->direita, valor);
    }
}

void inserirDireita(No **no, int valor) {
    if (*no == NULL) {
        No *novo = (No*)malloc(sizeof(No));
        novo->conteudo = valor;
        novo->esquerda = NULL;
        novo->direita = NULL;
        *no = novo; // Aponta para o novo nó
    } else {
        if (valor > (*no)->conteudo)
            inserirDireita(&(*no)->direita, valor);
        else
            inserirEsquerda(&(*no)->esquerda, valor);
    }
}

int tamanho(No *raiz) {
    if (raiz == NULL)
        return 0;
    return 1 + tamanho(raiz->esquerda) + tamanho(raiz->direita); // Conta o nó atual e os nós à esquerda e à direita
}

// Função para imprimir a árvore em pos-ordem
void imprimir(No *raiz) {
    if (raiz != NULL) {
        imprimir(raiz->esquerda); 
        imprimir(raiz->direita); 
        printf("%d  ", raiz->conteudo); 
    }
}

int main() {
    int op, valor;
    ArvB arv;
    arv.raiz = NULL; 
 
    do {
        printf("\n0 - sair\n1 - inserir\n2 - imprimir\n3 - Buscar\n4 - Remover\n");
        scanf("%d", &op);
        switch (op) {
            case 0:
                printf("\nSaindo...\n");
                break;
            case 1:
                printf("Digite um valor: ");
                scanf("%d", &valor);
                inserir(&arv.raiz, valor); // Passa a raiz da árvore por referência para a função de inserção
                break;
            case 2:
                printf("\nImpressao da arvore:\n");
                imprimir(arv.raiz);
                printf("\n");
                printf("\nTamanho: %d \n", tamanho(arv.raiz)); 
                break;
        }
    } while (op != 0); 

    return 0;
}