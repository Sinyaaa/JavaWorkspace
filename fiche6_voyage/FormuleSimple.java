import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;

public class FormuleSimple extends Formule{

    protected double prix;
    protected Vol volAller;
    protected Vol volRetour;

    public FormuleSimple(LocalDate dateDepart, int duree, double prix, Vol volAller, Vol volRetour) {
        super(dateDepart, duree);
        this.prix = prix;
        this.volAller = volAller;
        this.volRetour = volRetour;
    }

    @Override
    public double CalculerPrix() {
        double totalPrixFormuleSimple = duree * 100;
        return totalPrixFormuleSimple;
    }
}
