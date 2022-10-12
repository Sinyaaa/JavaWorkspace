import java.time.LocalDate;

public class Sejour extends FormuleSimple{
    private Reservation reservation;

    public Sejour(LocalDate dateDepart, int duree, double prix, Vol volAller, Vol volRetour, Reservation reservation) {
        super(dateDepart, duree, prix, volAller, volRetour);
        this.reservation = reservation;
    }

    @Override
    public double CalculerPrix() {
        String totalDaysOfVoyage = volRetour.getAirportDeparture();
        double totalPrixSejour = this.CalculerPrix() + (reservation.getPriceByNight() /* * totalDaysOfVoyage */ );

        return totalPrixSejour;
    }
}
