import java.util.Iterator;

public class PgmTestPorteFeuilleCartesBancaires {
    public static void main(String Args[]) throws Exception {
        Client banqueING = new Client("ING", "Banque", "16 Place Saint-Roch", "12/05/1966", "025472111");
        Client client1 = new Client("Delsine", "Benjamin", "45 Avenue de Charleroi", "25/10/2000", "047565987");;

        CompteCourant cptCourantBanque = new CompteCourant("BE457589", 125045678, 500000);
        CompteCourant cptCourantClient1 = new CompteCourant("BE458912", 5000, 500);

        client1.setCompteCourant(cptCourantClient1);
        banqueING.setCompteCourant(cptCourantBanque);

        CarteDebit crdDebitClient = new CarteDebit(client1);
        CarteDebitSpecialisee crdDebitSpeClient = new CarteDebitSpecialisee(client1, "tennis.png");
        CarteVisa crdVisaClient = new CarteVisa(client1, 500, banqueING);
        CarteMastercard crdMastercardClient = new CarteMastercard(client1, 500, banqueING);

        PortefeuilleCartesBancaires porteFeuilleCarte = new PortefeuilleCartesBancaires();
        porteFeuilleCarte.add(crdDebitClient);
        porteFeuilleCarte.add(crdDebitSpeClient);
        porteFeuilleCarte.add(crdVisaClient);
        porteFeuilleCarte.add(crdMastercardClient);

        Iterator<CarteBancaire> iterateurCartes = porteFeuilleCarte.iterator();

        while (iterateurCartes.hasNext()){
            CarteBancaire carteBancaire = iterateurCartes.next();
            System.out.println(carteBancaire.toString());
        }

        Client client2 = new Client("Assabban", "Yassin", "89 Rue Albert 1er", "07/04/2001", "0478987898");
        CompteCourant cptCourantClient2 = new CompteCourant("BE562398", 5000, 500);

        client2.setCompteCourant(cptCourantClient2);

        System.out.println(cptCourantClient2.getSolde());


        while (iterateurCartes.hasNext()){
            CarteBancaire carteBancaire = iterateurCartes.next();
            carteBancaire.payer(cptCourantClient2, 500);
        }

        System.out.println(cptCourantClient2.getSolde());





    }
}
