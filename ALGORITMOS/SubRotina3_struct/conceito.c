#include <stdio.h>

struct professor{
    char nome[30];
    float salario;
    int idade;
    char diploma[100];
};

typedef struct professor prof;

void cadastrarInfos(prof *p){
    printf("Nome: ");
    gets(p -> nome);

    printf("Idade: ");
    scanf("%d", &p -> idade);

    printf("Salario: ");
    scanf("%f", &p -> salario);
    fflush(stdin);

    printf("Diploma: ");
    gets(p -> diploma);
}

int main(){
    prof guerino;

    cadastrarInfos(&guerino);

    printf("Nome %s\n", guerino.nome);
    printf("Idade %d\n", guerino.idade);
    printf("Salario %s\n", guerino.salario);
    printf("Diploma %s\n", guerino.diploma);
}