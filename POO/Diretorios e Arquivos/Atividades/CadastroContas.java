import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroContas extends JFrame {
    private JTextField tfNumeroConta;
    private JTextField tfTitular;
    private JTextField tfSaldo;
    private JRadioButton rbContaCorrente;
    private JRadioButton rbPoupanca;
    private ButtonGroup tipoContaGroup;
    private JButton btnConsultar;
    private JButton btnGravar;
    private JButton btnLimpar;

    public CadastroContas() {
        setTitle("Cadastro de Contas");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // Usar layout nulo para posição e tamanho fixos

        JLabel lblNumeroConta = new JLabel("Nr. Conta");
        JLabel lblTitular = new JLabel("Titular");
        JLabel lblSaldo = new JLabel("Saldo");
        JLabel lblTipoConta = new JLabel("Selecione o Tipo de Conta:");

        tfNumeroConta = new JTextField();
        tfTitular = new JTextField();
        tfSaldo = new JTextField();

        rbContaCorrente = new JRadioButton("Conta Corrente", true);
        rbPoupanca = new JRadioButton("Poupança");
        tipoContaGroup = new ButtonGroup();
        tipoContaGroup.add(rbContaCorrente);
        tipoContaGroup.add(rbPoupanca);

        btnConsultar = new JButton("Consultar");
        btnGravar = new JButton("Gravar");
        btnLimpar = new JButton("Limpar");

        // Definir tamanhos e posições fixas dos componentes
        lblNumeroConta.setBounds(20, 20, 100, 25);
        tfNumeroConta.setBounds(120, 20, 240, 25);
        lblTitular.setBounds(20, 60, 100, 25);
        tfTitular.setBounds(120, 60, 240, 25);
        lblSaldo.setBounds(20, 100, 100, 25);
        tfSaldo.setBounds(120, 100, 240, 25);

        lblTipoConta.setBounds(20, 140, 200, 25);
        rbContaCorrente.setBounds(20, 170, 150, 25);
        rbPoupanca.setBounds(180, 170, 100, 25);

        btnConsultar.setBounds(20, 200, 100, 25);
        btnGravar.setBounds(140, 200, 100, 25);
        btnLimpar.setBounds(260, 200, 100, 25);

        // Adicionar componentes ao frame
        add(lblNumeroConta);
        add(tfNumeroConta);
        add(lblTitular);
        add(tfTitular);
        add(lblSaldo);
        add(tfSaldo);
        add(lblTipoConta);
        add(rbContaCorrente);
        add(rbPoupanca);
        add(btnConsultar);
        add(btnGravar);
        add(btnLimpar);

        // Adicionar ações aos botões
        btnConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String numeroConta = tfNumeroConta.getText();
                JOptionPane.showMessageDialog(null, "Consultar conta com número: " + numeroConta);
            }
        });

        btnGravar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tfNumeroConta.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo Número da Conta é obrigatório");
                    tfNumeroConta.requestFocus();
                } else if (tfTitular.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo Titular é obrigatório");
                    tfTitular.requestFocus();
                } else if (tfSaldo.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo Saldo é obrigatório");
                    tfSaldo.requestFocus();
                } else {
                    String tipoConta = rbContaCorrente.isSelected() ? "Conta Corrente" : "Poupança";
                    JOptionPane.showMessageDialog(null, "Conta salva: \n" +
                            "Número da Conta: " + tfNumeroConta.getText() + "\n" +
                            "Titular: " + tfTitular.getText() + "\n" +
                            "Saldo: " + tfSaldo.getText() + "\n" +
                            "Tipo de Conta: " + tipoConta);
                }
            }
        });

        btnLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tfNumeroConta.setText("");
                tfTitular.setText("");
                tfSaldo.setText("");
                rbContaCorrente.setSelected(true); // Voltar para valor padrão
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CadastroContas().setVisible(true);
            }
        });
    }
}
