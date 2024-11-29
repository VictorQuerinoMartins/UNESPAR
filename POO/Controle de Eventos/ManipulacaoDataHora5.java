import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.text.DateFormat;
import java.util.Date;

public class ManipulacaoDataHora5 extends JFrame {
    private JTextArea taTexto;
    private JButton btMostrar;
    private Date agora;
    final long MILI_SEGUNDOS_POR_DIA = 1000 * 60 * 60 * 24;

    public static void main(String[] args) {
        JFrame janela = new ManipulacaoDataHora5();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }

    public ManipulacaoDataHora5(){
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
                DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
                Calendar calendario = Calendar.getInstance();
                calendario.setTime(agora);
                int hora = calendario.get(Calendar.HOUR_OF_DAY);
                int minuto = calendario.get(Calendar.MINUTE);
                int segundo = calendario.get(Calendar.SECOND);
                String men = "Boa Noite!";
                if(hora<6) men = "Boa Madrugada!";
                else if(hora<12) men = "Bom Dia!";
                else if(hora<18) men = "Boa Tarde!";
                taTexto.setText("Data Atual " + df.format(agora) +
                        "\nHora atual " + hora + "h:" + minuto + "m:" + segundo + "s" +
                        "\n" + men
                );



            }
        });
    }
}