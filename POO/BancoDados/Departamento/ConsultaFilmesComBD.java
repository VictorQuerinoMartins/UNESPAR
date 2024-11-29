package BancoDados.Departamento;

import java.sql.*;
public class ConsultaFilmesComBD {
    public static void main (String[] args) {
        BD bd = new BD () ;
        if (bd.getConnection() ) { // Conexão OK
            try {
                String sql = "SELECT codigo, titulo_pt FROM filmes WHERE codigo > ? AND codigo < ? ORDER BY codigo";
                PreparedStatement statement = bd.connection.prepareStatement(sql);
                statement.setString(1, "800");
                statement.setString(2, "840");
                ResultSet resultSet  = statement.executeQuery();
                System.out.println("CÓDIGO      TÍTULO");
                System.out.println("______     ________________________________________________");
                while (resultSet.next()) {
                    String codigo = resultSet.getString("codigo");
                    String titulo = resultSet.getString("titulo_pt");
                    System.out.println(codigo + "	" + titulo);
                }
                resultSet.close();
                statement.close();
                bd.close();
            } catch (SQLException erro) {
                System.out.println(erro.toString());
            }
        } else {
            System.out.println("Erro ao conectar!");
        }
    }
}