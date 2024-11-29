#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int main() {
    char frase[100];
    char disco1[100], disco2[100];
    int len;
    int j = 0;  

    printf("Insira uma frase: ");
    fgets(frase, sizeof(frase), stdin);

    len = strlen(frase);

    for (int i = 0; i < len; i++) {
        disco1[j++] = frase[i];
    }

    
    strcpy(disco2, disco1);

    printf("RAID 1:\n");
    printf("Disco 1: %s", disco1);
    printf("Disco 2: %s\n", disco2);

    return 0;
}
