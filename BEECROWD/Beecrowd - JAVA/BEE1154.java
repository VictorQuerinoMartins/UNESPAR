import java.util.Scanner;

public class BEE1154 {
	
	public static void main(String[] args) {
		int idade;
		int totalnu = 0,totalidade = 0;
		float ageAverage;
		Scanner s =new Scanner(System.in);
		int i =1;
		while (((idade = s.nextInt()) >= 0)) {
			totalidade += idade;
			totalnu += i;
		}
		ageAverage = (float)((float)totalidade / (totalnu));
		System.out.printf("%.2f\n",ageAverage);
	}

}