package Exemplos;

import java.awt.*;
import javax.swing.*;
public class GuiGridLayout1 extends JPanel {
    public GuiGridLayout1() {
        inicializarComponentes();

    }

    private void inicializarComponentes() {
        setLayout (new GridLayout(2,3));
        for (int i = 1; i <= 6; i++) {
            add (new JButton("Botão " + i));
        }
    }
}