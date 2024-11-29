package Revisão.Classes.Atividades;

public class GPS {
    private String idioma;
    private String rota;

    // Construtor default
    public GPS() {
        this.idioma = "";
        this.rota = "";
    }

    public GPS(String idioma, String rota) {
        this.idioma = idioma;
        this.rota = rota;
    }

    public void definirIdioma(String novoIdioma) {
        this.idioma = novoIdioma;
    }

    public void definirRota(String novaRota) {
        this.rota = novaRota;
    }

    public void mostrar() {
        System.out.println("Idioma: " + this.idioma);
        System.out.println("Rota: " + this.rota);
    }
}