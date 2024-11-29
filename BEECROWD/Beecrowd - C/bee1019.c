//Leia um valor inteiro, que é o tempo de duração em segundos de um determinado evento em uma fábrica, e informe-o expresso no formato horas:minutos:segundos.

//Entrada
//O arquivo de entrada contém um valor inteiro N.

//Saída
//Imprima o tempo lido no arquivo de entrada (segundos), convertido para horas:minutos:segundos, conforme exemplo fornecido.

#include <stdio.h>

int main(){
 int segundos;
    
 scanf("%d", &segundos);
    
 int hours = segundos / 3600;
 segundos = segundos - (hours * 3600);
    
 int minutes = segundos / 60;
 segundos = segundos - (minutes * 60);
    
 printf("%d:%d:%d\n", hours, minutes, segundos);
    
 return 0;
}