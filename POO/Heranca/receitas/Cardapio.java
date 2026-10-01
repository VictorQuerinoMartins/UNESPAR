package receitas;

import java.util.ArrayList;
import java.util.List;

public class Cardapio {
    private List<Receita> receitas = new ArrayList<>();

    public void adicionar(Receita receita) {
        receitas.add(receita);
    }

    public void exibirCardapio() {
        for (Receita receita : receitas) {
            System.out.println("\nTipo: " + (receita.isDoce() ? "Doce" : "Salgado"));
            System.out.println("Ingredientes: " + receita.getIngredientes());
            System.out.println("Modo de fazer: " + receita.getModoDeFazer());

            if (receita instanceof Cozido cozido) {
                cozido.cozinhar();
            }
            if (receita instanceof Assado assado) {
                assado.assar();
            }
        }
    }
}
