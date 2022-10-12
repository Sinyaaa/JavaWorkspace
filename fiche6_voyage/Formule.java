import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class Formule {
    protected LocalDate dateDepart;
    protected int duree;

    public Formule(LocalDate dateDepart, int duree) {
        this.dateDepart = dateDepart;
        this.duree = duree;
    }

    public abstract double CalculerPrix();

    public LocalDate getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(LocalDate dateDepart) {
        this.dateDepart = dateDepart;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }
}
