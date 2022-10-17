import java.time.LocalDate;

public class Dictionnaire extends Document{

    protected String publishingHouse;
    protected LocalDate releaseYear;
    protected String language;

    public Dictionnaire(String recordNumber, String documentTitle, String publishingHouse, LocalDate releaseYear, String language) {
        super(recordNumber, documentTitle);
        this.publishingHouse = publishingHouse;
        this.releaseYear = releaseYear;
        this.language = language;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public LocalDate getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(LocalDate releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
