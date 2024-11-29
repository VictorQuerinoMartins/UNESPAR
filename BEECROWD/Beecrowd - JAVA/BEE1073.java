import java.io.IOException;
import java.util.Scanner;

public class BEE1073 {
	
	public static void main(String[] args) throws IOException {
    	Scanner s = new Scanner(System.in);

    	int N = s.nextInt();

    	for (int x= 1; x <= N; x++) {

    		if (x% 2 == 0) 
            System.out.println(x+ "^2 = " + (x * x));
    	}
	}
	
}