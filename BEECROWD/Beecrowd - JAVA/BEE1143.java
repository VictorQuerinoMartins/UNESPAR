import java.util.Scanner;

public class BEE1143 {

    public static void main(String[] args) {
        int N;
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        for (int i = 1; i <= N; i++) {
            for (int j = i, k = (j * i), l = (k * j); j == i; j++) {
                System.out.print(j + " " + k + " " + l + "\n");
            }
        }

    }

}