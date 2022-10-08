package be.iesca.mortis.tests;

import java.util.Iterator;

import be.iesca.mortis.domaine.Operation;
import be.iesca.mortis.domaine.RegistreOperations;

public class PgmTestRegistreOperations {

	public static void main(String[] args) {
		try {
			// Cr�ation du registre et des op�rations
			RegistreOperations registreOperations = new RegistreOperations();
			Operation operation1 = new Operation(null, 100, Operation.DEPOT, 100);
			Operation operation2 = new Operation(null, 50, Operation.RETRAIT, 50);

			// Ajout des op�rations au registre des op�rations
			registreOperations.add(operation1);
			registreOperations.add(operation2);

			// Parcours du registre des op�rations
			for (Operation operation : registreOperations) {
				System.out.println(operation);
			}

			// Essai de suppression des op�rations via un it�rateur
			Iterator<Operation> iterateur = registreOperations.iterator();
			while (iterateur.hasNext()) {
				iterateur.next();
				iterateur.remove();
			}
			System.out.println("Ce message ne devrait pas s'afficher. Il aurait du refuser les suppressions.");

		} catch (IllegalStateException e) {
			System.out.println("Il a refus� les suppressions. C'est correct.");

		}
	}
}
