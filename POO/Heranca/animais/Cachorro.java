package animais;

public class Cachorro extends Mamifero {
    private boolean tipoLatido; // true: alto, false: baixo

    public Cachorro() { super(); }
    public Cachorro(String nome, int velocidade) { super(nome, velocidade); }

    public void setLateAlto() { this.tipoLatido = true; }
    public void setLateBaixo() { this.tipoLatido = false; }

    @Override
    public String falar() {
        return tipoLatido ? "AU, AU" : "au, au";
    }
}