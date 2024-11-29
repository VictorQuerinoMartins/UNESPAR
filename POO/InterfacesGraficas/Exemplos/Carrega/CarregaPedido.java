package Exemplos.Carrega;

import javax.swing.JFrame;
import Exemplos.GuiPedido;

public class CarregaPedido {
    public static void main(String[] args){
        JFrame frame = new JFrame ("Uso de Pedido");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new GuiPedido());
        frame.setBounds(0,0,500,300);
        frame.setVisible (true);
    }
}

