import java.util.Scanner;

public class BEE1177 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        int[] N = new int[1000];

        for(int i = 0; i < 1000; i++) {
            N[i] = i % t;
        }
        for(int i = 0; i < 1000; i++) {
            System.out.println("N[" + i + "] = " + N[i]);
        }
        scanner.close();
    }
}