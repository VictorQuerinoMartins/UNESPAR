import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ano de nascimento: ");
        Integer anoNascimento = Integer.valueOf(sc.nextLine().trim());
        System.out.print("Ano atual: ");
        Integer anoAtual = Integer.valueOf(sc.nextLine().trim());

        if (!anoNascimento.equals(anoAtual)) {
            Integer idade = Integer.valueOf(anoAtual - anoNascimento);
            System.out.println("Idade: " + idade.toString() + " anos");
        } else {
            System.out.println("Os anos são iguais.");
        }
        sc.close();
    }
}
