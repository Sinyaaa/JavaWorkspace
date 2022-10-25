package ex2;

/**
 * POO 2 : exercice sur les �num�rations
 * @author Olivier Legrand
 */
public class Article {
    private String nom;
    private double prix;

    public Article(String nom, double prix) {
        super();
        Util.checkString(nom);
        Util.checkPositive(prix);
        this.nom = nom;
        this.prix = prix;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nom == null) ? 0 : nom.hashCode());
        long temp;
        temp = Double.doubleToLongBits(prix);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Article other = (Article) obj;
        if (nom == null) {
            if (other.nom != null)
                return false;
        } else if (!nom.equals(other.nom))
            return false;
        if (Double.doubleToLongBits(prix) != Double.doubleToLongBits(other.prix))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Article [ " + nom + " , " + prix + " ]";
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

}
