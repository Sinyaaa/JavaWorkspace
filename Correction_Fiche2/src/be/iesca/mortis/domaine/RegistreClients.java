package be.iesca.mortis.domaine;

import java.util.Collection;
import java.util.Iterator;

public class RegistreClients implements Collection<Client> {

	private static final int TAILLE_INI_REGISTRE = 100;

	private Client[] registre;
	private int nbClients;

	public RegistreClients() {
		super();
		this.registre = new Client[TAILLE_INI_REGISTRE];
		this.nbClients = 0;
	}

	@Override
	public boolean add(Client client) {
		if (this.contains(client)) {
			return false;
		}
		if (this.nbClients == this.registre.length) {
			agrandirRegistre();
		}
		this.registre[this.nbClients] = client;
		this.nbClients++;
		return true;
	}

	private void agrandirRegistre() {
		int taille = this.registre.length * 2;
		Client[] newRegistre = new Client[taille];
		for (int i = 0; i < registre.length; i++) {
			newRegistre[i] = registre[i];
		}
		this.registre = newRegistre;
	}

	@Override
	public void clear() {
		for (int i = 0; i < nbClients; i++) {
			registre[i] = null;
		}
		nbClients = 0;
	}

	@Override
	public boolean contains(Object o) {
		if (o == null) {
			throw new NullPointerException("référence==null ");
		}
		if (!(o instanceof Client)) {
			throw new ClassCastException("L'objet doit être de type" + "Client");
		}
		for (int i = 0; i < nbClients; i++) {
			Client client = registre[i];
			if (client.equals(o))
				return true;
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return nbClients == 0;
	}

	@Override
	public Iterator<Client> iterator() {
		throw new UnsupportedOperationException("opération refusée");
	}

	@Override
	public boolean remove(Object o) {
		if (!(o instanceof Client)) {
			throw new ClassCastException("L'objet doit être de type" + "Client");
		}
		for (int i = 0; i < nbClients; i++) {
			if (registre[i].equals(o)) {
				registre[i] = registre[nbClients - 1];
				registre[nbClients - 1] = null;
				nbClients--;
				return true;
			}
		}
		return false;
	}

	@Override
	public int size() {
		return this.nbClients;
	}

	@Override
	public Object[] toArray() {
		return registre.clone();
	}

	@Override
	public boolean addAll(Collection<? extends Client> c) {
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
