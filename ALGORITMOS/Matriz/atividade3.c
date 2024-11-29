//Implemente um programa que receba números para uma matriz A 3x4. Apresente como saída uma matriz B, em que os elementos são resultantes dos seguintes cálculos:
//● Os números ímpares da matriz A devem ser multiplicados por 3.
//● Os números pares da matriz A devem ser multiplicados por 2.


#include <stdio.h>
main(){
    int Amatriz [3] [4];
    int Bmatriz [3] [4];

    for(int i = 0; i < 3; i++){
        for(int j = 0; j < 4; j++){

            printf("Digite um valor para cada posicao da matriz A (%d,%d): ", i + 1, j + 1 );
            scanf("%d", &Amatriz[i][j]);
        }
    }
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 4; j++) {
            if(Amatriz[i][j] % 2 == 0){
                Bmatriz[i][j] = Amatriz [i][j]*2;
            }else{
                Bmatriz[i][j] = Amatriz [i][j]*3;
            }
        }
    }
    printf("\n");

    printf("Matriz B: ");
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 4; j++) {
            printf("%d ", Bmatriz[i][j]);
        }
}
}