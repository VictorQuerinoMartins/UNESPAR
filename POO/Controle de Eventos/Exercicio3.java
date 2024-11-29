import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class Exercicio3 extends JFrame {

    private JLabel rotuloImagem;
    private Random random;

    public Exercicio3() {
        setTitle("Mostrar e Ocultar Imagem");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // Usando layout nulo para usar setBounds

        random = new Random();

        JButton botaoMostrar = new JButton("Mostrar");
        JButton botaoOcultar = new JButton("Ocultar");

        botaoMostrar.setBounds(50, 400, 100, 30);
        botaoOcultar.setBounds(200, 400, 100, 30);

        ImageIcon icone = new ImageIcon("C:\\\\Users\\\\yguin\\\\OneDrive\\\\Documentos\\\\GitHub\\\\POO\\\\Controle de Eventos\\\\carecacalvo.jpg");
        rotuloImagem = new JLabel(icone);
        rotuloImagem.setBounds(150, 150, icone.getIconWidth(), icone.getIconHeight());
        rotuloImagem.setVisible(false);

        botaoMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = random.nextInt(getWidth() - rotuloImagem.getWidth());
                int y = random.nextInt(getHeight() - rotuloImagem.getHeight() - 100); // Deixa espaço para os botões
                rotuloImagem.setBounds(x, y, rotuloImagem.getWidth(), rotuloImagem.getHeight());
                rotuloImagem.setVisible(true);
            }
        });

        botaoOcultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rotuloImagem.setVisible(false);
            }
        });

        add(botaoMostrar);
        add(botaoOcultar);
        add(rotuloImagem);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Exercicio3();
    }
}
