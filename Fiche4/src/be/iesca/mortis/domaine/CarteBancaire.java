package be.iesca.mortis.domaine;

public class CarteBancaire {
	protected Client client;

	public CarteBancaire(Client client) {
		this.client = client;
	}
	
	public void payer(CompteEnBanque cpteDestination, double montant) throws Exception{
		throw new UnsupportedOperationException("Op�ration non support�e");
	}

	public String toString() {
		return "Carte bancaire du client : " + this.client.getNom() + " "
				+ this.client.getPrenom();
	}
	
}
