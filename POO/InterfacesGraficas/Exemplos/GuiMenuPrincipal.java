package Exemplos;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GuiMenuPrincipal extends JFrame {
    private Container contentPane;
    private JMenuBar mnBarra;
    private JMenu mnArquivo, mnExemplos;
    private JMenuItem miSair, miBotao, miAreaDeTexto, miCaixaOpcao, miCombo, miDialogoMensagem, miLabel, miLista, miRadio;
    private JMenuItem miBorderStyle, miBorderStyle2, miDialConfirmacao, miDialOpcao, miBarraRolagem, miBarraProg, miFlayLayout3, miGridLayout1, miAbas, miFrameInt, miPedido, miMascara;

    public GuiMenuPrincipal() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setTitle("Menu Principal");
        setBounds(0, 0, 800, 600);
        contentPane = getContentPane();
        mnBarra = new JMenuBar();
        mnArquivo = new JMenu("Arquivo");
        mnArquivo.setMnemonic ('A') ;
        mnExemplos = new JMenu("Exemplos");
        mnExemplos.setMnemonic('E');
        String path = "sair.png";
        miSair = new JMenuItem("Sair", new ImageIcon(getClass().getResource(path)));
        miSair.setAccelerator (KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.ALT_MASK));
        miBotao = new JMenuItem("Botão");
        miAreaDeTexto = new JMenuItem("Area de Texto");
        miCaixaOpcao = new JMenuItem("Caixa de Opção");
        miCombo = new JMenuItem("Combo");
        miDialogoMensagem = new JMenuItem("Dialogo");
        miLabel = new JMenuItem("Label");
        miLista = new JMenuItem("Lista");
        miRadio = new JMenuItem("Radio");
        miDialConfirmacao = new JMenuItem("Dialogo Confirmacao");
        miDialOpcao = new JMenuItem("Dialogo Opcao");
        miBarraRolagem = new JMenuItem("Barra Rolagem");
        miBarraProg = new JMenuItem("Barra Progresso");
        miFlayLayout3 = new JMenuItem("Flay Layout 3");
        miGridLayout1 = new JMenuItem("Grid Layout 1");
        miAbas = new JMenuItem("Abas");
        miFrameInt = new JMenuItem("Frame Interno");
        miPedido = new JMenuItem("Pedido");
        miMascara = new JMenuItem("Mascara");
        miBorderStyle2 = new JMenuItem("Borda Style 2");
        miBorderStyle = new JMenuItem("Borda Style");

        mnArquivo.add(miSair);
        mnExemplos.add (miBotao);
        mnExemplos.add(miAreaDeTexto);
        mnExemplos.add(miCaixaOpcao);
        mnExemplos.add(miCombo);
        mnExemplos.add(miDialogoMensagem);
        mnExemplos.add(miLabel);
        mnExemplos.add(miLista);
        mnExemplos.add(miRadio);
        mnExemplos.add(miDialConfirmacao);
        mnExemplos.add(miDialOpcao);
        mnExemplos.add(miBarraRolagem); 
        mnExemplos.add(miBarraProg);
        mnExemplos.add(miFlayLayout3);
        mnExemplos.add(miGridLayout1);
        mnExemplos.add(miAbas);
        mnExemplos.add(miFrameInt);
        mnExemplos.add(miPedido);
        mnExemplos.add(miMascara);
        mnExemplos.add(miBorderStyle2);
        mnExemplos.add(miBorderStyle);

        mnBarra.add (mnArquivo);
        mnBarra.add(mnExemplos);
        setJMenuBar (mnBarra);
    }

    private void definirEventos() {
        miSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        miBotao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GuiBotao botao = new GuiBotao();
                contentPane.removeAll();
                contentPane.add(botao);
                contentPane.validate();
            }
        });

        miAreaDeTexto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GuiAreaDeTexto texto = new GuiAreaDeTexto();
                contentPane.removeAll();
                contentPane.add(texto);
                contentPane.validate();
            }
        });

        miCaixaOpcao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GuiCaixaOpcao caixaOpcao = new GuiCaixaOpcao();
                contentPane.removeAll();
                contentPane.add(caixaOpcao);
                contentPane.validate();
            }
        });

        miCombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GuiCombo combo = new GuiCombo();
                contentPane.removeAll();
                contentPane.add(combo);
                contentPane.validate();
            }
        });

        miDialogoMensagem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GuiDialogoMensagem dialogo = new GuiDialogoMensagem();
                contentPane.removeAll();
                contentPane.add(dialogo);
                contentPane.validate();
            }
        });

        miLabel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GuiLabel label = new GuiLabel();
                contentPane.removeAll();
                contentPane.add(label);
                contentPane.validate();
            }
        });

        miLista.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GuiLista lista = new GuiLista();
                contentPane.removeAll();
                contentPane.add(lista);
                contentPane.validate();
            }
        });

        miRadio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GuiRadio radio = new GuiRadio();
                contentPane.removeAll();
                contentPane.add(radio);
                contentPane.validate();
            }
        });

        miDialConfirmacao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GuiDialogoConfirmacao conf = new GuiDialogoConfirmacao();
                contentPane.removeAll();
                contentPane.add(conf);
                contentPane.validate();
            }
        });

        miDialOpcao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GuiRadio opcao = new GuiRadio();
                contentPane.removeAll();
                contentPane.add(opcao);
                contentPane.validate();
            }
        });

        miBarraRolagem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GuiBarraRolagem barra = new GuiBarraRolagem();
                contentPane.removeAll();
                contentPane.add(barra);
                contentPane.validate();
            }
        });

        miBarraProg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GuiBarraProgresso barra = new GuiBarraProgresso();
                contentPane.removeAll();
                contentPane.add(barra);
                contentPane.validate();
            }
        });

        miFlayLayout3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GuiFlayLayout3 flay = new GuiFlayLayout3();
                contentPane.removeAll();
                contentPane.add(flay);
                contentPane.validate();
            }
        });

        miGridLayout1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GuiGridLayout1 grid = new GuiGridLayout1();
                contentPane.removeAll();
                contentPane.add(grid);
                contentPane.validate();
            }
        });

        miAbas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GuiAbas abas = new GuiAbas();
                contentPane.removeAll();
                contentPane.add(abas);
                contentPane.validate();
            }
        });

        miFrameInt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GuiFrameInterno frame = new GuiFrameInterno();
                contentPane.removeAll();
                contentPane.add(frame);
                contentPane.validate();
            }
        });

        miPedido.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GuiPedido pedido = new GuiPedido();
                contentPane.removeAll();
                contentPane.add(pedido);
                contentPane.validate();
            }
        });

        miMascara.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GuiMascara mascara = new GuiMascara();
                contentPane.removeAll();
                contentPane.add(mascara);
                contentPane.validate();
            }
        });

        miBorderStyle2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GuiBorderStyle2 border2 = new GuiBorderStyle2();
                contentPane.removeAll();
                contentPane.add(border2);
                contentPane.validate();
            }
        });

        miBorderStyle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GuiBorderStyle border = new GuiBorderStyle();
                contentPane.removeAll();
                contentPane.add(border);
                contentPane.validate();
            }
        });

    }

    public static void abrir () {
        GuiMenuPrincipal frame = new GuiMenuPrincipal();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((tela.width - frame.getSize().width) / 2,
                (tela.height - frame.getSize().height) / 2);
        frame.setVisible(true);
    }
}