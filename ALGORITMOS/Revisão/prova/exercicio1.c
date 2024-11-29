#include <stdio.h>
#include <stdlib.h>

void conta(int *vetor[]){
   for(int i =0; i < 10; i++){
    vetor[i] = pow(vetor[i], 3);
   }
}

int main(){
    int vetorA[10];
    
    for(int i=0; i < 10; i++){
        scanf("%d", &vetorA[i]);
    }

    conta(vetorA);

     for(int i=0; i < 10; i++){
        printf("%d", &vetorA[i]);
     }
}