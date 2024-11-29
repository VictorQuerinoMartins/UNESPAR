import java.io.IOException;
import java.util.Scanner;


public class BEE1035{
    public static void main(String[] args) throws IOException {
      try ( Scanner leia = new Scanner(System.in)){

        System.out.print("Insira o 1° valor: ");
        int A = leia.nextInt();

        System.out.print("Insira o 2° valor: ");
        int B = leia.nextInt();

        System.out.print("Insira o 3° valor: ");
        int C = leia.nextInt();

        System.out.print("Insira o 4° valor: ");
        int D = leia.nextInt();

    
        if (B>C && D>A && (C+D)>(B+A) && C>0 && D>0 && (A%2 == 0)){
        System.out.print("Valores aceitos");
        }
        
        else {
            System.out.print("Valores nao aceitos");
        }
        
     }
  }        

}