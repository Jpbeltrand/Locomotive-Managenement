import java.util.ArrayList;

public class GaragemLocomotiva {
    private ArrayList<Locomotiva> locomotivas;

    public GaragemLocomotiva() {
        locomotivas = new ArrayList<>();
    }

    public void engatarLocomotiva(Locomotiva umaLocomotiva) {
        locomotivas.add(umaLocomotiva);
    }

    public Locomotiva remover(int identificador) {
        for (int i = 0; i < locomotivas.size(); i++) {
            Locomotiva locomotiva = locomotivas.get(i);
            if (locomotiva.getIdentificador() == identificador) {
                locomotivas.remove(i);
                return locomotiva;
            }
        }
        return null;
    }

    public Locomotiva[] listar() {
        return locomotivas.toArray(new Locomotiva[locomotivas.size()]);

    }

    public Locomotiva buscaLocomotiva(int idLocomotiva) {
        for (Locomotiva locomotiva : locomotivas) {
            if (locomotiva.getIdentificador() == idLocomotiva) {
                return locomotiva;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (var locomotiva : locomotivas) {
            s.append(locomotiva);
            s.append(System.lineSeparator());
        }
        return s.toString();
    }
}
