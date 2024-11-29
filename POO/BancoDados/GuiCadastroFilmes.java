package BancoDados;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class GuiCadastroFilmes extends JFrame {
    JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10;
    JButton btGravar, btAlterar, btExcluir, btNovo, btLocalizar, btCancelar, btSair;
    static JTextField tfCodigo, tfTitulo_pt,tfDiretor,tfAno,tfPais,tfTitulo_original, tfGenero, tfImdb, tfProdutora, tfDataCompra;
    private FilmesDAO filmes;

    public static void main(String[] args) {
        JFrame janela = new GuiCadastroFilmes();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }

    public GuiCadastroFilmes() {
        inicializarComponentes();
        definirEventos();
    }

    public void inicializarComponentes() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBounds(200, 200, 610, 300);
        setTitle("Cadastramento de Filmes");
        label1 = new JLabel("Código");
        label2 = new JLabel("Título");
        label3 = new JLabel("Diretor");
        label4 = new JLabel("Ano");
        label5 = new JLabel("País");
        label6 = new JLabel("Titulo Original");
        label7 = new JLabel("Genero");
        label8 = new JLabel("Imdb");
        label9 = new JLabel("Produtora");
        label10 = new JLabel("Data de Compra");
        tfCodigo = new JTextField(8);
        tfTitulo_pt = new JTextField(35);
        tfDiretor = new JTextField(35);
        tfAno = new JTextField(10);
        tfPais = new JTextField(10);
        tfTitulo_original = new JTextField(30);
        tfGenero = new JTextField(30);
        tfImdb = new JTextField(10);
        tfProdutora = new JTextField(25);
        tfDataCompra = new JTextField (8);
        //btGravar = new JButton(null, new Imagelcon("gravar.gif"));
        btGravar = new JButton("Gravar");
        btGravar.setToolTipText("Gravar");
        //btAlterar = new JButton(null, new Imagelcon("alterar.gif"));
        btAlterar = new JButton ("Alterar");
        btAlterar.setToolTipText("Alterar");
        //btExcluir = new JButton(null, new Imagelcon("excluir.gif"));
        btExcluir = new JButton("Excluir");
        btExcluir.setToolTipText("Excluir");
        //btLocalizar = new JButton(null, new Imagelcon("localizar.png"));
        btLocalizar = new JButton("Localizar");
        btLocalizar.setToolTipText("Localizar");
        //btNovo = new JButton(null, new Imagelcon("novo.gif"));
        btNovo = new JButton("Novo");
        btNovo.setToolTipText("Novo");
        //btCancelar = new JButton(null, new Imagelcon("cancelar.gif"));
        btCancelar = new JButton("Cancelar");
        btCancelar.setToolTipText("Cancelar");
        //btSair = new JButton(null, new Imagelcon("sair.png"));
        btSair = new JButton("Sair");
        btSair.setToolTipText("Sair");
        add(label1);
        add(tfCodigo);
        add(label2);
        add(tfTitulo_pt) ;
        add(label3);
        add(tfDiretor);
        add(label4);
        add(tfAno);
        add(label5);
        add(tfPais);
        add(label6);
        add(tfTitulo_original);
        add(label7);
        add(tfGenero) ;
        add(label8);
        add(tfImdb);
        add(label9);
        add(tfProdutora);
        add(label10);
        add(tfDataCompra);
        add(btNovo);
        add(btLocalizar);
        add(btGravar);
        add(btAlterar);
        add(btExcluir);
        add(btCancelar);
        add(btSair);
        setResizable(false);
        setBotoes(true, true, false, false, false,false);
        filmes = new FilmesDAO();
        if (!filmes.bd.getConnection()) {
            JOptionPane.showMessageDialog(null, "Falha na conexão, o sistema será fechado!");
            System.exit(0);
        }
    }

    public void definirEventos () {
        btSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                filmes.bd.close();
                System.exit(0);
            }
        });

        btNovo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limparCampos();
                setBotoes(false, false, true, false, false, true);
            }
        });

        btCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });

        btGravar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tfCodigo.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "O campo código não pode ser vazio!");
                    tfCodigo.requestFocus();
                    return;
                }
                if (tfTitulo_pt.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "O campo título não pode ser vazio!");
                    tfTitulo_pt.requestFocus();
                    return;
                }
                if (tfDiretor.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "O campo Diretor não pode ser vazio!");
                    tfTitulo_pt.requestFocus();
                    return;
                }
                if (tfAno.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "O campo Ano não pode ser vazio!");
                    tfAno.requestFocus();
                    return;
                }
                if (tfPais.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "O campo País não pode ser vazio!");
                    tfPais.requestFocus();
                    return;
                }
                if (tfTitulo_original.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "O campo Título Original não pode ser vazio!");
                    tfTitulo_original.requestFocus();
                    return;
                }

                if (tfGenero.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "O campo gênero não pode ser vazio!");
                    tfGenero.requestFocus();
                    return;
                }
                if (tfImdb.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "O campo Imdb não pode ser vazio!");
                    tfImdb.requestFocus();
                    return;
                }

                if (tfProdutora.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "O campo produtora não pode ser vazio!");
                    tfProdutora.requestFocus();
                    return;
                }
                if (tfDataCompra.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "O campo data de compra não pode ser vazio!");
                    tfDataCompra.requestFocus();
                    return;
                }
                filmes.filme.setCodigo(tfCodigo.getText());
                filmes.filme.setTitulo_pt(tfTitulo_pt.getText());
                filmes.filme.setDiretor(tfDiretor.getText());
                filmes.filme.setAno(tfAno.getText());
                filmes.filme.setPais(tfPais.getText());
                filmes.filme.setTitulo_original(tfTitulo_original.getText());
                filmes.filme.setGenero(tfGenero.getText());
                filmes.filme.setImbd(tfImdb.getText());
                filmes.filme.setProdutora(tfProdutora.getText());
                filmes.filme.setDataCompra(tfDataCompra.getText());
                JOptionPane.showMessageDialog(null, filmes.atualizar(FilmesDAO.INCLUSAO));
                limparCampos();
            }
        });

        btAlterar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                filmes.filme.setCodigo(tfCodigo.getText());
                filmes.filme.setTitulo_pt(tfTitulo_pt.getText());
                filmes.filme.setDiretor(tfDiretor.getText());
                filmes.filme.setAno(tfAno.getText());
                filmes.filme.setPais(tfPais.getText());
                filmes.filme.setTitulo_original(tfTitulo_original.getText());
                filmes.filme.setGenero(tfGenero.getText());
                filmes.filme.setImbd(tfImdb.getText());
                filmes.filme.setProdutora(tfProdutora.getText());
                filmes.filme.setDataCompra(tfDataCompra.getText());
                JOptionPane.showMessageDialog(null, filmes.atualizar(FilmesDAO.ALTERACAO));
                limparCampos();
            }
        });
        btExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                filmes.filme.setCodigo(tfCodigo.getText());
                filmes.localizar();
                int n = JOptionPane.showConfirmDialog(null, filmes.filme.getTitulo_pt(), " Excluir o Filme?",
                        JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, filmes.atualizar(FilmesDAO.EXCLUSAO));
                    limparCampos();
                }
            }
        });

        btLocalizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atualizarCampos();
            }
        });
    }

    public void limparCampos() {
        tfCodigo.setText("");
        tfTitulo_pt.setText("");
        tfDiretor.setText("");
        tfAno.setText("");
        tfPais.setText("");
        tfTitulo_original.setText("");
        tfGenero.setText("");
        tfImdb.setText("");
        tfProdutora.setText("");
        tfDataCompra.setText("");
        tfCodigo.requestFocus();
        setBotoes(true, true, false, false, false, false);
    }

    public void atualizarCampos() {
        filmes.filme.setCodigo(tfCodigo.getText());
        if (filmes.localizar()) {
            tfCodigo.setText(filmes.filme.getCodigo());
            tfTitulo_pt.setText(filmes.filme.getTitulo_pt());
            tfDiretor.setText(filmes.filme.getDiretor());
            tfAno.setText(filmes.filme.getAno());
            tfPais.setText(filmes.filme.getPais());
            tfTitulo_original.setText(filmes.filme.getTitulo_original());
            tfGenero.setText(filmes.filme.getGenero());
            tfImdb.setText(filmes.filme.getImbd());
            tfProdutora.setText(filmes.filme.getProdutora());
            tfDataCompra.setText (filmes.filme.getDataCompra ());
            setBotoes(true, true, false, true, true, true);
        } else {
            JOptionPane.showMessageDialog(null, "Filme não encontrado!");
            limparCampos();
        }
    }
    public void setBotoes(boolean bNovo, boolean bLocalizar, boolean bGravar, boolean bAlterar,
                          boolean bExcluir, boolean bCancelar) {
        btNovo.setEnabled(bNovo);
        btLocalizar.setEnabled(bLocalizar);
        btGravar.setEnabled(bGravar);
        btAlterar.setEnabled(bAlterar);
        btExcluir.setEnabled(bExcluir);
        btCancelar.setEnabled(bCancelar);
    }

}