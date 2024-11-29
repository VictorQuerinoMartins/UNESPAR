#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <time.h>

typedef struct no{
    int valor;
    int prioridade;
    struct no *proximo;
} No;

typedef struct{
    No *inicio;
    No *fim;
    int tam;
} Fila;

void create_fila(Fila *fila){
    fila -> inicio = NULL;
    fila -> fim = NULL;
    fila -> tam = 0;
}

void insert_fila(Fila *fila, int value, int priority_value){
    No *novo = malloc(sizeof(No));
    novo->valor = value;
    novo->prioridade = priority_value;
    novo->proximo = NULL;

    if(fila->inicio == NULL) {
        fila->inicio = novo;
        fila->fim = novo;
    } else {
        No *aux = fila->inicio;
        No *prev = NULL;

        while(aux != NULL && aux->prioridade >= priority_value) {
            prev = aux;
            aux = aux->proximo;
        }

        if(prev == NULL) {
            novo->proximo = fila->inicio;
            fila->inicio = novo;
        } else {
            prev->proximo = novo;
            novo->proximo = aux;

            if(novo->proximo == NULL) {
                fila->fim = novo;
            }
        }
    }
    fila->tam++;
}

No* remove_fila(Fila *fila){
    No *remove = NULL;

    if(fila -> inicio){
        remove = fila -> inicio;
        fila -> inicio = remove -> proximo;
        fila -> tam--;
        if(fila->inicio == NULL) {
            fila->fim = NULL;
        }
    } else {
        printf("Fila vazia\n");
    }
    return remove;
}

void print_fila(Fila fila){
    No *aux = fila.inicio;
    printf("--- FILA ---\n");

    while(aux){
        printf("%d (Prioridade: %d) ", aux -> valor, aux -> prioridade);
        aux = aux -> proximo;
    }
    
    printf("\n");
}

int main(){
    No *r;
    Fila fila;
    create_fila(&fila);
    int option, value, priority_value;
    srand(time(NULL));
    bool stdbool = false;

    while(!stdbool){
        printf("\n1 - Inserir elemento\n2 - Remover elemento\n3 - Mostrar fila\n4 - Sair\n");
        printf("Insira sua opcao: ");
        scanf("%d", &option);
        
        switch(option){
            case 1:
                printf("\n\nDigite o grau de prioridade:\n1 - Sem Prioridade\n2 - Gestantes e pessoas com deficiencias\n3 - Idosos\n");
                scanf("%d", &priority_value);
                printf("\n");
                value = rand() % 100;

                insert_fila(&fila, value, priority_value);
                break;
            case 2:
                r = remove_fila(&fila);
                if(r != NULL) {
                    printf("Elemento removido: %d\n", r -> valor);
                    free(r);
                }
                break;
            case 3:
                print_fila(fila);
                break;
            case 4:
                stdbool = true;
                break;
            default:
                printf("Opcao invalida\n");
        }
    }
    return 0;
}