import java.io.IOException;
import java.util.Scanner;

public class BEE1060 {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int ps = 0;

        for (int x = 0; x < 6; x++) {
            double n = s.nextDouble();
            if (n > 0)
                ps++;
        }
        System.out.println(ps + " valores positivos");
    }

}