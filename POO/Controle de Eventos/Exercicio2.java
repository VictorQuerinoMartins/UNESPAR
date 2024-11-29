import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exercicio2 extends JFrame {

    public Exercicio2() {
        setTitle("Mostra Imagem");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Passe o mouse", SwingConstants.CENTER);
        JButton button = new JButton("Passe o mouse");
        ImageIcon icon = new ImageIcon("C:\\Users\\yguin\\OneDrive\\Documentos\\GitHub\\POO\\Controle de Eventos\\carecacalvo.jpg");
        JLabel imageLabel = new JLabel(icon);
        imageLabel.setVisible(false);

        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                imageLabel.setVisible(true);
            }

            public void mouseExited(MouseEvent e) {
                imageLabel.setVisible(false);
            }
        });

        add(label, BorderLayout.NORTH);
        add(button, BorderLayout.CENTER);
        add(imageLabel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Exercicio2();
    }
}
