import java.util.Scanner;

public class BEE1094 {
    public static void main(String agr[]) {
        Scanner s = new Scanner(System.in);

        int x, n, totalCobaias = 0, totalCoelhos = 0, totalRatos = 0, totalSapos = 0;
        double percentualR = 0, percentualS = 0, percentualC = 0;
        String animal;

        n = s.nextInt();

        for (int i = 1; i <= n; i++) {
            x = s.nextInt();
            animal = s.next();
            totalCobaias += x;

            if (animal.equals("C")) {
                totalCoelhos += x;
            } else if (animal.equals("R")) {
                totalRatos += x;
            } else if (animal.equals("S")) {
                totalSapos += x;
            }
            percentualR = (double) (totalRatos * 100) / totalCobaias;
            percentualS = (double) (totalSapos * 100) / totalCobaias;
            percentualC = (double) (totalCoelhos * 100) / totalCobaias;
        }

        System.out.println("Total: " + totalCobaias + " cobaias");
        System.out.println("Total de coelhos:  " + totalCoelhos);
        System.out.println("Total de ratos:  " + totalRatos);
        System.out.println("Total de sapos:  " + totalSapos);
        System.out.println(String.format("Percentual de coelhos: %.2f",  percentualC) + " %");
    	System.out.println(String.format("Percentual de ratos: %.2f",  percentualR) + " %");
    	System.out.println(String.format("Percentual de sapos: %.2f",  percentualS) + " %");
    }
}