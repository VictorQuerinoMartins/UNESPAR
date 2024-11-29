#include <stdio.h>
#include <stdlib.h>

main()
{
    int n, t, mult;
    printf("Qual valor que deseja a tabuada?");
    scanf("%i", &n);
    // Valor inicial de t=1, vai até n de 1 em 1.
    for (t = 1; t <= 10; t++)
    { // (atribui o valor; condição; incremento)
        mult = n * t;
        printf("%i x %i = %i \n", n, t, mult);
    }
}
