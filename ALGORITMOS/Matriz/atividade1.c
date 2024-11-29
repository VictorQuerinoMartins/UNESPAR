//Implemente um programa que:
//● Preencha uma matriz 3 X 3 com valores inteiros, maiores que zero;
//● Apresente todos os números da matriz;
//● Encontre e apresente o maior valor da matriz.


#include <stdio.h>

int main() {
    int matriz[3][3];
    
    // Preenchendo a matriz
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
        
                printf("Digite o valor para a posicao (%d, %d): ", i + 1, j + 1);
                scanf("%d", &matriz[i][j]);
                if (matriz[i][j] <=  0) {
                    printf("O valor deve ser maior que zero. Tente novamente.\n");
                }
            
        }
    }

    // Apresentando a matriz
    printf("Matriz:\n");
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            printf("%d\t", matriz[i][j]);
        }
        printf("\n");
    }

    // Encontrando o maior valor da matriz
    int Mvalor = matriz[0][0];      // Iniciamlmento o maior valor está na posição 0

    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (matriz[i][j] > Mvalor) {
                Mvalor = matriz[i][j];
            }
        }
    }

    printf("O maior valor da matriz eh: %d\n", Mvalor);

}