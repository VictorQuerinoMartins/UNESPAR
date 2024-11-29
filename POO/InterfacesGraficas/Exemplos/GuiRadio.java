package Exemplos;
import java.awt.event.*;
import javax.swing.*;
public class GuiRadio extends JPanel {
    private JLabel lbSexo;
    private JButton btVerificar;
    private JRadioButton rbMasculino, rbFeminino;
    private ButtonGroup buttonGroup;

    public GuiRadio() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(null);
        btVerificar = new JButton("Verificar");
        rbMasculino = new JRadioButton("Masculino");
        lbSexo = new JLabel("Selecione o sexo:");
        rbFeminino = new JRadioButton("Feminino");
        buttonGroup = new ButtonGroup();
        buttonGroup.add(rbMasculino);
        buttonGroup.add(rbFeminino);
        btVerificar.setBounds(55, 105, 100, 20);
        rbMasculino.setBounds(55, 45, 100, 25);
        lbSexo.setBounds(55, 10, 105, 30);
        rbFeminino.setBounds(55, 70, 100, 25);
        rbMasculino.setSelected(true);
        add(btVerificar);
        add(rbMasculino);
        add(lbSexo);
        add(rbFeminino);
    }

    private void definirEventos() {
        btVerificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent argO) {
                if (rbMasculino.isSelected()) {
                    JOptionPane.showMessageDialog (null, "Masculino selecionado");
                } else if (rbFeminino.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Feminino selecionado");
                }
            }
        });
    }
}