
import java.io.IOException;
import java.util.Scanner;

public class BEE1022 {
    public static void main (String[]agrs)throws IOException{
    Scanner s = new Scanner(System.in);

    Double A = s.nextDouble();
    Double B = s.nextDouble();
    Double C = s.nextDouble();

    if ((A == 0) | (B * B - 4 * A * C < 0)) {
        System.out.println("Impossivel calcular");
        return;
    }

    Double x1 = (-B + (Math. sqrt((B*B) - 4*A*C)))/ (2*A);
    Double x2 = (-B - (Math. sqrt((B*B) - 4*A*C)))/ (2*A);

    System.out.println(String.format("R1 = %.5f", x1));
    System.out.println(String.format("R2 = %.5f", x2));

    }
}



