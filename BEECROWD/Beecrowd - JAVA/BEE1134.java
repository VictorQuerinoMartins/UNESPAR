import java.util.Scanner;


public class BEE1134 {

	public static void main(String[] args) {
		int X = 0, cheio = 0, alcool = 0, gasolina = 0, disel = 0;
		Scanner s = new Scanner(System.in);
		
		
		
		while (X != 4) {
			X = s.nextInt();
			if (X == 1) {
				alcool+=1;
			}else if (X == 2) {
				gasolina += 1;
			}else if (X == 3) {
				disel += 1;
			}
			
		}
		
		System.out.print("MUITO OBRIGADO\n");
		System.out.print("Alcool: "+alcool+"\n");
		System.out.print("Gasolina: "+gasolina+"\n");
		System.out.print("Diesel: "+disel+"\n");
		

	}
}