package be.iesca.mortis.util;

import java.util.Comparator;

import be.iesca.mortis.domaine.Client;

public class ComparateurNoms implements Comparator<Client> {

	@Override
	public int compare(Client c1, Client c2) {
		return c1.getNom().compareTo(c2.getNom());
	}
	
}
