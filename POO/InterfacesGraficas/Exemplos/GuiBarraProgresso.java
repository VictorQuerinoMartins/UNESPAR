package Exemplos;

import java.awt.event.*;
import javax.swing.*;
public class GuiBarraProgresso extends JPanel {
    private JProgressBar pbInstalar;
    private JButton btAumenta, btDiminui;

    public GuiBarraProgresso() {
        inicializarComponentes();
        definirEventos();
    }


    private void inicializarComponentes() {
        setLayout (null);
        pbInstalar = new JProgressBar();
        pbInstalar.setBounds (50,10,100, 20);
        btAumenta = new JButton ("Aumentar");
        btAumenta.setBounds(50 , 50, 100, 25);
        btAumenta.setMnemonic('A');
        btDiminui = new JButton ("Diminuir");
        btDiminui.setBounds(50 , 100, 100, 25);
        btDiminui.setMnemonic('D');
        add (pbInstalar);
        add (btAumenta) ;
        add (btDiminui) ;
    }


    private void definirEventos() {
        btAumenta.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                pbInstalar.setValue (pbInstalar.getValue() + 5);
            }
        });

        btDiminui.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pbInstalar.setValue(pbInstalar.getValue() - 5);
            }
        });
    }
}