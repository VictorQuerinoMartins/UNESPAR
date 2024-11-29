#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void ordenar(int arr[], int n) {
    // Verifica se o array está vazio
    if (n <= 0) {
        printf("Erro: array vazio.\n");
        return;
    }

    // Encontra o valor máximo no array
    int max = arr[0]; // Inicializa com o primeiro elemento
    for (int i = 1; i < n; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }

    // Aloca dinamicamente memória para o array de contagem
    int *count = (int *)malloc((max + 1) * sizeof(int));
    if (count == NULL) {
        printf("Erro ao alocar memoria.\n");
        exit(EXIT_FAILURE);
    }

    // Inicializa o array de contagem com zeros
    for (int i = 0; i <= max; i++) {
        count[i] = 0;
    }

    // Conta ocorrências de cada elemento no array original
    for (int i = 0; i < n; i++) {
        count[arr[i]]++;
    }

    // Reconstrói o array ordenado
    int k = 0;
    for (int i = 0; i <= max; i++) {
        for (int j = 0; j < count[i]; j++) {
            arr[k++] = i;
        }
    }

    // Libera a memória alocada para o array de contagem
    free(count);
}

// Funcoes para os arquivos

void criar(const char *nomeArq) {
    FILE *arquivo = fopen(nomeArq, "w");
    if (arquivo == NULL) {
        printf("Erro ao criar o arquivo %s\n", nomeArq);
        return;
    }

    // Escrever conteúdo no arquivo
    fprintf(arquivo, "Conteudo do arquivo %s\n", nomeArq);

    fclose(arquivo);
}

void verificar(const char *nomeArq) {
    // Simulando processamento
    FILE *arquivo = fopen(nomeArq, "r");
    if (arquivo == NULL) {
        printf("Erro ao abrir o arquivo %s\n", nomeArq);
        return;
    }

    fclose(arquivo);
}

double calcularTemp(const char *nomeArq) {
    clock_t inicio, fim;
    double tempo_execucao;

    inicio = clock();
    verificar(nomeArq);
    fim = clock();

    tempo_execucao = ((double)(fim - inicio)) / CLOCKS_PER_SEC;
    return tempo_execucao;
}

int main() {

    int tam[] = {110000, 1200000, 13000000, 140000000, 1500000000}; // tamanho dos conjuntos de dados
    int num_tam = sizeof(tam) / sizeof(tam[0]);                     // tam = tamanho

    for (int i = 0; i < num_tam; i++) {
        int n = tam[i];
        int *arr = (int *)malloc(n * sizeof(int));
        if (arr == NULL) {
            printf("Erro ao alocar memória.\n");
            exit(EXIT_FAILURE);
        }

        // Preenche o vetor com números aleatórios entre 0 e 99
        for (int j = 0; j < n; j++) {
            arr[j] = rand() % 100;
        }

        printf("Tamanho de dados: %d\n", n);
        clock_t inicio = clock();
        ordenar(arr, n);
        clock_t fim = clock();
        double tempExc = ((double)(fim - inicio)) / CLOCKS_PER_SEC;              //tempExc = tempo de exeecução
        printf("Teste - Tempo de execucao: %.6f segundos\n", tempExc);

        free(arr); // Libera a memória alocada para o vetor
        printf("\n");

    }

    printf("-------Agora o teste com abertura de arquivos-------\n");

    const char *arquivos[] = {"arquivo1.txt", "arquivo2.txt", "arquivo3.txt"};
    
    // Criar e processar cada arquivo
    for (int u = 0; u < 3; u++) {
        criar(arquivos[u]);
        double tempExc2 = calcularTemp(arquivos[u]);
        printf("O arquivo %s foi processado em %.6f segundos.\n", arquivos[u], tempExc2);
    }

    return 0;
}
