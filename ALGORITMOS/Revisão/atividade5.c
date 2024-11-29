//Um professor, muito legal, fez 3 provas durante um semestre mas só vai levar em conta as duas notas mais altas para calcular a média. Faça uma aplicação em C que peça o valor das 3 notas, mostre como seria a média com essas 3 provas, a média com as 2 notas mais altas, bem como sua nota mais alta e sua nota mais baixa. Utilize subrotinas para os cálculos com 3 e 2 notas, e outra subrotina para mostrar a nota mais alta e mais baixa.

#include <stdio.h>

void Calculo3provas(float n1, float n2, float n3) {
	float media = (n1 + n2 + n3) / 3;
	printf("A media das 3 provas foi de: %.2f\n", media);
}

void Calculo2maiores(float p1, float p2, float p3) {
	float Max, Min;
	
	if(p1 >= p2 && p1 >= p3) {
		Max = p1;
		if(p2 >= p3) {
			Min = p3;
		}else {
			Min = p2;
		}
	} else if(p2 >= p1 && p2 >= p3) {
		Max = p2;
		if(p1 >= p3) {
			Min = p3;
		}else {
			Min = p1;
		}
	}else {
		Max = p3;
	}if(p1 >= p2) {
		Min = p2;
	}else {
		Min = p1;
	}
	float media = (p1 + p2 + p3 - Min) / 2;
	printf("A media das notas mais altas foi de: %.2f\n", media);
}

void Calculomaiormenor(float n1, float n2, float n3) {
	float Max, Min;
	if(n1 >= n2 && n1 >= n3) {
		Max = n1;
	}else if(n2 >= n1 && n2 >= n3) {
		Max = n2;
	}else {
		Max = n3;
	}
	
	if(n1 <= n2 && n1 <= n3) {
		Min = n1;
	}else if(n2 <= n1 && n2 <= n3) {
		Min = n2;
	}else {
		Min = n3;
	}
	printf("A maior nota foi da prova %.2f.\n", Max);
	printf("A menor nota foi da prova %.2f.\n", Min);
}

main() {
	float n1, n2, n3;
	printf("Digite a nota da primeira prova:");
	scanf("%f", &n1);
	printf("\nDigite a nota da segunda prova:");
	scanf("%f", &n2);
	printf("\nDigite a nota da terceira prova:");
	scanf("%f", &n3);
	
	Calculo3provas(n1, n2, n3);
	Calculo2maiores(n1, n2, n3);
	Calculomaiormenor(n1, n2, n3);
}
