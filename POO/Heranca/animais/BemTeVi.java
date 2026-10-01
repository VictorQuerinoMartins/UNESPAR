package animais;

public class BemTeVi extends Ave {


    public BemTeVi(){
        super();
    }

    public BemTeVi(String nome) { 
        super(nome); 
    }


    @Override
    public String falar(){
        return "bem-te-vi";
    }
}