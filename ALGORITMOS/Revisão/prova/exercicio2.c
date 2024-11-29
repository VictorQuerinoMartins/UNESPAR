#include <stdio.h>
#include <stdlib.h>

typedef struct alunos{
    char nome[30];
    int matricula;
    float nota1;
    float nota2;
    float nota3;
}aluno;

float calcularMedia(aluno alunoA){
    float media;
    media = (alunoA.nota1 + alunoA.nota2 + alunoA.nota3) / 3;
    return media;
}

int exibir(aluno alunoA){
    printf("\n Nome: %s ", alunoA.nome);
    printf("\n Matricula: %d", alunoA.matricula);
    printf("\n Nota1: %.2f", alunoA.nota1);
    printf("\n Nota1: %.2f",alunoA.nota2);
    printf("\n Nota1: %.2f",alunoA.nota3);
}


main(){
    aluno alunoA;

    scanf("%s", alunoA.nome);
    scanf("%d", &alunoA.matricula);
    scanf("%f", &alunoA.nota1);
    scanf("%f", &alunoA.nota2);
    scanf("%f", &alunoA.nota3);

    float media = calcularMedia(alunoA);
    exibir(alunoA);
}