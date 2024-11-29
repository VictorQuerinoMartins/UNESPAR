import java.io.IOException;
import java.util.Scanner;

public class BEE1145 {

	public static void main(String[] args)  throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int x, y, auxx=0, auxy; 
		
		x = sc.nextInt();
		y = sc.nextInt();

		if (x > y){
			int z = x;
			x = y;
			y = z;
		}
		
		for (auxy = 1; auxy <= y; auxy++){
			System.out.printf("%d ",auxy);
			auxx++;
			if (auxx == (x-1)){
				auxx = 0;
				auxy++;
				System.out.printf("%d\n",auxy);
			}
		}
    }
}