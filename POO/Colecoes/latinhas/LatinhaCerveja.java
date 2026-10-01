public class LatinhaCerveja {

    private int id;
    private String marca;
    private int conteudoMl;
    private String fabricacao;
    private String validade;

    public LatinhaCerveja(int id, String marca, int conteudoMl, String fabricacao, String validade) {
        this.id = id;
        this.marca = marca;
        this.conteudoMl = conteudoMl;
        this.fabricacao = fabricacao;
        this.validade = validade;
    }

    public int getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public int getConteudoMl() {
        return conteudoMl;
    }

    public String getFabricacao() {
        return fabricacao;
    }

    public String getValidade() {
        return validade;
    }

    @Override
    public String toString() {
        return "Latinha{id=" + id + ", marca=" + marca + ", conteudo=" + conteudoMl
                + "ml, fabricacao=" + fabricacao + ", validade=" + validade + "}";
    }
}
