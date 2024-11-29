#include <stdlib.h>
#include <stdio.h>

main(){
    float salario,percentual;
    printf("Insira um valor do seu salario: ");
        scanf("%f",&salario); 

    printf("Insira o valor do percuntual de reajuste : ");    
        scanf("%f",&percentual); 

    float aumento = salario*percentual/100;
    
    float novosal = aumento + salario;

    printf("Aumento: %.2f\n",aumento);   
    printf("O novo salario e: %.2f",novosal);    
}