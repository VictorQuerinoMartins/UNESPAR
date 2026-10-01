package animais;

public class Mamifero extends Animal {
    private int velocidade;

    public Mamifero() {
        this.classe = "Mamifero";
    }

    public Mamifero(String nome, int velocidade) {
        super(nome);
        this.classe = "Mamifero";
        this.velocidade = velocidade;
    }

    public int getVelocidade() { return velocidade; }
    public void setVelocidade(int velocidade) { this.velocidade = velocidade; }

    public void correr() {
        for (int i = 0; i < velocidade; i++) {
            System.out.print("correndo ");
        }
        System.out.println();
    }
}