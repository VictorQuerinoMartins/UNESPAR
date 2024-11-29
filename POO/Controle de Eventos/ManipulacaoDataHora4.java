import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ManipulacaoDataHora4 extends JFrame {
    private JTextArea taTexto;
    private JButton btMostrar;
    private Date agora;
    final long MILI_SEGUNDOS_POR_DIA = 1000 * 60 * 60 * 24;

    public static void main(String[] args) {
        JFrame janela = new ManipulacaoDataHora4();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }

    public ManipulacaoDataHora4(){
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
                Calendar calendario = Calendar.getInstance();
                calendario.setTime(agora);
                int dia = calendario.get(Calendar.DATE);
                int mes = calendario.get(Calendar.MONTH) + 1; // Adicionar 1 (os meses começam do zero)
                int ano = calendario.get(Calendar.YEAR);
                int hora = calendario.get (Calendar.HOUR_OF_DAY);
                int minuto = calendario.get(Calendar.MINUTE);
                int segundo = calendario.get(Calendar.SECOND);
                int diaDaSemana = calendario.get(Calendar.DAY_OF_WEEK);
                String semana = "";
                if (diaDaSemana == Calendar.SATURDAY || diaDaSemana == Calendar.SUNDAY)
                    semana = "Fim de Semana";
                else
                    semana = "Dia util";
                taTexto.setText("Dia = " + dia +
                        "\nMes = " + mes +
                        "\nAno - " + ano +
                        "\nHora = " + hora +
                        "\nMinuto = " + minuto +
                        "\nSegundo = " + segundo +
                        "\nDia da semana = " + diaDaSemana +
                        "\n" + semana
                );

            }
        });
    }
}