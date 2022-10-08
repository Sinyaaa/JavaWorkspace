package be.iesca.mortis.domaine;
public class CompteEpargne implements CompteEnBanque {

	private static final int DECOUVERT_MAXIMUM = 0; 

	private String numero;
	
	private double solde;
	
	private boolean cloture;	

	public CompteEpargne(String numero) {
		this.numero = numero;
		this.solde = 0;
		this.cloture = false;
	}
	
	public String getNumero() {
		return numero;
	}

	public double getSolde() {
		return solde;
	}

	public double getDecouvertMax() {
		return DECOUVERT_MAXIMUM;
	}

	public boolean isCloture() {
		return cloture;
	}
	
	public void cloturer() throws Exception {
		if(isCloture()) throw new Exception("Compte deja cloture");
		if(Math.abs(this.getSolde()) > 0.00001) throw new Exception("Solde non nul");
		// Ce test ne semble pas pleinement satisfaisant car
		// en java, les "double" ne sont pas les nombres les plus precis donc quand on
		// compare il faut faire attention.
		// On aurait pu comparer le solde restant à 0 en utilisant le type Math.BigDecimal
		// pour l'attribut solde.  Les BigDecimal sont des nombres a precision exacte.
		this.cloture = true;
	}

	public void deposer(double montant) throws Exception {
		if(isCloture()) throw new Exception("Compte deja cloture");
		if(montant<=0) throw new Exception("le montant doit etre strictement positif");
			
		this.solde += montant;
	}

	public void effectuerVirement(Client emetteur, CompteEnBanque destination,
			double montant) throws Exception {
		if(!emetteur.getCompteEpargne().equals(this)) throw new Exception("Titulaire errone");
		if(!emetteur.getCompteCourant().equals(destination))
			throw new Exception("Virement d'un compte epargne autorise seulement sur le compte courant du meme titulaire");
		if(destination.isCloture()) throw new Exception("Compte beneficiaire cloture");
		
		this.retirer(montant);
		destination.deposer(montant);
	}

	public void retirer(double montant) throws Exception {
		if(isCloture()) throw new Exception("Compte deja cloture");
		if(montant<=0) throw new Exception("le montant doit etre strictement positif");
		if(montant>solde) throw new Exception("Solde insuffisant");
		
		this.solde -= montant;
	}

	public boolean equals(Object autre){
		if(!(autre instanceof CompteEpargne)) return false;
		CompteEpargne autreCompte = (CompteEpargne) autre;
		return autreCompte.getNumero().equals(this.numero);
	}

}

