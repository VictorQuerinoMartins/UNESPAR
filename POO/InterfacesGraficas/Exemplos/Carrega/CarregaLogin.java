package Exemplos.Carrega;
import javax.swing.JFrame;

import Exemplos.GuiLogin;
public class CarregaLogin {
    public static void main(String[] args){
        JFrame frame = new JFrame ("Uso de Botões");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new GuiLogin());
        frame.setBounds(0,0,500,300);
        frame.setVisible (true);
    }
}