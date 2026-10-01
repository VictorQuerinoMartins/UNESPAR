package animais;

public class Animal {
    private String nome;
    protected String classe;

    public Animal() {}

    public Animal(String nome) {
        this.nome = nome;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public void imprime() {
        System.out.println("Nome: " + nome + " | Classe: " + classe);
    }

    public String falar() {
        return "";
    }
}