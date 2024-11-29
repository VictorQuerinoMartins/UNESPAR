package Exemplos;
import java.awt.*;
import javax.swing.JInternalFrame;
public class GuiFrameInterno extends JInternalFrame {
    public GuiFrameInterno() {
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setTitle ("Usando Frame Interno");
        setSize (300, 100);
        setResizable (true);
        setClosable (true);
        setMaximizable (true);
        setIconifiable (true);
        setBackground (Color.blue);
        setVisible (true);
    }
}