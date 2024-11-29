package BancoDados;

import java.sql.*;
import javax.swing.*;

import BancoDados.Departamento.BD;

import java.awt.*;
import java.awt.event.*;
public class NavegaFilmes extends JFrame {
    private JLabel label1, label2, label3, label4, label5;
    private JButton btProximo, btAnterior, btPrimeiro, btUltimo, btMais1O, btMenos1O, btSair;
    private JTextField tfCodigo, tfTitulo, tfGenero, tfProdutora, tfDatcom;
    private BD bd;
    private PreparedStatement statement;
    private ResultSet resultSet;

    public static void main(String[] args) {
        JFrame frame = new NavegaFilmes();
        frame.setDefaultCloseOperation (JFrame. EXIT_ON_CLOSE);
        frame. setVisible (true);
    }

    public NavegaFilmes() {
        inicializarComponentes();
        definirEventos ();
    }

    public void inicializarComponentes() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        label1 = new JLabel("Código ");
        label2 = new JLabel("Titulo");
        label3 = new JLabel("Gênero");
        label4 = new JLabel("Produtora");
        label5 = new JLabel("Data de Compra ");
        tfCodigo = new JTextField(10);
        tfTitulo = new JTextField(100);
        tfGenero = new JTextField(10);
        tfProdutora = new JTextField(15);
        tfDatcom = new JTextField(8);
        //btProximo = new JButton(null, new Imagelcon("proximo.gif"));
        btProximo = new JButton("Próximo");
        btProximo.setToolTipText("Próximo");
        //btAnterior = new JButton(null, new Imagelcon("anterior.gif"));
        btAnterior = new JButton ("Anterior");
        btAnterior.setToolTipText("Anterior");
        //btPrimeiro = new JButton(null, new Imagelcon("primeiro.gif"))
        btPrimeiro = new JButton ("Primeiro");
        btPrimeiro.setToolTipText("Primeiro");
        //btUltimo = new JButton(null, new Imagelcon("ultimo.gif"));
        btUltimo = new JButton ("Último");
        btUltimo.setToolTipText("Ultimo");
        //btMais1O = new JButton(null, new Imagelcon("mais.png"));
        btMais1O = new JButton("+10");
        btMais1O.setToolTipText("+10");
        //btMenos1O = new JButton(null, new Imagelcon("menos.png"));
        btMenos1O = new JButton("-10");
        btMenos1O.setToolTipText("-10");
        //btSair = new JButton (null, new Imagelcon ("sair.png"));
        btSair = new JButton ("Sair");
        btSair.setToolTipText("Sair");
        add(label1);
        add(tfCodigo);
        add(label2);
        add(tfTitulo);
        add(label3);
        add(tfGenero);
        add(label4);
        add(tfProdutora);
        add(label5);
        add(tfDatcom);
        add(btPrimeiro);
        add(btAnterior);
        add(btProximo);
        add(btUltimo);
        add(btMais1O);
        add(btMenos1O);
        add(btSair);
        setTitle("Navegando na tabela de Filmes");
        setBounds(200, 400, 620, 200);
        setResizable(false);
        bd = new BD();
        if (!bd.getConnection()) {
            JOptionPane.showMessageDialog(null,"Falha ao conectar, o sistema será fechado!");
            System.exit(0);
        }
        carregarTabela();
        atualizarCampos();
    }
    public void definirEventos() {
        btProximo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    resultSet.next();
                    atualizarCampos();
                } catch (SQLException erro) {
                }
            }
        });
        btAnterior.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    resultSet.previous();
                    atualizarCampos();
                } catch (SQLException erro) {
                }
            }
        });
        btPrimeiro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    resultSet.first();
                    atualizarCampos();
                } catch (SQLException erro) {
                }
            }
        });
        btUltimo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    resultSet.last();
                    atualizarCampos();
                } catch (SQLException erro) {
                }
            }
        });

		btMais1O.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        resultSet.relative(10);
                        atualizarCampos();
                    } catch (SQLException erro) {
                    }
                }
        });

		btMenos1O.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        if (resultSet.getRow() > 10) {
                            resultSet.relative(-10);
                        } else {
                            resultSet.first();
                        }
                        atualizarCampos();
                    } catch (SQLException erro) {
                    }
                }
        });

		btSair.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        resultSet.close();
                        statement.close();
                    } catch (SQLException erro) {
                    }
                    bd.close() ;
                    System.exit(0);
                }
        });

    }
    public void carregarTabela() {
        String sql = "select * from filmes";
        try {
            statement = bd.connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro! " + erro.toString());
        }
    }
    public void atualizarCampos() {
        try {
            if (resultSet.isAfterLast()) {
                resultSet.last();
            }
            if (resultSet.isBeforeFirst()) {
                resultSet.first();
            }
            tfCodigo.setText(resultSet.getString("codigo"));
            tfTitulo.setText(resultSet.getString("titulo_pt"));
            tfGenero.setText(resultSet.getString("genero"));
            tfProdutora.setText(resultSet.getString("produtora"));
            tfDatcom.setText("" + resultSet.getDate("datacompra"));
        } catch (SQLException erro) {
        }
    }
}