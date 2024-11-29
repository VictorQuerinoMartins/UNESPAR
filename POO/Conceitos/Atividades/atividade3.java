package Atividades;


import javax.swing.*;

public class atividade3 {
    public static void main(String[] args) {
        int totalTentativas = 3;
        boolean sucesso = false;

        for (int tentativa = 0; tentativa < totalTentativas; tentativa++) {
            String login = JOptionPane.showInputDialog("Insira o login ");
            String senha = JOptionPane.showInputDialog("Insira a senha ");

            if (login.equals("java8") && senha.equals("java8")) {
                JOptionPane.showMessageDialog(null, "Login e senha aceitos!");
                sucesso = true;
                break;
            } else {
                int tentativasRestantes = totalTentativas - tentativa - 1;
                JOptionPane.showMessageDialog(null, "Falha, verifique o Login e a Senha! Você tem mais " + tentativasRestantes + " tentativas!");
            }
        }

        if (!sucesso) {
            JOptionPane.showMessageDialog(null, "Falha, Tente novamente mais tarde!");
        }
    }
}