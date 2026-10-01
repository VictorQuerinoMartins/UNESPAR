package animais;

public class Papagaio extends Ave {
    private String vocabulario = "";

    public Papagaio(){ 
        super();
    }
    public Papagaio(String nome){
        super(nome);
    }


    public void setVocabulario(String vocabulario){
        this.vocabulario = vocabulario;
    }

    @Override
    public String falar() {
        return vocabulario;
    }
}
