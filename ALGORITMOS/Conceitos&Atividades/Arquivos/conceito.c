#include <stdio.h>
#include <stdlib.h>

main(){
    FILE *arq;
    arq = fopen("Unespar.txt", "w");         //fopen cria e abre o arquivo, se o arquivo já existir ele é sobreposto.

// int fprintf     --> Salva qualquer tipo de valor.
// int fputc    --> Vai salvar um char por vez.
// char* fputs     --> Salvar um string inteira.

// int fprintf(FILE* p, char* formato, lista);          formato = %c        lista = nome da variável

// 

// char* fputs( char* s, 

// int fgetc    --> Pega char por char.
// int fgets    --> Pega string por string.

//EOF   --> End of File

    int fclose (arq);
}

// Se for diferente de 0 salva.