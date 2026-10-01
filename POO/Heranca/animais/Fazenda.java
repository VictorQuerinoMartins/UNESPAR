package animais;

public class Fazenda {
    public static void main(String[] args) {
        BemTeVi btv = new BemTeVi("Bento");
        Papagaio papagaio = new Papagaio("Loro");
        Cachorro dog = new Cachorro("Rex", 3);
        Vaca mimosa = new Vaca("Mimosa", 2, true);

        papagaio.setVocabulario("Dá no pé, louro!");
        dog.setLateAlto();

        System.out.println("=== Ações das Aves ===");
        btv.imprime();
        System.out.println("Som: " + btv.falar());
        btv.voar(2);

        System.out.println();
        papagaio.imprime();
        System.out.println("Som: " + papagaio.falar());

        System.out.println("\n=== Ações dos Mamíferos ===");
        dog.imprime();
        System.out.println("Som: " + dog.falar());
        dog.correr();

        System.out.println();
        mimosa.imprime();
        System.out.println("Som: " + mimosa.falar());
        System.out.println("Status ordenha: " + mimosa.ordenhar());
    }
}