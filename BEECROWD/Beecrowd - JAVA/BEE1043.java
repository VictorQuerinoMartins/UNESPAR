import java.io.IOException;
import java.util.Scanner;

public class BEE1043 {
	
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		double A = s.nextDouble();
		double B = s.nextDouble();
		double C = s.nextDouble();

		double maior;
		double soma;
		boolean triangulo;
		
		if (A > B && A > C) maior = A;
		else if (B > C) maior = B;
		else maior = C;

		if (maior == A) soma = B + C;
		else if (maior == B) soma = A + C;
		else soma = B + A;
		
		if (soma > maior) triangulo = true;
		else triangulo = false;
		
		if (triangulo) {
			double perimetro = A + B + C;
			System.out.println(String.format("Perimetro = %.1f", perimetro));
		} else {
			double areaTrapezio = ((A + B) * C) / 2;
			System.out.println(String.format("Area = %.1f", areaTrapezio));
		}
	}
	
}