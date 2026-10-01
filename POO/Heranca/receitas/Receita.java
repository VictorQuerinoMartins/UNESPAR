package receitas;

public abstract class Receita {
    protected boolean doce;

    public Receita(boolean doce) {
        this.doce = doce;
    }

    public boolean isDoce() {
        return doce;
    }

    public abstract String getIngredientes();
    public abstract String getModoDeFazer();
}
