package Exemplos;

import java.awt.event.*;
import javax.swing.*;
public class GuiAreaDeTexto extends JPanel {
    private JTextField tfCampo;
    private JTextArea taTexto;
    private JScrollPane scrollPane;
    private JButton btLimpar;
    private final static String novaLinha = "\n";

    public GuiAreaDeTexto() {
        inicializarComponentes();
        definirEventos();
    }


    private void inicializarComponentes() {
        setLayout(null);
        tfCampo = new JTextField();
        taTexto = new JTextArea(5, 20); //desnecessário por causa de setBounds
        taTexto.setEditable(false);
        String path = "borracha.jpg";
        btLimpar = new JButton(new ImageIcon(getClass().getResource(path)));
        scrollPane = new JScrollPane(taTexto);
        tfCampo.setBounds(25, 15, 150, 25);
        scrollPane.setBounds(25, 45, 300, 120);
        btLimpar.setBounds (25, 170, 220, 80);
        add(tfCampo);
        add(scrollPane);
        add(btLimpar);
    }

    private void definirEventos() {
        tfCampo.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                tfCampo.selectAll();
                taTexto.append(tfCampo.getText() + novaLinha);
                taTexto.setCaretPosition(taTexto.getDocument().getLength());
            }
        });
        btLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tfCampo.setText("");
                taTexto.setText("") ;
            }
        });
    }
}