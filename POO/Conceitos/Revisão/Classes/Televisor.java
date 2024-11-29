package Revisão.Classes;

public class Televisor {
    private int volume;
    private int canal;
    
    public Televisor() {
    }

    public Televisor(int volume) {
        this.volume = volume;
    }

    public Televisor(int volume, int canal) {
        this.volume = volume;
        this.canal = canal;
    }

    public void mostrar() {
        System.out.println("Volume: " + volume + "\nCanal: " + canal);
    }
}
