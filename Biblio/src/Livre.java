public class Livre extends Document{
    protected String nameAutor;
    protected String publishingHouse;
    protected int totalNumberPages;

    public Livre(String recordNumber, String documentTitle, String nameAutor, String publishingHouse, int totalNumberPages) {
        super(recordNumber, documentTitle);
        this.nameAutor = nameAutor;
        this.publishingHouse = publishingHouse;
        this.totalNumberPages = totalNumberPages;
    }

    public String getNameAutor() {
        return nameAutor;
    }

    public void setNameAutor(String nameAutor) {
        this.nameAutor = nameAutor;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public int getTotalNumberPages() {
        return totalNumberPages;
    }

    public void setTotalNumberPages(int totalNumberPages) {
        this.totalNumberPages = totalNumberPages;
    }
}
