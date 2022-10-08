public class CarteCredit extends CarteBancaire{
    private double plafond;
    private Client banqueING;

    public CarteCredit(Client client, double plafond, Client banqueING) {
        super(client);
        this.plafond = plafond;
        this.banqueING = banqueING;
    }

    public void payer() throws Exception {

    }

    public boolean effectuerLesVirements(){

    }
}
