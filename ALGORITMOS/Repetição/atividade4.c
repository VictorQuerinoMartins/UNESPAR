#include <stdio.h>
int main() {
    float valor;
    int parcelas;

    printf("Digite o valor do carro: ");
    scanf("%f", &valor);

   
    float precoavista = valor +(valor * 0.05);

    float preco12parcelas = valor +(valor * 0.06);
    float preco12parcelas = preco12parcelas/12;

    float preco24parcelas = valor +(valor * 0.12);
    float preco24parcelas = preco24parcelas/24;

    float preco48parcelas = valor +(valor * 0.24);
    float preco48parcelas = preco48parcelas/48;

    float preco60parcelas = valor +(valor * 0.30);
    float preco60parcelas = preco60parcelas/60;


     printf("Preço final à vista: R$ %.2f\n", precoavista);
     printf("---A VISTA---\n");
     printf("Preco final: %.2f\n",precoavista);

      printf("---12 PARCELAS---\n");
     printf("Preco final: %.2f\n",preco12parcelas);

      printf("---24 PARCELAS---\n");
     printf("Preco final: %.2f\n",preco24parcelas);

      printf("---48 PARCELAS---\n");
     printf("Preco final: %.2f\n",preco48parcelas);

      printf("---60 PARCELAS---\n");
     printf("Preco final: %.2f\n",preco60parcelas);
 
}