import java.util.Scanner;

public class BEE1174 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] A = new double[100];

        for (int i = 0; i < 100; i++) {
            A[i] = scanner.nextDouble();
        }
        for (int i = 0; i < 100; i++) {
            if (A[i] <= 10.0) {
                System.out.printf("A[%d] = %.1f%n", i, A[i]);
            }
        }
    }
}