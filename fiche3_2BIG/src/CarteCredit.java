import java.util.Iterator;

public class CarteCredit extends CarteBancaire{
    private double plafond;

    private RegistreOperations paiementsEnAttente;
    private Client banqueING;

    public CarteCredit(Client client, double plafond, Client banqueING) {
        super(client);
        this.plafond = plafond;
        this.paiementsEnAttente = paiementsEnAttente;
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
        double totalPaiementsEnAttente = totalPaiementsEnAttente();
        if (totalPaiementsEnAttente > plafond){
            throw new Exception("Plafond dépasser ! Paiement impossible");
        }


        CompteEnBanque compteING = banqueING.getCompteCourant();
        compteING.effectuerVirement(banqueING, compteCible, montant);
    }

    /*
    public boolean effectuerLesVirements(){

    }*/
}
