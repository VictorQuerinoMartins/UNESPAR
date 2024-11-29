package Exemplos;

import java.awt.event.*;
import javax.swing.*;
public class GuiDialogoConfirmacao extends JPanel{
    private JButton btMostrar;
    private JRadioButton radioButton1, radioButton2, radioButton3;
    private ButtonGroup buttonGroup;

    public GuiDialogoConfirmacao() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes( ) {
        setLayout (null);
        btMostrar = new JButton("Mostrar");
        radioButton1 = new JRadioButton("Sim e Nao");
        radioButton2 = new JRadioButton("Sim, Nao e Cancelar");
        radioButton3 = new JRadioButton("Ok e Cancelar");
        buttonGroup = new ButtonGroup();
        buttonGroup.add (radioButton1);
        buttonGroup.add (radioButton2);
        buttonGroup.add (radioButton3);
        radioButton1.setBounds(55 , 10, 200, 25);
        radioButton2.setBounds(55 , 30, 200, 35);
        radioButton3.setBounds(55, 60, 200, 25);
        btMostrar.setBounds(55 , 90, 100, 20);
        add (btMostrar);
        add (radioButton1);
        add (radioButton2);
        add (radioButton3);
    }


    private void definirEventos() {
        btMostrar.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent arg0) {
                int resp = 0;
                if (radioButton1.isSelected()) {
                    resp = JOptionPane.showConfirmDialog(null, "Erro ao acessar arquivo. "
                                    + "Tentar novamente?", "Erro de arquivo", JOptionPane.YES_NO_OPTION,
                            JOptionPane.ERROR_MESSAGE);
                } else if (radioButton2.isSelected()) {
                    resp = JOptionPane.showConfirmDialog(null, "Deseja salvar as alteracoes?",
                            "Salvar o arquivo", JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                } else {
                    resp = JOptionPane.showConfirmDialog(null, "Deseja abrir o arquivo?",
                            "Abrir arquivo", JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                }
                JOptionPane. showMessageDialog(null, resp, "Resposta", 1);
            }
        });
    }
}