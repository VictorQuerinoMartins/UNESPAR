#include <stdio.h>
#include <stdlib.h>
#include <limits.h> // pegar o menor número (INT_MIN)

typedef struct Bloco {
    int id;       
    int tam;    
    int ocupado;  // 0 se livre, 1 se usando
} Bloco;


void iniciaMem(Bloco blocos[], int numBlocos) {
    for (int i = 0; i < numBlocos; i++) {
        blocos[i].id = i + 1;
        printf("Qual o tamanho do Bloco %d? (em KB): ", blocos[i].id);
        scanf("%d", &blocos[i].tam);
        blocos[i].ocupado = 0;
    }
}

void mostraMem(Bloco blocos[], int numBlocos) {
    printf("--- Status da Memoria ---\n");
    printf("Bloco ID\tTam (KB)\tSituacao\n");
    for (int i = 0; i < numBlocos; i++) {
        printf("%d\t\t%d KB\t\t%s\n", blocos[i].id, blocos[i].tam, blocos[i].ocupado ? "OCUPADO" : "LIVRE");
    }
}

void worstFit(Bloco blocos[], int numBlocos, int idProc, int tamProc) {
    int indBloco = 0; 
    int mmaiorEspc = INT_MIN; // O maior "espc" que a gente achar

    printf("Processo %d quer %d KB. verificando o maior espaco disponivel...\n", idProc, tamProc);

    for (int i = 0; i < numBlocos; i++) {
        if (!blocos[i].ocupado && blocos[i].tam >= tamProc) {
            if (blocos[i].tam - tamProc > mmaiorEspc) {
                mmaiorEspc = blocos[i].tam - tamProc; // atualiza o maior espc rest
                indBloco = i; 
            }
        }
    }

    if (indBloco != -1) {
        blocos[indBloco].ocupado = 1; // Marca como ocupado
        printf("Processo %d alocado no Bloco %d (%d KB). Sobrou %d KB.\n", idProc, blocos[indBloco].id, blocos[indBloco].tam, blocos[indBloco].tam - tamProc);
    } else {
        printf("Processo %d sem espaco. Nao foi possivel alocar.\n", idProc);
    }
    printf("\n");
}

void liberaBloco(Bloco blocos[], int numBlocos, int idBlocoLibera) {
    printf("Tentando desalocar o Bloco %d...\n", idBlocoLibera);
    for (int i = 0; i < numBlocos; i++) {
        if (blocos[i].id == idBlocoLibera) {
            if (blocos[i].ocupado) { // Se estiver ocupado
                blocos[i].ocupado = 0; 
                printf("Bloco %d liberado com sucesso.\n", idBlocoLibera);
                printf("\n");
                return;
            } else { 
                printf("Bloco %d ja estava LIVRE!\n", idBlocoLibera);
                printf("\n");
                return;
            }
        }
    }
    printf("Bloco %d nao encontrado ou nao existe.\n", idBlocoLibera);
    printf("\n");
}

int main() {
    int numBlocos;
    printf("Quantos blocos de memoria deseja gerenciar? ");
    scanf("%d", &numBlocos);

    Bloco *blocosMem = (Bloco *) malloc(numBlocos * sizeof(Bloco));
    if (blocosMem == NULL) {
        printf("Erro! Nao foi possivel reservar memoria. \n");
        return 1;
    }

    iniciaMem(blocosMem, numBlocos);
    mostraMem(blocosMem, numBlocos);

    int escolha;
    int idProcessoAtual = 1; // ID para os novos processos

    do {
        printf("1. Alocar Processo \n");
        printf("2. Desalocar Bloco\n");
        printf("3. Ver memoria\n");
        printf("0. Sair\n");
        printf("Digite sua opcao: ");
        scanf("%d", &escolha);

        switch (escolha) {
            case 1: {
                int tamProc;
                printf("Qual o tamanho do processo? (em KB): ");
                scanf("%d", &tamProc);
                worstFit(blocosMem, numBlocos, idProcessoAtual++, tamProc);
                break;
            }
            case 2: {
                int idBlocoLibera;
                printf("Qual o ID do bloco a ser liberado?: ");
                scanf("%d", &idBlocoLibera);
                liberaBloco(blocosMem, numBlocos, idBlocoLibera);
                break;
            }
            case 3:
                mostraMem(blocosMem, numBlocos);
                break;
            case 0:
                printf("Saindo. Tchau!\n");
                break;
            default:
                printf("Opcao invalida. Tente novamente.\n");
        }
    } while (escolha != 0);

    free(blocosMem); 

    return 0;
}