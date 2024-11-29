// Subrotina (função) podem ser definidas como blocos de instruções                 // função = método.         
// Exemplo de funções: scanf(), gets(), printf(), strcpy()...

// Sintaxe:
// tipo_de_retorno nome_da_função (pâmetros){
// declaração de variaveis locais;
// inscrucoes para realizar a tarefa;
// return valor; // Instrição opcional (depende da função)
//}

#include <stdio.h>
// Exemplo de função SEM passagem de parâmetros e sem retorno.
void soma(){
    int numero1, numero2;
    printf("\n Digite o numero 1 \n");
    scanf("%d", &numero1);
    printf("\n Digite o numero 2 \n");
    scanf("%d", &numero2);
    printf("\n\n Resultado da Soma: %d\n", numero1+numero2 );
}

int main(){
    soma();
    return 0;
}



// Exemplo de função COM passagem de parâmetros e sem retorno.
void soma2(int n1, int n2){
    printf("\n\n Resultado da Soma: %d\n", n1+n2 );
}

//

int main(){
    int numero1, numero2;
    printf("\n Digite o numero 1 \n");
    scanf("%d", &numero1);
    printf("\n Digite o numero 2 \n");
    scanf("%d", &numero2);
    soma2(numero1+numero2);
    return 0;

}

// Exemplo de função SEM passagem de parâmetros e COM retorno.
int soma3(){
     int numero1, numero2, resultado;
    printf("\n Digite o numero 1 \n");
    scanf("%d", &numero1);
    printf("\n Digite o numero 2 \n");
    scanf("%d", &numero2);
    resultado = numero1 + numero2;
    return resultado;
}

//

int main(){
    int valor_da_soma;
    valor_da_soma = soma3();
    printf("\n Resultado da Soma: %d\n", valor_da_soma);
    return 0;
}

// Exemplo de função COM passagem de parâmetros e COM retorno.

int soma4(int numero1, int numero2){
     int numero1, numero2, resultado;
    resultado = numero1 + numero2;
    return resultado;
}

//

int main(){
    int valor_da_soma, numero1, numero2;

    printf("\n Digite o numero 1 \n");
    scanf("%d", &numero1);
    printf("\n Digite o numero 2 \n");
    scanf("%d", &numero2);
    
    valor_da_soma = soma(numero1, numero2);
    printf("\n Resultado da Soma: %d\n", valor_da_soma);
    return 0;
}