#include <stdio.h>

// Função para calcular o valor gasto em combustível
float calcularGastoCombustivel(float distancia, float consumoLitrosPorKm, float precoCombustivel) {
    return distancia * consumoLitrosPorKm * precoCombustivel;
}

// Função para calcular a autonomia do carro
float calcularAutonomia(float capacidadeTanque, float consumoLitrosPorKm) {
    return capacidadeTanque / consumoLitrosPorKm;
}

// Função para calcular quantos tanques são necessários para uma certa distância
float calcularTanquesNecessarios(float distancia, float autonomia) {
    return distancia / autonomia;
}

int main() {
    // Definir a estrutura para armazenar informações de cada carro
    struct Carro {
        char fabricante[50];
        char modelo[50];
        char placa[20];
        char tipoCombustivel[20];
        float capacidadeTanque;
        float consumoLitrosPorKm;
    };

    // Lista de carros
    struct Carro carros[30];

    // Registrar dados para 30 carros
    for (int i = 0; i < 30; i++) {
        printf("Digite o fabricante do carro %d: ", i + 1);
        scanf("%s", carros[i].fabricante);

        printf("Digite o modelo do carro %d: ", i + 1);
        scanf("%s", carros[i].modelo);

        printf("Digite a placa do carro %d: ", i + 1);
        scanf("%s", carros[i].placa);

        printf("Digite o tipo de combustível do carro %d: ", i + 1);
        scanf("%s", carros[i].tipoCombustivel);

        printf("Digite a capacidade do tanque (em litros) do carro %d: ", i + 1);
        scanf("%f", &carros[i].capacidadeTanque);

        printf("Digite o consumo em litros por quilômetro do carro %d: ", i + 1);
        scanf("%f", &carros[i].consumoLitrosPorKm);
    }

    // Exibir os dados dos carros
    for (int i = 0; i < 30; i++) {
        printf("\nCarro %d:\n", i + 1);
        printf("Fabricante: %s\n", carros[i].fabricante);
        printf("Modelo: %s\n", carros[i].modelo);
        printf("Placa: %s\n", carros[i].placa);
        printf("Tipo de Combustível: %s\n", carros[i].tipoCombustivel);

        // Calcular e exibir o valor gasto em combustível para uma viagem de 100 km
        float distancia = 100.0;
        float autonomia = calcularAutonomia(carros[i].capacidadeTanque, carros[i].consumoLitrosPorKm);
        float gasto = calcularGastoCombustivel(distancia, carros[i].consumoLitrosPorKm, 9);
        printf("Valor gasto em combustível para uma viagem de 100 km: R$%.2f\n", gasto);

        // Calcular e exibir a autonomia do carro
        printf("Autonomia do carro: %.2f km/l\n", autonomia);

        // Calcular e exibir quantos tanques são necessários para percorrer 500 km
        distancia = 500.0;
        float tanquesNecessarios = calcularTanquesNecessarios(distancia, autonomia);
        printf("Tanques necessários para percorrer 500 km: %.2f\n", tanquesNecessarios);
    }
return 0;
}