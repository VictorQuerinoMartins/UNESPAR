package Atividades;

import javax.swing.JOptionPane;

public class atividade6 {
    public static void main(String[] args) {
        
        String frase = JOptionPane.showInputDialog(null, "Digite uma frase:");

        // para transformar em minusculo
        frase = frase.toLowerCase();

        if (frase.contains("sexo") || frase.contains("sexual")) {           //contains = ve se tem a palavra entre " " no texto

            JOptionPane.showMessageDialog(null, "A frase contém palavras impróprias.");
        } else {
            JOptionPane.showMessageDialog(null, "A frase não contém palavras impróprias.");
        }
    }
}