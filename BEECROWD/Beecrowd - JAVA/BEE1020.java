import java.io.IOException;
import java.util.Scanner;
public class BEE1020 {
    public static void main (String[]agrs)throws IOException{
    Scanner s = new Scanner(System.in);

    int idade  = s.nextInt();

    int Anos = idade / 365;
    idade -= Anos*365;

    int meses = idade / 30;
    idade -= meses*30;

    int dias = idade;

    System.out.println(Anos + " ano(s)");
        System.out.println(meses + " mes(es)");
        System.out.println(dias + " dia(s)");
    }


    }
