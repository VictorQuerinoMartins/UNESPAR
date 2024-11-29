package Exemplos.Carrega;

import Exemplos.GuiMenuPrincipal;
import javax.swing.JFrame;
public class CarregaMenuPrincipal {
    public static void main(String[] args){
        JFrame frame = new JFrame ("Uso de Botões");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new GuiMenuPrincipal());
        frame.setBounds(0,0,500,300);
        frame.setVisible (true);
    }
}