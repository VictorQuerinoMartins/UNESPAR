package figuras;

public class Principal {
    public static void main(String[] args) {
        FiguraGeometrica circulo = new Circulo();
        FiguraGeometrica quadrado = new Quadrado();
        FiguraGeometrica triangulo = new Triangulo();
        FiguraGeometrica trianguloEquilatero = new TrianguloEquilatero();

        circulo.desenha();
        quadrado.desenha();
        triangulo.desenha();
        trianguloEquilatero.desenha();
    }
}
