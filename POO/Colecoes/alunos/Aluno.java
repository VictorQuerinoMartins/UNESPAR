public class Aluno {

    private int codigo;
    private String nome;
    private String telefone;
    private String endereco;

    public Aluno(int codigo, String nome, String telefone, String endereco) {
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void imprimeDados() {
        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Telefone: " + telefone);
        System.out.println("Endereço: " + endereco);
        System.out.println("-----------------------------");
    }
}
