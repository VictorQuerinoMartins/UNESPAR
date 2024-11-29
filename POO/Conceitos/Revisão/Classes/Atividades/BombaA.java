package Revisão.Classes.Atividades;

class BombaAgua {
    int status;

    BombaAgua() {
        status = 0;
    }
}

public class BombaA {
    static void ligar(BombaAgua bomba, int tempo) {
        bomba.status = 1;
        System.out.printf("Bomba de água ligada por %d segundos.\n", tempo);
        for (int i = tempo; i > 0; i--) {
            System.out.printf("%d segundos restantes para desligar a bomba.\n", i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        bomba.status = 0;
        System.out.println("Bomba de água desligada.");
    }

    public static void main(String[] args) {
        BombaAgua bomba = new BombaAgua();
        ligar(bomba, 10);
    }
}
