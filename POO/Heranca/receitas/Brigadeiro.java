package receitas;

public class Brigadeiro extends Receita implements Cozido {
    public Brigadeiro() {
        super(true);
    }

    @Override
    public String getIngredientes() {
        return "Leite condensado, chocolate em pó, manteiga e granulado";
    }

    @Override
    public String getModoDeFazer() {
        return "Misture tudo em uma panela e mexa até desgrudar do fundo";
    }

    @Override
    public void cozinhar() {
        System.out.println("Cozinhando o brigadeiro em fogo baixo...");
    }
}
