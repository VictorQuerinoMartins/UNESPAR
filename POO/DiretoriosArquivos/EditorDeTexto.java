import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
public final class EditorDeTexto extends JFrame {
    private JLabel label1, label2;
    private JButton btGravar, btAbrir, btLimpar;
    private JTextField tfTexto;
    private TextArea taTexto;
    private FileDialog fdAbrir, fdSalvar;
    private String nome_do_arquivo;

    public static void main(String[] args) {
        JFrame frame = new EditorDeTexto();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public EditorDeTexto() {
        inicializarComponentes();
        definirEventos();
    }

    public void inicializarComponentes() {
        setTitle("Simples Editor de Texto");
        setLayout(null);
        setBounds(250, 50, 500, 300);
        setResizable(false);
        label1 = new JLabel("Texto a ser editado:");
        label1.setBounds(5, 5, 200, 20);
        label2 = new JLabel("Status:");
        label2.setBounds(5, 240, 200, 20);
        btGravar = new JButton("Gravar");
        btGravar.setBounds(200, 210, 100, 25);
        btAbrir = new JButton("Abrir");
        btAbrir.setBounds(80, 210, 100, 25);
        btLimpar = new JButton("Limpar");
        btLimpar.setBounds(320, 210, 100, 25);
        tfTexto = new JTextField();
        tfTexto.setBounds(50, 240, 430, 20);
        tfTexto.setEditable(false);
        taTexto = new TextArea();
        taTexto.setBounds(5, 25, 480, 180);
        fdAbrir = new FileDialog(this, "Abrir arquivo", FileDialog.LOAD);
        fdSalvar = new FileDialog(this, "Salvar arquivo", FileDialog.SAVE);
        add(label1);
        add(label2);
        add(tfTexto);
        add(taTexto);
        add(btGravar);
        add(btAbrir);
        add(btLimpar);
    }


    public void definirEventos () {

        btLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                taTexto.setText ("");
                tfTexto.setText ("");
            }
        });

        btGravar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    fdSalvar.setVisible(true);
                    if (fdSalvar.getFile() == null) {
                        return;
                    }
                    nome_do_arquivo = fdSalvar.getDirectory() + fdSalvar.getFile();
                    FileWriter out = new FileWriter(nome_do_arquivo);
                    out.write(taTexto.getText());
                    out.close();
                    tfTexto.setText("Arquivo gravado com sucesso !");
                } catch (IOException erro) {
                    tfTexto.setText("Erro ao gravar no arquivo! " + erro.toString());
                }
            }
        });

        btAbrir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    fdAbrir.setVisible(true);
                    if (fdAbrir.getFile() == null) {
                        return;
                    }
                    nome_do_arquivo = fdAbrir.getDirectory() + fdAbrir.getFile();
                    FileReader in = new FileReader(nome_do_arquivo);
                    String s = "";
                    int i = in.read();
                    while (i != -1) {
                        s = s+ (char) i;
                        i = in.read();
                    }
                    taTexto.setText(s);
                    in.close();
                    tfTexto.setText("Arquivo aberto com sucesso !");
                } catch (IOException erro) {
                    tfTexto.setText("Erro ao abrir o arquivo! " + erro.toString());
                }
            }
        });
    }

}