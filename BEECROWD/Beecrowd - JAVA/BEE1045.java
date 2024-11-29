import java.io.IOException;
import java.util.Scanner;

public class BEE1045 {
	
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		double A = s.nextDouble();
		double B = s.nextDouble();
		double C = s.nextDouble();
		double ajd;
		
		if (B > A && B > C) {
			ajd = A;
			A = B;
			B = ajd;
		} else if (C > A) {
			ajd = A;
			A = C;
			C = ajd;
		}		
		if (A >= (B + C)) { 
			System.out.println("NAO FORMA TRIANGULO");
		} else {
			if (A*A == (B*B) + (C*C)) System.out.println("TRIANGULO RETANGULO");
			if (A*A > (B*B) + (C*C)) System.out.println("TRIANGULO OBTUSANGULO");
			if (A*A < (B*B) + (C*C)) System.out.println("TRIANGULO ACUTANGULO");
			if (A == B && A == C) System.out.println("TRIANGULO EQUILATERO");
			if ((A == B && A != C) || (A == C && A != B) || (B == C && B != A)) System.out.println("TRIANGULO ISOSCELES");
		}
	}
	
}