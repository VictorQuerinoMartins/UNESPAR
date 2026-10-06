public class Usuario {

    private String nome;
    private double peso;
    private double altura;

    public Usuario(String nome, double peso, double altura) {
        this.nome = nome;
        this.peso = peso;
        this.altura = altura;
    }

    // double / 0 em Java resulta em Infinity (não lança exceção), então lançamos manualmente
    public double calcularImc() throws ArithmeticException {
        if (altura == 0) {
            throw new ArithmeticException("Altura igual a zero: divisão por zero");
        }
        return peso / (altura * altura);
    }

    public String getNome() {
        return nome;
    }
}
