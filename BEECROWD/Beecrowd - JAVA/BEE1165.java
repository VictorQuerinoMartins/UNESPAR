import java.util.Scanner;

public class BEE1165 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        if(N >= 1 && N <= 100) {
           for(int i = 0; i < N; i++) {
               int x = sc.nextInt();
               if(x > 1 && x <= 10000000) {
                   if(x % 1 == 0 && x % x == 1) {
                       System.out.printf("%.2 é primo", x);

                   }
               }
           }
        }


    }
}