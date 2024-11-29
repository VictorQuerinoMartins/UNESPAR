package Exemplos.Carrega;
import Exemplos.GuiAreaDeTexto;
import javax.swing.JFrame;
public class CarregaTexto {
    public static void main(String[] args){
        JFrame frame = new JFrame ("Uso de Botões");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new GuiAreaDeTexto());
        frame.setBounds(0,0,500,300);
        frame.setVisible (true);
    }
}