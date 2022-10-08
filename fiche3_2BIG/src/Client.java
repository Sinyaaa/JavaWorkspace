import java.util.Objects;

public class Client {
    private String nom;
    private String prenom;
    private String adresse;
    private String dateNaissance;
    private String numTel;
    private CompteEnBanque CompteEpargne;
    private CompteEnBanque CompteCourant;
    public Client(String nom, String prenom, String adresse, String dateNaissance, String numTel) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.dateNaissance = dateNaissance;
        this.numTel = numTel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public CompteEnBanque getCompteEpargne() {
        return CompteEpargne;
    }

    public void setCompteEpargne(CompteEnBanque compteEpargne) {
        CompteEpargne = compteEpargne;
    }

    public CompteEnBanque getCompteCourant() {
        return CompteCourant;
    }

    public void setCompteCourant(CompteEnBanque compteCourant) {
        CompteCourant = compteCourant;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return nom.equals(client.nom) && prenom.equals(client.prenom) && adresse.equals(client.adresse) && dateNaissance.equals(client.dateNaissance);
    }
}