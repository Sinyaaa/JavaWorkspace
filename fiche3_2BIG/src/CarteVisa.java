public class CarteVisa extends CarteCredit{

    public CarteVisa(Client client, double plafond, Client banqueING) {
        super(client, plafond, banqueING);
    }

    @Override
    public String toString() {
        return "CarteVisa de " + client.getPrenom() + " " + client.getNom();
    }
}
