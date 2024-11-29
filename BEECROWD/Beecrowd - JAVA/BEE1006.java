import java.util.Scanner;
import java.io.IOException;

    public class BEE1006 {
        
        public static void main(String[] args) throws IOException {
           try (Scanner leia = new Scanner(System.in)){

            
            double a = leia.nextDouble();
            double b = leia.nextDouble();
            double c = leia.nextDouble();

            double media = ((2*a) + (3*b) + (5*c))/10;

            System.out.printf("MEDIA = %.1f\n", media);

           }  
     }         
    }