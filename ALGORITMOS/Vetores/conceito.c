// É um conjunto de variáveis de mesmo tipo, que possuem o mesmo identificador (nome) e são alocadas sequencialmente na memória;

#include <stdio.h>

main(){
   int vetor[10];

 for (int i = 0; i < 9; i++) {                                        // Preenchendo o vetor
        printf("Digite um numero inteiro: ");
        scanf("%d", &vetor[i]);
    }
}