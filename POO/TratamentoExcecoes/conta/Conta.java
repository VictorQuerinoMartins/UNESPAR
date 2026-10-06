public class Conta {

    private String titular;
    private double saldo;

    public Conta(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public void saca(double valor) throws ContaExcecao {
        if (saldo < valor) {
            throw new ContaExcecao("Saldo insuficiente: saldo R$ " + saldo + ", saque R$ " + valor);
        }
        saldo -= valor;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }
}
