import java.util.Scanner;

public class BEE1153 {

	public static void main(String[] args) {
		int N, x = 1;
		Scanner s =new Scanner(System.in);
		N = s.nextInt();
		for (int i = 1; i <= N; i++) {
			x *= i;
		}
		System.out.print(x+"\n");

	}

}