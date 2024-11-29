#include <stdio.h>


int main(){
    int N, quantia, total = 0;
    int coelhos = 0,ratos = 0,sapos = 0;
    char tipo;

    printf("Indique a quantidade de cobaias: \n");
    scanf("%d", &N);

    printf("Preencha com a quantidade de cobaias e o seu tipo: \n");
    scanf("%d %c", &quantia, &tipo);

    total += quantia;

    switch(tipo){
        case 'R':
        ratos += total;
        break;

        case 'S':
        sapos += total;
        break;

        case 'C':
        coelhos += total;
        break;

        default:
            break;
    }

    printf("Total %d  cobaias \n", N);
    printf("Total de coelhos: %d\n", coelhos);
    printf("Total de ratos: %d\n", ratos);
    printf("Total de sapos: %d\n", sapos);

    printf("Percentual de coelhos: %d %%\n", coelhos / total * 100);
    printf("Percentual de ratos: %d %%\n", ratos / total * 100);
    printf("Percentual de sapos: %d %%\n", sapos / total * 100);
}