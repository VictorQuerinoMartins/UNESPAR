#include <stdio.h>
#include <locale.h>

//Victor Querino Martins 

int main() {

    setlocale(LC_ALL, "Portuguese");

    int i;
    for (i = 0; i < 20; i++)
        printf("%c\n", '*');

}