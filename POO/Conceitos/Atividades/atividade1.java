package Atividades;

import javax.swing.*;

public class atividade1 {
    public static void main(String[] args) {
        String produto = JOptionPane.showInputDialog("Insira o nome do produto");
        String valorInput = JOptionPane.showInputDialog("Insira o valor do produto");

        // Convertendo o valor inserido para float
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

        
        JOptionPane.showMessageDialog(null, "Nome do Produto: " + produto + "\nValor Total: " + "R$" + valor + "\nValor com Desconto: " + "R$ " + (valor - desconto));
        
    }
}
