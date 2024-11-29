package Atividades;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CadastroCurso extends JFrame {
    private JTextField codigoField, nomeField, cargaHorariaField;
    private JComboBox<String> tipoCursoBox, modalidadeBox;
    private JButton btConsultar, btGravar, btLimpar;

    public CadastroCurso() {
        setTitle("Cadastro de Curso");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);  

        JLabel codigoLabel = new JLabel("Código do Curso:");
        codigoLabel.setBounds(10, 20, 120, 25);
        add(codigoLabel);

        codigoField = new JTextField();
        codigoField.setBounds(140, 20, 200, 25);
        add(codigoField);

        JLabel nomeLabel = new JLabel("Nome do Curso:");
        nomeLabel.setBounds(10, 60, 120, 25);
        add(nomeLabel);

        nomeField = new JTextField();
        nomeField.setBounds(140, 60, 200, 25);
        add(nomeField);

        JLabel cargaHorariaLabel = new JLabel("Carga Horária:");
        cargaHorariaLabel.setBounds(10, 100, 120, 25);
        add(cargaHorariaLabel);

        cargaHorariaField = new JTextField();
        cargaHorariaField.setBounds(140, 100, 200, 25);
        add(cargaHorariaField);

        JLabel tipoCursoLabel = new JLabel("Tipo de Curso:");
        tipoCursoLabel.setBounds(10, 140, 120, 25);
        add(tipoCursoLabel);

        tipoCursoBox = new JComboBox<>(new String[]{"", "Extensão", "Graduação", "Pós-Graduação"});
        tipoCursoBox.setBounds(140, 140, 200, 25);
        add(tipoCursoBox);

        JLabel modalidadeLabel = new JLabel("Modalidade:");
        modalidadeLabel.setBounds(10, 180, 120, 25);
        add(modalidadeLabel);

        modalidadeBox = new JComboBox<>(new String[]{"", "Presencial", "EAD", "Presencial/EAD"});
        modalidadeBox.setBounds(140, 180, 200, 25);
        add(modalidadeBox);

        btConsultar = new JButton("Consultar");
        btConsultar.setBounds(30, 220, 100, 30);
        btGravar = new JButton("Gravar");
        btGravar.setBounds(140, 220, 100, 30);
        btLimpar = new JButton("Limpar");
        btLimpar.setBounds(250, 220, 100, 30);

        add(btConsultar);
        add(btGravar);
        add(btLimpar);

        btConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String codigo = JOptionPane.showInputDialog("Digite o código do curso:");
                JOptionPane.showMessageDialog(null, "Código digitado: " + codigo);
            }
        });

        btGravar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (codigoField.getText().isEmpty() || nomeField.getText().isEmpty() || cargaHorariaField.getText().isEmpty() ||
                        tipoCursoBox.getSelectedIndex() == 0 || modalidadeBox.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Todos os campos devem estar preenchidos!");
                    if (codigoField.getText().isEmpty()) codigoField.requestFocus();
                    else if (nomeField.getText().isEmpty()) nomeField.requestFocus();
                    else if (cargaHorariaField.getText().isEmpty()) cargaHorariaField.requestFocus();
                    else if (tipoCursoBox.getSelectedIndex() == 0) tipoCursoBox.requestFocus();
                    else modalidadeBox.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(null, "Curso cadastrado:\nCódigo: " + codigoField.getText() +
                            "\nNome: " + nomeField.getText() + "\nCarga Horária: " + cargaHorariaField.getText() +
                            "\nTipo de Curso: " + tipoCursoBox.getSelectedItem() + "\nModalidade: " + modalidadeBox.getSelectedItem());
                }
            }
        });

        btLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                codigoField.setText("");
                nomeField.setText("");
                cargaHorariaField.setText("");
                tipoCursoBox.setSelectedIndex(0);
                modalidadeBox.setSelectedIndex(0);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new CadastroCurso();
    }
}
