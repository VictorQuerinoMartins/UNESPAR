// Escreva um programa que contenha duas variáveis inteiras. Leia essas variáveis do teclado. Em seguida, compare seus endereços e exiba o conteúdo do maior endereço.

int main(){

int A;
int B;

int *pA = &A;
int *pB = &B;

scanf("%d",&A);
scanf("%d",&B);

if(&A>&B){
    printf("endereco A(%d) maior : %d\n",&A,A);
}else if(&A<&B){
    printf("endereco B(%d) maior : %d\n",&B,B);
}

}