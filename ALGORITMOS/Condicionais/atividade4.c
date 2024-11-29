#include <stdio.h>

main(){
    float preco;
    int cod;

    
    printf("Insira o preco do produto: ");
    scanf("%f", &preco);
    
    printf("Insira o codigo do produto: ");
    scanf("%i", &cod);

switch (cod)
{
case 1:
     printf("Norte");
    break;
case 2:

    printf("Nordeste");
    break;
case 3:
    printf("Sudeste");
    break;
case 4:
    printf("Sul");
    break;
case 5:
    printf("Centro-oeste");
    break;
default:
    printf("Codigo invalido");
    break;
}

}