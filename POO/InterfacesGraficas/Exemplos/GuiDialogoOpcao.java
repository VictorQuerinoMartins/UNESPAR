package Exemplos;

import java.awt.event.*;
import javax.swing.*;
public class GuiDialogoOpcao extends JPanel {
    private JButton btAbrir;
    private JLabel lbResposta;

    public GuiDialogoOpcao() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout (null);
        lbResposta = new JLabel ("");
        btAbrir = new JButton("Abrir");
        btAbrir.setBounds(25 , 30, 100, 25);
        lbResposta.setBounds(25 , 60, 200, 25);
        add (btAbrir);
        add (lbResposta);
    }

    private void definirEventos() {
        btAbrir.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent arg0) {
                String[] escolha = {"Masculino", "Feminino"};
                int resp = JOptionPane.showOptionDialog(null, "Escolha o Sexo",
                        "Sexo", 0, JOptionPane.INFORMATION_MESSAGE,
                        new ImageIcon("carecacalvo1.jpg"), escolha, escolha[0]);
                lbResposta.setText("Sexo Escolhido: " + escolha[resp]);
            }
        });
    }
}