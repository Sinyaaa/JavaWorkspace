import java.time.LocalDate;


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
        this.prix = duree * 10;
        return prix;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Vol getVolAller() {
        return volAller;
    }

    public void setVolAller(Vol volAller) {
        this.volAller = volAller;
    }

    public Vol getVolRetour() {
        return volRetour;
    }

    public void setVolRetour(Vol volRetour) {
        this.volRetour = volRetour;
    }

    @Override
    public String toString() {
        return "FormuleSimple{" +
                "prix=" + prix +
                ", volAller=" + volAller +
                ", volRetour=" + volRetour +
                ", dateDepart=" + dateDepart +
                ", duree=" + duree +
                '}';
    }
}
