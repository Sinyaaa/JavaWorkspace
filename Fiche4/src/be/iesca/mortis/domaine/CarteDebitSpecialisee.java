package be.iesca.mortis.domaine;

public class CarteDebitSpecialisee extends CarteDebit {

	private String image;

	public CarteDebitSpecialisee(Client client, String image) {
		super(client);
		this.image = image;
	}

	@Override
	public String toString() {
		return super.toString() + " sp�cialis�e" + "\n" + "Fichier image : " + this.image;
	}
}
