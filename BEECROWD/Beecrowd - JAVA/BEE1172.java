import java.util.Scanner;

public class BEE1172 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] x = new int[10];

        for(int i = 0; i < 10; i++) {
            System.out.println("Digite o valor de X[" + i + "]:");
            x[i] = sc.nextInt();
        }
        for(int i = 0; i < 10; i++) {
            if(x[i] <= 0) {
                x[i] = 1;
            }
        }
        for(int i = 0; i < 10; i++) {
            System.out.println("X[" + i +"] = " + x[i]);
        }
    }
}