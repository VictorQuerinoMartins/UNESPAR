package BancoDados;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class GuiCadastroFilmess extends JFrame {

    // Componentes da interface
    private JTextField txtCodigo, txtTitulo, txtAno, txtDiretor, txtPais, txtTituloOriginal, txtImdb, txtGenero, txtProdutora, txtDataCompra;
    private JButton btnNovo, btnLocalizar, btnGravar, btnAlterar, btnExcluir, btnCancelar, btnSair;

    // Referência para a camada de dados
    private FilmesDAO filmesDAO;

    public GuiCadastroFilmes() {
        inicializarComponentes();
        definirEventos();
        
        // Inicializa a classe DAO para operações de BD
        filmesDAO = new FilmesDAO();
    }

    private void inicializarComponentes() {
        setTitle("Cadastramento de Filmes");
        setLayout(new GridLayout(12, 2));

        // Criação dos componentes da interface
        add(new JLabel("Código:"));
        txtCodigo = new JTextField(10);
        add(txtCodigo);

        add(new JLabel("Título:"));
        txtTitulo = new JTextField(40);
        add(txtTitulo);

        add(new JLabel("Ano:"));
        txtAno = new JTextField(10);
        add(txtAno);

        add(new JLabel("Diretor:"));
        txtDiretor = new JTextField(30);
        add(txtDiretor);

        add(new JLabel("País:"));
        txtPais = new JTextField(30);
        add(txtPais);

        add(new JLabel("Título Original:"));
        txtTituloOriginal = new JTextField(40);
        add(txtTituloOriginal);

        add(new JLabel("Imdb:"));
        txtImdb = new JTextField(10);
        add(txtImdb);

        add(new JLabel("Gênero:"));
        txtGenero = new JTextField(20);
        add(txtGenero);

        add(new JLabel("Produtora:"));
        txtProdutora = new JTextField(30);
        add(txtProdutora);

        add(new JLabel("Data de Compra:"));
        txtDataCompra = new JTextField(10);
        add(txtDataCompra);

        // Criação dos botões
        btnNovo = new JButton("Novo");
        btnLocalizar = new JButton("Localizar");
        btnGravar = new JButton("Gravar");
        btnAlterar = new JButton("Alterar");
        btnExcluir = new JButton("Excluir");
        btnCancelar = new JButton("Cancelar");
        btnSair = new JButton("Sair");

        add(btnNovo);
        add(btnLocalizar);
        add(btnGravar);
        add(btnAlterar);
        add(btnExcluir);
        add(btnCancelar);
        add(btnSair);

        setSize(600, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void definirEventos() {
        // Ação do botão Sair
        btnSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Ação do botão Novo
        btnNovo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });

        // Ação do botão Gravar
        btnGravar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Filmes filme = new Filmes();
                    filme.setCodigo(Integer.parseInt(txtCodigo.getText()));
                    filme.setTitulo(txtTitulo.getText());
                    filme.setAno(Integer.parseInt(txtAno.getText()));
                    filme.setDiretor(txtDiretor.getText());
                    filme.setPais(txtPais.getText());
                    filme.setTituloOriginal(txtTituloOriginal.getText());
                    filme.setImdb(Double.parseDouble(txtImdb.getText()));
                    filme.setGenero(txtGenero.getText());
                    filme.setProdutora(txtProdutora.getText());
                    filme.setDataCompra(txtDataCompra.getText());

                    filmesDAO.inserir(filme);
                    JOptionPane.showMessageDialog(null, "Filme gravado com sucesso!");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao gravar filme: " + ex.getMessage());
                }
            }
        });

        // Ação do botão Localizar
        btnLocalizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do filme:"));
                    Filmes filme = filmesDAO.localizar(codigo);
                    if (filme != null) {
                        preencherCampos(filme);
                    } else {
                        JOptionPane.showMessageDialog(null, "Filme não encontrado!");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao localizar filme: " + ex.getMessage());
                }
            }
        });

        // Ação do botão Alterar
        btnAlterar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Filmes filme = new Filmes();
                    filme.setCodigo(Integer.parseInt(txtCodigo.getText()));
                    filme.setTitulo(txtTitulo.getText());
                    filme.setAno(Integer.parseInt(txtAno.getText()));
                    filme.setDiretor(txtDiretor.getText());
                    filme.setPais(txtPais.getText());
                    filme.setTituloOriginal(txtTituloOriginal.getText());
                    filme.setImdb(Double.parseDouble(txtImdb.getText()));
                    filme.setGenero(txtGenero.getText());
                    filme.setProdutora(txtProdutora.getText());
                    filme.setDataCompra(txtDataCompra.getText());

                    filmesDAO.alterar(filme);
                    JOptionPane.showMessageDialog(null, "Filme alterado com sucesso!");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao alterar filme: " + ex.getMessage());
                }
            }
        });

        // Ação do botão Excluir
        btnExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int codigo = Integer.parseInt(txtCodigo.getText());
                    filmesDAO.excluir(codigo);
                    JOptionPane.showMessageDialog(null, "Filme excluído com sucesso!");
                    limparCampos();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao excluir filme: " + ex.getMessage());
                }
            }
        });

        // Ação do botão Cancelar
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });
    }

    // Limpa os campos do formulário
    private void limparCampos() {
        txtCodigo.setText("");
        txtTitulo.setText("");
        txtAno.setText("");
        txtDiretor.setText("");
        txtPais.setText("");
        txtTituloOriginal.setText("");
        txtImdb.setText("");
        txtGenero.setText("");
        txtProdutora.setText("");
        txtDataCompra.setText("");
    }

    // Preenche os campos do formulário com os dados do filme
    private void preencherCampos(Filmes filme) {
        txtCodigo.setText(String.valueOf(filme.getCodigo()));
        txtTitulo.setText(filme.getTitulo());
        txtAno.setText(String.valueOf(filme.getAno()));
        txtDiretor.setText(filme.getDiretor());
        txtPais.setText(filme.getPais());
        txtTituloOriginal.setText(filme.getTituloOriginal());
        txtImdb.setText(String.valueOf(filme.getImdb()));
        txtGenero.setText(filme.getGenero());
        txtProdutora.setText(filme.getProdutora());
        txtDataCompra.setText(filme.getDataCompra());
    }

    public static void main(String[] args) {
        new GuiCadastroFilmes();
    }
}
