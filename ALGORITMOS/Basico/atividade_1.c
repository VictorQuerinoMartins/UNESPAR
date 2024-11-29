#include <stdlib.h>
#include <stdio.h>


main(){
    float x, y, z;
    float a, b, c;
    printf("Insira as notas: ");

        scanf("%f",&x); 
        scanf("%f",&y); 
        scanf("%f",&z); 

printf("Insira os pesos: ");

        scanf("%f",&a); 
        scanf("%f",&b); 
        scanf("%f",&c); 
    float media;
    media = ((x*a) , (y*b) , (z*c)) /a+b+c;
    printf("A media eh: %.2f", media);
}
