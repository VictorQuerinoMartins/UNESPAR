//No lugar de scanf usa se "gets(nome)"

#include <stdio.h>
main(){
    char nome[30];
    printf("Digite o seu nome: ");
    gets(nome);

    printf(nome);
}


Strcpy
// strcpy, copia caracteres da cadeia string2 para string1
// strncpy, copia n caracteres
strncpy(string1, string2,n);


Strcat
// strcat, concatena a cadeia string2 na string1
// strncat, concatena n caracteres
strncat(string1, string2,n);


Strcmp
// strcmp, compara duas cadeias de caracteres
// zero se as duas cadeias são iguais
// um número menor que zero. se a string1 for alfabeticamente menor que a string2
// um número maior que zero. se a string1 for alfabeticamente maior que a string2
//Considera que letras maiusculas e minúsculas são diferentes.
strcmp(string1, string2,n);

Strncmp
// Compara as duas cadeias de caracteres, da primeira posição até a posição.
strncmp(string1, string2,n);

Strlen 
// Retorna a quantidade de caracteres da cadeia
// O valor de retorno pode ser armazenado em uma variável.
strlen(string1, string2,n);

Stricmp
//Compara duas cadeias de caractéres e retorna um número inteiro
//Essa função considera que letras maiúculas e minusculas são iguais
stricmp(string1, string2,n);

Strset
//Substitui todos os caracteres por outro

Strrev
// Inverte todos caracteres da cadeia str.
//(ABC) -> (CBA)

Toupper
//Converte um caracter especício para Maiúsculo
cadeia[posicao] = toupper = cadeia[posicao];


Tolower
//Converte um caracter especício para Minúculo
cadeia[posicao] = tolower = cadeia[posicao];