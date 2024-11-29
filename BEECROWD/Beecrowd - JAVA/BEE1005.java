import java.util.Scanner;
import java.io.IOException;

    public class BEE1005 {
        
        public static void main(String[] args) throws IOException {
           try (Scanner leia = new Scanner(System.in)){

            System.out.print("Insira o valor da 1° nota: ");
            double a = leia.nextDouble();
            System.out.print("Insira o valor da 2° nota: ");
            double b = leia.nextDouble();

            double media = ((3.5*a) + (7.5*b))/11;
            System.out.println(String.format("MEDIA = %.5f" , media));
        }         
        }         
    }
