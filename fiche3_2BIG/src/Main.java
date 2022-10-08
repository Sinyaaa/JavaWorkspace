public class Main {

    public static void main(String Args[]) throws Exception {

        Client client1 = new Client("Haulet", "Thomas", "12 Avenue de Thuin", "25/09/2000", "0465789845");
        Client client2 = new Client("Delsine", "Benjamin", "45 Avenue de Charleroi", "07/.04/2001", "047565987");

        CompteCourant compteCourantClient1 = new CompteCourant("BE457589", 1250, 500);
        CompteCourant compteCourantClient2 = new CompteCourant("BE458912", 500, 500);

        CompteEpargne compteEpargneClient1 = new CompteEpargne("BE357589");
        CompteEpargne compteEpargneClient2 = new CompteEpargne("BE358912");

        client1.setCompteCourant(compteCourantClient1);
        client1.setCompteEpargne(compteEpargneClient1);
        client2.setCompteCourant(compteCourantClient2);
        client2.setCompteEpargne(compteEpargneClient2);

        ComparateurNoms comparateurNomsClient = new ComparateurNoms();
        ComparateurSoldes comparateurSoldesClient = new ComparateurSoldes();

/*
        System.out.println(comparateurNomsClient.compare(client1, client2));
        System.out.println(comparateurSoldesClient.compare(client1, client2));
*/
/*
        System.out.println("------------------- [COMPTE COURANT CLIENT 1] ------------------- ");
                System.out.println(compteCourantClient1.getSolde());
                System.out.println(compteCourantClient1.getNumero());
        System.out.println("--------------------------- [COMPTE COURANT CLIENT 2] -------------------");
                System.out.println(compteCourantClient2.getSolde());
                System.out.println(compteCourantClient2.getNumero());

        System.out.println("--------------------------- [COMPTE EPARGNE CLIENT 1] -------------------");
                System.out.println(compteEpargneClient1.getSolde());
                System.out.println(compteEpargneClient1.getNumero());

        System.out.println("--------------------------- [COMPTE EPARGNE CLIENT 1] -------------------");
                System.out.println(compteEpargneClient1.getSolde());
                System.out.println(compteEpargneClient1.getNumero()); */

        /* System.out.println("----- [VIREMENT CLIENT 1 COMPTE COURANT VERS CLIENT 2 COMPTE COURANT ] -----");
                System.out.println(compteCourantClient1.getSolde());
                System.out.println(compteCourantClient2.getSolde());
                compteCourantClient1.effectuerVirement(client1, compteCourantClient2, 500);
                System.out.println(compteCourantClient1.getSolde());
                System.out.println(compteCourantClient2.getSolde()); */

       /* System.out.println("----- [VIREMENT CLIENT 1 COMPTE COURANT VERS CLIENT 1 COMPTE EPARGNE ] -----");
        System.out.println(compteCourantClient1.getSolde());
        System.out.println(compteEpargneClient1.getSolde());
        compteCourantClient1.effectuerVirement(client1, compteEpargneClient1, 500);
        System.out.println(compteCourantClient1.getSolde());
        System.out.println(compteEpargneClient1.getSolde()); */

       /* System.out.println("----- [VIREMENT CLIENT 1 COMPTE COURANT VERS CLIENT 2 COMPTE EPARGNE ] -----");
        System.out.println(compteCourantClient1.getSolde());
        System.out.println(compteEpargneClient2.getSolde());
        compteCourantClient1.effectuerVirement(client1, compteEpargneClient2, 500);
        System.out.println(compteCourantClient1.getSolde());
        System.out.println(compteEpargneClient2.getSolde()); */

      /*   System.out.println("----- [VIREMENT CLIENT 1 COMPTE EPARGNE VERS CLIENT 2 COMPTE COURANT ] -----");
        System.out.println(compteEpargneClient1.getSolde());
        compteEpargneClient1.deposer(1000);
        System.out.println(compteEpargneClient1.getSolde());
        System.out.println(compteCourantClient2.getSolde());
        compteEpargneClient1.effectuerVirement(client1, compteCourantClient2, 500);
        System.out.println(compteEpargneClient1.getSolde());
        System.out.println(compteCourantClient2.getSolde()); */



    }
}
