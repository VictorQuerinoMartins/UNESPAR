#include <stdio.h>

main(){
    if(2>1 && 10>20){                       // && and -> Seria "e", ambos os lados devem ser verdadeiros.
    printf("Verdadeiro \n");
}else{
    printf ("Falso \n");
}
}

if(2>1 || 10>20){                       // || or -> Seria "ou", um lado ou outro é verdadeiro.
    printf("Verdadeiro \n");
}else{
    printf ("Falso \n");
}

if(!(2>1) && 10>20){                       // ! -> inverte os valores.
    printf("Verdadeiro \n");
}else{
    printf ("Falso \n");
}




// && tem primoridade de início