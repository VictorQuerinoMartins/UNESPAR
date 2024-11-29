import java.io.IOException;
import java.util.Scanner;

public class BEE1047 {
	
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        
		int hi = s.nextInt();
		int mi = s.nextInt();
		int hf = s.nextInt();
		int mf = s.nextInt();

		int mt1 = (hi*60)+mi;
		int mt2 = (hf*60)+mf;
		int h24 = (24*60);
        int resultado = 0;
		
		if (mt2>mt1 ) {
			resultado = mt2-mt1;
            System.out.printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)\n",(resultado/60), (resultado%60));
        }else if(mt1>mt2){
            resultado = (h24-mt1)+(mt2);
            System.out.printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)\n",(resultado/60), (resultado%60));
        }else if(mt2==mt1){
            System.out.printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)\n",24, 0);
        }
       
    }
}