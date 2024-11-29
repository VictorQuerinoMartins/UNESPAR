#include stdio.h
#include time.h

int main() {
    FILE arquivos[100];  //Array de ponteiros para os arquivos
    int i;
    clock_t inicio, fim;
    double tempodecorrido;

     //Inicia a contagem de tempo
    inicio = clock();

     //Abre os arquivos
    for (i = 0; i  100; i++) {
        char nome_arquivo[20];
        sprintf(nome_arquivo, "arquivo_%d.txt", i);
        arquivos[i] = fopen(nome_arquivo, w);
        if (arquivos[i] == NULL) {
            printf("Erro ao abrir o arquivo %sn", nome_arquivo);
            return 1;
        }
    }

     //Fecha os arquivos
    for (i = 0; i  100; i++) {
        fclose(arquivos[i]);
    }

     //Finaliza a contagem de tempo
    fim = clock();
    
     //Calcula o tempo decorrido em segundos
    tempodecorrido = ((double) (fim - inicio))  CLOCKS_PER_SEC;

    printf("Operacoes de abrir e fechar arquivos concluidas em %.6f segundos.n", tempodecorrido);

    return 0;
}
