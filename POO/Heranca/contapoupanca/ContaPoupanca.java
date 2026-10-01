package contapoupanca;

public class ContaPoupanca extends Conta {
    private int numConta;
    private int numAgencia;
    private float variacao;

    public ContaPoupanca(int codigo, String nomeProprietario, float saldo,
                          int numConta, int numAgencia, float variacao) {
        super(codigo, nomeProprietario, saldo);
        this.numConta = numConta;
        this.numAgencia = numAgencia;
        this.variacao = variacao;
    }

    @Override
    public void somarSaldo(float s) {
        saldo += s;
    }

    public void imprimirExtrato() {
        System.out.println("=== Extrato ===");
        System.out.println("Código: " + codigo);
        System.out.println("Proprietário: " + nomeProprietario);
        System.out.println("Agência/Conta: " + numAgencia + "/" + numConta);
        System.out.println("Variação: " + variacao);
        System.out.println("Saldo: R$ " + saldo);
    }
}
