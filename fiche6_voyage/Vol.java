import java.time.LocalDate;

public class Vol {

    private LocalDate date;
    private String flyNumber;
    private String airportDeparture;
    private String airportArrival;

    public Vol(LocalDate date, String flyNumber, String airportDeparture, String airportArrival) {
        this.date = date;
        this.flyNumber = flyNumber;
        this.airportDeparture = airportDeparture;
        this.airportArrival = airportArrival;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getFlyNumber() {
        return flyNumber;
    }

    public void setFlyNumber(String flyNumber) {
        this.flyNumber = flyNumber;
    }

    public String getAirportDeparture() {
        return airportDeparture;
    }

    public void setAirportDeparture(String airportDeparture) {
        this.airportDeparture = airportDeparture;
    }

    public String airportArrival() {
        return airportArrival;
    }

    public void setGetAirportArrival(String airportArrival) {
        this.airportArrival = airportArrival;
    }
}
