//Crie um programa que receba os valores antigo e atual de um produto. Chame uma sub-rotina que determine o percentual de acréscimo entre esses valores. O resultado deverá ser mostrado no programa principal. Utilize passagem por referência.

#include <stdio.h>


void valores(float ValorAnt, float Valoratt, float *percentual) {
 
        *percentual = ((Valoratt - ValorAnt) / ValorAnt) * 100;
        
}


int main(){
   float percentual, ValorAnt, ValorAtt;

printf("Insira o valor antigo: ");
   scanf("%f", &ValorAnt);

printf("Insira o valor atual: ");
   scanf("%f", &ValorAtt);

  valores(ValorAnt,ValorAtt,&percentual);

printf("O percentual eh de %.2f", percentual);
   

}