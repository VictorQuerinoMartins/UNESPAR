 main() {
    int numero;

    printf("Digite um numero inteiro: ");
    scanf("%d", &numero);

    if (numero % 2 == 0) {
        printf("%d eh um numero par.", numero);
    } else {
        printf("%d eh um numero impar.", numero);
    }
}