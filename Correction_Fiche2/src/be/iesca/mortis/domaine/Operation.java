package be.iesca.mortis.domaine;
import java.util.GregorianCalendar;

public class Operation {

	// constantes
	public static final int CREATION = 0;
	public static final int DEPOT = 1;
	public static final int RETRAIT = 2;
	public static final int VIREMENT_DEBIT = 3;
	public static final int VIREMENT_CREDIT = 4;
	public static final int CLOTURE = 5;
	public static final int VIREMENT_EN_ATTENTE = 6;
	
	// attributs
	private GregorianCalendar date; // date de l'op�ration
	private int type; // creation, retrait, depot, virement ou cloture
	private double montant; // montant de l'op�ration
	private CompteEnBanque autreCompte; // utilis� pour les virements
	private int numero; // num�ro d'identification de l'op�ration
	private double solde; // solde du compte apr�s l'op�ration
	
	// construction d'une op�ration, on ne connait pas encore son num�ro (-1)
	// il sera d�termin� lors de l'ajout de l'op�ration � l'historique
	public Operation( CompteEnBanque autreCompte, double montant, int type,
			double solde ) {
		this.autreCompte = autreCompte;
		if ( type == Operation.RETRAIT || 
				type == Operation.VIREMENT_DEBIT ) montant = -montant;
		this.date = new GregorianCalendar();
		this.montant = montant;
		this.numero = -1;
		this.type = type;
		this.solde = solde;
	}

	// m�thode qui renvoie les donn�es principales de l'op�ration
	// sous forme d'une cha�ne de caract�res
	public String toString() {
		String message =  "Op�ration n� " + this.numero + " du " + 
		this.date + " de type : " + getTypeString()  + 
		", montant : " + this.montant + ", solde : " + this.solde;
		
		if  ( this.type == VIREMENT_CREDIT ) 
			message += " compte d�biteur : " +	this.autreCompte.getNumero();
		if  ( this.type == VIREMENT_DEBIT ) 
			message += " compte cr�diteur : " + this.autreCompte.getNumero();
		return message; 
	}

	// renvoie le type d'op�ration sous forme d'une cha�ne de caract�res
	public String getTypeString() {
		switch ( this.type ) {
			case CREATION : return "CREATION";
			case DEPOT : return "DEPOT";
			case RETRAIT : return "RETRAIT";
			case VIREMENT_DEBIT : return "VIREMENT_DEBIT";
			case VIREMENT_CREDIT : return "VIREMENT_CREDIT";
			case CLOTURE : return "CLOTURE";
			default : return "OPERATION INCONNUE"; 
		}
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public GregorianCalendar getDate() {
		return date;
	}

	public int getType() {
		return type;
	}

	public double getMontant() {
		return montant;
	}

	public CompteEnBanque getAutreCompte() {
		return autreCompte;
	}

	public double getSolde() {
		return solde;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Operation other = (Operation) obj;
		if (autreCompte == null) {
			if (other.autreCompte != null)
				return false;
		} else if (!autreCompte.equals(other.autreCompte))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (Double.doubleToLongBits(montant) != Double
				.doubleToLongBits(other.montant))
			return false;
		if (numero != other.numero)
			return false;
		if (Double.doubleToLongBits(solde) != Double
				.doubleToLongBits(other.solde))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
} // fin classe Operation
