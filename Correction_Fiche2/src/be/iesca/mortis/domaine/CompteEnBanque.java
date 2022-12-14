package be.iesca.mortis.domaine;
public interface CompteEnBanque {

	/* des methodes qui posent des questions */
	double getSolde(); 
	double getDecouvertMax();
	String getNumero();
	boolean isCloture();
	boolean equals(Object autre);
	RegistreOperations getRegistreOperations();
	
	/* des methodes qui agissent sur l'objet cible */
	void cloturer() throws Exception;
	void deposer(double montant) throws Exception;
	void retirer(double montant) throws Exception;
	void effectuerVirement(Client emetteur, CompteEnBanque cpteDestination, double montant) throws Exception;	

}

