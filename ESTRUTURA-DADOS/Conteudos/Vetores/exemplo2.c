#include <stdio.h>
#include <stdlib.h>

int main(){
    int *v;
    int n;
    
    printf("Digite a quantidade de vetores: \n");
    scanf("%d", &n);
    v = malloc(n * sizeof(int)); // Aloca memoria para o vetor
    
    printf("-----------------------------------------\n");
    printf("Insercao de vetores\n");

    for(int i = 0; i < n; i++){
        printf("Digite o valor para v[%d]: ", i);
        scanf("%d", &v[i]); // Lê o valor para o elemento v[i]
    }

    printf("Valores inseridos:\n");
    for(int i = 0; i < n; i++){
        printf("%d \n", v[i]);
    }

    free(v); // Libera memoria alocada
    return 0;
}
