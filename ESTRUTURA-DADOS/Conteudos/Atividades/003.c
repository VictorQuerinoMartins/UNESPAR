#include <stdio.h>
// Aluno: Victor Querino Martins

main(){
int idade;

printf("Insira sua idade: ");
scanf("%d", &idade );

if(idade < 25){
    printf("Voce eh jovem");
}else{
    printf("Voce eh maduro");
}
}