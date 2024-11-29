package Atividades;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CadastroProduto extends JFrame {
    private JTextField codigoField, descricaoField, precoField;
    private JButton btConsultar, btGravar, btLimpar;

    public CadastroProduto() {
        setTitle("Cadastro de Produto");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);  

        JLabel codigoLabel = new JLabel("Código do Produto:");
        codigoLabel.setBounds(10, 20, 120, 25);
        add(codigoLabel);

        codigoField = new JTextField();
        codigoField.setBounds(140, 20, 200, 25);
        add(codigoField);

        JLabel descricaoLabel = new JLabel("Descrição do Produto:");
        descricaoLabel.setBounds(10, 60, 120, 25);
        add(descricaoLabel);

        descricaoField = new JTextField();
        descricaoField.setBounds(140, 60, 200, 25);
        add(descricaoField);

        JLabel precoLabel = new JLabel("Preço:");
        precoLabel.setBounds(10, 100, 120, 25);
        add(precoLabel);

        precoField = new JTextField();
        precoField.setBounds(140, 100, 200, 25);
        add(precoField);

        btConsultar = new JButton("Consultar");
        btConsultar.setBounds(30, 150, 100, 30);
        btGravar = new JButton("Gravar");
        btGravar.setBounds(140, 150, 100, 30);
        btLimpar = new JButton("Limpar");
        btLimpar.setBounds(250, 150, 100, 30);

        add(btConsultar);
        add(btGravar);
        add(btLimpar);

        btConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String codigo = JOptionPane.showInputDialog("Digite o código do produto:");
                JOptionPane.showMessageDialog(null, "Código digitado: " + codigo);
            }
        });

        btGravar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (codigoField.getText().isEmpty() || descricaoField.getText().isEmpty() || precoField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos os campos devem estar preenchidos!");
                    if (codigoField.getText().isEmpty()) codigoField.requestFocus();
                    else if (descricaoField.getText().isEmpty()) descricaoField.requestFocus();
                    else precoField.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(null, "Produto cadastrado:\nCódigo: " + codigoField.getText() +
                            "\nDescrição: " + descricaoField.getText() + "\nPreço: " + precoField.getText());
                }
            }
        });

        btLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                codigoField.setText("");
                descricaoField.setText("");
                precoField.setText("");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new CadastroProduto();
    }
}
