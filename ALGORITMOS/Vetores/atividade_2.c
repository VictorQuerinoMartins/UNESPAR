// Faça um programa que receba a temperatura média de cada mês do ano,armazenando-as em um vetor. Calcule e mostre a maior e a menor temperatura do ano e
// em que mês ocorreram (mostrar o mês por extenso: 1 – janeiro, 2 – fevereiro...).Desconsidere empates.


#include <stdio.h>

int main()
{
    float temp[12];
    float maiorTemperatura = 0, menorTemperatura = 0;
    int mesMaiorTemperatura = 1, mesMenorTemperatura = 1;

    for (int i = 0; i < 12; i++)
    {
        printf("Digite a temperatura media do mes %d: ", i + 1);
        scanf("%f", &temp[i]);
    }

    menorTemperatura = temp[0];
    maiorTemperatura = temp[0];

    for (int i = 0; i < 12; i++)
    {
        if (temp[i] < menorTemperatura)
        {
            menorTemperatura = temp[i];
            mesMenorTemperatura = i + 1;
        }
        if (temp[i] > maiorTemperatura)
        {
            maiorTemperatura = temp[i];
            mesMaiorTemperatura = i + 1;
        }
    }

    printf("\nMaior temperatura do ano: %.2f°C, Mes: %s\n", maiorTemperatura, mesMaiorTemperatura);
    printf("Menor temperatura do ano: %.2f°C, Mes: %s\n", menorTemperatura, mesMenorTemperatura);

    switch (mesMaiorTemperatura)
    {
    case 1;
        printf("Janeiro");
        break;
    case 2;
        printf("Fevereiro");
        break;
    case 3;
        printf("Marco");
        break;
    case 4;
        printf("Abril");
        break;
    case 5;
        printf("Maio");
        break;
    case 6;
        printf("Junho");
        break;
    case 7;
        printf("Julho");
        break;
    case 8;
        printf("Agosto");
        break;
    case 9;
        printf("Setembro");
        break;
    case 10;
        printf("Outubro");
        break;
    case 11;
        printf("Novembro");
        break;
    
    case 12;
        printf("Dezembro");
        break;

        default:
        break;
    }

   switch (mesMenorTemperatura)
    {
    case 1;
        printf("Janeiro");
        break;
    case 2;
        printf("Fevereiro");
        break;
    case 3;
        printf("Marco");
        break;
    case 4;
        printf("Abril");
        break;
    case 5;
        printf("Maio");
        break;
    case 6;
        printf("Junho");
        break;
    case 7;
        printf("Julho");
        break;
    case 8;
        printf("Agosto");
        break;
    case 9;
        printf("Setembro");
        break;
    case 10;
        printf("Outubro");
        break;
    case 11;
        printf("Novembro");
        break;
    
    case 12;
        printf("Dezembro");
        break;

    default:
        break;
    }
}
