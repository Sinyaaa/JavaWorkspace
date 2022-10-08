import java.util.Objects;

public class CompteEpargne implements CompteEnBanque{

    private final static int DECOUVERT_MAX = 0;
    private String numero;
    private double solde;
    private boolean cloture;

    public CompteEpargne(String numero) {
        super();
        this.numero = numero;
        this.solde = 0;
        this.cloture = false;
    }

    public double getDecouvertMax() {
        return DECOUVERT_MAX;
    }

    public String getNumero() {
        return numero;
    }

    public double getSolde() {
        return solde;
    }

    public boolean isCloture() {
        return cloture;
    }


    public void cloturer() {
        if(solde == DECOUVERT_MAX) {
            this.cloture = true;
        }
    }

    public void deposer(double montant) throws Exception {
        if (isCloture()) throw new Exception("Ce compte est cloturer");
        if (montant <=0) throw new Exception("Le montant doit etre positif");
        this.solde += montant;


    }
    public void effectuerVirement(Client envoyeur, CompteEnBanque receveur, double montant) throws Exception {

        if(!envoyeur.getCompteEpargne().equals(this)) throw new Exception("Titulaire errone");
        if(!envoyeur.getCompteCourant().equals(receveur)) throw new Exception("Virement d'un compte épargne a un autre compte courant non autorisé");
        if(receveur.isCloture()) throw new Exception("Ce compte beneficiaire est cloturer");
        if(montant <= 0) throw new Exception("Erreur montant incorrect");

        this.retirer(montant);
        receveur.deposer(montant);
    }


    public void retirer(double montant) throws Exception {
        if (isCloture()) throw new Exception("Ce compte est cloturer");
        if (montant <=0) throw new Exception("Le montant doit etre positif");
        if (montant > solde) throw new Exception("Solde insuffisant");
        this.solde -= montant;

    }

    public boolean equals(Object autre){
        if(!(autre instanceof CompteEpargne)) return false;
        CompteEpargne autreCompte = (CompteEpargne) autre;
        return autreCompte.getNumero().equals(this.numero);
    }
}