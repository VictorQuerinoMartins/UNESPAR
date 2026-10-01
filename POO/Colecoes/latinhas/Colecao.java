import java.util.HashMap;
import java.util.Map;

public class Colecao {

    private Map<String, LatinhaCerveja> latinhasPorApelido = new HashMap<>();

    public void apelidar(String apelido, LatinhaCerveja latinha) {
        latinhasPorApelido.put(apelido, latinha);
    }

    public LatinhaCerveja buscarPorApelido(String apelido) {
        return latinhasPorApelido.get(apelido);
    }
}
