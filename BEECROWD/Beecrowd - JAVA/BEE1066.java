import java.io.IOException;
import java.util.Scanner;

public class BEE1066 {
	
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int par = 0;
        int impar = 0;
        int pstv = 0;
        int neg = 0;
        int x;
        for (int i = 0; i < 5; i++) {
            
        	x = s.nextInt();

        	if (x % 2 == 0) par++;

        	else impar++;

        	if (x > 0) pstv++;

        	else if(x < 0) neg++;
        }
        System.out.println(par + " valor(es) par(es)");
        System.out.println(impar + " valor(es) impar(es)");
        System.out.println(pstv + " valor(es) positivo(s)");
        System.out.println(neg + " valor(es) negativo(s)");
    }
	
}