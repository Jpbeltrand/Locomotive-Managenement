import java.util.ArrayList;

public class PatioComposicao {
    private ArrayList<Composicao> composicoes;

    public PatioComposicao() {
        this.composicoes = new ArrayList<>();
    }

    public void engatarComposicao(Composicao composicao) {
        this.composicoes.add(composicao);
    }

    public void desengatarComposicao(int identificador) {
        Composicao composicao = getComposicao(identificador);
        if (composicao != null) {
            this.composicoes.remove(composicao);
        }
    }

    public Composicao[] listar() {
        return composicoes.toArray(new Composicao[composicoes.size()]);

    }

    public Composicao buscaComposicao(int idComposicao) {
        for (Composicao composicao : composicoes) {
            if (composicao.getIdentificador() == idComposicao) {
                return composicao;
            }
        }
        return null;
    }

    public Composicao getComposicao(int identificador) {
        for (Composicao composicao : this.composicoes) {
            if (composicao.getIdentificador() == identificador) {
                return composicao;
            }
        }
        return null;
    }
}
