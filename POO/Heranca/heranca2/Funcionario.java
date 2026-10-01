package heranca2;

public class Funcionario extends Pessoa{
    protected String matricula;
    protected String dataAdmissao;
    protected double salario;


public Funcionario(){
    super();
}

public Funcionario(String nome, String cpf, String dataNasc, String matricula, String dataAdmissao, double salario) {
        super(nome, cpf, dataNasc);
        this.matricula = matricula;
        this.dataAdmissao = dataAdmissao;
        this.salario = salario;
}

public String getMatricula(){return matricula;}
public void setMatricula(String matricula){this.matricula = matricula;}

public String getDataAdmissao(){return dataAdmissao;}
public void setDataAdmissao(String dataAdmissao){this.dataAdmissao = dataAdmissao;}

public double getsalario(){return salario;}
public void setsalario(double salario){this.salario = salario;}

}

