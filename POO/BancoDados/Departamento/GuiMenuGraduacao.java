package BancoDados.Departamento;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class GuiMenuGraduacao extends JPanel {

    private JMenuBar mnBarra;
    private JMenu mnArquivo, mnCadastros, mnConsultas;
    private JMenuItem miSair, miMatricula,miCurso,miDepartamento,miMatriculados;
    private Container parentContainer;
    private JMenuBar menuBarPrincipal; // Referência ao menu principal

    public GuiMenuGraduacao(Container parent, JMenuBar menuPrincipal ) {
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
        miMatricula = new JMenuItem("Matrícula");
        miMatricula.setMnemonic('M');
        miCurso = new JMenuItem("Curso");
        miDepartamento = new JMenuItem("Departamento");
        //Consultas
        miMatriculados = new JMenuItem("Matriculados");
        miMatriculados.setMnemonic('D');
        //Adiciona componentes ao Frame
        //Vincula os menus aos itens de menu
        mnArquivo.add(miSair);
        mnCadastros.add(miMatricula);
        mnCadastros.add(miCurso);
        mnCadastros.add(miDepartamento);
        mnConsultas.add(miMatriculados);
        mnBarra.add (mnArquivo);
        mnBarra.add(mnCadastros);
        mnBarra.add(mnConsultas);
        add(new JLabel("Sistema de Graduação", JLabel.CENTER), BorderLayout.CENTER);

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
        miMatricula.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Abre Cadastro de Matrícula");
            }
        });
        miCurso.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Abre Cadastro de Curso");
            }
        });
        miDepartamento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Abre Cadastro de Departamento");
                // Limpa o contentPane para remover os componentes existentes
                parentContainer.removeAll();
                // Adiciona o novo painel GuiCadastroDepartamentos
                GuiCadastroDepartamentos guiCadastroDepartamentos = new GuiCadastroDepartamentos();
                parentContainer.add(guiCadastroDepartamentos, BorderLayout.CENTER);
                // Revalida e repinta o contentPane para garantir que o novo painel seja mostrado
                parentContainer.revalidate();
                parentContainer.repaint();






            }
        });

        miMatriculados.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Abre Consulta de Matriculados");
            }
        });

    }
}