import java.util.Scanner;
import java.io.IOException;

public class BEE1042 {
    public static void main (String[]agrs)throws IOException{
        Scanner s = new Scanner(System.in);
    
      int A = s.nextInt();
      int B = s.nextInt();
      int C = s.nextInt();

      if (A < B && A < C) {
        System.out.println(A);
        if (B < C) {
            System.out.println(B);
            System.out.println(C);
        } else {
            System.out.println(C);
            System.out.println(B);
        }
    } else if (B < C) {
        System.out.println(B);
        if (A < C) {
            System.out.println(A);
            System.out.println(C);
        } else {
            System.out.println(C);
            System.out.println(A);
        }
    } else {
        System.out.println(C);
        if (A < B) {
            System.out.println(A);
            System.out.println(B);
        } else {
            System.out.println(B);
            System.out.println(A);
        }
    }
    
    System.out.println("");
    System.out.println(A);
    System.out.println(B);
    System.out.println(C);
}

}
    
