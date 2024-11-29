//Faça um programa que seja capaz de registrar uma frota de 30 carros e mostrar os seguintes dados de cada um deles:
//● fabricante, modelo, placa e tipo de combustível;
//● o valor gasto em R$ de combustível para uma viagem (subrotina);
//● a autonomia do carro (a distância máxima percorrida com um tanque cheio decombustível);
//● quantos tanques são necessários para percorrer uma certa distância em km (subrotina);

#include <stdio.h>


typedef struct carro{
    char fabricante[20];
    char modelo[30];
    char placa[9];
    char tipocombus[20];
    float preco;
    float distancia;
    float autonomia;
} carro;


float calculoGasto(float distancia, float preco) {
    return distancia / preco;   
   
}

float calculoTanques(float distancia, float autonomia) {
    return distancia / autonomia;
}

main(){

    carro frota[2];

 for (int i = 0; i < 2; i++) {
        printf("Digite os detalhes do carro %d:\n", i + 1);

        printf("Fabricante:\n ");
        scanf("%s", frota[i].fabricante);

        printf("Modelo:\n ");
        scanf("%s", frota[i].modelo);

        printf("Placa: \n");
        scanf("%s", frota[i].placa);
        fflush(stdin);

        printf("Tipo de combustivel: \n");
        scanf(" %s", frota[i].tipocombus);
        fflush(stdin);

        printf("Preco do combustivel: \n");
        scanf("%f", &frota[i].preco);
        fflush(stdin);

        printf("Distancia percorrida : \n");
        scanf("%f", &frota[i].distancia);

        printf("Autonomia do carro em km: \n");
        scanf("%f", &frota[i].autonomia);
    }

    
 for (int i = 0; i < 2; i++) {

        printf("Fabricante: %s \n", frota[i].fabricante);        
        printf("Modelo: %s \n", frota[i].modelo);
        printf("Placa:  %s \n", frota[i].placa);
        printf("Combustivel:  %s \n",frota[i].tipocombus );
        printf("Autonomia do carro em km:  %.2f \n",  &frota[i].autonomia);
        

        float gasto = calculoGasto(frota[i].distancia, frota[i].preco);
        printf("Valor gasto de combustivel por km em R$: %.2f \n", gasto);

        float tanques = calculoTanques(frota[i].distancia,frota[i].autonomia);
        printf("Quantidades de tanques necessarios: %.2f \n", tanques);

    }


}