package be.iesca.mortis.domaine;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RegistreOperations implements Collection<Operation> {

	private static final int TAILLE_INI_REGISTRE = 100;
	private static final int AUGMENTATION_REGISTRE = 50;

	private Operation[] tableOperations; // registre des op�rations
	private int numOperation; // num�ro de la derni�re op�ration
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
	public boolean add(Operation op�ration) {
		if (this.contains(op�ration)) {
			return false;
		}
		if (this.numOperation == this.tableOperations.length) {
			agrandirTableRegistre();
		}
		this.numOperation++;
		op�ration.setNum�ro(this.numOperation);
		this.tableOperations[this.numOperation - 1] = op�ration;
		return true;
	}

	// agrandissement de la table des op�rations
	private void agrandirTableRegistre() {
		int taille = this.tableOperations.length + AUGMENTATION_REGISTRE;
		Operation[] histTemp = new Operation[taille];
		for (int i = 0; i < this.numOperation; i++) {
			histTemp[i] = this.tableOperations[i];
		}
		this.tableOperations = histTemp;
	}

	// renvoie le registre des op�rations sous forme de cha�ne
	// de caract�res
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

	// Classe interne : it�rateur
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
				throw new IllegalStateException("Le retrait n'est pas autoris�");

		}
	} // fin classe interne

	@Override
	public boolean contains(Object o) {
		if (o == null) {
			throw new NullPointerException("r�f�rence==null ");
		}
		if (!(o instanceof Operation)) {
			throw new ClassCastException("L'objet doit �tre de type" + "op�ration");
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
		throw new UnsupportedOperationException("op�ration refus�e");
	}

	@Override
	public boolean remove(Object o) {
		if (!this.removeAutorise)
			throw new UnsupportedOperationException(
					"Les retraits ne sont pas autoris�s dans le registre" + " des op�rations");
		if (!(o instanceof Operation)) {
			throw new ClassCastException("L'objet doit �tre de type" + "Operation");
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
		throw new UnsupportedOperationException("op�ration refus�e");
	}

	@Override
	public boolean addAll(Collection<? extends Operation> arg0) {
		throw new UnsupportedOperationException("op�ration refus�e");
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		throw new UnsupportedOperationException("op�ration refus�e");
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		throw new UnsupportedOperationException("op�ration refus�e");
	}

	@Override
	public Object[] toArray() {
		throw new UnsupportedOperationException("op�ration refus�e");
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		throw new UnsupportedOperationException("op�ration refus�e");
	}
}
