package Revisão.exemplos;


public class encapsulamento2 {

    //Atributos

    static int numeroDeCachorros;

    private String nome;
    private String cor;
    private int altura;
    private double peso;
    private int tamanhoDoRabo;
    private String estadoDeEspirito;


    //Construtor padrão

    encapsulamento2( ){ }

    //Construtor condicionado

    encapsulamento2(String nome, String cor, int altura, double peso,int tamanhoDoRabo,  String estadoDeEspirito){    // Já pede para quer for construir o obj cachorro passar os atributos, para construção com os devidos valores.

            this.nome = nome;
            this.cor = cor;
            this.altura = altura;
            this.peso = peso;
            this.tamanhoDoRabo = tamanhoDoRabo;
            this.estadoDeEspirito = estadoDeEspirito;
           

            numeroDeCachorros ++;
          
    }

    //Métodos

    public static int getNumeroDeCachorros(){
        return numeroDeCachorros;
    }
    public static void setNumeroDeCachorros(int numeroDeCachorros){
            encapsulamento2.numeroDeCachorros = numeroDeCachorros;
    }
    public String getNome(){                                // getter -> pegar         // Da para selecionar o que vai acontecer dependendo da pessoa.
        return this.nome;
    }
   public void setNome(String nome){                       // setter -> definir, colocar
        this.nome = nome;
    }
    public String getcor(){
        return cor;

    }public void setcor(String cor){
        this.cor = cor;

    }public int getaltura(){
        return altura;

    }public void setaltura(int altura){
        this.altura = altura;

    }public Double getpeso(){
        return peso;

    } public void setpeso(Double peso){
        this.peso = peso;

    }public int gettamanhoDoRabo(){
        return tamanhoDoRabo;

    }public void settamanhoDoRabo(int tamanhoDoRabo){
        this.tamanhoDoRabo = tamanhoDoRabo;

    }public String getestadoDeEspirito(){
        return estadoDeEspirito;

    }public void setestadoDeEspirito(String estadoDeEspirito){
        this.estadoDeEspirito = estadoDeEspirito;

    }public void comer(){  

    }public void latir(){  
        System.out.println("AU AU");

    }public String pegar(){ 
    return "Bolinha";

    }public String interagir(String acao){           
    
        switch(acao){
        case "carinho": this.estadoDeEspirito = "Feliz";
        break;
        case "vai dormir": this.estadoDeEspirito = "Bravo";
        break;
        default: this.estadoDeEspirito = "Neutro";
        break;
    }


return this.estadoDeEspirito;  

}
}