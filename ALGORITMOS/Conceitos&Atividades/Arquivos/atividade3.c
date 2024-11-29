//Faça um programa que salvará dados de alunos em arquivos. Um aluno será composto pelos seguintes campos: numero, nome, curso, nota1, nota2. Cada campo será informado pelo usuário. O seu programa deverá criar um arquivo chamado NomeDoAluno.txt (haverá um arquivo por aluno) e salvar as informações do aluno neste arquivo. Teste seu programa com 3 alunos.

#include <stdio.h>

int main() {
    int numero;
    char nome[50];
    char curso[50];
    float nota1, nota2;
    char nomeArq[100];

    for (int i = 1; i <= 3; i++) {
        
        printf("Aluno %d:\n", i);
        printf("Numero: ");
        scanf("%d", &numero);
        printf("Nome: ");
        scanf(" %s", nome);
        printf("Curso: ");
        scanf(" %s", curso);
        printf("Nota 1: ");
        scanf("%f", &nota1);
        printf("Nota 2: ");
        scanf("%f", &nota2);

        
        snprintf(nomeArq, sizeof(nomeArq), "%s.txt", nome);

        
        FILE *arquivo = fopen(nomeArq, "w");

        if (arquivo == NULL) {
            printf("Erro ao criar o arquivo %s.\n", nome);
            return 1;
        }

        
        fprintf(arquivo, "Numero: %d\n", numero);
        fprintf(arquivo, "Nome: %s\n", nome);
        fprintf(arquivo, "Curso: %s\n", curso);
        fprintf(arquivo, "Nota 1: %.2f\n", nota1);
        fprintf(arquivo, "Nota 2: %.2f\n", nota2);

       
        fclose(arquivo);

        printf("Dados do aluno %s salvos no arquivo %s\n", nome, nomeArq);
    }

    return 0;
}