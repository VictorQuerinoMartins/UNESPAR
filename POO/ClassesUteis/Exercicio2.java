import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("a: ");
        double a = sc.nextDouble();
        System.out.print("b: ");
        double b = sc.nextDouble();
        System.out.print("c: ");
        double c = sc.nextDouble();

        double x = Math.pow(a, 2) + Math.pow(b, 2);
        System.out.println("x = a² + b² = " + x);

        double d = Math.pow(b, 2) - 4 * a * c;
        if (d < 0) {
            System.out.println("D = " + d + " (negativo): não existe raiz real.");
        } else {
            double xPositivo = (-b + Math.sqrt(d)) / (2 * a);
            System.out.println("D = " + d);
            System.out.println("xPositivo = (-b + √D)/(2*a) = " + xPositivo);
        }
        sc.close();
    }
}
