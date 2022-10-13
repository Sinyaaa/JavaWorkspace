import java.time.LocalDate;

public abstract class FormuleEtape extends Formule{
    protected int numEtape;
    protected String formuleEtapeName;
    protected double formuleEtapePrice;
    protected Etape tableEtape;

    public FormuleEtape(LocalDate dateDepart, int duree, String formuleEtapeName, double formuleEtapePrice) {
        super(dateDepart, duree);
        this.numEtape = numEtape;
        this.formuleEtapeName = formuleEtapeName;
        this.formuleEtapePrice = formuleEtapePrice;
    }
    public class IterateurEtape{
    }
    public double CalculerPrix(){

    }


}
