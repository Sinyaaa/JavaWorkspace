import java.time.LocalDate;

public class Croisiere extends FormuleEtape {

    protected String nomTableau;
    protected int cabinsCount;
    protected String activites;

    public Croisiere(LocalDate dateDepart, int duree, String formuleEtapeName, double formuleEtapePrice, String nomTableau, int cabinsCount, String activites) {
        super(dateDepart, duree, formuleEtapeName, formuleEtapePrice);
        this.nomTableau = nomTableau;
        this.cabinsCount = cabinsCount;
        this.activites = activites;
    }

    @Override
    public String toString() {
        return "Croisiere{" +
                "nomTableau='" + nomTableau + '\'' +
                ", cabinsCount=" + cabinsCount +
                ", activites='" + activites + '\'' +
                ", numEtape=" + numEtape +
                ", formuleEtapeName='" + formuleEtapeName + '\'' +
                ", formuleEtapePrice=" + formuleEtapePrice +
                ", tableEtape=" + tableEtape +
                ", dateDepart=" + dateDepart +
                ", duree=" + duree +
                '}';
    }
}
