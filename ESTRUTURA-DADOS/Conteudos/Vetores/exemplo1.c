#include <stdio.h>
#include <stdlib.h>

int main(){
    int arr[5](10,20,30,40,50);
    arr[2] = 100;
    char arrs[5] = ('G','e','e','k','s', "\0");

    printf("-----Elementos do Array imprimido-----");
    printf("\n");

    for(int i = 0; i < 5; i++){
        printf("%d \n", arr[i]);    
    }

     printf("-----------------------------------------\n");

    int y =0;
    while(arrs[y]){
        printf("%c", arrs[y++]);
    }
    printf("\n");
    return 0;
}