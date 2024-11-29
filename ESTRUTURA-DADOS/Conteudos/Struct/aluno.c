#include <stdio.h>
#include <stdlib.h>

typedef struct ficha_aluno {
    int numero;
    char nome[40];
    float nota, nota1, nota2, nota3;
} aluno;

int main() {
    aluno alunos[3];

    for (int i = 0; i < 3; i++) {

        printf("----------Cadastro do aluno %d----------\n\n", i + 1);

        printf("Nome do aluno: ", i + 1);
        scanf("%s", &alunos[i].nome);

        printf("Digite o numero do aluno %d: ", i + 1);
        scanf("%d", &alunos[i].numero);

        printf("Digite a nota 1 do aluno %d: ", i + 1);
        scanf("%f", &alunos[i].nota);

        printf("Digite a nota 2 do aluno %d: ", i + 1);
        scanf("%f", &alunos[i].nota1);

        printf("Digite a nota 3 do aluno %d: ", i + 1);
        scanf("%f", &alunos[i].nota2);

        printf("Digite a nota 4 do aluno %d: ", i + 1);
        scanf("%f", &alunos[i].nota3);


        printf("---Lendo os dados da struct---\n\n");
        printf("Nome.................: %s\n", alunos[i].nome);
        printf("Numero...............: %d\n", alunos[i].numero);
        printf("Nota1.................: %.2f\n", alunos[i].nota);
        printf("Nota2.................: %.2f\n", alunos[i].nota1);
        printf("Nota3.................: %.2f\n", alunos[i].nota2);
        printf("Nota4.................: %.2f\n", alunos[i].nota3);

       
    }

    return 0;
}

