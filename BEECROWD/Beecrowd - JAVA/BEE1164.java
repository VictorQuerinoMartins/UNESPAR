import java.util.Scanner;

public class BEE1164 {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);

        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            double[] valores = new double[3];
            for (int k = 0; k < 3; k++) {
                valores[k] = sc.nextDouble();
            }
            double mediaPonderada = (valores[0] * 2 + valores[1] * 3 + valores[2] * 5) / 10.0;
            System.out.printf("%.1f%n", mediaPonderada);
        }
    }
}