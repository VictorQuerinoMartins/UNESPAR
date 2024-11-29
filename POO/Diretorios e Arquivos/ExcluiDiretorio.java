import java.io.File;
public class ExcluiDiretorio {
    public static void main(String[] args) {
        File dir = new File("c:/loja");
        String men = "";
        if (dir.isDirectory()) {
            if (dir.delete ()) {
                men = dir.getName() + " Excluído com sucesso!";
            } else {
                if (excluirFilhos(dir)) {
                    men = dir.getName() + " Excluído com Sucesso!";
                } else {
                    men = "Falha na exclusão de " + dir.getName();
                }
            }
            System.out.println(men);
        }
    }

    private static boolean excluirFilhos(File dir) {
        if (dir.isDirectory()) {
            String[] arquivos = dir.list();
            for (int i = 0; i < arquivos.length; i++) {
                boolean success = excluirFilhos(new File(dir, 			arquivos[i]));
                if (success) {
                    System.out.println("Excluído: " + arquivos[i]);
                } else {
                    System.out.println("Não pode ser excluído: " + arquivos[i]);
                    return false;
                }
            }
        }
        return dir.delete();
    }
}
