package receitas;

public class FrangoAssado extends Receita implements Assado, Cozido {
    public FrangoAssado() {
        super(false);
    }

    @Override
    public String getIngredientes() {
        return "Frango inteiro, alho, sal e ervas";
    }

    @Override
    public String getModoDeFazer() {
        return "Tempere o frango, pré-cozinhe e depois asse até dourar";
    }

    @Override
    public void cozinhar() {
        System.out.println("Pré-cozinhando o frango...");
    }

    @Override
    public void assar() {
        System.out.println("Assando o frango até dourar...");
    }
}
