import java.util.Scanner;

public class BEE1159 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x, soma;

        while (true) {
            x = sc.nextInt();
            if ( x == 0) {
                break;
            }
            if(x % 2 == 1) {
                x++;
            }
            soma = 0;
            for(int i = 0; i < 5; i++) {
                soma += x;
                x += 2;
            }
            System.out.println(soma);
        }
    }
}
