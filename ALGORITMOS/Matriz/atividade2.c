// Implemente um programa que carregue uma matriz A 2x2. Em seguida, o maior número da matriz deve ser encontrado. Por fim, uma matriz B deve ser apresentada, com os elementos sendo resultantes do seguinte cálculo:
// ● elemento da matriz A * maior elemento da matriz A.

#include <stdlib.h>

main(){
    int Amatriz[2][2];
    int matrizB[2][2];

    for (int i = 0; i < 2; i++){
        for (int j = 0; j < 2; j++){

            printf("Digite um valor para cada posicao da matriz A (%d,%d): ", i + 1, j + 1);
            scanf("%d", &Amatriz[i][j]);
        }
    }

    int Maiorn = Amatriz[0][0];
    for (int i = 0; i < 2; i++){
        for (int j = 0; j < 2; j++) {

            if (Amatriz[i][j] > Maiorn){
                Maiorn = Amatriz[i][j];
            }
        }
    }

    printf("O maior valor da matriz A eh: %d\n", Maiorn);
    printf("\n");

    for (int i = 0; i < 2; i++){
        for (int j = 0; j < 2; j++){

            printf("Digite um valor para cada posicao da matriz B (%d,%d): ", i + 1, j + 1);
            scanf("%d", &matrizB[i][j]);

            matrizB[i][j] = Amatriz[i][j] * Maiorn;
        }
    }
    printf("\n");

    printf("Matriz B: ");
    for (int i = 0; i < 2; i++){
        for (int j = 0; j < 2; j++){
            printf("%d ", matrizB[i][j]);
        }
    }
}