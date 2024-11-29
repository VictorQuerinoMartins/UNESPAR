import java.io.IOException;
import java.util.Scanner;

public class BEE1009 {
    public static void main(String[]agrs) throws IOException{
        try (Scanner leia = new Scanner(System.in)) {
            String nome = leia.next();

            double salariofx = leia.nextDouble();
            double vendas = leia.nextDouble();

            double totalv = (vendas*0.15);
            double total = (salariofx + totalv);

    System.out.println(String.format("TOTAL = R$ %.2f" , total));
        }

    }

    }

 

