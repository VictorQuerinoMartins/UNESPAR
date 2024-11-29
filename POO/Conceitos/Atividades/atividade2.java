package Atividades;

import javax.swing.*;

public class atividade2 {
    public static void main(String[] args) {
        String reInput = JOptionPane.showInputDialog("Insira o valor da resistencia 1: ");
        String re1Input = JOptionPane.showInputDialog("Insira o valor da resistencia 2: ");
        String re2Input = JOptionPane.showInputDialog("Insira o valor da resistencia 3: ");
        String re3Input = JOptionPane.showInputDialog("Insira o valor da resistencia 4: ");
        

        // Convertendo o valor inserido para float
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

        JOptionPane.showMessageDialog(null, "A maior resistencia eh " + maior + "\nA menor resistencia eh " + menor);
        
    }
}

