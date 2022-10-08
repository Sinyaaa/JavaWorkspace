import java.util.Comparator;

public class ComparateurSoldes implements Comparator<Client>{


    @Override
    public int compare(Client o1, Client o2) {
        double SoldeClient1Total = o1.getCompteCourant().getSolde() + o1.getCompteEpargne().getSolde();
        double SoldeClient2Total = o2.getCompteCourant().getSolde() + o2.getCompteEpargne().getSolde();

        return (int) (SoldeClient1Total - SoldeClient2Total);
    }
}
