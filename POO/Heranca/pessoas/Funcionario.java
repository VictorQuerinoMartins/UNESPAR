package pessoas;

public class Funcionario extends Pessoa {
    private Double salario;

    public Funcionario(int codigo, String nome, String telefone, String endereco, Double salario) {
        super(codigo, nome, telefone, endereco);
        this.salario = salario;
    }
}
