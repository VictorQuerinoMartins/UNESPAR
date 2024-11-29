import java.util.Scanner;

public class BEE1003 {
 
   
    public static void main(String[] args){
     try (Scanner som = new Scanner(System.in)) {

        System.out.print("Informe o valor de A:");
        int A = som.nextInt();
        
        System.out.print("Informe o valor de B:");
        int B = som.nextInt();
        
        int X = A + B;
        System.out.println ("SOMA = " + X);
    }
 
 
    }
 
}