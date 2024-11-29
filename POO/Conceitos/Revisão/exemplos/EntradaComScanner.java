package Revisão.exemplos;
import java.util.*;
public class EntradaComScanner {
    public static void main(String []args) {
        float largura, comprimento, area, perimetro;
        Scanner sc;//criar nome pro scanner
        try {
            System.out.println("Entre com o comprimento");
            sc = new Scanner(System.in);
            comprimento = sc.nextFloat();
            
            System.out.println("Entre com a largura");
            largura = sc.nextFloat();
            
            area = comprimento * largura;
            perimetro = comprimento * 2 + largura * 2;
            System.out.println("Area do retangulo: " + area);
            System.out.println("Perimetro do retangulo: " + perimetro);
            
        } catch (NumberFormatException e) {
            System.out.println("Houve erro na conversao, digite apenas caracteres numericos");
        }
    }
}