package receitas;

public class Principal {
    public static void main(String[] args) {
        Cardapio cardapio = new Cardapio();
        cardapio.adicionar(new Brigadeiro());
        cardapio.adicionar(new BoloDeChocolate());
        cardapio.adicionar(new Feijoada());
        cardapio.adicionar(new FrangoAssado());

        cardapio.exibirCardapio();
    }
}
