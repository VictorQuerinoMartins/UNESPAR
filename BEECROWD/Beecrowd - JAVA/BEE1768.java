import java.util.Scanner;
import java. util. Arrays;

public class BEE1768{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNextInt()) {
            int N = scanner.nextInt();

            for (int i = N / 2, j = 1; i >= 0; --i, j += 2) {
                char[] line = new char[N];
                Arrays.fill(line, ' ');
                Arrays.fill(line, i, i + j, '*');
                System.out.println(line);
            }

            char[] line = new char[N];
            int i = N / 2;
            Arrays.fill(line, ' ');
            line[i] = '*';
            System.out.println(line);

            i -= 1;
            line = new char[N];
            Arrays.fill(line, ' ');
            Arrays.fill(line, i, i + 3, '*');
            line[i + 3] = '\n';
            System.out.println(line);
        }
    }
}