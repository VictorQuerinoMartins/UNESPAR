//Acesso → “Chegar” até um nó;
//Visita → Testar se o nó sendo acessado é o nó objetivo;
//Objetivo → Nó procurado;
//Percurso → Lista de todos os nós visitados até o nó a ser encontrado;
//Caminho → Nós que devem ser percorridos para chegar ao nó encontrado;

// Entradas -> num de vértices, vertice inicial e grafo(matriz);
// Saída -> Caminho percorrido;

#include <stdio.h>
#include <stdlib.h>

typedef struct{
    int elementos[50];
    int inicio, fim;
}fila;

void iniciar(fila *f){
    for(int i =0; i<50; i++){
        f->elementos[i] = 0;
    }
    f->inicio = 0;
    f->fim = 0;
}

int vazia(fila *f){
    return f->inicio == f->fim;
}

void enfileirar(fila *f, int vertice){
    f->elementos[f->fim++] = vertice;  // gauarda o vertice e incrementa no fim da lista
}

int desenfileirar(fila *f) {
    return f->elementos[f->inicio++];  // retorna o primeiro elemento e avança o inicio pra frente
}

// Entradas -> num de vértices, vertice inicial e grafo(matriz);
// Saída -> Caminho percorrido;

void buscar_largura(int grafo[50][50],int numVert,int inicio){
    int visitado[50] = {0};
    fila f;
    iniciar(&f);

    printf("Ordem de visita: ");
    enfileirar(&f, inicio);
    visitado[inicio] = 1;   // vertice inicial marcado como visitado

    while(!vazia(&f)){                 // enquanto a fila não estiver vazia
        int v = desenfileirar(&f);
        printf("%d ", v);

        for(int i = 0; i < numVert; i++){
            if(grafo[v][i] && !visitado[i]){    // v = vertice, i = aresta se a conex entre ambos e vertice não visitado
                enfileirar(&f, i); // coloca i na fila
                visitado[i] = 1;
            }
        }
    }
    printf("\n");
}

int main() {
    int numVert = 5; 
    int inicio = 0;   

    int grafo[50][50] = {       //cada ponto é um vértice, e o número 1 indica que existe uma conexão entre eles
        {0, 1, 0, 1, 0},
        {1, 0, 1, 0, 1},
        {0, 1, 0, 0, 0},
        {1, 0, 0, 0, 0},
        {0, 1, 0, 0, 0}
    };

    buscar_largura(grafo, numVert, inicio);
    return 0;
}