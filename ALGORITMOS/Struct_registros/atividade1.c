// 1. Crie um programa (utilizando registros) para ler o código, o sexo (M — masculino; F — feminino) e o número de horas--aula ministradas pelos professores de uma escola durante um mês. Sabe-se que um professor ganha R$ 60,50 hora-aula e que a escola possui dez professores. Se o professor ministrar menos de 70 horas no mês, deve ser descontado 8% do seu salário bruto. Se o professor ministrar 70 horas no mês ou mais, deve ser descontado 5% do salário bruto. Após a leitura, o programa deverá mostrar:
//  a) Uma listagem contendo o código, o salário bruto, o desconto e o salário líquido de todos os professores.
//  b) A média aritmética dos salários brutos dos professores do sexo masculino.
//  c) A média aritmética dos salários brutos dos professores do sexo feminino.

#include <stdio.h>

struct professores{
    int cod;
    char sexo;
    int horas;
    float salarioB;
    float salarioL;
    float desconto;
};

typedef struct professores Profs;

main(){

Profs v[2];

for(int i = 0; i < strlen(v); i++){

    printf("\nInsira o codigo: ");
    scanf("%d", &v[i].cod);
    fflush(stdin);              // Usado para limpar o tipo de variavél do scanf. (Resetar o scanner)

    printf("\nInsira o sexo M/F: ");
    scanf("%c", &v[i].sexo);

    printf("\nInsira as horas: ");
    scanf("%d", &v[i].horas);


v[i].salarioB = 60.50 * v[i].horas;


if(v[i].horas < 70){
    v[i].desconto = v[i].salarioB * 0.08;
}else{
    v[i].desconto = 0.05 * v[i].salarioB;
}

v[i].salarioL = v[i].salarioB - v[i].desconto;
}

printf("Codigo, Salario bruto, Desconto, Salario Liquido");

for(int j =0; j < 2; j++){
    printf("\nCodigo:%.2d \nSexo:%c \nHoras:%.2d \nSalario Bruto:%.2f \nDesconto:%.2f \nSalario Liquido:%.2f\n", v[j].cod, v[j].sexo, v[j].horas, v[j].salarioB, v[j].desconto, v[j].salarioL);
}
int TotalDeM = 0;
float SomaM = 0.0;
int TotalDeF = 0;
float SomaF = 0.0;
float MediaM;
float MediaF;

for( int k = 0; k < 2; k++){
    if(v[k].sexo == 'M'){
    TotalDeM++;
    SomaM += v[k].salarioB;
}else if(v[k].sexo == 'F'){
    TotalDeF++;
    SomaF += v[k].salarioB;
}
}
MediaM = SomaM / TotalDeM;
MediaF = SomaF / TotalDeF;

printf("Media salario masc: %.2f \n", MediaM);
printf("Media salario fem: %.2f \n", MediaF);
}