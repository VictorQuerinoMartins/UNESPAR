package heranca2;

public class TestaTudo {
    public static void main(String[] args) {
        ChefeDepartamento chefe = new ChefeDepartamento(
            "Guilherme", "12345678932", "30/04/2000", "6ASD341SDF", "17/09/2026", 10000,
            "TI", "01/09/2025", 2000.0

        );

        Aluno victor = new Aluno(
            "Victor", "10325063403", "30/04/2005", "A202S32D34"
        );

        chefe.mostrarChefe();
        victor.mostrarAluno();
    }
}
