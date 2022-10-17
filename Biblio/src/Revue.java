import java.time.LocalDate;

public class Revue extends Document{
    protected LocalDate releaseDate;

    public Revue(String recordNumber, String documentTitle, LocalDate releaseDate) {
        super(recordNumber, documentTitle);
        this.releaseDate = releaseDate;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
