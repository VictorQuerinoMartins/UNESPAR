#include <stdio.h>

int main(){
    int bolasNeve[9];
    int vence = -1;
    int totalb = 0;
    int ultimaB = 0;

    for(int i =0; i <9; i++){
        scanf("%d", &bolasNeve[i]);
        totalb += bolasNeve[i];
    }

    for(int i =0; i <9; i++){
        ultimaB += bolasNeve[i];
        
         if (ultimaB >= totalb) {
            vence = i;
            break;
        }
    }

    switch (vence) {
        case 0:
            printf("Dasher\n");
            break;
        case 1:
            printf("Dancer\n");
            break;
        case 2:
            printf("Prancer\n");
            break;
        case 3:
            printf("Vixen\n");
            break;
        case 4:
            printf("Comet\n");
            break;
        case 5:
            printf("Cupid\n");
            break;
        case 6:
            printf("Donner\n");
            break;
        case 7:
            printf("Blitzen\n");
            break;
        case 8:
            printf("Rudolph\n");
            break;
        default:
            break;
    }

    return 0;
}


