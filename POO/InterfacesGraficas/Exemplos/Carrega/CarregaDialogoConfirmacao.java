package Exemplos.Carrega;

import javax.swing.JFrame;

import Exemplos.GuiDialogoConfirmacao;
public class CarregaDialogoConfirmacao {
    public static void main(String[] args){
        JFrame frame = new JFrame ("Uso de Diálogo de Informação");

        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new GuiDialogoConfirmacao());
        frame.setBounds(0,0,500,300);
        frame.setVisible (true);
    }
}