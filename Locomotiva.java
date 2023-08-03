public class Locomotiva {
    private int identificador;
    private double pesoMaximo = 1000.00;
    private int numMaximoVagoes;
    private Composicao composicao;

    public Locomotiva(int identificador, double pesoMaximo) {
        this.identificador = identificador;
        this.pesoMaximo = pesoMaximo;

        this.composicao = null;
    }

    public int getIdentificador() {
        return identificador;
    }

    public double getPesoMaximo() {
        return pesoMaximo;
    }

    public int getNumMaximoVagoes() {
        return numMaximoVagoes;
    }

    public Composicao getComposicao() {
        return composicao;
    }

    public void setComposicao(Composicao composicao) {
        this.composicao = composicao;
    }

}
