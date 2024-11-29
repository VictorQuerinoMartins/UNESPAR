package Atividades;
import java.util.Scanner;
class BombaAgua {
    int status;

    BombaAgua() {
        status = 0;
    }
}

public class atividade8 {
    static void ligar(BombaAgua bomba, int tempo) {
        bomba.status = 1;
        System.out.printf("Bomba de agua ligada por %d segundos.\n", tempo);
        for (int i = tempo; i > 0; i--) {
            System.out.printf("%d segundos restantes para desligar a bomba.\n", i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {  
                e.printStackTrace();    //`printStackTrace()` resume detalhadamente onde uma exceção ocorreu, incluindo a classe, método e linha, ajudando na detecção e resolução de problemas no código.
            }
        }
        bomba.status = 0;
        System.out.println("Bomba de agua desligada.");
    }

    public static void main(String[] args) {
        BombaAgua bomba = new BombaAgua();

        int tempo;
        Scanner sc = new Scanner(System.in);

    System.out.println("Insira o tempo desejado para a bomba ficar ligada até desligar: ");
    tempo = sc.nextInt();

        ligar(bomba, tempo);
    }
}
 