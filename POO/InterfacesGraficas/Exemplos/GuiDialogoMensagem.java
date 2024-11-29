package Exemplos;

import java.awt.event.*;
import javax.swing.*;
public class GuiDialogoMensagem extends JPanel {
    private ImageIcon imageIcon1;
    private JComboBox cbCaixas;

    public GuiDialogoMensagem() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(null);
        String path = "estrela.gif";
        imageIcon1 = new ImageIcon(getClass().getResource(path));
        String[] cbCaixasItens = {"Pergunta", "Informação", "Alerta", "Erro", "definida pelo usuário", "Somente Mensagem"};
        cbCaixas = new JComboBox(cbCaixasItens);
        cbCaixas.setBounds(25, 40, 150, 25);
        add(cbCaixas) ;
    }


    private void definirEventos() {
        cbCaixas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch (cbCaixas.getSelectedIndex() ) {
                    case 0:
                        JOptionPane.showMessageDialog(null, "Estou aprendendo Java? ", "Pergunta", JOptionPane.QUESTION_MESSAGE);
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(null, "Gravação 0K. ", "Informacao", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 2:
                        JOptionPane.showMessageDialog (null, "Cuidado!", "Alerta", JOptionPane.WARNING_MESSAGE);
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Ocorreu algum erro!", "Erro", JOptionPane.ERROR_MESSAGE);
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, "Usando um gif animado", "Personalizado", JOptionPane.INFORMATION_MESSAGE, imageIcon1) ;
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "Caixa de mensagem simples", "Somente mensagem", JOptionPane.PLAIN_MESSAGE);
                        break;
                }
            }
        });
    }
}