package be.iesca.mortis.tests;

import java.util.Iterator;

import be.iesca.mortis.domaine.Client;
import be.iesca.mortis.domaine.RegistreClients;

public class PgmTestRegistreClients {

	public static void main(String[] args) {
		try {
			// Client Bill
			Client bill = new Client("Bocquet", "Bill", "42 rue Pestre...", "01/01/2001", "071/12.34.56");

			// Client Bob
			Client bob = new Client("Boby", "Bob", "42 rue du Cora...", "12/06/2002", "065/12.34.33");

			// Ajout des clients au registre des clients
			RegistreClients registreClients = new RegistreClients();
			registreClients.add(bill);
			registreClients.add(bob);

			// Parcours du registre des clients
			for (Client client : registreClients) {
				System.out.println(client.getPrenom() + " " + client.getNom());
			}

			// Essai de suppression des clients via un it�rateur
			Iterator<Client> iterateur = registreClients.iterator();
			while (iterateur.hasNext()) {
				iterateur.next();
				iterateur.remove();
			}
			if (registreClients.isEmpty()) {
				System.out.println("Les clients ont �t� supprim�s");
			} else {
				System.out.println("Erreur : tous les clients n'ont pas �t� supprim�s!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
