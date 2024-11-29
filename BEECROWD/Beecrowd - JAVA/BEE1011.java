import java.util.Scanner;
import java.io.IOException;

public class BEE1011 {

    public static void main(String[] args) throws IOException {
        try (Scanner s = new Scanner(System.in)) {
            Double raio = s.nextDouble();
            Double volume = (4.0 / 3) * 3.14159 * (raio*raio*raio);

            System.out.printf("VOLUME = %.3f", volume);
        }

        return;
    }
    }

 