package Revisão.Treino.Aluno;

public class AlunoTeste {
    public static void main(String [] args){
        Aluno aluno1 = new Aluno();

        aluno1.nome = "Victor Wenber";
        aluno1.curso = "Ciencias da computacao";     
        aluno1.idade = 19;

        // chamando metodos(acoes)

        aluno1.assistirAula();
        aluno1.fazerProva();
        aluno1.calcularNota();
    
    }
}
