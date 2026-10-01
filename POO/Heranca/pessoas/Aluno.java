package pessoas;

public class Aluno extends Pessoa {
    private int numMatricula;
    protected Double media;
    protected int faltas;

    public Aluno(int codigo, String nome, String telefone, String endereco,
                 int numMatricula, Double media, int faltas) {
        super(codigo, nome, telefone, endereco);
        this.numMatricula = numMatricula;
        this.media = media;
        this.faltas = faltas;
    }
}
