#include <stdio.h>
#include <stdlib.h>

int main() {
    struct ficha_aluno {
        int numero;
        char nome[40];
        float nota;
    };

    struct ficha_aluno aluno;
    printf("----------Cadastro----------\n\n");

    printf("Nome do aluno: ");
    fgets(aluno.nome, 40, stdin);
    

    printf("Digite o numero do aluno: ");
    scanf("%d", &aluno.numero);

    printf("Digite a nota do aluno: ");
    scanf("%f", &aluno.nota);

    printf("---Lendo os dados da struct---\n\n");
    printf("Nome.................: %s\n", aluno.nome);
    printf("Numero...............: %d\n", aluno.numero);
    printf("Nota.................: %.2f\n", aluno.nota);

    return 0;
}