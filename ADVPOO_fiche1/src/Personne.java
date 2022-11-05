
public class Personne {

    private String nom;
    private String prenom;

    public Personne(String nom, String prenom) {
        super();
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    @Override
    public String toString() {
        return "[nom=" + nom + ", prenom=" + prenom + "]";
    }
}