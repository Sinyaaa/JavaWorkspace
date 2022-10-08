public class CarteDebit extends CarteBancaire{

    public CarteDebit(Client client) {
        super(client);
    }

    public void payer(CompteEnBanque compteCible, double montant) throws Exception {
        CompteEnBanque envoyeur = client.getCompteCourant();
        envoyeur.effectuerVirement(client, compteCible, montant);
    }

    @Override
    public String toString() {
        return "Carte de débit de " + " " + client.getPrenom() + " " + client.getNom();
    }
}
