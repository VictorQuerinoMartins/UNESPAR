package Exemplos.Carrega;

import javax.swing.*;

import Exemplos.GuiAbas;

public class CarregaAbas {
    public static void main(String[] args){
        JFrame frame = new JFrame ("Uso de FlayLayout3");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new GuiAbas());
        frame.setBounds(0,0,500,300);
        frame.setVisible (true);
    }
}