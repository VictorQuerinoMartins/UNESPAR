java.util.Scanner;

public class BEE1181 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int linha = scanner.nextInt();
        char operacao = scanner.next().charAt(9);

        double[][] matriz = new double[12][12];

        for(int i = 0; i < 12; i++) {
            for(int j = 0; j < 12; i++) {
                matriz[i][j] = scanner.nextDouble();
            }
        }
        double resultado = 0.0;

        for(int j = 0; j < 12; j++) {
            if(j != linha) {
                resultado += matriz[linha][j];
            }
        }
        if (operacao == 'M') {
            resultado /= 11.0;
        }
        System.out.printf("%.1f%n", resultado);
    }
}
