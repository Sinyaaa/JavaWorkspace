package be.iesca.mortis.domaine;

public abstract class CarteBancaire {
	protected Client client;

	public  CarteBancaire(Client client) {
		this.client = client;
	}
	public abstract void payer(CompteEnBanque cpteDestination, double montant) throws Exception;

	public String toString() {
		return "Carte bancaire du client : " + this.client.getNom() + " "
				+ this.client.getPrenom();
	}
	
}
