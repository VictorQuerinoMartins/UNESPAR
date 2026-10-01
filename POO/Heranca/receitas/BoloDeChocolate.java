package receitas;

public class BoloDeChocolate extends Receita implements Assado {
    public BoloDeChocolate() {
        super(true);
    }

    @Override
    public String getIngredientes() {
        return "Farinha, ovos, chocolate em pó, açúcar e fermento";
    }

    @Override
    public String getModoDeFazer() {
        return "Misture os ingredientes e leve para assar";
    }

    @Override
    public void assar() {
        System.out.println("Assando o bolo a 180°C por 40 minutos...");
    }
}
