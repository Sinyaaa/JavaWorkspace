import java.util.Iterator;

public class PgmTestRegistreOperations {
    public static void main(String Args[]) throws Exception {
        Client client1 = new Client("Haulet", "Thomas", "12 Avenue de Thuin", "25/09/2000", "0465789845");
        Client client2 = new Client("Delsine", "Benjamin", "45 Avenue de Charleroi", "07/04/2001", "047565987");

        CompteCourant compteCourantClient1 = new CompteCourant("BE457589", 1250, 500);
        CompteCourant compteCourantClient2 = new CompteCourant("BE458912", 500, 500);

        CompteEpargne compteEpargneClient1 = new CompteEpargne("BE357589");
        CompteEpargne compteEpargneClient2 = new CompteEpargne("BE358912");

        client1.setCompteCourant(compteCourantClient1);
        client1.setCompteEpargne(compteEpargneClient1);
        client2.setCompteCourant(compteCourantClient2);
        client2.setCompteEpargne(compteEpargneClient2);

        RegistreClients registreClient = new RegistreClients();
        RegistreOperations registreOperations = new RegistreOperations();

        Iterator<Client> iterateurClient = registreClient.iterator();
        Iterator<Operation> iterateurOperation = registreOperations.iterator();


        while (iterateurOperation.hasNext()){
            Operation operation = iterateurOperation.next();
            System.out.println(operation);
        }
    }
}
