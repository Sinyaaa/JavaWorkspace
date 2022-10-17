import java.time.LocalDate;

public class Circuit extends FormuleEtape{

    protected String description;

    public Circuit(LocalDate dateDepart, int duree, String formuleEtapeName, double formuleEtapePrice, String description) {
        super(dateDepart, duree, formuleEtapeName, formuleEtapePrice);
        this.description = description;
    }

    @Override
    public String toString() {
        return "Circuit{" +
                "description='" + description + '\'' +
                ", numEtape=" + numEtape +
                ", formuleEtapeName='" + formuleEtapeName + '\'' +
                ", formuleEtapePrice=" + formuleEtapePrice +
                ", tableEtape=" + tableEtape +
                ", dateDepart=" + dateDepart +
                ", duree=" + duree +
                '}';
    }
}
