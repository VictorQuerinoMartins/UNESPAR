import java.util.Scanner;

public class BEE1046 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int inicial = s.nextInt();
        int hrfinal = s.nextInt();

        if (inicial > hrfinal) {
            System.out.println("O JOGO DUROU" + (24 - (inicial - hrfinal)) + "HORA(S)");

        } else if (hrfinal > inicial) {
            System.out.println("O JOGO DUROU " + (hrfinal - inicial) + " HORA(S)");

        } else {
            System.out.println("O JOGO DUROU 24 HORA(S)");
        }

    }

}
