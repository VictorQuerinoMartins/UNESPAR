import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Aceita "1.75" ou "1,75"; lança NumberFormatException se não for número
    public static double lerNumero(Scanner leitura, String msg) throws NumberFormatException {
        System.out.print(msg);
        double valor = Double.parseDouble(leitura.nextLine().trim().replace(',', '.'));
        if (valor < 0) {
            throw new NumberFormatException("Valor negativo: " + valor);
        }
        return valor;
    }

    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String continuar;

        do {
            System.out.print("Nome completo: ");
            String nome = leitura.nextLine();

            boolean loop = true;
            do {
                try {
                    double peso = lerNumero(leitura, "Peso (kg): ");
                    double altura = lerNumero(leitura, "Altura (m): ");
                    usuarios.add(new Usuario(nome, peso, altura));
                    loop = false;
                } catch (NumberFormatException e) {
                    System.err.println("Exceção: " + e);
                    System.out.println("Entre com valores numéricos válidos.");
                }
            } while (loop);

            System.out.print("Cadastrar outro usuário? (s/n): ");
            continuar = leitura.nextLine();
        } while (continuar.equalsIgnoreCase("s"));

        System.out.println("\n--- IMC dos usuários ---");
        for (Usuario u : usuarios) {
            try {
                System.out.printf("%s: IMC = %.2f%n", u.getNome(), u.calcularImc());
            } catch (ArithmeticException e) {
                System.err.println("Exceção: " + e);
                System.out.println(u.getNome() + ": não foi possível calcular o IMC.");
            } finally {
                System.out.println("Usuário processado.");
            }
        }
        leitura.close();
    }
}
