import java.io.IOException;
import java.util.Scanner;

public class BEE1010 {
    public static void main (String[]agrs) throws IOException{
        try (Scanner leia = new Scanner(System.in)) {
            double cod1 = leia.nextDouble();
            double num1 = leia.nextDouble();
            double valoru1 = leia.nextDouble();
            double total1 = (num1*valoru1);

            double cod2 = leia.nextDouble();
            double num2 = leia.nextDouble();
            double valoru2 = leia.nextDouble();
            double total2 = (num2*valoru2);
            
            double total3 = (total1 + total2);

            System.out.printf("VALOR A PAGAR: R$ %.2f\n", total3 );
        }
    }
    }

