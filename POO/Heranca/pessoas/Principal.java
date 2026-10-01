package pessoas;

public class Principal {
    public static void main(String[] args) {
        AlunoMestrado aluno = new AlunoMestrado(
                1, "Victor Querino", "(41) 99999-0000", "Rua das Flores, 123",
                20261234, 8.5, 3, 9.0, 7.5);

        aluno.imprimeDados();
        System.out.println("Aprovado: " + aluno.aprovado());
    }
}
