import java.util.Scanner;
import java.io.IOException;

    public class BEE1040 {
        
        public static void main(String[] args) throws IOException {
           try(Scanner s = new Scanner(System.in)){

            
            float N1 = s.nextFloat();
            float N2 = s.nextFloat();
            float N3 = s.nextFloat();
            float N4 = s.nextFloat();
            

            float media = ((2*N1) + (3*N2) + (4*N3) + (1*N4))/10;

            if(media >= 7.0){
                System.out.printf("MEDIA = %.1f\n", media);
                System.out.println("Aluno aprovado.");
            }
            if (media >= 7) {
                System.out.println("Aluno aprovado.");
            } else if (media < 7 && media >= 5) {
                System.out.println("Aluno em exame.");
                double exame = s.nextDouble();
                System.out.println("Nota do exame: " + (exame));
                media = (float) ((media + exame) / 2);
                if (media >= 5) {
                    System.out.println("Aluno aprovado.");
                } else {
                    System.out.println("Aluno reprovado.");
                }
                System.out.println("media final: " + (media));
            } else {
                System.out.println("Aluno reprovado.");
            }
        }
        
    }
}