public class CarteMastercard extends CarteCredit{
    public CarteMastercard(Client client, double plafond, Client banqueING) {
        super(client, plafond, banqueING);
    }

    @Override
    public String toString() {
        return "Carte Mastercard de " + client.getPrenom() + " " + client.getNom();

    }
}
