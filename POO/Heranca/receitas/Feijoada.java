package receitas;

public class Feijoada extends Receita implements Cozido {
    public Feijoada() {
        super(false);
    }

    @Override
    public String getIngredientes() {
        return "Feijão preto, carnes variadas, louro e temperos";
    }

    @Override
    public String getModoDeFazer() {
        return "Cozinhe o feijão com as carnes por várias horas";
    }

    @Override
    public void cozinhar() {
        System.out.println("Cozinhando a feijoada na panela de pressão...");
    }
}
