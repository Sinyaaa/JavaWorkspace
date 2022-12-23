package be.iesca.mortis.tests;

import be.iesca.mortis.domaine.CarteVisa;
import be.iesca.mortis.domaine.Client;
import be.iesca.mortis.domaine.CompteCourant;
import be.iesca.mortis.domaine.CompteEnBanque;

public class PgmTestCarteCredit {

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

			// Création d'une carte de crédit
			CarteVisa carteVisa = new CarteVisa(bill, 1000, banqueMortis);

			// Client Bob
			Client bob = new Client("Boby", "Bob", "42 rue du Cora...", "12/06/2002", "065/12.34.33");
			CompteCourant cpteCourantBob = new CompteCourant("BE65 6119 4645 1095", 1000, 1000);
			bob.setCompteCourant(cpteCourantBob);

			// Paiement par carte
			carteVisa.payer(cpteCourantBob, 100);

			// Soldes
			System.out.println("Soldes des comptes après le paiement :");
			System.out.println("Solde compte courant Bill : " + cpteCourantBill.getSolde());
			System.out.println("Solde compte courant Bob : " + cpteCourantBob.getSolde());
			System.out.println("Solde compte de la banque : " + cpteDeLaBanque.getSolde());

			// Le client Bill est débité en fin de mois
			carteVisa.effectuerLesVirements();
			
			// Soldes
			System.out.println(
					"Soldes des comptes en fin de mois après le paiement de l'opération en attente (carte Visa) :");
			System.out.println("Solde compte courant Bill : " + cpteCourantBill.getSolde());
			System.out.println("Solde compte courant Bob : " + cpteCourantBob.getSolde());
			System.out.println("Solde compte de la banque : " + cpteDeLaBanque.getSolde());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
