public class Exercicio3 {
    public static void main(String[] args) {
        double[] numeros = {10.5, -32.5, -0.1, -0.9, 3.9, 3.1};

        for (double n : numeros) {
            System.out.println("Número: " + n);
            System.out.println("  abs   (valor absoluto):          " + Math.abs(n));
            System.out.println("  floor (decimal mais baixo):      " + Math.floor(n));
            System.out.println("  ceil  (decimal mais alto):       " + Math.ceil(n));
            System.out.println("  rint  (decimal mais próximo):    " + Math.rint(n));
            System.out.println("  round (arredondamento aritm.):   " + Math.round(n));
        }
    }
}
