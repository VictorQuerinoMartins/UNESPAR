// Armazena valores de endereços, e para cada tipo de variável diferente existem o ponteiro correspondente. float - ponteiro de float, int - ponteiro de int.

// Para declarar ponteito utiliza (*), exemplo = int *p , isso estaria declarando um ponteiro p.

//Recebe o endereço da memória.

//Exemplo:

#include <stdio.h>
#include <stdlib.h>

//int main(){
  //  int a = 5;
  //  int *p; //declaração de ponteiro
  //  int c;

    //Manipulção de vetores

    // & significa ("O endereço de"), já o operador * significa ("O conteudo de")

  //  p = &a; // p recebe o endereço de a

   // *p = 6; //Posição da memoria apontada por p = 6         Mesma coisa que a = 6;

   // c = *p; // C recebe o valor armazenado na posição apontada por *p

  //  return 0;
//}

int main(){
    int a, b, *p;

    p = &a;
    a=3;
    b = a + (*p);

    printf("%d", b);
}