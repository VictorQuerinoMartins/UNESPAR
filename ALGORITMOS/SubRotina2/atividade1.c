//Elabore um programa contendo uma sub-rotina que receba as três notas de um aluno como parâmetros e uma letra. Se a letra for A, a sub-rotina deverá calcular a média aritmética das notas do aluno; se for P, deverá calcular a média ponderada, com pesos 5, 3 e 2. A média calculada deverá ser mostrada no programa principal. Utilize passagem por referência



#include <stdio.h>

void notas(float *nota1, float *nota2, float *nota3,  char *letra){    

  if(*letra == 'A' || *letra == 'a' ){
    float mediaA = (*nota1 + *nota2 + *nota3) / 3;
    printf(" A media aritmeticia eh: %.2f ", mediaA);

  }else if(*letra == 'P' || *letra == 'p'){
    float mediaP = (((*nota1*5) + (*nota2*3) + (*nota3*2)) / 10);
    printf("A media ponderada eh: %.2f ", mediaP);
  }
    
}

int main(){
   float numero1, numero2, numero3;
    char letra;

    printf(" Digite a nota 1: ");
    scanf("%f", &numero1);

    printf("\n Digite a nota 2: ");
    scanf("%f", &numero2);

    printf("\n Digite a nota 3: ");
    scanf("%f", &numero3);

    printf("\n Digite (A) para media aritmetica ou (P) para media ponderada: ");
    scanf(" %c", &letra);
   
   notas(&numero1, &numero2, &numero3, &letra);

    return 0;

}