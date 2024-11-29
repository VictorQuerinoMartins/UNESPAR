#include <stdlib.h>

main(){
    int i;
    for(i=1000; i<=2000; i++){
    if(i % 7 == 0){
        printf("O numero %d eh divisivel por 7\n", i);
    }
    }
}