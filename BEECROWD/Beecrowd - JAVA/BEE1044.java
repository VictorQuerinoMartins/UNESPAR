import java.util.Scanner;
import java.io.IOException;

public class BEE1044 {
    public static void main (String[]agrs)throws IOException{
        Scanner s = new Scanner(System.in);
    
      int A = s.nextInt();
      int B = s.nextInt();
     
      if(A%B == 0 || B%A == 0){
      System.out.printf("Sao multiplos");
     
      }else{
        System.out.printf("Nao sao multiplos");
      }
    }
  }
