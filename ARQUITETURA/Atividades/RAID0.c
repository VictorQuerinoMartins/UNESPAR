#include <stdlib.h>
#include <stdio.h>

int main (){
    char frase[100];
    int len;
    char disco1[100], disco2[100];

    printf("Insira uma frase: ");
    fgets(frase, sizeof(frase), stdin);

    len = strlen(frase);
    int j = 0, k = 0;

    for(int i = 0; i < len; i++){
        if(i % 2 == 0 ){
            disco1[j++] = frase[i];
        }else{
            disco2[k++] = frase[i];
        }
    }

    printf("Disco1: %s\n", disco1);
    printf("Disco2: %s\n", disco2);


    return 0;
}