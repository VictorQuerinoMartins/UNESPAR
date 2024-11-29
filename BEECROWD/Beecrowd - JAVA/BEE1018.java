import java.io.IOException;
import java.util.Scanner;
public class BEE1018 {
    public static void main (String[]agrs)throws IOException{
    Scanner s = new Scanner(System.in);

    int valor = s.nextInt();
    int x = valor;

    int notas100 = x/100;
    x =  x - notas100*100;

    int notas50 = x/50;
    x =  x - notas50*50;

    int notas20 = x/20;
    x =  x - notas20*20;

    int notas10 = x/10;
    x =  x - notas10*10;
    
    int notas5 = x/5;
    x =  x - notas5*5;

    int notas2 = x/2;
    x =  x - notas2*2;

    int notas1 = x;


    System.out.println(valor);
        System.out.println(notas100 + " nota(s) de R$ 100,00");
        System.out.println(notas50 + " nota(s) de R$ 50,00");
        System.out.println(notas20 + " nota(s) de R$ 20,00");
        System.out.println(notas10 + " nota(s) de R$ 10,00");
        System.out.println(notas5 + " nota(s) de R$ 5,00");
        System.out.println(notas2 + " nota(s) de R$ 2,00");
        System.out.println(notas1 + " nota(s) de R$ 1,00");
    }
	


    }
