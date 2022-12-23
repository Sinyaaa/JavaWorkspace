package be.iesca.mortis.domaine;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PortefeuilleCartesBancaires implements Collection<CarteBancaire> {

	private static final int TAILLE_INI_REGISTRE = 100;

	private CarteBancaire[] portefeuille;
	private int nbCartes;

	public PortefeuilleCartesBancaires() {
		super();
		this.portefeuille = new CarteBancaire[TAILLE_INI_REGISTRE];
		this.nbCartes = 0;
	}

	@Override
	public boolean add(CarteBancaire carteBancaire) {
		if (this.contains(carteBancaire)) {
			return false;
		}
		if (this.nbCartes == this.portefeuille.length) {
			agrandirRegistre();
		}
		this.portefeuille[this.nbCartes] = carteBancaire;
		this.nbCartes++;
		return true;
	}

	private void agrandirRegistre() {
		int taille = this.portefeuille.length * 2;
		CarteBancaire[] newRegistre = new CarteBancaire[taille];
		for (int i = 0; i < portefeuille.length; i++) {
			newRegistre[i] = portefeuille[i];
		}
		this.portefeuille = newRegistre;
	}

	@Override
	public void clear() {
		for (int i = 0; i < nbCartes; i++) {
			portefeuille[i] = null;
		}
		nbCartes = 0;
	}

	@Override
	public boolean contains(Object o) {
		if (o == null) {
			throw new NullPointerException("référence==null ");
		}
		if (!(o instanceof CarteBancaire)) {
			throw new ClassCastException("L'objet doit être de type" + "CarteBancaire");
		}
		for (int i = 0; i < nbCartes; i++){
			CarteBancaire carteBancaire = portefeuille[i]; 
			if (carteBancaire.equals(o))
				return true;
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return nbCartes == 0;
	}

	@Override
	public Iterator<CarteBancaire> iterator() {
		return new IterateurPortefeuille();
	}
	
	// Classe interne : itérateur
	class IterateurPortefeuille implements Iterator<CarteBancaire> {
		private int indice = 0;
		
		public boolean hasNext() {
			return indice<nbCartes;
		}
		public CarteBancaire next() {
			if ( !hasNext() ) 
				throw new NoSuchElementException("Plus de cartes");
			return portefeuille[indice++];
		}
		public void remove() {
			throw new UnsupportedOperationException("opération de retrait refusée");
		}
	} // fin classe interne

	@Override
	public boolean remove(Object o) {
		if (!(o instanceof CarteBancaire)) {
			throw new ClassCastException("L'objet doit être de type" + "CarteBancaire");
		}
		for (int i = 0; i < nbCartes; i++) {
			if (portefeuille[i].equals(o)) {
				portefeuille[i] = portefeuille[nbCartes - 1];
				portefeuille[nbCartes - 1] = null;
				nbCartes--;
				return true;
			}
		}
		return false;
	}

	@Override
	public int size() {
		return this.nbCartes;
	}

	@Override
	public Object[] toArray() {
		return portefeuille.clone();
	}

	@Override
	public boolean addAll(Collection<? extends CarteBancaire> c) {
		throw new UnsupportedOperationException("opération refusée");
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		throw new UnsupportedOperationException("opération refusée");
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException("opération refusée");
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException("opération refusée");
	}

	@Override
	public <T> T[] toArray(T[] a) {
		throw new UnsupportedOperationException("opération refusée");
	}

}
