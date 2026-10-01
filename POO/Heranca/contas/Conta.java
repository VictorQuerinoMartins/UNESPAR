package contas;

public class Conta {
    protected double saldo;

    public Conta(double saldo) {
        this.saldo = saldo;
    }

    public void mostrarSaldo() {
        System.out.println("Saldo: R$ " + saldo);
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        saldo -= valor;
    }

    public void atualiza(double taxa) {
        saldo += saldo * (taxa / 100);
    }
}
