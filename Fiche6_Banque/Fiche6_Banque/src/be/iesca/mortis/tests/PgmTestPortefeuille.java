package be.iesca.mortis.tests;

import java.util.Iterator;

import be.iesca.mortis.domaine.CarteBancaire;
import be.iesca.mortis.domaine.CarteCredit;
import be.iesca.mortis.domaine.CarteDebit;
import be.iesca.mortis.domaine.CarteDebitSpecialisee;
import be.iesca.mortis.domaine.CarteMastercard;
import be.iesca.mortis.domaine.CarteVisa;
import be.iesca.mortis.domaine.Client;
import be.iesca.mortis.domaine.CompteCourant;
import be.iesca.mortis.domaine.CompteEnBanque;
import be.iesca.mortis.domaine.PortefeuilleCartesBancaires;

public class PgmTestPortefeuille {

	public static void main(String[] args) {
		try {
			// Compte de la banque
			Client banqueMortis = new Client("Banque Mortis", "", "", "", "");
			CompteEnBanque cpteDeLaBanque = new CompteCourant("BE65 6121 4645 1097", 1000, 1000);
			banqueMortis.setCompteCourant(cpteDeLaBanque);

			// Client Bill
			Client bill = new Client("Bocquet", "Bill", "42 rue Pestre...", "01/01/2001", "071/12.34.56");
			CompteCourant cpteCourantBill = new CompteCourant("BE65 6119 4645 1096", 1000, 1000);
			bill.setCompteCourant(cpteCourantBill);

			// Création des cartes
			CarteDebit carteDebit = new CarteDebit(bill);
			CarteDebitSpecialisee carteDebitSpec = new CarteDebitSpecialisee(bill, "c:/img/Bill.png");
			CarteVisa carteVisa = new CarteVisa(bill, 1000, banqueMortis);
			CarteMastercard carteMastercard = new CarteMastercard(bill, 2000, banqueMortis);

			// Obtention du portefeuille et ajout des cartes
			PortefeuilleCartesBancaires ptfCartesBill = bill.getPortefeuilleCartes();
			ptfCartesBill.add(carteDebit);
			ptfCartesBill.add(carteDebitSpec);
			ptfCartesBill.add(carteVisa);
			ptfCartesBill.add(carteMastercard);

			// Parcours du portefeuille de cartes de Bill
			for (CarteBancaire carte : ptfCartesBill) {
				System.out.println(carte);
			}

			// Client Bob
			Client bob = new Client("Boby", "Bob", "42 rue du Cora...", "12/06/2002", "065/12.34.33");
			CompteCourant cpteCourantBob = new CompteCourant("BE65 6119 4645 1095", 1000, 1000);
			bob.setCompteCourant(cpteCourantBob);

			// Paiements par carte
			for (CarteBancaire carte : ptfCartesBill) {
				carte.payer(cpteCourantBob, 100);
			}

			// Soldes
			System.out.println("Soldes des comptes après les paiements :");
			System.out.println("Solde compte courant Bill : " + cpteCourantBill.getSolde());
			System.out.println("Solde compte courant Bob : " + cpteCourantBob.getSolde());
			System.out.println("Solde compte de la banque : " + cpteDeLaBanque.getSolde());

			// Cartes de crédit: paiement des opérations en attente (fin du
			// mois)
			for (CarteBancaire carte : ptfCartesBill) {
				if (carte instanceof CarteCredit)
					((CarteCredit) carte).effectuerLesVirements();
			}
			// Soldes
			System.out.println("Soldes des comptes en fin de mois après les paiements des opérations en attente (cartes de crédit) :");
			System.out.println("Solde compte courant Bill : " + cpteCourantBill.getSolde());
			System.out.println("Solde compte courant Bob : " + cpteCourantBob.getSolde());
			System.out.println("Solde compte de la banque : " + cpteDeLaBanque.getSolde());

			try {
				// Essai de suppression des cartes du portefeuille via un
				// itérateur
				Iterator<CarteBancaire> iterateur = ptfCartesBill.iterator();
				while (iterateur.hasNext()) {
					iterateur.next();
					iterateur.remove();
				}
				System.out.println("Ce message ne devrait pas s'afficher. Il aurait du refuser les suppressions.");
			} catch (UnsupportedOperationException e) {
				System.out.println("Il a refusé les suppressions. C'est correct.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
