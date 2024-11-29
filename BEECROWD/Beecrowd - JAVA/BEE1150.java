import java.io.IOException;
import java.util.Scanner;

public class BEE1150 {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int X = s.nextInt();
        int Z = s.nextInt();
        int cont = 0;
        int soma = 0;
        while (Z <= X) {
            Z = s.nextInt();
        }
        while (soma < Z) {
            soma += X;
            cont++;
            X++;
        }
        System.out.println(cont);
    }

}