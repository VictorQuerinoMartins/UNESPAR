package Exemplos.Carrega;
import Exemplos.GuiGridLayout1;
import javax.swing.*;

public class CarregaGuiGridLayout1 {
    public static void main(String[] args){
        JFrame frame = new JFrame ("Uso de GridLayouot");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new GuiGridLayout1());
        frame.setBounds(0,0,500,300);
        frame.setVisible (true);
    }
}