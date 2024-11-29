package BancoDados.Departamento;

public class Disciplina {
    private String idDisciplina;
    private String idCurso;  // Chave estrangeira (Curso)
    private String nome;
    private int cargaHoraria;
    private String areaMateria;

    // Construtor
    public Disciplina(String idDisciplina, String idCurso, String nome, int cargaHoraria, String areaMateria) {
        this.idDisciplina = idDisciplina;
        this.idCurso = idCurso;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.areaMateria = areaMateria;
    }

    // Getters e Setters
    public String getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(String idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

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

    public String getAreaMateria() {
        return areaMateria;
    }

    public void setAreaMateria(String areaMateria) {
        this.areaMateria = areaMateria;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
               "ID='" + idDisciplina + '\'' +
               ", CursoID='" + idCurso + '\'' +
               ", Nome='" + nome + '\'' +
               ", Carga Horaria=" + cargaHoraria +
               ", Area Materia='" + areaMateria + '\'' +
               '}';
    }
}
