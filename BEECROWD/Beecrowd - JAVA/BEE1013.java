import java.io.IOException;
import java.util.Scanner;

public class BEE1013 {
	
    public static void main(String[] args) throws IOException {
        Scanner leia = new Scanner(System.in);
        int A = leia.nextInt();
        int B = leia.nextInt();
        int C = leia.nextInt();
        if (A > B && A > C) {
        	System.out.println(A + " eh o maior");
        } else if (B > C) {
        	System.out.println(B + " eh o maior");
        } else {
        	System.out.println(C + " eh o maior");
        }
    }
	
}