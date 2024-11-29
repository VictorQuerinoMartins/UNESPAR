import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroProduto extends JFrame {
    private JTextField tfCodigo;
    private JTextField tfDescricao;
    private JTextField tfPreco;
    private JButton btnConsultar;
    private JButton btnGravar;
    private JButton btnLimpar;

    public CadastroProduto() {
        setTitle("Cadastro de Produto");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // Usar layout nulo para posição e tamanho fixos

        JLabel lblCodigo = new JLabel("Codigo:");
        JLabel lblDescricao = new JLabel("Descr.:");
        JLabel lblPreco = new JLabel("Preço:");

        tfCodigo = new JTextField();
        tfDescricao = new JTextField();
        tfPreco = new JTextField();

        btnConsultar = new JButton("Consultar");
        btnGravar = new JButton("Gravar");
        btnLimpar = new JButton("Limpar");

        // Definir tamanhos e posições fixas dos componentes
        lblCodigo.setBounds(20, 20, 50, 25);
        tfCodigo.setBounds(80, 20, 180, 25);
        lblDescricao.setBounds(20, 60, 50, 25);
        tfDescricao.setBounds(80, 60, 180, 25);
        lblPreco.setBounds(20, 100, 50, 25);
        tfPreco.setBounds(80, 100, 180, 25);

        btnConsultar.setBounds(20, 140, 80, 25);
        btnGravar.setBounds(110, 140, 80, 25);
        btnLimpar.setBounds(200, 140, 80, 25);

        // Adicionar componentes ao frame
        add(lblCodigo);
        add(tfCodigo);
        add(lblDescricao);
        add(tfDescricao);
        add(lblPreco);
        add(tfPreco);
        add(btnConsultar);
        add(btnGravar);
        add(btnLimpar);

        // Adicionar ações aos botões
        btnConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String codigo = tfCodigo.getText();
                JOptionPane.showMessageDialog(null, "Consultar produto com código: " + codigo);
            }
        });

        btnGravar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tfCodigo.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo Código é obrigatório");
                    tfCodigo.requestFocus();
                } else if (tfDescricao.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo Descrição é obrigatório");
                    tfDescricao.requestFocus();
                } else if (tfPreco.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo Preço é obrigatório");
                    tfPreco.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(null, "Produto salvo: \n" +
                            "Código: " + tfCodigo.getText() + "\n" +
                            "Descrição: " + tfDescricao.getText() + "\n" +
                            "Preço: " + tfPreco.getText());
                }
            }
        });

        btnLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tfCodigo.setText("");
                tfDescricao.setText("");
                tfPreco.setText("");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CadastroProduto().setVisible(true);
            }
        });
    }
}
