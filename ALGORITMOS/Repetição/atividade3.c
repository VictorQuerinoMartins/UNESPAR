#include <stdio.h>
int main() {
int soma, idade, peso;
float altura = 0;
int cont = 0;
int cont2 = 0;
int cont3 = 0;

    for (int i = 1; i <=3; i++) {
        printf("Digite idade da pessoa %d: ");
        scanf("%d", &idade);
         printf("Digite o peso da pessoa %d: ");
        scanf("%d", &peso);
         printf("Digite a altura da pessoa %d: ");
        scanf("%f", &altura);
       

        soma = soma + idade;

        if (peso > 90 && altura < 1.50) {
            cont++;
        }
        if(altura > 1.90){
            cont2++;

        }
        if (altura >= 1.90 && idade >= 10 && idade < 30) {
            cont3++;

     }    
}

if(cont2 == 0){
    cont2 = 1;
}

float porcentagem = (cont3*100) / cont2;

printf("P\n");
printf("Média das idades: %.2f\n", soma / 3.0);
printf("Quantidade de pessoas com o peso superior a 90 kg e altura menor que 1.50")
printf(("Porcentagem de pessoas com idade entre 10 e 30 anos e altura maior que 1,90m: %.2f\n"), porcentagem);


}
