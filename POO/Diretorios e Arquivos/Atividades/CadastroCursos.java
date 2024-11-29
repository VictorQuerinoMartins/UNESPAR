import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroCursos extends JFrame {
    private JTextField tfCodigo;
    private JTextField tfNomeCurso;
    private JTextField tfCargaHoraria;
    private JComboBox<String> cbTiposCurso;
    private JComboBox<String> cbModalidade;
    private JButton btnConsultar;
    private JButton btnGravar;
    private JButton btnLimpar;

    public CadastroCursos() {
        setTitle("Cadastro de Cursos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // Usar layout nulo para posição e tamanho fixos

        JLabel lblCodigo = new JLabel("Código:");
        JLabel lblNomeCurso = new JLabel("Nome do Curso:");
        JLabel lblCargaHoraria = new JLabel("Carga Horária:");
        JLabel lblTiposCurso = new JLabel("Tipos de Cursos:");
        JLabel lblModalidade = new JLabel("Modalidade:");

        tfCodigo = new JTextField();
        tfNomeCurso = new JTextField();
        tfCargaHoraria = new JTextField();

        cbTiposCurso = new JComboBox<>(new String[]{"", "Extensão", "Graduação", "Pós-Graduação"});
        cbModalidade = new JComboBox<>(new String[]{"", "Presencial", "EAD", "Presencial/EAD"});

        btnConsultar = new JButton("Consultar");
        btnGravar = new JButton("Gravar");
        btnLimpar = new JButton("Limpar");

        // Definir tamanhos e posições fixas dos componentes
        lblCodigo.setBounds(20, 20, 100, 25);
        tfCodigo.setBounds(120, 20, 240, 25);
        lblNomeCurso.setBounds(20, 60, 100, 25);
        tfNomeCurso.setBounds(120, 60, 240, 25);
        lblCargaHoraria.setBounds(20, 100, 100, 25);
        tfCargaHoraria.setBounds(120, 100, 240, 25);

        lblTiposCurso.setBounds(20, 140, 100, 25);
        cbTiposCurso.setBounds(120, 140, 240, 25);
        lblModalidade.setBounds(20, 180, 100, 25);
        cbModalidade.setBounds(120, 180, 240, 25);

        btnConsultar.setBounds(20, 220, 100, 25);
        btnGravar.setBounds(140, 220, 100, 25);
        btnLimpar.setBounds(260, 220, 100, 25);

        // Adicionar componentes ao frame
        add(lblCodigo);
        add(tfCodigo);
        add(lblNomeCurso);
        add(tfNomeCurso);
        add(lblCargaHoraria);
        add(tfCargaHoraria);
        add(lblTiposCurso);
        add(cbTiposCurso);
        add(lblModalidade);
        add(cbModalidade);
        add(btnConsultar);
        add(btnGravar);
        add(btnLimpar);

        // Adicionar ações aos botões
        btnConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String codigo = tfCodigo.getText();
                JOptionPane.showMessageDialog(null, "Consultar curso com código: " + codigo);
            }
        });

        btnGravar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tfCodigo.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo Código é obrigatório");
                    tfCodigo.requestFocus();
                } else if (tfNomeCurso.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo Nome do Curso é obrigatório");
                    tfNomeCurso.requestFocus();
                } else if (tfCargaHoraria.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo Carga Horária é obrigatório");
                    tfCargaHoraria.requestFocus();
                } else if (cbTiposCurso.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Selecione um Tipo de Curso");
                    cbTiposCurso.requestFocus();
                } else if (cbModalidade.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Selecione uma Modalidade");
                    cbModalidade.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(null, "Curso salvo: \n" +
                            "Código: " + tfCodigo.getText() + "\n" +
                            "Nome do Curso: " + tfNomeCurso.getText() + "\n" +
                            "Carga Horária: " + tfCargaHoraria.getText() + "\n" +
                            "Tipo de Curso: " + cbTiposCurso.getSelectedItem() + "\n" +
                            "Modalidade: " + cbModalidade.getSelectedItem());
                }
            }
        });

        btnLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tfCodigo.setText("");
                tfNomeCurso.setText("");
                tfCargaHoraria.setText("");
                cbTiposCurso.setSelectedIndex(0);
                cbModalidade.setSelectedIndex(0);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CadastroCursos().setVisible(true);
            }
        });
    }
}
