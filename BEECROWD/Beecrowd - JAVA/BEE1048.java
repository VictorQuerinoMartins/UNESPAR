import java.io.IOException;
import java.util.Scanner;

public class BEE1048 {
    public static void main(String[] args) throws IOException {
        Scanner s= new Scanner(System.in);

        double salario;
        int porcentagem;

        salario = s.nextDouble();
        if (salario >= 0.00 && salario <= 400.00) {
            porcentagem = 15;
            System.out.println(salario*0.15 + salario);
            System.out.println("Reajuste ganho: " + (salario*0.15));
            System.out.println("Em percentual: "+ porcentagem + " %");


        }else if (salario >= 400.01 && salario <= 800.00) {
            porcentagem = 12;
            System.out.println(salario*0.12 + salario);
            System.out.println("Reajuste ganho: " + (salario*0.12));
            System.out.println("Em percentual: "+ porcentagem + " %");


        }else if (salario >= 800.01 && salario <= 1200.00) {
            porcentagem = 10;
            System.out.println(salario*0.10 + salario);
            System.out.println("Reajuste ganho: " + (salario*0.10 - salario));
            System.out.println("Em percentual: "+ porcentagem + " %");


        }else if (salario >= 1200.01 && salario <= 2000.00) {
            porcentagem = 7;
            System.out.println(salario*0.07 + salario);
            System.out.println("Reajuste ganho: " + (salario*0.07));
            System.out.println("Em percentual: "+ porcentagem + " %");


        }else if (salario > 2000.00) {
            porcentagem = 4;
            System.out.println(salario*0.04 + salario);
            System.out.println("Reajuste ganho: " + (salario*0.04 ));
            System.out.println("Em percentual: "+ porcentagem + " %");


        }
    }  
 }
