import java.io.IOException;
import java.util.Scanner;


public class BEE1038{
    public static void main(String[] args) throws IOException {
      try (Scanner s = new Scanner(System.in)) {
        {
          int cod = s.nextInt();
            int qtd = s.nextInt();
            double total = 0.0;

            if(cod == 1){
           total = qtd * 4.0;

            }else if(cod == 2){
           total = qtd * 4.5;

            }else if(cod == 3){
           total = qtd * 5.0;

            }else if(cod == 4){
           total = qtd * 2;

          }else if(cod == 5){
              total = qtd * 1.5;
            } else {
              System.out.println("Código não encontrado.");
            }

            System.out.printf("Total: R$ %.2f\n",total);
  }
      }
    }
    }

