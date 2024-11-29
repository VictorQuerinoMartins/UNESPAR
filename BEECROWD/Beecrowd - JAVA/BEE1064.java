import java.io.IOException;
import java.util.Scanner;

public class BEE1064 {
	
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int ps = 0;
        double media = 0;
    
        
        for (int y = 0; y < 6; y++) {
        	double x = s.nextDouble();
           

        	if (x > 0) {
            ps++;
        		media += x;
            }
                media = media / ps;
        System.out.println(ps + " valores positivos");
        System.out.println(String.format("%.1f", media));
        	}
        }
    }
