//Leia um valor inteiro. A seguir, calcule o menor número de notas possíveis (cédulas) no qual o valor pode ser decomposto. As notas consideradas são de 100, 50, 20, 10, 5, 2 e 1. A seguir mostre o valor lido e a relação de notas necessárias.

//Entrada
//O arquivo de entrada contém um valor inteiro N (0 < N < 1000000).

//Saída
//Imprima o valor lido e, em seguida, a quantidade mínima de notas de cada tipo necessárias, conforme o exemplo fornecido. Não esqueça de imprimir o fim de linha após cada linha, caso contrário seu programa apresentará a mensagem: “Presentation Error”.

#include <stdio.h>


 int main(){
    int notes, aux;

    scanf("%d", &notes);

    printf("%d\n", notes);
    printf("%d nota(s) de R$ 100,00\n", notes/100);
    aux = (notes%100);


    printf("%d nota(s) de R$ 50,00\n", aux/50);
    aux = (aux%50);

    printf("%d nota(s) de R$ 20,00\n", aux/20);                                                                                                                        
    aux = (aux%20);

    printf("%d nota(s) de R$ 10,00\n", aux/10);
    aux = (aux%10);

    printf("%d nota(s) de R$ 5,00\n", aux/5);
    aux = (aux%5);

    printf("%d nota(s) de R$ 2,00\n", aux/2);
    aux = (aux%2);

    printf("%d nota(s) de R$ 1,00\n", aux/1);
    return 0;
 }