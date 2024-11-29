package BancoDados.Departamento;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GuiMenuSistema extends JFrame {
    private Container contentPane;
    private JPanel painelInicial; // Painel inicial que será restaurado
    private JMenuBar mnBarra;
    private JMenu mnArquivo, mnSistemas;
    private JMenuItem miSair, miGraduacao,miBiblioteca,miRestaurante,miFinancas;

    // Armazena a barra de menu principal para restaurar depois
    private JMenuBar menuBarPrincipal;

    public static void main(String[] args) {
        JFrame janela = new GuiMenuSistema();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Maximiza a janela para ocupar toda a tela
        janela.setExtendedState(JFrame.MAXIMIZED_BOTH);
        janela.setVisible(true);
    }
    public GuiMenuSistema() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setTitle("Menu Principal");
        setBounds(0, 0, 800, 600);
        contentPane = getContentPane();

        // Criando um painel inicial simples
        painelInicial = new JPanel(new BorderLayout());
        JLabel msgMenuPrincipal = new JLabel("Menu Principal",JLabel.CENTER);

        // Adiciona o JLabel no centro do painel
        painelInicial.add(msgMenuPrincipal, BorderLayout.CENTER);
        // Adiciona o painel inicial no centro do contentPane
        contentPane.add(painelInicial, BorderLayout.CENTER);
        //Inicializa os menus e atalhos de teclado
        mnBarra = new JMenuBar();
        mnArquivo = new JMenu("Arquivo");
        mnArquivo.setMnemonic ('A') ;
        mnSistemas = new JMenu("Sistemas");
        mnSistemas.setMnemonic('S');
        //Inicializa os Itens de Menus
        miSair = new JMenuItem("Sair");
        miSair.setAccelerator (KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.ALT_MASK));
        miGraduacao = new JMenuItem("Graduação");
        miGraduacao.setMnemonic('G');
        miBiblioteca = new JMenuItem("Biblioteca");
        miBiblioteca.setMnemonic('B');
        miRestaurante = new JMenuItem("Restaurante");
        miRestaurante.setMnemonic('R');
        miFinancas = new JMenuItem("Financas");
        miFinancas.setMnemonic('F');
        //Adiciona componentes ao Frame
        //Vincula os menus aos itens de menu
        mnArquivo.add(miSair);
        mnSistemas.add(miGraduacao);
        mnSistemas.add(miBiblioteca);
        mnSistemas.add(miRestaurante);
        mnSistemas.add(miFinancas);
        mnBarra.add (mnArquivo);
        mnBarra.add(mnSistemas);

        // Armazena a barra de menu principal para restaurar depois
        menuBarPrincipal = mnBarra;
        setJMenuBar (mnBarra);

    }
    private void definirEventos() {
        miSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        miGraduacao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Abre Sistema de Graduacao");
                //Prepara o painel adicionar novos componentes
                contentPane.removeAll();
                //Cria nova instância de GuiMenuGraduação
                // Passa o contentPane e o menu principal para trocar o menu;
                GuiMenuGraduacao guiMenuGraduacao = new GuiMenuGraduacao(contentPane, menuBarPrincipal);
                contentPane.add(guiMenuGraduacao);
                //Atualiza a barra de menu
                setJMenuBar(guiMenuGraduacao.getMenuBar());

                //Faz a revalidação e repaint da janela
                contentPane.revalidate();
                contentPane.repaint();
                revalidate();  // Revalida o JFrame inteiro
                repaint();     // Redesenha o JFrame inteiro
            }
        });

        miBiblioteca.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Abre Sistema de Biblioteca");
                //Prepara o painel adicionar novos componentes
                contentPane.removeAll();
                //Cria nova instância de GuiMenuGraduação
                // Passa o contentPane e o menu principal para trocar o menu;
                GuiMenuBiblioteca guiMenuBiblioteca = new GuiMenuBiblioteca(contentPane, menuBarPrincipal);
                contentPane.add(guiMenuBiblioteca);
                //Atualiza a barra de menu
                setJMenuBar(guiMenuBiblioteca.getMenuBar());

                //Faz a revalidação e repaint da janela
                contentPane.revalidate();
                contentPane.repaint();
                revalidate();  // Revalida o JFrame inteiro
                repaint();     // Redesenha o JFrame inteiro
            }

        });

        miRestaurante.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Abre Sistema de Restaurante");
                 //Prepara o painel adicionar novos componentes
                 contentPane.removeAll();
                 //Cria nova instância de GuiMenuGraduação
                 // Passa o contentPane e o menu principal para trocar o menu;
                 GuiMenuRestaurante guiMenuRestaurante = new GuiMenuRestaurante(contentPane, menuBarPrincipal);
                 contentPane.add(guiMenuRestaurante);
                 //Atualiza a barra de menu
                 setJMenuBar(guiMenuRestaurante.getMenuBar());
 
                 //Faz a revalidação e repaint da janela
                 contentPane.revalidate();
                 contentPane.repaint();
                 revalidate();  // Revalida o JFrame inteiro
                 repaint();     // Redesenha o JFrame inteiro
            }
        });
        
        miFinancas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Abre Sistema de Finanças");
                //Prepara o painel adicionar novos componentes
                contentPane.removeAll();
                //Cria nova instância de GuiMenuGraduação
                // Passa o contentPane e o menu principal para trocar o menu;
                GuiMenuTesouraria guiMenuTesouraria = new GuiMenuTesouraria(contentPane, menuBarPrincipal);
                contentPane.add(guiMenuTesouraria);
                //Atualiza a barra de menu
                setJMenuBar(guiMenuTesouraria.getMenuBar());

                //Faz a revalidação e repaint da janela
                contentPane.revalidate();
                contentPane.repaint();
                revalidate();  // Revalida o JFrame inteiro
                repaint();     // Redesenha o JFrame inteiro
            }
        });
    }
}