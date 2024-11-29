package BancoDados;

import BancoDados.Departamento.BD;
import java.sql.*;
public class FilmesDAO {
    public Filmes filme;
    public BD bd;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private String men, sql;
    public static final byte INCLUSAO = 1;
    public static final byte ALTERACAO = 2;
    public static final byte EXCLUSAO =3;

    public FilmesDAO() {
        bd = new BD ();
        filme = new Filmes();
    }

    public boolean localizar() {
        sql = "select * from filmes where codigo = ?";
        try {
            statement = bd.connection.prepareStatement(sql);
            statement.setString(1, filme.getCodigo());
            resultSet = statement.executeQuery();
            resultSet.next();
            filme.setCodigo(resultSet.getString(1));
            filme.setTitulo_pt(resultSet.getString(2));
            filme.setDiretor(resultSet.getString(3));
            filme.setAno(resultSet.getString(4));
            filme.setPais(resultSet.getString(5));
            filme.setTitulo_original(resultSet.getString(6));
            filme.setGenero(resultSet.getString(7));
            filme.setImbd(resultSet.getString(8));
            filme.setProdutora(resultSet.getString(9));
            filme.setDataCompra("" + resultSet.getDate(10));
            return true;
        } catch (SQLException erro) {
            men = "Falha na operação " + erro.toString();
            return false;
        }
    }

    public String atualizar(int operacao) {
        men = "Operação realizada com sucesso!";
        try {
            if (operacao == INCLUSAO) {
                sql = "insert into filmes values (?,?,?,?,?,?,?,?,?,?)"; 								statement = bd.connection.prepareStatement(sql);
                statement.setString(1,filme.getCodigo());
                statement.setString(2,filme.getTitulo_pt());
                statement.setString(3,filme.getDiretor());
                statement.setString(4,filme.getAno());
                statement.setString(5,filme.getPais());
                statement.setString(6,filme.getTitulo_original());
                statement.setString(7,filme.getGenero());
                statement.setString(8,filme.getImbd());
                statement.setString(9,filme.getProdutora());
                statement.setString(10,filme.getDataCompra());


            } else if (operacao == ALTERACAO) {
                sql = "update filmes set titulo_pt = ?, diretor = ?, ano = ?,"
                        + "pais = ?, titulo_original = ?, genero = ?,  "
                        + "imdb = ?, produtora = ?, "
                        + "datacompra = ? where codigo = ?";
                statement = bd.connection.prepareStatement(sql);
                statement.setString(10,filme.getCodigo());
                statement.setString(1, filme.getTitulo_pt());
                statement.setString(2, filme.getDiretor());
                statement.setString(3, filme.getAno());
                statement.setString(4, filme.getPais());
                statement.setString(5, filme.getTitulo_original());
                statement.setString(6, filme.getGenero());
                statement.setString(7, filme.getImbd());
                statement.setString(8, filme.getProdutora());
                statement.setString(9, filme.getDataCompra());

            } else if (operacao == EXCLUSAO) {
                sql = "delete from filmes where codigo = ?";
                statement = bd.connection.prepareStatement(sql);
                statement.setString(1, filme.getCodigo());
            }
            if (statement.executeUpdate() == 0) {
                men = "Falha na operacao!";
            }
        } catch (SQLException erro) {
            men = "Falha na operação " + erro.toString();
        }
        return men;
    }
}