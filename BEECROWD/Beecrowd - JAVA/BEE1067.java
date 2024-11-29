import java.io.IOException;
import java.util.Scanner;

public class BEE1067 {	
	
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        for (int i = 1; i <= x; i++) {
        	if (i % 2 != 0) System.out.println(i);          //! -> para not
        }
    }
	
}