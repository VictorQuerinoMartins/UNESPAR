// Possibilidades
//  Parâmetros por valor <-- Passando apenas o valor não a váriavel.    (cria uma cópia)

//  Parâmetros por referencia   <-- Passando o endereço da váriavel na memória.    (Não cria uma cópia)



int soma_dobro(int *numero1, int *numero2){     //  (*)  Para indicar que é um endereço na memória.
    int resultado;
    *numero1 = (*numero1) * 2;
    *numero2 = (*numero2) * 2;
    resultado = *numero1 + *numero2;
    return resultado;
}

int main(){
    int numero1, numero2, soma;
    printf("\n Digite o numero 1 \n");
    scanf("%d", &numero1);
    printf("\n Digite o numero 2 \n");
    scanf("%d", &numero2);
    soma = soma_dobro (&numero1, &numero2);
    printf("\nResultado: %d", soma);
    return 0;

}