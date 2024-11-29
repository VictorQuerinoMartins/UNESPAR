#include<stdio.h>
#include<stdlib.h>

main(){

    float racao,restanteemgrama, gato1, gato2,racaoemgrama;

    printf("Quantidade ddo saco de racao em kg: ");
    scanf("%f", &racao);


     printf("Quantidade de comida para cada gato em grama: ");
    scanf("%f", &gato1);
    scanf("%f", &gato2);
    
    racaoemgrama = racao*1000;
    restanteemgrama= racaoemgrama - ((gato1 + gato2)*3);

    printf("Restante de racao em gramas %.2f\n", restanteemgrama);
    printf("Restante de racao em kg %.2f", restanteemgrama*1000);
}
