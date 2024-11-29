import java.util.Scanner;

public class BEE1149 {

	public static void main(String[] args) {
		int A, N,total = 0;
		Scanner s =new Scanner(System.in);
		A = s.nextInt();
		N =s.nextInt();
		for (int i = A,totalNumber = 0; totalNumber < N; i++) {
			total += i;
			totalNumber += 1;
		}
		System.out.print(total+"\n");
	}

}