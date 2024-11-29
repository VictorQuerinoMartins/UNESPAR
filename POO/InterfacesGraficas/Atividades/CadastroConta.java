package Atividades;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CadastroConta extends JFrame {
    private JTextField numeroField, titularField, saldoField;
    private JRadioButton contaCorrenteButton, poupancaButton;
    private JButton btConsulat, btGravar, btLimpar;
    private ButtonGroup tipoContaGroup;

    public CadastroConta() {
        setTitle("Cadastro de Conta");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);  

        JLabel numeroLabel = new JLabel("Número da Conta:");
        numeroLabel.setBounds(10, 20, 120, 25);
        add(numeroLabel);

        numeroField = new JTextField();
        numeroField.setBounds(140, 20, 200, 25);
        add(numeroField);

        JLabel titularLabel = new JLabel("Titular:");
        titularLabel.setBounds(10, 60, 120, 25);
        add(titularLabel);

        titularField = new JTextField();
        titularField.setBounds(140, 60, 200, 25);
        add(titularField);

        JLabel saldoLabel = new JLabel("Saldo:");
        saldoLabel.setBounds(10, 100, 120, 25);
        add(saldoLabel);

        saldoField = new JTextField();
        saldoField.setBounds(140, 100, 200, 25);
        add(saldoField);

        JLabel tipoContaLabel = new JLabel("Tipo de Conta:");
        tipoContaLabel.setBounds(10, 140, 120, 25);
        add(tipoContaLabel);

        contaCorrenteButton = new JRadioButton("Conta Corrente");
        poupancaButton = new JRadioButton("Poupança");
        tipoContaGroup = new ButtonGroup();
        tipoContaGroup.add(contaCorrenteButton);
        tipoContaGroup.add(poupancaButton);

        contaCorrenteButton.setBounds(140, 140, 120, 25);
        poupancaButton.setBounds(260, 140, 120, 25);

        add(contaCorrenteButton);
        add(poupancaButton);

        btConsulat = new JButton("Consultar");
        btConsulat.setBounds(30, 180, 100, 30);
        btGravar = new JButton("Gravar");
        btGravar.setBounds(140, 180, 100, 30);
        btLimpar = new JButton("Limpar");
        btLimpar.setBounds(250, 180, 100, 30);

        add(btConsulat);
        add(btGravar);
        add(btLimpar);

        btConsulat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String numero = JOptionPane.showInputDialog("Digite o número da conta:");
                JOptionPane.showMessageDialog(null, "Número digitado: " + numero);
            }
        });

        btGravar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (numeroField.getText().isEmpty() || titularField.getText().isEmpty() || saldoField.getText().isEmpty() ||
                        (!contaCorrenteButton.isSelected() && !poupancaButton.isSelected())) {
                    JOptionPane.showMessageDialog(null, "Todos os campos devem estar preenchidos!");
                    if (numeroField.getText().isEmpty()) numeroField.requestFocus();
                    else if (titularField.getText().isEmpty()) titularField.requestFocus();
                    else if (saldoField.getText().isEmpty()) saldoField.requestFocus();
                    else if (!contaCorrenteButton.isSelected() && !poupancaButton.isSelected()) contaCorrenteButton.requestFocus();
                } else {
                    String tipoConta = contaCorrenteButton.isSelected() ? "Conta Corrente" : "Poupança";
                    JOptionPane.showMessageDialog(null, "Conta cadastrada:\nNúmero: " + numeroField.getText() +
                            "\nTitular: " + titularField.getText() + "\nSaldo: " + saldoField.getText() +
                            "\nTipo: " + tipoConta);
                }
            }
        });

        btLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numeroField.setText("");
                titularField.setText("");
                saldoField.setText("");
                tipoContaGroup.clearSelection();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new CadastroConta();
    }
}
