package BancoDados.Departamento;

import java.sql.*;
import javax. swing. *;
public class Conecta {
    public static void main (String[] args) {
        final String DRIVER = "com.mysql.jdbc.Driver";
        final String URL = "jdbc:mysql://localhost:3306/mysql?useTimezone=true&serverTimezone=UTC";
        try {
            Class. forName(DRIVER);
            try (Connection connection = DriverManager.getConnection(URL, "root", "3310")) {
                JOptionPane.showMessageDialog(null, "Conexão realizada com sucesso");
            }
        }catch (ClassNotFoundException erro) {
            JOptionPane.showMessageDialog(null, "Driver não encontrado!\n"
                    + erro.toString());
        }catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Problemas na conexão com a fonte de dados" + erro.toString());
        }
    }
}