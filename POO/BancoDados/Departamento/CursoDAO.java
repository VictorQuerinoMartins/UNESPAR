package BancoDados.Departamento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    public void adicionarCurso(Curso curso) throws SQLException {
        String sql = "INSERT INTO cursos (id_curso, nome, carga_horaria, tipo, modalidade, depto_codigo) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = BD.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, curso.getIdCurso());
            stmt.setString(2, curso.getNome());
            stmt.setInt(3, curso.getCargaHoraria());
            stmt.setString(4, curso.getTipo());
            stmt.setString(5, curso.getModalidade());
            stmt.setString(6, curso.getDeptoCodigo());
            stmt.executeUpdate();
        }
    }

    public List<Curso> listarCursos() throws SQLException {
        List<Curso> cursos = new ArrayList<>();
        String sql = "SELECT * FROM cursos";
        try (Connection conn = BD.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Curso curso = new Curso(
                        rs.getString("id_curso"),
                        rs.getString("nome"),
                        rs.getInt("carga_horaria"),
                        rs.getString("tipo"),
                        rs.getString("modalidade"),
                        rs.getString("depto_codigo")
                );
                cursos.add(curso);
            }
        }
        return cursos;
    }
    
    // Outros métodos para atualizar, deletar e buscar cursos.
}
