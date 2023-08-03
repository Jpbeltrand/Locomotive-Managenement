import java.util.ArrayList;

public class Composicao {
    private int identificacao;
    private ArrayList<Locomotiva> locomotivas;
    private ArrayList<Vagao> vagoes;

    public Composicao(int identificacao) {
        this.identificacao = identificacao;
        this.locomotivas = new ArrayList<Locomotiva>();
        this.vagoes = new ArrayList<Vagao>();
    }

    public int getIdentificador() {
        return identificacao;
    }

    public ArrayList<Locomotiva> getLocomotivas() {
        return locomotivas;
    }

    public ArrayList<Vagao> getVagoes() {
        return vagoes;
    }

    public boolean engataLocomotiva(Locomotiva locomotiva) {
        if (locomotivas.isEmpty() || locomotivas.size() == 1 ||
                (locomotivas.size() > 1 && locomotivas.size() <= locomotivas.get(0).getNumMaximoVagoes())) {
            if (vagoes.isEmpty() || (vagoes.size() == 1 && locomotivas.size() == 1)) {
                locomotivas.add(locomotiva);
                locomotiva.setComposicao(this);
                return true;
            }
        }
        return false;
    }

    public boolean engataVagao(Vagao vagao) {
        if (vagoes.isEmpty() || vagoes.size() < locomotivas.get(0).getNumMaximoVagoes() &&
                pesoMaximoVagoes() + vagao.getCapacidadeMaximaCarga() <= pesoMaximoLocomotivas() &&
                (locomotivas.size() == 0 || vagoes.size() > 0)) {
            vagoes.add(vagao);
            vagao.setComposicao(this);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeUltimoElemento() {
        if (!vagoes.isEmpty()) {
            Vagao vagao = vagoes.get(vagoes.size() - 1);
            vagao.setComposicao(null);
            vagoes.remove(vagao);
            return true;
        } else if (!locomotivas.isEmpty()) {
            Locomotiva locomotiva = locomotivas.get(locomotivas.size() - 1);
            locomotiva.setComposicao(null);
            locomotivas.remove(locomotiva);
            return true;
        }
        return false;
    }

    public double pesoMaximoLocomotivas() {
        double peso = 0.0;
        for (Locomotiva locomotiva : locomotivas) {
            peso += locomotiva.getPesoMaximo();
        }
        return peso;
    }

    public double pesoMaximoVagoes() {
        double peso = 0.0;
        for (Vagao vagao : vagoes) {
            peso += vagao.getCapacidadeMaximaCarga();
        }
        return peso;
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
