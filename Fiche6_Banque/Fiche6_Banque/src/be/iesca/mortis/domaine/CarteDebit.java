package be.iesca.mortis.domaine;


public class CarteDebit extends CarteBancaire {

	public CarteDebit(Client client) {
		super(client);
	}

	public void payer(CompteEnBanque cpteDestination, double montant) throws Exception {
		CompteEnBanque cptEmetteur = this.client.getCompteCourant();
		cptEmetteur.effectuerVirement(this.client, cpteDestination, montant);
	}
	
	@Override
	public String toString() {
		return "Carte de débit du client : " + this.client.getNom() + " "
				+ this.client.getPrenom();
	}
	
}
