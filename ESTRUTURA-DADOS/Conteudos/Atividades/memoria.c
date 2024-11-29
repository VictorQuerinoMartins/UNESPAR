#include <stdio.h>

void alocarMemoria(int tamBloco[], int m, int tamProcesso[], int n) {
    int alocacao[n];
    
    for (int i = 0; i < n; i++)
        alocacao[i] = -1;

   
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (tamBloco[j] >= tamProcesso[i]) {        // j recebe i
                alocacao[i] = j;
                tamBloco[j] -= tamProcesso[i];
                break;
            }
        }
    }

    printf("\nProcesso No.\tTam do Processo\tBloco No.\n");
    for (int i = 0; i < n; i++) {
        printf("%d\t\t%d\t\t\t", i + 1, tamProcesso[i]);
        if (alocacao[i] != -1)
            printf("%d\n", alocacao[i] + 1);
        else
            printf("Nao Alocado\n");
    }
}

int main() {
    int m, n;

    printf("Digite o numero de blocos: ");
    scanf("%d", &m);
    int tamBloco[m];
    printf("Digite os tams dos blocos: ");
    for (int i = 0; i < m; i++) {
        scanf("%d", &tamBloco[i]);
    }

    printf("Digite o numero de processos: ");
    scanf("%d", &n);
    int tamProcesso[n];
    printf("Digite os tams dos processos: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &tamProcesso[i]);
    }

    alocarMemoria(tamBloco, m, tamProcesso, n);

    return 0;
}
