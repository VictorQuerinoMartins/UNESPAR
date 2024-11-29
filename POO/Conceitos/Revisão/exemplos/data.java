package Revisão.exemplos;


import java.util.Locale;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.time.LocalDateTime;

public class data {

private static final Locale Brasil = null;

public static void main (String[] args){
// Olá, {nome}. Hoje é {dia da semana}, Bom dia.

String nome = "Victor";

    LocalDate hoje = LocalDate.now();

    String diaSemana =(hoje.getDayOfWeek().getDisplayName(TextStyle.FULL,Brasil));

    String saudacao;

    LocalDateTime agora = LocalDateTime.now();

    if(agora.getHour() >= 0 && agora.getHour() < 12){
        saudacao = "Bom dia";

    } else if(agora.getHour() >= 12 && agora.getHour() < 18){
        saudacao = "Boa Tarde";

    }else if(agora.getHour() >= 18 && agora.getHour() < 24){
        saudacao = "Boa Noite";
  } else{
    saudacao = "Olá.";
  }

  System.out.printf("Olá, %s. Hoje é %s, %s.", nome, diaSemana, saudacao.toUpperCase());
 }
}
