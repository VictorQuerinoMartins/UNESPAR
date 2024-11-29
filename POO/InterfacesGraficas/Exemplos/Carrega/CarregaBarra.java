package Exemplos.Carrega;
import javax.swing.*;

import Exemplos.GuiBarraRolagem;

public class CarregaBarra {
    public static void main(String[] args){
        JFrame frame = new JFrame ("Uso de Barra de Rolagem");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new GuiBarraRolagem());
        frame.setBounds(0,0,500,300);
        frame.setVisible (true);
    }
}