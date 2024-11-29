import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class GuiEventos extends JFrame {
    JButton btMudarCor;
    JTextField tfCaixa1, tfCaixa2;
    int posicaoEsquerda = 100, posicaoTopo = 100;


    public static void main (String[] args) {
        JFrame janela = new GuiEventos();
        janela.addWindowListener(new WindowListener() {
            public void windowOpened(WindowEvent e) {}
            public void windowClosing(WindowEvent e) {}
            public void windowClosed(WindowEvent e) {}
            public void windowIconified(WindowEvent e) {
                System.out.println("A janela foi minimizada!");
            }
            public void windowDeiconified(WindowEvent e) {
                System.out.println("A janela foi restaurada!");
            }
            public void windowActivated(WindowEvent e) {}
            public void windowDeactivated(WindowEvent e) {}
        });



        janela.addComponentListener(new ComponentListener() {
            public void componentResized(ComponentEvent e) {
                System.out.println("A janela foi redimensionada!");
            }
            public void componentMoved(ComponentEvent e) {
                System.out.println("A janela foi movida!");
            }
            public void componentShown(ComponentEvent e) {
                System.out.println("A janela tornou-se visível!");
            }
            public void componentHidden(ComponentEvent e) {
                System.out.println ("A janela tornou-se oculta!");
            }
        });


        janela.setUndecorated(true);
        janela.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        janela. setDefaultCloseOperation (JFrame. EXIT_ON_CLOSE);
        janela.setVisible(true);
    }


    public GuiEventos() {
        inicializarComponentes();
        definirEventos();
    }

    public void inicializarComponentes() {
        setTitle("Controle de Eventos");
        setSize(250, 150);
        setLocation(posicaoEsquerda, posicaoTopo);
        setLayout(new GridLayout(3, 1));
        btMudarCor = new JButton("Eventos do Botão");
        tfCaixa1 = new JTextField();
        tfCaixa2 = new JTextField();
        btMudarCor.setBackground(Color.gray);
        add(btMudarCor);
        add(tfCaixa1);
        add(tfCaixa2);
    }


    public void definirEventos () {
        btMudarCor.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("O botão do mouse foi pressionado e solto!");
            }
            public void mousePressed(MouseEvent e) {
                System.out.println("O botão do mouse foi pressionado!");
                tfCaixa1.setBackground(Color.red);
            }
            public void mouseReleased(MouseEvent e) {
                System.out.println("O botão do mouse foi solto!");
            }
            public void mouseEntered(MouseEvent e) {
                btMudarCor.setBackground(Color.yellow);
            }
            public void mouseExited(MouseEvent e) {
                btMudarCor.setBackground(Color.gray);
            }
        });

        btMudarCor.addMouseMotionListener(new MouseMotionListener() {
            public void mouseDragged(MouseEvent e) {
                System.out.println("Mouse foi arrastado em " + e.getX() + " , " + e.getY());
            }
            public void mouseMoved(MouseEvent e) {
                System.out.println ("Mouse se moveu em " + e.getX() + " , " + e.getY());
            }
        });

        tfCaixa1.addKeyListener(new KeyListener() {
            public void keyTyped (KeyEvent e) {}
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyCode());
                if	(e.getKeyCode() == 38) // seta direcional para cima
                    posicaoTopo = posicaoTopo - 5;
                if	(e.getKeyCode() == 40) // seta direcional para baixo
                    posicaoTopo = posicaoTopo + 5;
                if	(e.getKeyCode() == 37) // seta direcional para esquerda
                    posicaoEsquerda = posicaoEsquerda - 5;
                if	(e.getKeyCode() == 39) // seta direcional para direita
                    posicaoEsquerda = posicaoEsquerda + 5;
                setLocation(posicaoEsquerda, posicaoTopo);
            }
            public void keyReleased(KeyEvent e) {}
        });


        tfCaixa2.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                System.out.println("A caixa 2 recebeu o foco!");
            }
            public void focusLost(FocusEvent e) {
                System.out.println("A caixa 2 perdeu o foco");
            }
        });

        tfCaixa2.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                System.out.println("Um caractere foi inserido!");
            }
            public void removeUpdate(DocumentEvent e) {
                System.out.println("Um caractere foi removido!");
            }
            public void changedUpdate(DocumentEvent e) {
                System.out.println("O conteúdo de um atributo mudou!");
            }
        });



    }
}
