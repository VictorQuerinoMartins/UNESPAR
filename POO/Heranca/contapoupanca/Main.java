package contapoupanca;

public class Main {
    public static void main(String[] args) {
        ContaPoupanca conta = new ContaPoupanca(1, "Victor", 500f, 12345, 1, 0.5f);

        conta.imprimirExtrato();
        conta.somarSaldo(100);
        System.out.println();
        conta.imprimirExtrato();
    }
}
