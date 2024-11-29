package Revisão.exemplos;
import javax.swing.JOptionPane;

public class If {

    public static void main(String[] args) {

        Object[] op = { "Masculino", "Feminino" };
        String resp = (String) JOptionPane.showInputDialog(null, "Selecione o sexo:\n", "Pesquisa",
                JOptionPane.PLAIN_MESSAGE, null, op, "Masculino");

        if (resp == null) {

            JOptionPane.showMessageDialog(null, "Você pressionou Cancel");

        }

        if (resp == "Masculino") {

            JOptionPane.showMessageDialog(null, "Você é homem.");

        }

        if (resp == "Feminino") {

            JOptionPane.showMessageDialog(null, "Você é mulher.");

        }

        System.exit(0);
    }
}