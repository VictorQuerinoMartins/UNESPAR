//A prefeitura de uma cidade fez uma pesquisa entre seus habitantes, coletando dados sobre o salário, idade, sexo e número de filhos. Crie um programa em C (utilizando registros) que leia os dados de um número indeterminado de pessoas (assumir que idade=0 deve sair do programa) e, ao final, mostre:

//a) A média de idade das mulheres com salário inferior a R$ 300,00;
//b) A média de salário da população;
//c) A média do número de filhos;
//d) O maior salário;
//e) A menor idade.

#include <stdio.h>

struct Pessoa {
    char sexo;
    float salario;
    int idade;
    int Filhos;
};

int main() {
    struct Pessoa pessoa;
    int contador = 0;
    float somaIdadeMulheres = 0;
    int contadorMulheres = 0;
    float somaSalario = 0;
    float somaFilhos = 0;
    float maiorSalario = 0;
    int menorIdade = 999; 
    

    while (1) {
        printf("Digite a idade (ou 0 para sair): ");
        scanf("%d", &pessoa.idade);
        
        if (pessoa.idade == 0) {
            break; 
            
        }

        printf("Digite o sexo (M/F): ");
        scanf(" %c", &pessoa.sexo);

        printf("Digite o salario: ");
        scanf("%f", &pessoa.salario);

        printf("Digite o numero de filhos: ");
        scanf("%d", &pessoa.Filhos);

        // Calcular estatísticas
        if (pessoa.sexo == 'F' && pessoa.salario < 300.0) {
            somaIdadeMulheres += pessoa.idade;
            contadorMulheres++;
        }

        somaSalario += pessoa.salario;
        somaFilhos += pessoa.Filhos;

        if (pessoa.salario > maiorSalario) {
            maiorSalario = pessoa.salario;
        }

        if (pessoa.idade < menorIdade) {
            menorIdade = pessoa.idade;
        }

        contador++;
    }

    if (contador > 0) {
        printf("a) A média de idade das mulheres com salário inferior a R$ 300,00: %.2f\n", 
               (contadorMulheres > 0) ? somaIdadeMulheres / contadorMulheres : 0);

        printf("b) A media de salario da populacao: %.2f\n", somaSalario / contador);
        printf("c) A media do numero de filhos: %.2f\n", somaFilhos / contador);
        printf("d) O maior salario: %.2f\n", maiorSalario);
        printf("e) A menor idade: %d\n", menorIdade);
    } else {
        printf("Nenhum dado foi inserido.\n");
    }

}
