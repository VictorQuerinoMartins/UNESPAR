package contas;

public class TestaContas {
    public static void main(String[] args) {
        ContaCorrente corrente = new ContaCorrente(1000);
        ContaPoupanca poupanca = new ContaPoupanca(1000);

        corrente.depositar(200);
        corrente.atualiza(1);

        poupanca.depositar(200);
        poupanca.atualiza(1);

        System.out.println("Conta Corrente:");
        corrente.mostrarSaldo();

        System.out.println("Conta Poupança:");
        poupanca.mostrarSaldo();
    }
}
