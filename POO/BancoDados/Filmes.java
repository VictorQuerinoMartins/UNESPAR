package BancoDados;

public class Filmes {
    private String codigo, titulo_pt, diretor, ano, pais, titulo_original, genero, imbd, produtora, dataCompra;
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getDiretor() {
        return diretor;
    }
    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
    public String getAno() {
        return ano;
    }
    public void setAno(String ano) {
        this.ano = ano;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTitulo_original() {
        return titulo_original;
    }
    public void setTitulo_original(String titulo_original) {
        this.titulo_original = titulo_original;
    }
    public String getImbd() {
        return imbd;
    }
    public void setImbd(String imbd) {
        this.imbd = imbd;
    }

    public String getDataCompra() {
        return dataCompra;
    }
    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getProdutora() {
        return produtora;
    }
    public void setProdutora(String produtora) {
        this.produtora = produtora;
    }
    public String getTitulo_pt() {
        return titulo_pt;
    }
    public void setTitulo_pt(String titulo) {
        this.titulo_pt = titulo;
    }
}