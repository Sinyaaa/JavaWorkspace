import java.time.LocalDate;

public class Sejour extends FormuleSimple{
    private Reservation reservation;

    public Sejour(LocalDate dateDepart, int duree, double prix, Vol volAller, Vol volRetour, Reservation reservation) {
        super(dateDepart, duree, prix, volAller, volRetour);
        this.reservation = reservation;
    }

    @Override
    public double CalculerPrix() {
        double totalPrixSejour = super.CalculerPrix() + (reservation.getPriceByNight()  * (this.duree - 1));

        return totalPrixSejour;
    }

    @Override
    public String toString() {
        return "Sejour{" +
                "reservation=" + reservation +
                ", prix=" + this.CalculerPrix() +
                ", volAller=" + volAller +
                ", volRetour=" + volRetour +
                ", dateDepart=" + dateDepart +
                ", duree=" + duree +
                '}';
    }
}
