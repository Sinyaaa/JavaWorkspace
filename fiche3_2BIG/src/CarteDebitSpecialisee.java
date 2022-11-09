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
        return "Carte de débit spécialisée de " + " " + client.getPrenom() + " " + client.getNom() + " | nom du fichier image : " + image;
    }
}
