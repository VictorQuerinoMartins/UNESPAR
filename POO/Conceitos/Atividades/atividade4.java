package Atividades;


import javax.swing.*;

public class atividade4 {
    public static void main(String[] args) {
        
        String numInput = JOptionPane.showInputDialog("Insira o numero que deseje na tabuada ");

        float num = Float.parseFloat(numInput);

        String resultado = " ";

        for (int i = 1; i <= 10; i++) {
            resultado += (num + " x " + i + " = ") + (num * i) + "\n";
        }

        JOptionPane.showMessageDialog(null, resultado);
    }

}

