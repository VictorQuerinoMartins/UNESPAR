// Implemente um programa que leia o nome de 5 pessoas e mostre os nomes armazenados. Utilize vetores.


#include <stdio.h>
#include <string.h>.
main ()  {
	int i;
	char pessoa [5] [80];
	
	for (i = 1; i < 6; i++) {
		printf("Informe o nome da pessoa %d:\n", i);
		gets(pessoa[i]);
		
		}

		printf("Lista de nomes informados:\n");
			for (i = 1; i < 6; i++) {
	
		printf("%s\n", pessoa[i]);
		}
		
			return 0;
		}
		
	
	

