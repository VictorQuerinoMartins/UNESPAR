#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int elementos[50];
    int topo;
} pilha;

void iniciarPilha(pilha *p) {
    p->topo = -1;
}

int pilhaVazia(pilha *p) {
    return p->topo == -1;
}

void empilhar(pilha *p, int vertice) {
    p->elementos[++(p->topo)] = vertice;  
}

int desempilhar(pilha *p) {
    return p->elementos[(p->topo)--]; 
}

// Entradas -> num de vértices, vértice inicial e grafo (matriz);
// Saída -> Caminho percorrido;

void buscar_profundidade(int grafo[50][50], int numVert, int inicio) {
    int visitado[50] = {0};
    pilha p;
    iniciarPilha(&p);

    printf("Ordem de visita por profundidade: ");
    empilhar(&p, inicio);
    visitado[inicio] = 1;  // vértice inicial marcado como visitado

    while (!pilhaVazia(&p)) {  // snquanto a pilha não estiver vazia
        int v = desempilhar(&p);
        printf("%d ", v);

        for (int i = 0; i < numVert; i++) {
            if (grafo[v][i] && !visitado[i]) {  // se existe uma conexão e o vértice não foi visitado
                empilhar(&p, i);  // smpilha o vértice
                visitado[i] = 1;
            }
        }
    }
    printf("\n");
}

int main() {
    int numVert = 5;
    int inicio = 0;

    int grafo[50][50] = {  
        {0, 1, 0, 1, 0},
        {1, 0, 1, 0, 1},
        {0, 1, 0, 0, 0},
        {1, 0, 0, 0, 0},
        {0, 1, 0, 0, 0}
    };

    buscar_profundidade(grafo, numVert, inicio);
    return 0;
}
