#include <stdio.h>
#include <string.h>
#include <math.h>

typedef enum {
    Instru000001 = 1,
    Instru000010,
    Instru000011,
    Instru000100,
    Instru000101,
    Instru000110,
    Instru000111,
    Instru001000,
    Instru001010,
    Instru001011,
    Instru001111,
    Instru001100
} TipoInstrucao;

typedef struct {
    TipoInstrucao tipo;
    int operando1;
    int operando2;
} Instrucao;

int memoria[256];
Instrucao instrucaoo[50];

int CP = 0; // Contador
int ACC = 0; // Acumulador
int MBR = 0; 
int numInstru = 0; 

TipoInstrucao obterInstr(char* instrucao) {
    if (strcmp(instrucao, "000001") == 0) return Instru000001;
    if (strcmp(instrucao, "000010") == 0) return Instru000010;
    if (strcmp(instrucao, "000011") == 0) return Instru000011;
    if (strcmp(instrucao, "000100") == 0) return Instru000100;
    if (strcmp(instrucao, "000101") == 0) return Instru000101;
    if (strcmp(instrucao, "000110") == 0) return Instru000110;
    if (strcmp(instrucao, "000111") == 0) return Instru000111;
    if (strcmp(instrucao, "001000") == 0) return Instru001000;
    if (strcmp(instrucao, "001010") == 0) return Instru001010;
    if (strcmp(instrucao, "001011") == 0) return Instru001011;
    if (strcmp(instrucao, "001111") == 0) return Instru001111;
    if (strcmp(instrucao, "001100") == 0) return Instru001100;
    return Instru000001; 
}

void iniciar() {
    char instrucao[10];
    int operando1, operando2;

    printf("Insira as instrucoes do programa. Digite '001100' para finalizar.\n");

    while (1) {
        printf("Instrucao: ");
        scanf("%s", instrucao); 
        if (strcmp(instrucao, "001100") == 0) break; 

        TipoInstrucao tipo = obterInstr(instrucao);
        printf("Operando1: ");
        scanf("%d", &operando1);

        printf("Operando2: ");
        scanf("%d", &operando2);
        
        instrucaoo[numInstru].tipo = tipo;
        instrucaoo[numInstru].operando1 = operando1;
        instrucaoo[numInstru].operando2 = operando2;
        numInstru++; 
    }
}

void executar() {
    while (CP < numInstru) { 
        Instrucao instr = instrucaoo[CP]; 
        switch (instr.tipo) { 
            case Instru000001: // Carregar memória no MBR
                MBR = memoria[instr.operando1]; 
                printf("MBR = %d, CP = %d\n", MBR, CP);
                break; 
            case Instru000010: // Armazenar valor na memória
                memoria[instr.operando1] = instr.operando2;
                printf("Memoria[%d] = %d, CP = %d\n", instr.operando1, instr.operando2, CP);
                break;
            case Instru000011: // Adicionar valor da memória no MBR
                MBR += memoria[instr.operando1];
                printf("MBR = %d, CP = %d\n", MBR, CP);
                break;
            case Instru000100: // Carregar memória no ACC
                MBR = memoria[instr.operando1];
                ACC = MBR;
                printf("ACC = %d, MBR = %d, CP = %d\n", ACC, MBR, CP);
                break;
            case Instru000101: // Subtrai memória do ACC
                MBR = memoria[instr.operando1];
                ACC -= MBR;
                printf("ACC = %d, MBR = %d, CP = %d\n", ACC, MBR, CP);
                break;
            case Instru000110: // Endereço especifico
                CP = instr.operando1 - 1;
                printf("CP = %d\n", CP);
                break;
            case Instru000111: // ACC se = a zero
                if (ACC == 0) CP = instr.operando1 - 1;
                printf("ACC = %d, CP = %d\n", ACC, CP);
                break;
            case Instru001000: // ACC se diferente de zero
                if (ACC != 0) CP = instr.operando1 - 1;
                printf("ACC = %d, CP = %d\n", ACC, CP);
                break;
            case Instru001010: 
                MBR = (int)sqrt(MBR);
                printf("MBR = %d, CP = %d\n", MBR, CP);
                break;
            case Instru001011: //  MBR - MBR
                MBR = -MBR;
                printf("MBR = %d, CP = %d\n", MBR, CP);
                break;
            case Instru001111: //  MBR -> memory
                memoria[instr.operando1] = MBR;
                printf("Memoria[%d] = %d, CP = %d\n", instr.operando1, MBR, CP);
                break;
            case Instru001100: 
                printf("Fim, CP = %d\n", CP);
                return; 
            default:
                printf("Instrucao invalida CP: %d\n", CP);
                break;
        }
        CP++; 

        printf("Valor final do acumulador: %d\n\n", ACC);
    }

    printf("Estado final da memoria:\n");
    for (int i = 0; i < 256; i++) {
        if (memoria[i] != 0) {
            printf("Memoria[%d] = %d\n", i, memoria[i]);
        }
    }
}

int main() {
    memset(memoria, 0, sizeof(memoria)); // Inicializa a memória com zero
    iniciar(); 
    executar(); 
    return 0;
}
