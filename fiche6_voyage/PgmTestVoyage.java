import java.time.LocalDate;

public class PgmTestVoyage {
    public static void main(String Args[]){

        LocalDate dateVolAller = LocalDate.of(2011, 6 ,27);
        LocalDate dateVolRetour = LocalDate.of(2010, 7 ,12);
        LocalDate dateSejour = LocalDate.of(2011, 6 ,27);
        Vol volAller1 = new Vol(dateVolAller, "FR2033", "BXL", "ORLY");
        Vol volRetour1= new Vol(dateVolRetour, "FR0456", "CDG", "BXL");
        Reservation reservation1 = new Reservation("Mercure Hotel", 4, 180);
        Sejour sejour1 = new Sejour(dateSejour,15, 0 ,volAller1, volRetour1, reservation1);

        System.out.println(sejour1.CalculerPrix());





    }
}
