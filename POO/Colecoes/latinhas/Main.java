public class Main {

    public static void main(String[] args) {

        Colecao colecao = new Colecao();

        LatinhaCerveja l1 = new LatinhaCerveja(1, "Brahma", 350, "01/2026", "01/2027");
        LatinhaCerveja l2 = new LatinhaCerveja(2, "Skol", 473, "03/2026", "03/2027");
        LatinhaCerveja l3 = new LatinhaCerveja(3, "Heineken", 350, "05/2026", "05/2027");

        colecao.apelidar("Vermelhinha", l1);
        colecao.apelidar("Lata Grande", l2);
        colecao.apelidar("Verdinha", l3);

        System.out.println(colecao.buscarPorApelido("Vermelhinha"));
        System.out.println(colecao.buscarPorApelido("Lata Grande"));
        System.out.println(colecao.buscarPorApelido("Verdinha"));
        System.out.println(colecao.buscarPorApelido("Apelido inexistente"));
    }
}
