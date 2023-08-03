public class Vagao {
    private int identificador;
    private double capacidadeMaximaCarga = 50.00;
    private Composicao composicao;

    public Vagao(int identificador, double capacidadeMaximaCarga) {
        this.identificador = identificador;
        this.capacidadeMaximaCarga = capacidadeMaximaCarga;
        this.composicao = null;
    }

    public int getIdentificador() {
        return identificador;
    }

    public double getCapacidadeMaximaCarga() {
        return capacidadeMaximaCarga;
    }

    public Composicao getComposicao() {
        return composicao;
    }

    public void setComposicao(Composicao composicao) {
        this.composicao = composicao;
    }

}
