#include <stdio.h>
#include <stdbool.h>
#include <limits.h>

typedef struct {
    int blocos[100]; // Lista de tamanhos dos blocos de memoria
    bool alocados[100]; // Indica se o bloco esta alocado
    int processos[100]; // Mapeia ID do processo para indice do bloco
    int quantidade_de_blocos;
    int ultimo_indice_alocados; // Para Next Fit
} GerenciadorMemoria;

// Inicializa o gerenciador de memoria
void inicializarGerenciadorMemoria(GerenciadorMemoria *gm, int blocos[], int quantidade_de_blocos) {
    gm->quantidade_de_blocos = quantidade_de_blocos;
    gm->ultimo_indice_alocados = 0;
    for (int i = 0; i < quantidade_de_blocos; i++) {
        gm->blocos[i] = blocos[i];
        gm->alocados[i] = false;
    }
    for (int i = 0; i < 100; i++) {
        gm->processos[i] = -1; // -1 indica que o processo nao esta alocado
    }
}

// Exibe o estado da memoria
void exibirMemoria(GerenciadorMemoria *gm) {
    printf("\nEstado da Memoria:\n");
    for (int i = 0; i < gm->quantidade_de_blocos; i++) {
        printf("Bloco %d: %d KB - %s (Processo: ", i, gm->blocos[i], gm->alocados[i] ? "Ocupado" : "Livre");
        bool encontrado = false;
        for (int j = 0; j < 100; j++) {
            if (gm->processos[j] == i) {
                printf("%d)\n", j);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) printf("N/A)\n");
    }
}

// First Fit
bool primeiroAjuste(GerenciadorMemoria *gm, int id_processo, int tamanho_processo) {
    for (int i = 0; i < gm->quantidade_de_blocos; i++) {
        if (!gm->alocados[i] && gm->blocos[i] >= tamanho_processo) {
            gm->alocados[i] = true;
            gm->processos[id_processo] = i;
            printf("Processo %d (%d KB) alocado no bloco %d (%d KB)\n", id_processo, tamanho_processo, i, gm->blocos[i]);
            return true;
        }
    }
    printf("Processo %d (%d KB) nao alocado - nenhum bloco adequado\n", id_processo, tamanho_processo);
    return false;
}

// Next Fit
bool proximoAjuste(GerenciadorMemoria *gm, int id_processo, int tamanho_processo) {
    int n = gm->quantidade_de_blocos;
    for (int i = 0; i < n; i++) {
        int indice = (gm->ultimo_indice_alocados + i) % n;
        if (!gm->alocados[indice] && gm->blocos[indice] >= tamanho_processo) {
            gm->alocados[indice] = true;
            gm->processos[id_processo] = indice;
            gm->ultimo_indice_alocados = indice;
            printf("Processo %d (%d KB) alocado no bloco %d (%d KB)\n", id_processo, tamanho_processo, indice, gm->blocos[indice]);
            return true;
        }
    }
    printf("Processo %d (%d KB) nao alocado - nenhum bloco adequado\n", id_processo, tamanho_processo);
    return false;
}

// Best Fit
bool melhorAjuste(GerenciadorMemoria *gm, int id_processo, int tamanho_processo) {
    int melhor_indice = -1;
    int tamanho_minimo = INT_MAX;
    for (int i = 0; i < gm->quantidade_de_blocos; i++) {
        if (!gm->alocados[i] && gm->blocos[i] >= tamanho_processo && gm->blocos[i] < tamanho_minimo) {
            tamanho_minimo = gm->blocos[i];
            melhor_indice = i;
        }
    }
    if (melhor_indice != -1) {
        gm->alocados[melhor_indice] = true;
        gm->processos[id_processo] = melhor_indice;
        printf("Processo %d (%d KB) alocado no bloco %d (%d KB)\n", id_processo, tamanho_processo, melhor_indice, gm->blocos[melhor_indice]);
        return true;
    }
    printf("Processo %d (%d KB) nao alocado - nenhum bloco adequado\n", id_processo, tamanho_processo);
    return false;
}

// Worst Fit
bool piorAjuste(GerenciadorMemoria *gm, int id_processo, int tamanho_processo) {
    int pior_indice = -1;
    int tamanho_maximo = -1;
    for (int i = 0; i < gm->quantidade_de_blocos; i++) {
        if (!gm->alocados[i] && gm->blocos[i] >= tamanho_processo && gm->blocos[i] > tamanho_maximo) {
            tamanho_maximo = gm->blocos[i];
            pior_indice = i;
        }
    }
    if (pior_indice != -1) {
        gm->alocados[pior_indice] = true;
        gm->processos[id_processo] = pior_indice;
        printf("Processo %d (%d KB) alocado no bloco %d (%d KB)\n", id_processo, tamanho_processo, pior_indice, gm->blocos[pior_indice]);
        return true;
    }
    printf("Processo %d (%d KB) nao alocado - nenhum bloco adequado\n", id_processo, tamanho_processo);
    return false;
}

// Funcao para reiniciar o gerenciador de memoria
void reiniciarMemoria(GerenciadorMemoria *gm, int blocos[], int quantidade_de_blocos) {
    inicializarGerenciadorMemoria(gm, blocos, quantidade_de_blocos);
}

// Funcao para obter entrada do usuario
void obterBlocosMemoria(int blocos[], int *quantidade_de_blocos) {
    printf("Digite o numero de blocos de memoria (maximo 100): ");
    scanf("%d", quantidade_de_blocos);
    if (*quantidade_de_blocos > 100 || *quantidade_de_blocos <= 0) {
        printf("Numero invalido. Usando 5 blocos como padrao.\n");
        *quantidade_de_blocos = 5;
    }
    printf("Digite o tamanho de cada bloco (em KB):\n");
    for (int i = 0; i < *quantidade_de_blocos; i++) {
        printf("Bloco %d: ", i);
        scanf("%d", &blocos[i]);
        if (blocos[i] <= 0) {
            printf("Tamanho invalido. Usando 100 KB como padrao.\n");
            blocos[i] = 100;
        }
    }
}

// Funcao para obter processos do usuario
void obterProcessos(int processos[], int *quantidade_de_processos) {
    printf("Digite o numero de processos a alocar (maximo 100): ");
    scanf("%d", quantidade_de_processos);
    if (*quantidade_de_processos > 100 || *quantidade_de_processos <= 0) {
        printf("Numero invalido. Usando 4 processos como padrao.\n");
        *quantidade_de_processos = 4;
    }
    printf("Digite o tamanho de cada processo (em KB):\n");
    for (int i = 0; i < *quantidade_de_processos; i++) {
        printf("Processo %d: ", i + 1);
        scanf("%d", &processos[i]);
        if (processos[i] <= 0) {
            printf("Tamanho invalido. Usando 100 KB como padrao.\n");
            processos[i] = 100;
        }
    }
}

// Funcao principal
int main() {
    int blocos[100];
    int processos[100];
    int quantidade_de_blocos, quantidade_de_processos;
    GerenciadorMemoria gm;

    // Obter blocos de memoria do usuario
    obterBlocosMemoria(blocos, &quantidade_de_blocos);
    printf("\nBlocos de memoria definidos: ");
    for (int i = 0; i < quantidade_de_blocos; i++) {
        printf("%d KB ", blocos[i]);
    }
    printf("\n");

    // Obter processos do usuario
    obterProcessos(processos, &quantidade_de_processos);

    // Testando Primeiro Ajuste
    printf("\n=== Primeiro Ajuste ===\n");
    inicializarGerenciadorMemoria(&gm, blocos, quantidade_de_blocos);
    for (int i = 0; i < quantidade_de_processos; i++) {
        primeiroAjuste(&gm, i + 1, processos[i]);
    }
    exibirMemoria(&gm);

    // Testando Proximo Ajuste
    printf("\n=== Proximo Ajuste ===\n");
    reiniciarMemoria(&gm, blocos, quantidade_de_blocos);
    for (int i = 0; i < quantidade_de_processos; i++) {
        proximoAjuste(&gm, i + 1, processos[i]);
    }
    exibirMemoria(&gm);

    // Testando Melhor Ajuste
    printf("\n=== Melhor Ajuste ===\n");
    reiniciarMemoria(&gm, blocos, quantidade_de_blocos);
    for (int i = 0; i < quantidade_de_processos; i++) {
        melhorAjuste(&gm, i + 1, processos[i]);
    }
    exibirMemoria(&gm);

    // Testando Pior Ajuste
    printf("\n=== Pior Ajuste ===\n");
    reiniciarMemoria(&gm, blocos, quantidade_de_blocos);
    for (int i = 0; i < quantidade_de_processos; i++) {
        piorAjuste(&gm, i + 1, processos[i]);
    }
    exibirMemoria(&gm);

    return 0;
}