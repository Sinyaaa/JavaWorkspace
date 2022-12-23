package be.iesca.mortis.tests;

import java.util.Iterator;

import be.iesca.mortis.domaine.Operation;
import be.iesca.mortis.domaine.RegistreOperations;

public class PgmTestRegistreOperations {

	public static void main(String[] args) {
		try {
			// Création du registre et des opérations
			RegistreOperations registreOperations = new RegistreOperations();
			Operation operation1 = new Operation(null, 100, Operation.DEPOT, 100);
			Operation operation2 = new Operation(null, 50, Operation.RETRAIT, 50);

			// Ajout des opérations au registre des opérations
			registreOperations.add(operation1);
			registreOperations.add(operation2);

			// Parcours du registre des opérations
			for (Operation operation : registreOperations) {
				System.out.println(operation);
			}

			// Essai de suppression des opérations via un itérateur
			Iterator<Operation> iterateur = registreOperations.iterator();
			while (iterateur.hasNext()) {
				iterateur.next();
				iterateur.remove();
			}
			System.out.println("Ce message ne devrait pas s'afficher. Il aurait du refuser les suppressions.");

		} catch (IllegalStateException e) {
			System.out.println("Il a refusé les suppressions. C'est correct.");

		}
	}
}
