import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exercicio1 extends JFrame {

    public Exercicio1() {
        setTitle("Muda cor do botão");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton button = new JButton("Trocar");
        button.setBackground(Color.YELLOW);

        button.addMouseListener(new MouseAdapter() {
            
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.ORANGE);
            }

            public void mouseExited(MouseEvent e) {
                button.setBackground(Color.YELLOW);
            }
        });

        add(button);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Exercicio1();
    }
}
