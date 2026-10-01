package heranca2;

public class Pessoa {
    protected String nome;
    protected String cpf;
    protected String dataNasc;

public Pessoa(){}

public Pessoa(String nome, String cpf, String dataNasc){
    this.nome = nome;
    this.cpf = cpf;
    this.dataNasc = dataNasc;
}

public String getNome(){return nome;}
public void setNome(String nome){this.nome = nome;}

public String getcpf(){return cpf;}
public void setcpf(String cpf){this.cpf = cpf;}

public String getdataNasc(){return dataNasc;}
public void setdataNasc(String dataNasc){this.dataNasc = dataNasc;}
}



