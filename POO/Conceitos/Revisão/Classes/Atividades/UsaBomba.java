package Revisão.Classes.Atividades;

public class UsaBomba {

    public static void main(String[] args) {
        
        BombaAgua bomba1 = new BombaAgua();

        ligarBombaPorS(bomba1, 5);
    }

    static void ligarBombaPorS(BombaAgua bomba, int segundos) {
       
        BombaA.ligar(bomba, segundos);

     
        if (bomba.status == 1) {
            System.out.println("A bomba ainda está ligada.");
        } else {
            System.out.println("A bomba está desligada.");
        }
       
    }
}