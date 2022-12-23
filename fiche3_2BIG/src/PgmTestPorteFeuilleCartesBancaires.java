import java.util.Iterator;

public class PgmTestPorteFeuilleCartesBancaires {
    public static void main(String Args[]) throws Exception {
        Client banqueING = new Client("ING", "Banque", "16 Place Saint-Roch", "12/05/1966", "025472111");
        Client client1 = new Client("Delsine", "Benjamin", "45 Avenue de Charleroi", "25/10/2000", "047565987");;

        CompteCourant cptCourantBanque = new CompteCourant("BE457589", 120000, 500000);
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


        System.out.println("--------------------------- VOS CARTES ------------------------------");
        while (iterateurCartes.hasNext()){
            CarteBancaire carteBancaire = iterateurCartes.next();
            System.out.println(carteBancaire.toString());
        }


        System.out.println("--------------------------- VIREMENT CPT COURANT CLIENT 1 VERS CPT COURANT CLIENT 2 ------------------------------");
        Client client2 = new Client("Assabban", "Yassin", "89 Rue Albert 1er", "27/06/1999", "0478987898");
        CompteCourant cptCourantClient2 = new CompteCourant("BE562398", 5000, 500);

        client2.setCompteCourant(cptCourantClient2);

        System.out.println("Avant-Virement(s)");

        System.out.println(cptCourantClient1.getSolde());
        System.out.println(cptCourantClient2.getSolde());

        iterateurCartes = porteFeuilleCarte.iterator();
        System.out.println("Virement(s) Effectué(s)");

        while (iterateurCartes.hasNext()){
            CarteBancaire carteBancaire = iterateurCartes.next();
            carteBancaire.payer(cptCourantClient2, 250);
            System.out.println(cptCourantClient1.getSolde());
            System.out.println(cptCourantClient2.getSolde());
        }


        System.out.println("--------------------------- Suppression des Cartes ------------------------------");
        iterateurCartes = porteFeuilleCarte.iterator();

        while (iterateurCartes.hasNext()){
            CarteBancaire carteBancaire = iterateurCartes.next();
            iterateurCartes.remove();
            if (porteFeuilleCarte.isEmpty()){
                System.out.println("Les cartes on été supprimés");
            } else {
                System.out.println("ERREUR CARTES(S) ENCORE PRESENTE(S)");
            }
        }
    }
}