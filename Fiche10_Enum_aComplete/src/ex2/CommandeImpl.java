package ex2;

/**
 * POO 2 : exercice sur les �num�rations
 * @author
 */

public class CommandeImpl implements Commande {

    // � compl�ter

    public CommandeImpl() {
        // � compl�ter
    }

    @Override
    public double montantTotalCommande() {
        double total = 0;
        // � compl�ter
        return total;
    }

    @Override
    public double montantTotalPaye() {
        // � modifier
        return 0;
    }

    @Override
    public EtatCommande getEtatCommande() {
        // � modifier
        return null;
    }

    @Override
    public double soldeAPayer() {
        // � modifier
        return 0;
    }

    @Override
    public void encaisserPaiement(double montant) {
        // � compl�ter
    }

    @Override
    public void ajouterArticle(Article article, int quantite) {
        // � compl�ter
    }

    @Override
    public void cloturer() {
        // � compl�ter
    }

    @Override
    public void livrer() {
        // � compl�ter
    }

    // �num�r� qui g�re les �tats de la commande
    public enum EtatCommande {
        CREEE() {
            // � compl�ter

        },
        EN_PREPARATION {
            // � compl�ter

        },
        PRETE {
            // � compl�ter

        },
        LIVREE {
        };

        // � compl�ter

    }

}

