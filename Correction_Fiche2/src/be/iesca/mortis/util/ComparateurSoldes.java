package be.iesca.mortis.util;

import java.util.Comparator;

import be.iesca.mortis.domaine.Client;

public class ComparateurSoldes implements Comparator<Client> {

	@Override
	public int compare(Client c1, Client c2) {
		double soldeClient1 = c1.getCompteCourant().getSolde()
				+ c1.getCompteEpargne().getSolde();
		double soldeClient2 = c2.getCompteCourant().getSolde()
				+ c2.getCompteEpargne().getSolde();
		return (int) (soldeClient1 - soldeClient2);
	}

}
