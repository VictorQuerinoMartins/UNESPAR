#include <stdio.h>
#include <limits.h>

#define infinito INT_MAX

int encontrarMenordistancia(int dtc[], int visitado[], int numVert) { // dtc = distancia
    int min = infinito, minIndice;
    
    for (int i = 0; i < numVert; i++) {
        if (!visitado[i] && dtc[i] <= min) {
            min = dtc[i];
            minIndice = i;
        }
    }
    return minIndice;
}

void dijkstra(int grafo[50][50], int numVert, int origem) {
    int dtc[50];
    int visitado[50] = {0};
    
    for (int i = 0; i < numVert; i++) {
        dtc[i] = infinito;   // sem info = infinito
    }
    dtc[origem] = 0;         // origem = 0
    
    for (int count = 0; count < numVert - 1; count++) {
        int u = encontrarMenordtccia(dtc, visitado, numVert);
        visitado[u] = 1;  // marca o vértice como visitado
        
        for (int v = 0; v < numVert; v++) {
            if (!visitado[v] && grafo[u][v] && dtc[u] != infinito && dtc[u] + grafo[u][v] < dtc[v]) {
                dtc[v] = dtc[u] + grafo[u][v];  // atualiza a distância
            }
        }
    }
    
    for (int i = 0; i < numVert; i++) {
        if (dtc[i] == infinito) {
            printf("Vertice %d: Ifinito\n", i);
        } else {
            printf("Vertice %d: %d\n", i, dtc[i]);
        }
    }
}

int main() {
    int numVert = 5;  
    int origem = 0;   
    
    int grafo[50][50] = {
        {0, 10, 0, 0, 5},
        {10, 0, 1, 0, 2},
        {0, 1, 0, 4, 0},
        {0, 0, 4, 0, 3},
        {5, 2, 0, 3, 0}
    };
    
   
    dijkstra(grafo, numVert, origem);
    
    return 0;
}
