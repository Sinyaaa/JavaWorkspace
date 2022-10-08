public class CarteDebitSpecialisee extends CarteDebit{
    private String image;

    public CarteDebitSpecialisee(Client client, String image) {
        super(client);
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return super.toString() + "spécialisée" + "|" + " nom du fichier image : " + image;
    }
}
