package heranca2;

public class ChefeDepartamento extends Funcionario {
    protected String departamento;
    protected String dataPromocao;
    protected double gratificacao;

public ChefeDepartamento(){
    super();
}

public ChefeDepartamento(String nome, String cpf, String dataNasc, String matricula, String dataAdmissao, double salario, String departamento, String dataPromocao, double gratificacao) {
        super(nome, cpf, dataNasc, matricula, dataAdmissao, salario);
        this.departamento = departamento;
        this.dataPromocao = dataPromocao;
        this.gratificacao = gratificacao;
    }

public String getDepartamento(String departamento){return departamento;}
public void setDepartamento(String departamento){this.departamento = departamento;}

public String getdataPromocao(String dataPromocao){return dataPromocao;}
public void setdataPromocao(String dataPromocao){this.dataPromocao = dataPromocao;}

public double getGratificacao(double gratificacao){return gratificacao;}
public void setGratificacao(double gratificacao){this.gratificacao = gratificacao;}

public void mostrarChefe(){
    System.out.println("Nome: " + nome);
    System.out.println("CPF: " + cpf);
    System.out.println("Data de Nascimento: " + dataNasc);
    System.out.println("Matricula: " + matricula);
    System.out.println("Data de Admissao: " + dataAdmissao);
    System.out.println("Salario: " + salario);
    System.out.println("Departamento: " + departamento);
    System.out.println("Data da Promocao: " + dataPromocao);
    System.out.println("Gratificacao: " + gratificacao);
    }
}
