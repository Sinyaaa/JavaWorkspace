import java.time.LocalDate;

public class Etape {

    protected String city;
    protected LocalDate dateEtape;

    public Etape(String city, LocalDate dateEtape) {
        this.city = city;
        this.dateEtape = dateEtape;
    }

    @Override
    public String toString() {
        return "Etape{" +
                "city='" + city + '\'' +
                ", dateEtape=" + dateEtape +
                '}';
    }
}
