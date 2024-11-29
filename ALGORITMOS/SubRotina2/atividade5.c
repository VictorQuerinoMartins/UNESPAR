// Crie um programa que carregue (em uma sub-rotina) uma matriz 3X4 com números reais. Utilize uma outra função para copiar todos os valores da matriz para um vetor de 12 posições. Esse vetor deverá ser mostrado no programa principal.


#include <stdio.h>

void preencer(float matriz[3][4]){

  printf("Isira os valores da matris 3x4: ");
    for(int i = 0; i < 3; i++){
        for(int j = 0; j < 4; j++){
            scanf("%f", &matriz[i][j]);
        }
    }
}

void atribuicao(float matriz[3][4], float vetor[12]) {
   int k = 0;
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 4; j++) {
            vetor[k] = matriz[i][j];
            k++;
        }
    }
}

int main(){

   float matriz[3][4];
   float vetor[12];

    preencer(matriz);

    atribuicao(matriz, vetor);
  
printf("Valor do novo vetor:\n");
    for (int i = 0; i < 12; i++) {
        printf("%.2f \n", vetor[i]);
    }
    return 0;
}


