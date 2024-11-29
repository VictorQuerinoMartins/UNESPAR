// Para armazenar cadeias de caracteres utilizamos o vetor. Cada posição do vetor armazena um caractere.


#include <stdio.h>
main()
{
    float a, b, result;
    char op;                        // char é um símbolo.
    scanf("%f %c %f", &a, &op, &b); // Scanf multiplo     // "%c" -> para char.

    switch (op)
    {
    case '+': // ' ' para um caracter.
        result = a + b;
        printf("A soma e = %.2f \n", result);
        break;

    case '-':
        result = a - b;
        printf("A subtracao e = %.2f \n", result);
        break;

    case '*':
        result = a * b;
        printf("A multiplicacao e = %.2f \n", result);
        break;

    case '/':
        result = a / b;
        printf("A divisao e = %.2f \n", result);
        break;

    default:
        break;
    }
}