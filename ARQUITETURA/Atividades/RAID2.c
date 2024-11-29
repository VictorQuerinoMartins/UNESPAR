#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int main() {
    char frase[100];
    char disco1[100], disco2[100];
    int len;  

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

    printf("RAID 0:\n");
    printf("Disco1: %s\n", disco1);
    printf("Disco2: %s\n", disco2);

    for (int i = 0; i < len; i++) {
        disco1[j++] = frase[i];
    }

    
    strcpy(disco2, disco1);

    printf("RAID 2:\n");
    printf("Disco 1: %s", disco1);
    printf("Disco 2: %s\n", disco2);

     for (int i = 0; i < len; i++) {
        disco1[j++] = frase[i];
    }

    

    printf("RAID 1:\n");
    printf("Disco 1: %s", disco1);
    printf("Disco 2: %s\n", disco2);


    return 0;


}
