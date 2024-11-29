package Exemplos.Carrega;
import Exemplos.GuiFrameInterno;
import javax.swing.*;

public class CarregaFrameInterno {
    public static void main(String[] args){
        JFrame frame = new JFrame ("Uso de Frame Interno");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new GuiFrameInterno());
        frame.setBounds(0,0,500,300);
        frame.setVisible (true);
    }
}