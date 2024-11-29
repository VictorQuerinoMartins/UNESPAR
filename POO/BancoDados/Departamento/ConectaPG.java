package BancoDados.Departamento;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;

public class ConectaPG {
    public static void main (String[] args) {
        final String DRIVER = "org.postgresql.Driver";
        final String URL = "jdbc:postgresql://localhost:3306/exemplo";
        final String USER = "root";
        final String PASSWORD = "3310";
        try {
            Class. forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            JOptionPane.showMessageDialog(null, "Conexão realizada com sucesso");
            connection.close();
        }catch (ClassNotFoundException erro) {
            JOptionPane.showMessageDialog(null, "Driver não encontrado!\n"
                    + erro.toString());
        }catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Problemas na conexão com a fonte de dados" + 		erro.toString());
        }
    }
}