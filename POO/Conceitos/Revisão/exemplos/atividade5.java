package Revisão.exemplos;

import java.util.Scanner;

public class atividade5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a os pontos do lider: ");
        int pts = sc.nextInt();

        System.out.println("Digite os pontos do time lanterna: ");
        int ptsL = sc.nextInt();

        int difPts = pts - ptsL;
        int Vtnecss = difPts / 3;

        System.out.println("Numero de vitórias necessarias para o time lanterna alcançar o lider eh: " + Vtnecss);

        sc.close();
    }
}

