import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;

public class ManipulacaoDataHora extends JFrame {
    private JTextArea taTexto;
    private JButton btMostrar;
    private Date agora;
    final long MILI_SEGUNDOS_POR_DIA = 1000 * 60 * 60 * 24;

    public static void main(String[] args) {
        JFrame janela = new ManipulacaoDataHora();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }

    public ManipulacaoDataHora(){
        inicializarComponentes();
        definirEventos();
    }

    public void inicializarComponentes() {
        setTitle("Manipulação de Datas e Horas");
                setBounds(100,100,300,200);
        taTexto = new JTextArea();
        btMostrar = new JButton("Mostrar");
                add(taTexto,"Center");
                        add(btMostrar,"North");
        agora = new Date();
    }

    public void definirEventos() {
        btMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                long tempo = agora.getTime();
                Date novaData = new Date(agora.getTime() + (MILI_SEGUNDOS_POR_DIA * 10));
                taTexto.setText("Milisegundos desde 1970: " + tempo +
                        "\nDias: "	+ tempo / MILI_SEGUNDOS_POR_DIA +
                        "\nMeses: " + tempo / MILI_SEGUNDOS_POR_DIA / 30 +
                        "\nAnos: " + tempo / MILI_SEGUNDOS_POR_DIA / 365 +
                        "\nData: " + novaData);
            }
        });
    }
}
