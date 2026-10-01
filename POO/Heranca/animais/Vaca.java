package animais;

public class Vaca extends Mamifero {
    private boolean permiteOrdenha;

    public Vaca() { super(); }
    public Vaca(String nome, int velocidade, boolean permiteOrdenha) {
        super(nome, velocidade);
        this.permiteOrdenha = permiteOrdenha;
    }

    public void setPermiteOrdenha(boolean permiteOrdenha) {
        this.permiteOrdenha = permiteOrdenha;
    }

    @Override
    public String falar() {
        return "Muuuu";
    }

    public String ordenhar() {
        if (permiteOrdenha) {
            return "ordenhando";
        }
        return "não permite ordenha";
    }
}