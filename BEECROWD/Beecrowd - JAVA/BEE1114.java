import java.util.Scanner;
public class BEE1114 {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);

        int x = s.nextInt();
        while (x != 2002) {
            System.out.println("Senha Invalida");
            x = s.nextInt();
        }
        System.out.println("Acesso Permitido");
    }

}