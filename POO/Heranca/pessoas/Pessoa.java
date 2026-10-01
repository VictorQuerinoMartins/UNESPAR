package pessoas;

public abstract class Pessoa {
    private int codigo;
    protected String nome;
    private String telefone;
    public String endereco;

    public Pessoa(int codigo, String nome, String telefone, String endereco) {
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public void imprimeDados() {
        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Telefone: " + telefone);
        System.out.println("Endereço: " + endereco);
    }
}
