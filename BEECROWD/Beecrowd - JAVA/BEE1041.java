import java.util.Scanner;
import java.io.IOException;

public class BEE1041 {
    public static void main (String[]agrs)throws IOException{
        Scanner s = new Scanner(System.in);
    
        Double x = s.nextDouble();
        Double y = s.nextDouble();

        if(x==0 && y==0){
            System.out.println("Origem");
        }else if (x == 0) {
            System.out.println("Eixo Y");
        } else if (y == 0) {
            System.out.println("Eixo X");
        } else if (y > 0 && x > 0) {
            System.out.println("Q1");
        } else if (y > 0 && x < 0) {
            System.out.println("Q2");
        } else if (y < 0 && x < 0) {
            System.out.println("Q3");
        } else if (y < 0 && x > 0) {
            System.out.println("Q4");
        }
    }
}
