import java.io.IOException;
import java.util.Scanner;

public class BEE1004{

	public static void main(String[] args) throws IOException {
        try (Scanner leitor = new Scanner(System.in)) {
            int a = leitor.nextInt();
            int b = leitor.nextInt();
            System.out.println("PROD = " + (a*b) );
        }
    }
	
}