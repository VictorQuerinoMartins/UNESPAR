package Exemplos.Carrega;
import javax.swing.JFrame;

import Exemplos.GuiLabel;
public class CarregaLabel {
    public static void main(String[] args){
        JFrame frame = new JFrame ("Uso de Botões");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new GuiLabel());
        frame.setBounds(0,0,500,300);
        frame.setVisible (true);
    }
}