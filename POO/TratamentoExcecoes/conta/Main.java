public class Main {

    public static void main(String[] args) {
        Conta conta = new Conta("Victor", 100.0);
        double[] saques = {30.0, 50.0, 40.0};

        for (double valor : saques) {
            try {
                conta.saca(valor);
                System.out.println("Saque de R$ " + valor + " realizado.");
            } catch (ContaExcecao e) {
                System.err.println("Exceção: " + e.getMessage());
            } finally {
                System.out.println("Saldo atual de " + conta.getTitular() + ": R$ " + conta.getSaldo());
            }
        }
    }
}
