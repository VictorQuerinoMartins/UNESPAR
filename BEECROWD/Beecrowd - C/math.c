#include<stdio.h>
#include<stdlib.h>
#include<math.h>   

main(){
    float x1,y1;            // Coordenados do ponto (x1,y1)
    float x2,y2;          // Coordenados do ponto (x2,y2)
    float q1, q2, dist;

    printf("x1: ");
    scanf("%f",&x1);

     printf("y1: ");
    scanf("%f",&y1);
     
      printf("x2: ");
    scanf("%f",&x2);

     printf("y2: ");
    scanf("%f",&y2);

    q1 = pow (x2 - x1, 2);
    q2 = pow (y2 - y1, 2);
    dist = sqrt(q1+q2);
    printf("Distancia: %f \n", dist);
}