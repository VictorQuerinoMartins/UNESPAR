
package Revisão.exemplos;

import javax.swing.*;

public class estudo {
    public static void main(String[] args) {
        int Ttentativas = 3;
        boolean sucesso = false;

        for (int tentativas = 0; tentativas < Ttentativas; tentativas++) {
            String login = JOptionPane.showInputDialog("Insira o login: ");

            // Usando JPasswordField para entrada da senha
            JPasswordField mascara = new JPasswordField();
            int opcao = JOptionPane.showConfirmDialog(null, mascara, "Insira a senha: ", JOptionPane.OK_CANCEL_OPTION);

            // Se o usuário clicar em "OK", obter a senha
            if (opcao == JOptionPane.OK_OPTION) {
                String senha = new String(mascara.getPassword());

                if (login.equals("123") && senha.equals("321")) {
                    JOptionPane.showMessageDialog(null, "Login e senha aceitos !!!");
                    sucesso = true;
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Falha no login ou senha. Você tem mais " + (Ttentativas - tentativas - 1) + " tentativas restantes");
                }
            } else {
                // Se o usuário cancelar a entrada da senha, sair do loop
                break;
            }
        }

        if (!sucesso) {
            JOptionPane.showMessageDialog(null, "Você excedeu o número de tentativas");
        }
    }
}
