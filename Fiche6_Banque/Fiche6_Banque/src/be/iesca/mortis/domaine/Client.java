package be.iesca.mortis.domaine;
public class Client {

	private String nom;
	private String prenom;
	
	private String adresse;
	
	private String dateNaissance;
	
	private String numTel;
	
	private CompteEnBanque compteCourant;
	private CompteEnBanque compteEpargne;
	
	private PortefeuilleCartesBancaires portefeuilleCartes;

	
	public Client(String nom, String prenom, String adresse,
			String dateNaissance, String numTel) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.dateNaissance = dateNaissance;
		this.numTel = numTel;
		this.portefeuilleCartes = new PortefeuilleCartesBancaires();
	}

	public String getAdresse() {
		return adresse;
	}

	public PortefeuilleCartesBancaires getPortefeuilleCartes() {
		return portefeuilleCartes;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public CompteEnBanque getCompteCourant() {
		return compteCourant;
	}

	public void setCompteCourant(CompteEnBanque compteCourant) {
		this.compteCourant = compteCourant;
	}

	public CompteEnBanque getCompteEpargne() {
		return compteEpargne;
	}

	public void setCompteEpargne(CompteEnBanque compteEpargne) {
		this.compteEpargne = compteEpargne;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}
	
	public boolean equals(Object autre){
		if(!(autre instanceof Client)) return false;
		Client autreClient = (Client) autre;
		if(!autreClient.getNom().equals(this.getNom())) return false;		
		if(!autreClient.getPrenom().equals(this.getPrenom())) return false;		
		if(!autreClient.getDateNaissance().equals(this.getDateNaissance())) return false;		
		if(!autreClient.getAdresse().equals(this.getAdresse())) return false;		
		return true;
	}
	
}

