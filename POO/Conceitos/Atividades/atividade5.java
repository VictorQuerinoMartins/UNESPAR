package Atividades;

import javax.swing.JOptionPane;

public class atividade5 {
    public static void main(String[] args) {
    
        String frase = JOptionPane.showInputDialog(null, "Digite uma frase para ser invertida:");

        StringBuilder fraseInvertida = new StringBuilder();     // cria uma strings mutáveis, possibilitando modificações.

        // Inverte, sem alterar a ordem das palavras
        for (int i = frase.length() - 1; i >= 0; i--) {
            fraseInvertida.append(frase.charAt(i));
        }

        JOptionPane.showMessageDialog(null, "Frase invertida de trás para frente:\n" + fraseInvertida.toString());
    }
}