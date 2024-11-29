import java.io.IOException;
import java.util.Scanner;

public class BEE1008 {
	
	public static void main(String[] args) throws IOException {
        try (Scanner leia = new Scanner(System.in)) {
            int cod = leia.nextInt();
            int hrs = leia.nextInt();

            double valorph = leia.nextDouble();
            double salario = hrs * valorph;

            System.out.println("NUMBER = " + cod);
            System.out.println(String.format("SALARY = U$ %.2f" , salario));
        }
    }
}