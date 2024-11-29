import java.util.Scanner;

public class BEE1118 {

    public static void main(String[] args) {
        int valid = 0, X = 0;
        float score1, total = 0, x;
        Scanner s = new Scanner(System.in);
        while (X != 2) {

            while (valid != 2) {
                score1 = s.nextFloat();
                if (score1 >= 0.0 && score1 <= 10.0) {
                    total += score1;
                    valid += 1;

                } else {
                    System.out.print("Nota invalida\n");
                }
                x = (float) total / 2;

                System.out.printf("media = %.2f\n", x);

            } 

            X = s.nextInt();
            if (X == 1) {
                System.out.println("novo calculo (1-sim 2-nao)\n");
            }

        }

    }

}