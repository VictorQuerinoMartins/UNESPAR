package heranca2;

public class Aluno extends Pessoa{
    protected String matricula;


public Aluno(){
    super();
}

public Aluno(String nome, String cpf, String dataNasc, String matricula){
    super(nome, cpf, dataNasc);
    this.matricula = matricula;
}

public String getMatricula (String matricula){return matricula;}
public void setMatricula (String matricula){this.matricula = matricula;}

public void mostrarAluno(){
    System.out.println("Nome: " + nome);
    System.out.println("CPF: " + cpf);
    System.out.println("Data de Nascimento: " + dataNasc);
    System.out.println("Matricula: " + matricula);
}

}