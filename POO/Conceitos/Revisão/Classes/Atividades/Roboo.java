package Revisão.Classes.Atividades;


interface Controle {
    void andar();
    void virar();
    void falar();
}

class Robo implements Controle {
    public void andar() {
        System.out.println("O robô está andando.");
    }

    public void virar() {
        System.out.println("O robô está virando.");
    }

    public void falar() {
        System.out.println("O robô está falando.");
    }
}

public class Roboo {
    public static void main(String[] args) {
        Controle meuRobo = new Robo();
        meuRobo.andar();
        meuRobo.virar();
        meuRobo.falar();
    }
}
