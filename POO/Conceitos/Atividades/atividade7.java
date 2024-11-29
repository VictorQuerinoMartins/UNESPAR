package Atividades;

import javax.swing.*;

public class atividade7 {
    public static void main(String[] args) {
        int opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção:\n1. Calcular Desconto\n2. Verificar Resistências\n3. Verificar Login\n4. Mostrar Tabuada"));

        switch (opcao) {
            case 1:
                String produto = JOptionPane.showInputDialog("Insira o nome do produto");
                String valorInput = JOptionPane.showInputDialog("Insira o valor do produto");

                float valor = Float.parseFloat(valorInput);

                float desconto;

                if (valor >= 1000) {
                    desconto = (valor * 8) / 100;
                } else if (valor >= 500) {
                    desconto = (valor * 7) / 100;
                } else if (valor >= 200) {
                    desconto = (valor * 6) / 100;
                } else if (valor >= 50) {
                    desconto = (valor * 5) / 100;
                } else {
                    desconto = 0;
                }

                JOptionPane.showMessageDialog(null, "Nome do Produto: " + produto);
                JOptionPane.showMessageDialog(null, "Valor Total: " + "R$" + valor);
                JOptionPane.showMessageDialog(null, "Valor com Desconto: " + "R$" + (valor - desconto));
                break;

            case 2:
                String reInput = JOptionPane.showInputDialog("Insira o valor da resistencia 1: ");
                String re1Input = JOptionPane.showInputDialog("Insira o valor da resistencia 2: ");
                String re2Input = JOptionPane.showInputDialog("Insira o valor da resistencia 3: ");
                String re3Input = JOptionPane.showInputDialog("Insira o valor da resistencia 4: ");

                float re = Float.parseFloat(reInput);
                float re1 = Float.parseFloat(re1Input);
                float re2 = Float.parseFloat(re2Input);
                float re3 = Float.parseFloat(re3Input);

                float maior, menor;

                if (re > re1 && re > re2 && re > re3) {
                    maior = re;
                } else if (re1 > re && re1 > re2 && re1 > re3) {
                    maior = re1;
                } else if (re2 > re && re2 > re1 && re2 > re3) {
                    maior = re2;
                } else {
                    maior = re3;
                }

                if (re < re1 && re < re2 && re < re3) {
                    menor = re;
                } else if (re1 < re && re1 < re2 && re1 < re3) {
                    menor = re1;
                } else if (re2 < re && re2 < re1 && re2 < re3) {
                    menor = re2;
                } else {
                    menor = re3;
                }

                JOptionPane.showMessageDialog(null, "A maior resistencia eh " + maior);
                JOptionPane.showMessageDialog(null, "A menor resistencia eh " + menor);
                break;

            case 3:
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
                break;

            case 4:
                String numInput = JOptionPane.showInputDialog("Insira o numero que deseje na tabuada ");

                float num = Float.parseFloat(numInput);

                for (int i = 1; i <= 10; i++) {
                    JOptionPane.showMessageDialog(null, (num + " x " + i + " = ") + (num * i));
                }
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opção inválida");
                break;
        }
    }
}
