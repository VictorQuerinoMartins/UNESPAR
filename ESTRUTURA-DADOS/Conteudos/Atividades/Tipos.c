#include <stdio.h>

main(){
    // Aluno: Victor Querino Martins 2° - Ciências da Computação

    float vteste;
    printf("=== TIPO === | === Bytes ===\n");
    printf("Char:.......   %d  Bytes\n", sizeof(char));
    printf("Short:......   %d  Bytes\n", sizeof(short));
    printf("Int:........   %d  Bytes\n", sizeof(int));
    printf("Long:.......   %d  Bytes\n", sizeof(long));
    printf("Float:......   %d  Bytes\n", sizeof(float));
    printf("Double:.....   %d  Bytes\n", sizeof(double));
    printf("Long double:   %d  Bytes\n", sizeof(long double));
    
    printf("\n O tamanho de vteste eh: %d  Bytes\n", sizeof vteste);
}