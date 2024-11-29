import java.util.Scanner;

public class BEE1115 {

    public static void main(String[] args) {
        int quadra1, quadra2;
        Scanner s = new Scanner(System.in);
        while (((quadra1 =s.nextInt()) != 0) && ((quadra2 =s.nextInt()) != 0)) {

            if (quadra1 > 0 && quadra2 > 0) {
                System.out.print("primeiro\n");

            } else if (quadra1 > 0 && quadra2 < 0) {
                System.out.print("quarto\n");

            } else if (quadra1 < 0 && quadra2 < 0) {
                System.out.print("terceiro\n");

            } else if (quadra1 < 0 && quadra2 > 0) {
                System.out.print("segundo\n");
            }
        }

    }

}