public class Exercicio4 {
    public static void main(String[] args) {
        String s1 = "Programação";
        String s2 = "JAVA";
        String s3 = "java";

        System.out.println("Concatenação s1 + s2: " + s1.concat(s2));
        System.out.println("Tamanho de s1: " + s1.length());
        System.out.println("Tamanho de s2: " + s2.length());

        String primeiros = String.valueOf(s1.charAt(0)) + s2.charAt(0);
        System.out.println("Primeiros caracteres concatenados: " + primeiros);

        System.out.println("s1 contém '@'? " + s1.contains("@"));

        int numero = 13;
        s2 = String.valueOf(numero);
        System.out.println("s2 após receber o inteiro: " + s2);

        System.out.println("s3: " + s3);
    }
}
