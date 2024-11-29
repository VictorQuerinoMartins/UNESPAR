import java.util.Scanner;

public class BEE1173 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] x = new int[10];
        int y = sc.nextInt();

        x[0] = y;

        for(int i = 1; i < 10; i++) {
            x[i] = 2 * x[i -1];
        }
        for(int i =0; i < 10; i++) {
            System.out.println("N[" + i + "] = " + x[i]);
        }
    }
}