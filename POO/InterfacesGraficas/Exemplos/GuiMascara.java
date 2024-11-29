package Exemplos;
import java.awt.event.*;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

public class GuiMascara extends JPanel {
    private JLabel lbCpf, lbCnpj, lbTel, lbCep;
    private JFormattedTextField tfCpf, tfCnpj, tfTel, tfCep;
    private MaskFormatter msCpf, msCnpj, msTel, msCep;
    private JButton btMostrar;

    public GuiMascara() {
        inicializarComponentes();
        definirEventos();
    }
    public void inicializarComponentes() {
        try {
            msCpf = new MaskFormatter("###.###.###-##");
            msCnpj = new MaskFormatter ("##.###.###/####-##");
            msTel = new MaskFormatter ("(##) #####-####");
            msCep = new MaskFormatter("##.###-###");
            setBounds(0, 0, 250, 220);
            setLayout(null);

            lbCpf = new JLabel("CPF:");
            lbCpf.setBounds(15, 20, 100, 20);
            tfCpf = new JFormattedTextField(msCpf);
            tfCpf.setBounds(50, 20, 100, 20);

            lbCnpj = new JLabel("CNPJ:");
            lbCnpj.setBounds(15, 50, 100, 20);
            tfCnpj = new JFormattedTextField(msCnpj);
            tfCnpj.setBounds(50, 50, 150, 20);

            lbTel = new JLabel("TEL:");
            lbTel.setBounds(15, 80, 100, 20);
            tfTel = new JFormattedTextField(msTel);
            tfTel.setBounds(50, 80, 100, 20);

            lbCep = new JLabel("CEP:");
            lbCep.setBounds(15, 110, 100, 20);
            tfCep = new JFormattedTextField(msCep);
            tfCep.setBounds(50, 110, 100, 20);

            btMostrar = new JButton("Mostrar");
            btMostrar.setBounds(15, 140, 100, 22);


            add(lbCnpj);
            add(tfCnpj);
            add(lbTel);
            add(tfTel);
            add(lbCep);
            add(tfCep);
            add(lbCpf);
            add(tfCpf);
            add(btMostrar);
        } catch (ParseException erro) {
            erro.printStackTrace();
        }
    }

    public void definirEventos() {
        btMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        tfCpf.getText() + "\n" + tfCnpj.getText() + "\n" +
                                tfTel.getText() + "\n" + tfCep.getText());
                JOptionPane.showMessageDialog(null, tfCpf.getValue());
                String cnpjSoNumeros = tfCnpj.getText();
                cnpjSoNumeros = cnpjSoNumeros.replace(".", "");
                cnpjSoNumeros = cnpjSoNumeros.replace("/", "");
                cnpjSoNumeros = cnpjSoNumeros.replace("-", "");
                JOptionPane.showMessageDialog(null, cnpjSoNumeros);
            }
        });
    }
}