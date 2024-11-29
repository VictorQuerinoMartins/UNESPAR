package Revisão.Treino.Car;

import javax.swing.*;

public class CarroTestar {
    public static void main(String[] args) {
        
      
        Carro c1 = new Carro();

        c1.nome = JOptionPane.showInputDialog(null, "Insira o nome do carro", "");
        c1.marca = JOptionPane.showInputDialog(null, "Insira a marca do carro", "");
        c1.ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o ano do carro", ""));
        c1.velocidade = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira a velocidade do carro", ""));


       String opcao = JOptionPane.showInputDialog( null, "Voce deseja: \n Acelerar(1) \n Freiar(2) \n Buzinar(3)");

       switch (Integer.parseInt(opcao)) {
        case 1:
            c1.acelerar(10);
            JOptionPane.showMessageDialog(null, "Velocidade atual: " + c1.velocidade);
                break;
       case 2: 
            c1.frear(20);
            JOptionPane.showMessageDialog(null, "Velocidade atual: " + c1.velocidade);
                break;

        case 3:
            c1.buzinar();
                break;

        default:
            JOptionPane.showMessageDialog(null, "Opção inválida");
            break;
       }
    }
}
