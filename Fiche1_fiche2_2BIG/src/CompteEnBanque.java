public interface CompteEnBanque extends Comparable<CompteEnBanque> {

    double getSolde();
    double getDecouvertMax();
    String getNumero();
    boolean isCloture();
    boolean equals(Object autre);
    void cloturer() throws Exception;
    void deposer(double montant) throws Exception;
    void retirer(double montant) throws Exception;
    void effectuerVirement(Client client, CompteEnBanque compteEnBanque, double montant) throws Exception;

    default int compareTo(CompteEnBanque compteEnBanque){
        return (int) (this.getSolde()-compteEnBanque.getSolde());
    }
}