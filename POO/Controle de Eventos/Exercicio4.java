import javax.swing.*;
import java.time.LocalDateTime;
import java.time.DayOfWeek;

public class Exercicio4 {
    public static void main(String[] args) {
        LocalDateTime agora = LocalDateTime.now();
        DayOfWeek diaSemana = agora.getDayOfWeek();
        int hora = agora.getHour();

        String mensagem;

        if (diaSemana != DayOfWeek.SATURDAY && diaSemana != DayOfWeek.SUNDAY && hora >= 8 && hora < 17) {
            mensagem = "Estamos Atendendo";
        } else {
            mensagem = "Expediente Encerrado";
        }

        String diaSemanaNome = diaSemana.name().substring(0, 1).toUpperCase() + diaSemana.name().substring(1).toLowerCase();
        String mensagemFinal = diaSemanaNome + " - " + hora + "h - " + mensagem;

        JOptionPane.showMessageDialog(null, mensagemFinal, "Mensagem", JOptionPane.INFORMATION_MESSAGE);
    }
}
