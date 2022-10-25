package ex2;

public interface Commande {
    double montantTotalCommande();

    double montantTotalPaye();

    double soldeAPayer();

    void encaisserPaiement(double montant);

    void ajouterArticle(Article article, int quantite);

    void cloturer();

    void livrer();

    EtatCommande getEtatCommande();

}
