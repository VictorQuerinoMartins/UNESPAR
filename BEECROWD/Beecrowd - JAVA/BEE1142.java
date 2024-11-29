import java.util.Scanner;

public class BEE1142 {

	public static void main(String[] args) {
		int N;
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		for (int i = 1; i <= (4*N - 1); i+=4) {
			for (int j = i; j <= i+2; j++) {
				System.out.print(j+" ");
			}
			System.out.println(" PUM\n");
		}
	}
}