package contapoupanca;

public abstract class Conta {
    protected int codigo;
    protected String nomeProprietario;
    protected float saldo;

    public Conta(int codigo, String nomeProprietario, float saldo) {
        this.codigo = codigo;
        this.nomeProprietario = nomeProprietario;
        this.saldo = saldo;
    }

    public abstract void somarSaldo(float s);
}
