public class Reservation {
    private String hotelName;
    private int starsNumber;
    private double priceByNight;

    public Reservation(String hotelName, int starsNumber, double priceByNight) {
        this.hotelName = hotelName;
        this.starsNumber = starsNumber;
        this.priceByNight = priceByNight;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getStarsNumber() {
        return starsNumber;
    }

    public void setStarsNumber(int starsNumber) {
        this.starsNumber = starsNumber;
    }

    public double getPriceByNight() {
        return priceByNight;
    }

    public void setPriceByNight(double priceByNight) {
        this.priceByNight = priceByNight;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "hotelName='" + hotelName + '\'' +
                ", starsNumber=" + starsNumber +
                ", priceByNight=" + priceByNight +
                '}';
    }
}
