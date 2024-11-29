import java.util.Scanner;

public class BEE1180 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] X = new int[N];

        for(int i = 0; i < N; i++) {
            X[i] = scanner.nextInt();
        }
        int menorValor = X[0];
        int posicao = 0;

        for(int i = 1; i < N; i++) {
            if(X[i] < menorValor) {
                menorValor = X[i];
                posicao = i;
            }
        }
        System.out.println("Menor valor: " + menorValor);
        System.out.println("Posicao: " + posicao);
    }
}