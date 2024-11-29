//Crie uma sub-rotina que receba como parâmetro um vetor A de 25 números inteiros e substitua todos os valores negativos de A por zero. O vetor resultante deverá ser mostrado no programa principal.

#include <stdio.h>

void substituicao(int vetorA[], int tamanho){

  printf("Digite 25 numeros para preencer o vetor: ");
    for(int i = 0; i < tamanho; i++){
       if(vetorA[i] < 0){
        vetorA[i] = 0;
       }
    }
}

int main(){
int vetorA[25];

printf("Digite 25 numeros para preencer o vetor: \n");
   for (int i = 0; i < 25; i++) {
        scanf("%d", &vetorA[i]);
    }

    substituicao(vetorA, 25);

     printf("Valor do novo vetor:\n");
    for (int i = 0; i < 25; i++) {
        printf("%d ", vetorA[i]);
    }
    return 0;
}
