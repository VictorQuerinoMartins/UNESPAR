#include <stdlib.h> 
#include <stdio.h>  

int main(void){  
    int valor = 29;  // Variável inteira com valor 29.
    int *ptr;  // Ponteiro para inteiro.
    ptr = &valor;  // Atribuição do endereço de "valor" ao ponteiro "ptr".
    
    // Impressão de informações.
    printf("Conteudo da variavel %d \n", valor);  // Imprime o valor de "valor".
    printf("endereco da variavel %x \n", &valor);  // Imprime o endereço de "valor".
    printf("Conteudo da variavel ponteiro %x \n", ptr);  // Imprime o conteúdo de "ptr", que é o endereço de "valor".
    
    return 0;  
}
