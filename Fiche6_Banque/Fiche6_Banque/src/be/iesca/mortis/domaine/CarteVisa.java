package be.iesca.mortis.domaine;

public class CarteVisa extends CarteCredit {

	public CarteVisa(Client client, double plafond, Client banque) {
		super(client, plafond, banque);
	}

	@Override
	public String toString() {
			return super.toString() + "\n Carte Visa";
	}
}
