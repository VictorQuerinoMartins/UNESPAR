import java.util.Scanner;

public class BEE1175 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] N = new int[20];

        for(int i = 0; i < 20; i++) {
            N[i] = scanner.nextInt();
        }
        for(int i = 0; i < 10; i++) {
            int temp = N[i];
            N[i] = N[19 - i];
            N[19 - i] = temp;
        }
        for(int i = 0; i < 20; i++) {
            System.out.println("N[" + i + "] = " + N[i]);
        }

    }
}