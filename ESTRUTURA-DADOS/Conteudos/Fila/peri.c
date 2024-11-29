#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <time.h>

typedef struct no{
    int dado;
    struct no *proximo;
} No;

typedef struct{
    No *inicio;
    No *fim;
} Fila;

void inicializa(Fila *f){
    f -> inicio = NULL;
    f -> fim = NULL;
}

void enfileira(int dado, Fila  *f){
   No *novo = (No*)(malloc(sizeof(No)));
    if(novo == NULL){
        printf("Erro de alocacao de memoria");
        return;
    }else{
        novo -> dado = dado;
        novo -> proximo = NULL;
        if(f -> inicio == NULL){
            f -> inicio = novo;
        }else{
            f -> fim -> proximo = novo;     //Apontando para um novo npo atualizando o fim
        }

        f -> fim = novo;
        return;
    }
}

int desenfilerar (Fila *f){
    No *ptr = f -> inicio;
    int dado;                       // variavel de backup

    if(ptr != NULL){
        f -> inicio = ptr -> proximo;
        ptr -> proximo = NULL;
        dado = ptr -> dado;
        free(ptr);

        if(f -> inicio == NULL){
            f -> fim = NULL;
        }
        return dado;

    } else {
        printf("Fila vazia\n");
    }
}

void imprimirFila(Fila *f){
    No *ptr = f -> inicio;

    if(ptr != NULL){                        
        while(ptr != NULL){
        printf("%d", ptr -> dado);              // imprime e vai para o proximo
        ptr = ptr -> proximo;
        }
        printf("\n");
    } else {
        printf("Fila vazia. \n");
        return;
    }
    
    printf("\n");
}

int main(){
    
    Fila *f1 = (Fila*) malloc(sizeof(Fila));
    if(f1 == NULL ){
        printf("Erro de Alocacao. \n");
    }else{
        inicializa(f1);
        enfileira(10, f1);
        enfileira(20, f1);
        enfileira(30, f1);

        imprimirFila(f1);

        printf("Desenfileirar o resultado: %d\n", desenfilerar(f1));
        imprimirFila(f1);
        printf("Desenfileirar o resultado: %d\n", desenfilerar(f1));
        imprimirFila(f1);
        printf("Desenfileirar o resultado: %d\n", desenfilerar(f1));
        imprimirFila(f1);
    }

    return 0;
}