import java.util.Scanner;

public class BEE1079 {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        for (int i = 0; i < N; i++) {
            double n1 = s.nextDouble();
            double n2 = s.nextDouble();
            double n3 = s.nextDouble();
            double media = ((n1 * 2) + (n2 * 3) + (n3 * 5)) / 10;
            System.out.println(String.format("%.1f", media));
        }
    }
}