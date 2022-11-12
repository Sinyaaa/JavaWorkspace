import java.util.Iterator;

public abstract class CarteCredit extends CarteBancaire{
    private double plafond;

    private RegistreOperations paiementsEnAttente;
    private Client banqueING;

    public CarteCredit(Client client, double plafond, Client banqueING) {
        super(client);
        this.plafond = plafond;
        this.banqueING = banqueING;
    }

    private void retraitOperation(){
        Iterator<Operation> iterateurOp = paiementsEnAttente.iterator();
        while(iterateurOp.hasNext()){
            iterateurOp.next();
            iterateurOp.remove();
        }
    }

    private double totalPaiementsEnAttente(){
        double totalPaiements = 0;
        Iterator<Operation> iterateurOp = paiementsEnAttente.iterator();
        while(iterateurOp.hasNext()){
            Operation operation = iterateurOp.next();
           totalPaiements += operation.getMontant();
        }
        return totalPaiements;
    }

    public void payer(CompteEnBanque compteCible, double montant) throws Exception {

        Operation op = new Operation(compteCible, montant, 7, 0);
        this.paiementsEnAttente.add(op);

        double totalPaiementsEnAttente = totalPaiementsEnAttente();
        if (totalPaiementsEnAttente > plafond){
            throw new Exception("Plafond dépasser ! Paiement impossible");
        }

        CompteEnBanque compteING = banqueING.getCompteCourant();
        compteING.effectuerVirement(banqueING, compteCible, montant);
    }


    public boolean effectuerLesVirements() throws Exception {
        Iterator<Operation> itPaiement = this.paiementsEnAttente.iterator();
        boolean virementEffectuable = true;
        CompteCourant cptCourant = (CompteCourant) this.client.getCompteCourant();
        CompteEnBanque cptDeLaBanque = this.banqueING.getCompteCourant();
        double montant = 0;
        double montantIfInsuffisant = 0;
        while(itPaiement.hasNext()){
            Operation opPaiement = itPaiement.next();
            montant = opPaiement.getMontant();
            if (cptCourant.getSolde() - montant > cptCourant.getDecouvertMax()){
                cptCourant.effectuerVirement(client, cptDeLaBanque, montant);
                itPaiement.remove();
            } else {
                montantIfInsuffisant += montant;
                virementEffectuable = false;
            }

        }
            if (virementEffectuable == false){
                Operation opPaiementInsuffisant =new Operation(cptDeLaBanque, montantIfInsuffisant * 0.1, Operation.VIREMENT_EN_ATTENTE, 0);
                this.paiementsEnAttente.add(opPaiementInsuffisant);
            }

            return virementEffectuable;

    }

    @Override
    public String toString() {
        return "CarteCredit{" +
                "plafond=" + plafond +
                ", paiementsEnAttente=" + paiementsEnAttente +
                ", banqueING=" + banqueING +
                ", client=" + client +
                '}';
    }
}
