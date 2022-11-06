public abstract class CarteBancaire  {
    protected Client client;

    public CarteBancaire(Client client) {
        this.client = client;
    }

    public void payer(CompteEnBanque compteCible, double montant) throws Exception {
        throw new UnsupportedOperationException("Operation refusee");
    }

    @Override
    public String toString() {
        return "Carte bancaire de " + " " + client.getPrenom() + " " + client.getNom();
    }
}
