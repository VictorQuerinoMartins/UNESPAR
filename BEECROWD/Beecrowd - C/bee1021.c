//Leia um valor de ponto flutuante com duas casas decimais. Este valor representa um valor monetário. A seguir, calcule o menor número de notas e moedas possíveis no qual o valor pode ser decomposto. As notas consideradas são de 100, 50, 20, 10, 5, 2. As moedas possíveis são de 1, 0.50, 0.25, 0.10, 0.05 e 0.01. A seguir mostre a relação de notas necessárias.

//Entrada
//O arquivo de entrada contém um valor de ponto flutuante N (0 ≤ N ≤ 1000000.00).

//Saída
//Imprima a quantidade mínima de notas e moedas necessárias para trocar o valor inicial, conforme exemplo fornecido.

//Obs: Utilize ponto (.) para separar a parte decimal.


#include<stdio.h>
#include<math.h>

int main(){
//NOTAS	
int dinheiro1, cem, cinquenta, cinquenta1, vinte, vinte1, dez, dez1, cinco, cinco1, dois, dois1;
//MOEDAS
int moedas, um, um1, cinquentac, vintec, dezc, cincoc, umc;

double dinheiro;

//TRANSFORMAÇAO DE FLOAT PARA INTEIRO
scanf("%lf", &dinheiro);
dinheiro1 = (int)dinheiro;
dinheiro -= dinheiro1;

moedas = (dinheiro *100);


cem = dinheiro1/100;
cinquenta = dinheiro1 %100;
cinquenta1 = cinquenta/50;
vinte = cinquenta%50;
vinte1 = vinte/20;
dez = vinte%20;
dez1 = dez/10;
cinco = dez%10;
cinco1 = cinco/5;
dois = cinco%5;
dois1 = dois/2;

// MOEDAS
um = dois%2;
um1 = um/1;


printf("NOTAS:\n");
printf("%d nota(s) de R$ 100.00\n",cem);
printf("%d nota(s) de R$ 50.00\n",cinquenta1);
printf("%d nota(s) de R$ 20.00\n",vinte1);
printf("%d nota(s) de R$ 10.00\n",dez1);
printf("%d nota(s) de R$ 5.00\n",cinco1);
printf("%d nota(s) de R$ 2.00\n",dois1);



cinquentac = moedas /50;
vintec = (moedas %50)/25;
dezc = (((moedas %50)%25)/10);
cincoc = ((((moedas %50)%25)%10)/5);
umc = ((((moedas %50)%25)%10)%5)/1;

printf("MOEDAS:\n");
printf("%d moeda(s) de R$ 1.00\n", um1);
printf("%d moeda(s) de R$ 0.50\n", cinquentac);
printf("%d moeda(s) de R$ 0.25\n", vintec);
printf("%d moeda(s) de R$ 0.10\n", dezc);
printf("%d moeda(s) de R$ 0.05\n", cincoc);
printf("%d moeda(s) de R$ 0.01\n", umc);

return 0;
}