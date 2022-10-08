package be.iesca.mortis.domaine;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RegistreOperations implements Collection<Operation> {

	private static final int TAILLE_INI_REGISTRE = 100;
	private static final int AUGMENTATION_REGISTRE = 50;

	private Operation[] tableOperations; // registre des opérations
	private int numOperation; // numéro de la dernière opération
	private boolean removeAutorise = false;

	public RegistreOperations() {
		super();
		this.tableOperations = new Operation[TAILLE_INI_REGISTRE];
		this.numOperation = 0;
		this.add(new Operation(null, 0, Operation.CREATION, 0));
	}

	public RegistreOperations(boolean removeAutorise) {
		this();
		this.removeAutorise = removeAutorise;
	}

	@Override
	public boolean add(Operation opération) {
		if (this.contains(opération)) {
			return false;
		}
		if (this.numOperation == this.tableOperations.length) {
			agrandirTableRegistre();
		}
		this.numOperation++;
		opération.setNuméro(this.numOperation);
		this.tableOperations[this.numOperation - 1] = opération;
		return true;
	}

	// agrandissement de la table des opérations
	private void agrandirTableRegistre() {
		int taille = this.tableOperations.length + AUGMENTATION_REGISTRE;
		Operation[] histTemp = new Operation[taille];
		for (int i = 0; i < this.numOperation; i++) {
			histTemp[i] = this.tableOperations[i];
		}
		this.tableOperations = histTemp;
	}

	// renvoie le registre des opérations sous forme de chaîne
	// de caractères
	public String toString() {
		if (this.numOperation == 0)
			return "Historique vide";
		String resultat = "";
		for (int i = 0; i < this.numOperation; i++) {
			resultat += this.tableOperations[i] + "\n";
		}
		return resultat;
	}

	@Override
	public Iterator<Operation> iterator() {
		return new IterateurOperation();
	}

	// Classe interne : itérateur
	class IterateurOperation implements Iterator<Operation> {
		private int indice = 0;
		private boolean removeAutoriseIterateur = false;

		public boolean hasNext() {
			return indice < numOperation;
		}

		public Operation next() {
			if (!hasNext())
				throw new NoSuchElementException("Plus d'operations");
			this.removeAutoriseIterateur = true;
			return tableOperations[indice++];
		}

		public void remove() {
			if (removeAutorise && this.removeAutoriseIterateur) {
				tableOperations[--indice] = tableOperations[numOperation - 1];
				tableOperations[numOperation - 1] = null;
				numOperation--;
				this.removeAutoriseIterateur = false;
			} else
				throw new IllegalStateException("Le retrait n'est pas autorisé");

		}
	} // fin classe interne

	@Override
	public boolean contains(Object o) {
		if (o == null) {
			throw new NullPointerException("référence==null ");
		}
		if (!(o instanceof Operation)) {
			throw new ClassCastException("L'objet doit être de type" + "opération");
		}
		for (int i = 0; i < this.numOperation; i++) {
			if (this.tableOperations[i].equals(o))
				return true;
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return numOperation == 0;
	}

	@Override
	public int size() {
		return numOperation;
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException("opération refusée");
	}

	@Override
	public boolean remove(Object o) {
		if (!this.removeAutorise)
			throw new UnsupportedOperationException(
					"Les retraits ne sont pas autorisés dans le registre" + " des opérations");
		if (!(o instanceof Operation)) {
			throw new ClassCastException("L'objet doit être de type" + "Operation");
		}
		for (int i = 0; i < this.numOperation; i++) {
			if (tableOperations[i].equals(o)) {
				tableOperations[i] = tableOperations[numOperation - 1];
				tableOperations[numOperation - 1] = null;
				numOperation--;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		throw new UnsupportedOperationException("opération refusée");
	}

	@Override
	public boolean addAll(Collection<? extends Operation> arg0) {
		throw new UnsupportedOperationException("opération refusée");
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		throw new UnsupportedOperationException("opération refusée");
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		throw new UnsupportedOperationException("opération refusée");
	}

	@Override
	public Object[] toArray() {
		throw new UnsupportedOperationException("opération refusée");
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		throw new UnsupportedOperationException("opération refusée");
	}
}
