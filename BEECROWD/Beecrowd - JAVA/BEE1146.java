import java.util.Scanner;

public class BEE1146 {

    public static void main(String[] args) {

        int X;
        Scanner s = new Scanner(System.in);
        while ((X = s.nextInt()) != 0) {
            for (int i = 1; i <= X; i++) {
                if (i == X) {
                    System.out.print(i + "\n");
                } else {
                    System.out.print(i + " ");
                }

            }
        }
    }

}