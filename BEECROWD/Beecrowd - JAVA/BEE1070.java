import java.io.IOException;
import java.util.Scanner;

public class BEE1070 {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        int x = s.nextInt();

        int y = 0;
        while (y < 6) {
            if (x % 2 == 1) {
                System.out.println(x);
                y++;
            }
            x++;
        }
    }

}