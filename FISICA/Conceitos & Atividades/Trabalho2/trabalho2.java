package Trabalho2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class trabalho2 {

    public static void main(String[] args) {
      
        JFrame janela = new JFrame("Calculadora de Força Eletrostática");
        janela.setSize(400, 300);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLayout(null);

        JLabel escritaCarga1 = new JLabel("Carga 1 (C):");
        escritaCarga1.setBounds(20, 20, 100, 30);
        janela.add(escritaCarga1);

        JTextField insiraCarga1 = new JTextField("1.00");
        insiraCarga1.setBounds(130, 20, 200, 30);
        janela.add(insiraCarga1);

        JLabel escritaCarga2 = new JLabel("Carga 2 (C):");
        escritaCarga2.setBounds(20, 70, 100, 30);
        janela.add(escritaCarga2);

        JTextField insiraCarga2 = new JTextField("1.00");
        insiraCarga2.setBounds(130, 70, 200, 30);
        janela.add(insiraCarga2);

        JLabel escritaDistancia = new JLabel("Distância (m):");
        escritaDistancia.setBounds(20, 120, 100, 30);
        janela.add(escritaDistancia);

        JTextField insiraDistancia = new JTextField("1.00");
        insiraDistancia.setBounds(130, 120, 200, 30);
        janela.add(insiraDistancia);

        JButton botaoCalcular = new JButton("Calcular");
        botaoCalcular.setBounds(130, 170, 200, 30);
        janela.add(botaoCalcular);

        JLabel escritaResult = new JLabel("Força (N):");
        escritaResult.setBounds(20, 220, 100, 30);
        janela.add(escritaResult);

        JTextField exibirResult = new JTextField();
        exibirResult.setBounds(130, 220, 200, 30);
        exibirResult.setEditable(false);
        janela.add(exibirResult);

        botaoCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double carga1 = Double.parseDouble(insiraCarga1.getText());
                double carga2 = Double.parseDouble(insiraCarga2.getText());
                double distancia = Double.parseDouble(insiraDistancia.getText());

                // Constante de Coulomb em N·m²/C²
                double ke = 8.99e9;

                // Calcula a força eletrostática usando a Lei de Coulomb
                double forca = ke * (carga1 * carga2) / Math.pow(distancia, 2);

                // Exibe o resultado formatado
                exibirResult.setText(String.format("%.2e", forca));
            }
        });

        
        janela.setVisible(true);
    }
}
