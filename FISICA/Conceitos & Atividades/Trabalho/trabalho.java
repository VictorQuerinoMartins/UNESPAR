package Trabalho;
//Criar um código em java para calcular o volume de gelo na Antártica, assumindo quea forma da Antártica é semicircular. Fazendo que o usuário insira o raio e a espessura da cobertura de gelo, e calcula o volume de gelo em centímetros cúbicos.


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class trabalho { //CALCULADORA DE VOLUME DA ANTARTICA


    public static void main(String[] args) {
        // Cria a janela
        JFrame janela = new JFrame("Calculadora de Volume da Antártica");
        janela.setSize(400, 300);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLayout(null);


        // Cria os rótulos e campos de texto
        JLabel escritaRaio = new JLabel("Raio (km):");
        escritaRaio.setBounds(20, 20, 100, 30);
        janela.add(escritaRaio);


        JTextField insiraRaio = new JTextField("2000");
        insiraRaio.setBounds(130, 20, 200, 30);
        janela.add(insiraRaio);


        JLabel escritaEspessura = new JLabel("Espessura (m):");
        escritaEspessura.setBounds(20, 70, 100, 30);
        janela.add(escritaEspessura);


        JTextField insiraEspessura = new JTextField("3000");
        insiraEspessura.setBounds(130, 70, 200, 30);
        janela.add(insiraEspessura);


        JButton botaoCalcular = new JButton("Calcular");
        botaoCalcular.setBounds(130, 120, 200, 30);
        janela.add(botaoCalcular);


        JLabel escritaResult = new JLabel("Volume (cm³):");
        escritaResult.setBounds(20, 170, 100, 30);
        janela.add(escritaResult);


        JTextField exibirResult = new JTextField();
        exibirResult.setBounds(130, 170, 200, 30);
        exibirResult.setEditable(false);
        janela.add(exibirResult);


        // Adiciona o action listener ao botão
        botaoCalcular.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
                double raio = Double.parseDouble(insiraRaio.getText());
                double espessura = Double.parseDouble(insiraEspessura.getText()) / 1000; // converte para km


                // Calcula o volume em quilômetros cúbicos
                double volumeKm3 = 0.5 * Math.PI * Math.pow(raio, 2) * espessura;


                // Converte o volume para centímetros cúbicos
                double volumeCm3 = volumeKm3 * Math.pow(10, 15);


                // Exibe o resultado
                exibirResult.setText(String.format("%.2e", volumeCm3));
            }
        });


        // Define a janela como visível
        janela.setVisible(true);
    }
}


