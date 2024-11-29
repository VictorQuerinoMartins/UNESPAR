import java.util.Scanner;

public class BEE1113 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int X = s.nextInt();
        int Y = s.nextInt();

        while (X != Y) {
            if (X < Y) {
                System.out.println("Crescente");
            } else {
                System.out.println("Decrescente");
            }
            X = s.nextInt();
            Y = s.nextInt();

        }
    }

}