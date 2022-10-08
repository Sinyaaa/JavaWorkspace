import java.util.Objects;

public class CompteCourant implements CompteEnBanque {
    private String numero;
    private double solde;
    private double decouvertMax;
    private boolean cloture;


    public CompteCourant(String numero, double decouvertMax) {
        super();
        this.numero = numero;
        this.decouvertMax = decouvertMax;
        this.solde = 0;
    }


    public CompteCourant(String numero, double solde, double decouvertMax) {
        super();
        this.numero = numero;
        this.solde = solde;
        this.decouvertMax = decouvertMax;
        this.cloture = false;
    }


    public double getDecouvertMax() {
        return decouvertMax;
    }


    public void setDecouvertMax(double decouvertMax) {
        this.decouvertMax = decouvertMax;
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
        if(solde == decouvertMax) {
            this.cloture = true;
        }
    }

    public void deposer(double montant) throws Exception {
        if (isCloture()) throw new Exception("Ce compte est cloturer");
        if (montant <=0) throw new Exception("Le montant doit etre positif");
        this.solde += montant;


    }

    public void effectuerVirement(Client envoyeur, CompteEnBanque receveur, double montant) throws Exception {
        if(receveur.isCloture()) throw new Exception("Ce compte beneficiaire est cloturer");
        if(montant <= 0) throw new Exception("Erreur montant incorrect");
        else
        this.retirer(montant);
        receveur.deposer(montant);
    }


    public void retirer(double montant) throws Exception {
        if (isCloture()) throw new Exception("Ce compte est cloturer");
        if (montant <=0) throw new Exception("Le montant doit etre positif");
        this.solde -= montant;

    }

    public boolean equals(Object autre){
        if(!(autre instanceof CompteCourant)) return false;
        CompteCourant autreCompte = (CompteCourant) autre;
        return autreCompte.getNumero().equals(this.numero);
    }

}