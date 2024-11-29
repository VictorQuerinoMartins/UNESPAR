import java.io.IOException;
import java.util.Scanner;

public class BEE1014 {
    public static void main (String[]args)throws IOException{

        Scanner s = new Scanner(System.in);

        Double X = s.nextDouble();
        Double Y = s.nextDouble();
        Double result = (X/Y);

        System.out.println(String.format("%.3f km/l", result));   
    }

    }
    

    
