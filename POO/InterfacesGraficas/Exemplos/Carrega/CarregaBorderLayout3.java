package Exemplos.Carrega;
import Exemplos.GuiFlayLayout3;
import javax.swing.*;

public class CarregaBorderLayout3 {
    public static void main(String[] args){
        JFrame frame = new JFrame ("Uso de FlayLayout3");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new GuiFlayLayout3());
        frame.setBounds(0,0,500,300);
        frame.setVisible (true);
    }
}