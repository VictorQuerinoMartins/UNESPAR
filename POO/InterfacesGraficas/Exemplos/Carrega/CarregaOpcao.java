package Exemplos.Carrega;
import Exemplos.GuiMascara;
import javax.swing.JFrame;
public class CarregaOpcao {
    public static void main(String[] args){
        JFrame frame = new JFrame ("Uso de Mascara");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new GuiMascara());
        frame.setBounds(0,0,500,300);
        frame.setVisible (true);
    }
}