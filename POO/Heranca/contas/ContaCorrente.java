package contas;

public class ContaCorrente extends Conta {
    public ContaCorrente(double saldo) {
        super(saldo);
    }

    @Override
    public void atualiza(double taxa) {
        super.atualiza(taxa * 2);
    }

    @Override
    public void depositar(double valor) {
        super.depositar(valor - 0.10);
    }
}
