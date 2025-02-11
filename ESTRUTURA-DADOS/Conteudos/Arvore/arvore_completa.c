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

// Função para imprimir a árvore em ordem
void imprimir(No *raiz) {
    if (raiz != NULL) {
        imprimir(raiz->esquerda); 
        printf("%d  ", raiz->conteudo); 
        imprimir(raiz->direita); 
    }
}

// Função para imprimir a árvore pos-ordem
void imprimirpos(No *raiz) {
    if (raiz != NULL) {
        imprimirpos(raiz->esquerda); 
        imprimirpos(raiz->direita); 
        printf("%d  ", raiz->conteudo); 
    }
}

// Função para imprimir a árvore em pre-ordem
void imprimirpre(No *raiz) {
    if (raiz != NULL) {
        printf("%d  ", raiz->conteudo); 
        imprimirpre(raiz->esquerda); 
        imprimirpre(raiz->direita); 
    }
}

void verifica(No *raiz){
    if (raiz != NULL) {
        verifica(raiz->esquerda); // Verifica os nós à esquerda
        if (raiz->conteudo % 2 == 0) { 
            printf("\nNo par: %d", raiz->conteudo);
        }
        verifica(raiz->direita); // Verifica os nós à direita
    }
}

No* remover(No *raiz, int chave) {
    if (raiz == NULL) {
        printf("Valor nao encontrado!\n");
        return NULL;
    } else {
        if (raiz->conteudo == chave) {
            // Caso 1: Nó folha
            if (raiz->esquerda == NULL && raiz->direita == NULL) {
                free(raiz);
                printf("Elemento folha removido: %d!\n", chave);
                return NULL;
            }
            // Caso 2: Nó com apenas um filho
            else if (raiz->esquerda == NULL) {
                No* temp = raiz->direita;
                free(raiz);
                printf("Elemento com um filho removido: %d!\n", chave);
                return temp;
            } else if (raiz->direita == NULL) {
                No* temp = raiz->esquerda;
                free(raiz);
                printf("Elemento com um filho removido: %d!\n", chave);
                return temp;
            }
            // Caso 3: Nó com dois filhos
            else {
                No* sucessor = raiz->direita;
                // Encontrando o sucessor (menor elemento da subárvore direita)
                while (sucessor->esquerda != NULL) {
                    sucessor = sucessor->esquerda;
                }
                // Substitui o conteúdo do nó pelo sucessor
                raiz->conteudo = sucessor->conteudo;
                // Remove o sucessor recursivamente
                raiz->direita = remover(raiz->direita, sucessor->conteudo);
            }
        } else if (chave < raiz->conteudo) {
            raiz->esquerda = remover(raiz->esquerda, chave);
        } else {
            raiz->direita = remover(raiz->direita, chave);
        }
        return raiz;
    }
}

int main() {
    int op, valor;
    ArvB arv;
    arv.raiz = NULL; 

    do {
        printf("\n0 - sair\n1 - inserir\n2 - imprimir em ordem\n3 - imprimir em pre-ordem\n4 - imprimir em pos-ordem\n5 - Buscar\n6 - Remover\n");
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
                printf("\nImpressao da arvore em ordem:\n");
                imprimir(arv.raiz);
                verifica(arv.raiz);
                printf("\n");
                break;
            case 3:
                printf("\nImpressao da arvore em pre-ordem:\n");
                imprimirpre(arv.raiz);
                verifica(arv.raiz);
                printf("\n");
                break;
            case 4:
                printf("\nImpressao da arvore em pos-ordem:\n");
                imprimirpos(arv.raiz);
                verifica(arv.raiz);
                printf("\n");
                break;
            
            case 6:
                printf("\nRemover folha: ");
                scanf("%d", &valor);
                arv.raiz = remover(arv.raiz, valor);
                printf("\n");
                break;
        }
    } while (op != 0); 

    return 0;
}

