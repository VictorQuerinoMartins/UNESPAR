import java.io.IOException;
import java.util.Scanner;

public class BEE1017 {
    public static void main (String[]agrs) throws IOException{
        Scanner s = new Scanner(System.in);
        int tempo = s.nextInt();
        int velocidade = s.nextInt();

        double km = tempo*velocidade;
        double media = km/12;
        System.out.println(String.format("%.3f",media));

        

    }
}
