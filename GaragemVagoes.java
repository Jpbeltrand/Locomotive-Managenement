import java.util.ArrayList;;

public class GaragemVagoes {
    private ArrayList<Vagao> vagoes;

    public GaragemVagoes() {
        vagoes = new ArrayList<>();
    }

    public void engatarVagao(Vagao umVagao) {
        vagoes.add(umVagao);
    }

    public Vagao remover(int identificador) {
        for (Vagao vagao : vagoes) {
            if (vagao.getIdentificador() == identificador) {
                vagoes.remove(vagao);
                return vagao;
            }
        }
        return null;
    }

    public Vagao[] listar() {
        return vagoes.toArray(new Vagao[vagoes.size()]);

    }

    public Vagao buscaVagao(int idVagao) {
        for (Vagao vagao : vagoes) {
            if (vagao.getIdentificador() == idVagao) {
                return vagao;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (var vagao : vagoes) {
            s.append(vagao);
            s.append(System.lineSeparator());
        }
        return s.toString();
    }
}