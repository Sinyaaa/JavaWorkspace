package be.iesca.mortis.domaine;

public class CarteMastercard extends CarteCredit {

	public CarteMastercard(Client client, double plafond, Client banque) {
		super(client, plafond, banque);
	}

	@Override
	public String toString() {
			return super.toString() + "\n Carte Mastercard";
	}
}
