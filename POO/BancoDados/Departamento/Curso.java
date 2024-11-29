package BancoDados.Departamento;

public class Curso {
    private String idCurso;
    private String nome;
    private int cargaHoraria;
    private String tipo;
    private String modalidade;
    private String deptoCodigo;  // Chave estrangeira (Departamento)

    // Construtor
    public Curso(String idCurso, String nome, int cargaHoraria, String tipo, String modalidade, String deptoCodigo) {
        this.idCurso = idCurso;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.tipo = tipo;
        this.modalidade = modalidade;
        this.deptoCodigo = deptoCodigo;
    }

    // Getters e Setters
    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getDeptoCodigo() {
        return deptoCodigo;
    }

    public void setDeptoCodigo(String deptoCodigo) {
        this.deptoCodigo = deptoCodigo;
    }

    @Override
    public String toString() {
        return "Curso{" +
               "ID='" + idCurso + '\'' +
               ", Nome='" + nome + '\'' +
               ", Carga Horaria=" + cargaHoraria +
               ", Tipo='" + tipo + '\'' +
               ", Modalidade='" + modalidade + '\'' +
               ", DeptoCodigo='" + deptoCodigo + '\'' +
               '}';
    }
}
