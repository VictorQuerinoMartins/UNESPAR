import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        // 5 instâncias de Aluno
        Aluno a1 = new Aluno(1, "Ana Silva", "41-9999-0001", "Rua A, 100");
        Aluno a2 = new Aluno(2, "Bruno Costa", "41-9999-0002", "Rua B, 200");
        Aluno a3 = new Aluno(3, "Carla Souza", "41-9999-0003", "Rua C, 300");
        Aluno a4 = new Aluno(4, "Diego Lima", "41-9999-0004", "Rua D, 400");
        Aluno a5 = new Aluno(5, "Elisa Rocha", "41-9999-0005", "Rua E, 500");

        // ArrayList com 6 alunos, um duplicado (a1 repetido)
        ArrayList<Aluno> lista = new ArrayList<>();
        lista.add(a1);
        lista.add(a2);
        lista.add(a3);
        lista.add(a4);
        lista.add(a5);
        lista.add(a1); // duplicado

        // HashSet com o nome de cada aluno
        HashSet<String> nomes = new HashSet<>();
        nomes.add(a1.getNome());
        nomes.add(a2.getNome());
        nomes.add(a3.getNome());
        nomes.add(a4.getNome());
        nomes.add(a5.getNome());

        // HashMap com 7 chaves, 5 alunos (a1 e a2 apontados por 2 chaves cada)
        HashMap<String, Aluno> mapa = new HashMap<>();
        mapa.put("matricula-01", a1);
        mapa.put("matricula-01b", a1);
        mapa.put("matricula-02", a2);
        mapa.put("matricula-02b", a2);
        mapa.put("matricula-03", a3);
        mapa.put("matricula-04", a4);
        mapa.put("matricula-05", a5);

        System.out.println("=== ArrayList (for) ===");
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).imprimeDados();
        }

        System.out.println("=== HashSet (Iterator) ===");
        Iterator<String> it = nomes.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("=== HashMap (chaves + dados) ===");
        for (Map.Entry<String, Aluno> entry : mapa.entrySet()) {
            System.out.println("Chave: " + entry.getKey());
            entry.getValue().imprimeDados();
        }
    }
}
