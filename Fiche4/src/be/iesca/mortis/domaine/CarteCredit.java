package be.iesca.mortis.domaine;

import java.util.Iterator;

/*
 * Remarque :
 *  Cette classe porte mal son nom. Il s'agit d'une carte de débit à paiement différé.
 *  Le compte courant associé à cette carte est débité en fin du mois.
 *  Une carte de crédit est plus souple car le remboursement du crédit se fait au rythme du titulaire,
 *  donc pas uniquement à la fin du mois. Mais il paie des intérêts parfois très élevés.
 *  Il n'y a pas d'intérêts perçus pour l'utilisation du plafond lié à la carte de débit à paiement différé. 
 */

public class CarteCredit extends CarteBancaire {
	private double plafond;
	private RegistreOperations paiementsEnAttente;
	private Client banqueMortis; // nécessaire pour les paiements

	public CarteCredit(Client client, double plafond, Client banque) {
		super(client);
		this.plafond = plafond;
		this.paiementsEnAttente = new RegistreOperations(true);
		this.banqueMortis = banque;
		retraitOperationCreation();
	}

	private void retraitOperationCreation() {
		Iterator<Operation> it = this.paiementsEnAttente.iterator();
		while (it.hasNext()) {
			it.next();
			it.remove();
		}
	}

	public void payer(CompteEnBanque cpteDestination, double montant) throws Exception {
		double totalPaiementsEnAttente = totalPaiementsEnAttente();
		if (totalPaiementsEnAttente > plafond)
			throw new Exception("Le plafond ne permet pas d'effectuer ce paiement");

		// enregistrement du paiement en attente de la fin du mois
		// le client sera débité à la fin du mois
		Operation operation = new Operation(cpteDestination, montant, Operation.VIREMENT_EN_ATTENTE, 0);
		this.paiementsEnAttente.add(operation);
		
		// transfert du compte de la banque vers le compte de destination
		CompteEnBanque cptDeLaBanque = this.banqueMortis.getCompteCourant();
		cptDeLaBanque.effectuerVirement(banqueMortis, cpteDestination, montant);
	}

	private double totalPaiementsEnAttente() {
		Iterator<Operation> it = this.paiementsEnAttente.iterator();
		double total = 0;
		while (it.hasNext()) {
			Operation operation = it.next();
			total += operation.getMontant();
		}
		return total;
	}

	public boolean effectuerLesVirements() throws Exception {
		Iterator<Operation> it = this.paiementsEnAttente.iterator();
		CompteCourant cpteCourant = (CompteCourant) this.client.getCompteCourant();	
		CompteEnBanque cpteDeLaBanque = this.banqueMortis.getCompteCourant();
		double montant = 0;
		boolean soldeSuffisant = true;
		double montantSoldeInsuffisant = 0;
		while (it.hasNext()) {
			Operation operation = it.next();
			montant = operation.getMontant();
			if (cpteCourant.getSolde() - montant > -cpteCourant.getDecouvertMax()) {
				// solde suffisant
				cpteCourant.effectuerVirement(client, cpteDeLaBanque, montant);
				it.remove();
			} else {
				// solde insuffisant
				soldeSuffisant = false;
				montantSoldeInsuffisant += montant;
			}
		}
		if (!soldeSuffisant) {			
			Operation operation = new Operation(cpteDeLaBanque, montantSoldeInsuffisant * 0.1,
					Operation.VIREMENT_EN_ATTENTE, 0);
			this.paiementsEnAttente.add(operation);
		}
		return soldeSuffisant;
	}

	public String toString() {
		return "Carte de crédit du client : " + this.client.getNom() + " " + this.client.getPrenom();
	}

}
