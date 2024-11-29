import java.io.IOException;
import java.util.Scanner;
public class BEE1019 {
    public static void main (String[]agrs)throws IOException{
    Scanner s = new Scanner(System.in);

        int tempo = s.nextInt();

        int horas = tempo / 3600;
        tempo -= horas * 3600;
        int minutos = tempo / 60;
        tempo -= minutos * 60;
        int segundos = tempo;
        System.out.println(horas + ":" + minutos + ":" + segundos);

    }
}
