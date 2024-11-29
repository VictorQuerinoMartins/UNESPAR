package BancoDados.Departamento;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class GuiMenuTesouraria extends JPanel {

    private JMenuBar mnBarra;
    private JMenu mnArquivo, mnCadastros, mnConsultas;
    private JMenuItem miSair, miContasPagar, miContasReceber, miFluxoCaixa; 
    private Container parentContainer;
    private JMenuBar menuBarPrincipal; // Referência ao menu principal

    public GuiMenuTesouraria(Container parent, JMenuBar menuPrincipal ) {
        this.parentContainer = parent;
        this.menuBarPrincipal = menuPrincipal; // Guarda o menu principal
        inicializarComponentes();
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(new BorderLayout());
        //Inicializa os menus e atalhos de teclado
        mnBarra = new JMenuBar();
        mnArquivo = new JMenu("Arquivo");
        mnArquivo.setMnemonic ('A') ;
        mnCadastros = new JMenu("Cadastros");
        mnCadastros.setMnemonic('C');
        mnConsultas = new JMenu("Consultas");
        mnConsultas.setMnemonic('S');
        //Inicializa os Itens de Menus
        miSair = new JMenuItem("Sair");
        //Define um atalho de teclado (Alt + S)
        miSair.setAccelerator (KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.ALT_MASK));
        //Cadastros
        miFluxoCaixa = new JMenuItem("Fluxo de Caixa");
        miFluxoCaixa.setMnemonic('F');
        //Consultas
        miContasPagar = new JMenuItem("Contas a Pagar");
        miContasPagar.setMnemonic('P');
        miContasReceber = new JMenuItem("Contas a Receber");
        miContasReceber.setMnemonic('R');
        //Adiciona componentes ao Frame
        //Vincula os menus aos itens de menu
        mnArquivo.add(miSair);
        mnCadastros.add(miFluxoCaixa);
        mnConsultas.add(miContasPagar);
        mnConsultas.add(miContasReceber);
        mnBarra.add (mnArquivo);
        mnBarra.add(mnCadastros);
        mnBarra.add(mnConsultas);
        add(new JLabel("Sistema da Tesouraria", JLabel.CENTER), BorderLayout.CENTER);

    }
    public JMenuBar getMenuBar() {
        return mnBarra;
    }
    private void definirEventos() {
        miSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Fecha o painel de graduação e volta ao painel inicial
                parentContainer.removeAll(); // Remove o painel de graduação

                //Configura um painel inicial com layout centralizado
                JPanel painelInicial = new JPanel(new BorderLayout());
                JLabel msgMenuPrincipal = new JLabel("Menu Principal!", JLabel.CENTER);
                //Centraliza o texto
                painelInicial.add(msgMenuPrincipal, BorderLayout.CENTER);
                //Adiciona o painel inicial ao parentContainer
                parentContainer.add(painelInicial, BorderLayout.CENTER);
                parentContainer.revalidate();
                parentContainer.repaint();
                // Restaura o menu principal
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(parentContainer);
                if (topFrame != null) {
                    // Restaura a barra de menu principal
                    topFrame.setJMenuBar(menuBarPrincipal);
                    topFrame.revalidate();
                }

            }
        });

        miFluxoCaixa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Abre Sistema de Fluxo de Caixa");
            }
        });

        miContasPagar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Abre Cadastro de Contas a Pagar");
            }
        });

        miContasReceber.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Abre Cadastro de Contas a Receber");
            }
        });

    }
}