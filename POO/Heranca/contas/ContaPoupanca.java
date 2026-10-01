package contas;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(double saldo) {
        super(saldo);
    }

    @Override
    public void atualiza(double taxa) {
        super.atualiza(taxa * 3);
    }
}
