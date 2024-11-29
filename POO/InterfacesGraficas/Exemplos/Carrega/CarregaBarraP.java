package Exemplos.Carrega;
import javax.swing.*;

import Exemplos.GuiBarraProgresso;

public class CarregaBarraP {
    public static void main(String[] args){
        JFrame frame = new JFrame ("Uso de Barra de Progresso");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new GuiBarraProgresso());
        frame.setBounds(0,0,500,300);
        frame.setVisible (true);
    }
}