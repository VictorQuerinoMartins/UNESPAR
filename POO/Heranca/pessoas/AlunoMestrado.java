package pessoas;

public class AlunoMestrado extends Aluno {
    private Double conceitoDissertacao;
    private Double notaDissertacao;

    public AlunoMestrado(int codigo, String nome, String telefone, String endereco,
                          int numMatricula, Double media, int faltas,
                          Double conceitoDissertacao, Double notaDissertacao) {
        super(codigo, nome, telefone, endereco, numMatricula, media, faltas);
        this.conceitoDissertacao = conceitoDissertacao;
        this.notaDissertacao = notaDissertacao;
    }

    @Override
    public void imprimeDados() {
        super.imprimeDados();
        System.out.println("Média: " + media);
        System.out.println("Faltas: " + faltas);
        System.out.println("Nota da dissertação: " + notaDissertacao);
        System.out.println("Conceito da dissertação: " + conceitoDissertacao);
    }

    public Boolean aprovado() {
        return media >= 7 && faltas <= 10 && notaDissertacao >= 6;
    }
}
