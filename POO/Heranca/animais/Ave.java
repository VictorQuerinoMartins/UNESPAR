package animais;

public class Ave extends Animal {
    
    public Ave(){
        this.classe = "Ave";
    }

     public Ave(String nome) {
        super(nome);
        this.classe = "Ave";
    }

   @Override
    public String falar(){
        return "piu piu";
}

public void voar(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("voando ");
        }
    
    }
}