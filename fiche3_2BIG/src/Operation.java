import java.util.GregorianCalendar;
import java.util.Objects;

public class Operation {

    public static final int CREATION = 1;
    public static final int DEPOT = 2;
    public static final int RETRAIT = 3;
    public static final int VIREMENT_DEBIT = 4;
    public static final int VIREMENT_CREDIT = 5;
    public static final int CLOTURE = 6;
    public static final int VIREMENT_EN_ATTENTE = 7;


    private GregorianCalendar dateCreation;
    private double montant;
    private int numero;
    private int type;
    private double solde;
    private CompteEnBanque comptePourOperation;


    public Operation(CompteEnBanque comptePourOperation, double montant, int type, double solde) {
        this.comptePourOperation = comptePourOperation;
        if ( type == Operation.RETRAIT ||
                type == Operation.VIREMENT_DEBIT ) montant = -montant;
        this.dateCreation = new GregorianCalendar();
        this.montant = montant;
        this.numero = -1;
        this.type = type;
        this.solde = solde;

    }

    @Override
    public String toString() {
        String message =  "Operation n' " + this.numero + " du " +
                this.dateCreation.getTime() + " de type : " + getTypeString()  +
                ", montant : " + this.montant + ", solde : " + this.solde;

        if  ( this.type == VIREMENT_CREDIT )
            message += " compte debiteur : " +	this.comptePourOperation.getNumero();
        if  ( this.type == VIREMENT_DEBIT )
            message += " compte crediteur : " + this.comptePourOperation.getNumero();
        return message;
    }

    public String getTypeString() {
        switch ( this.type ) {
            case CREATION : return "CREATION";
            case DEPOT : return "DEPOT";
            case RETRAIT : return "RETRAIT";
            case VIREMENT_DEBIT : return "VIREMENT_DEBIT";
            case VIREMENT_CREDIT : return "VIREMENT_CREDIT";
            case CLOTURE : return "CLOTURE";
            default : return "OPERATION INCONNUE";
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public GregorianCalendar getDateCreation() {
        return dateCreation;
    }

    public double getMontant() {
        return montant;
    }

    public int getType() {
        return type;
    }

    public double getSolde() {
        return solde;
    }

    public CompteEnBanque getComptePourOperation() {
        return comptePourOperation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return Double.compare(operation.montant, montant) == 0 && numero == operation.numero && type == operation.type && Double.compare(operation.solde, solde) == 0 && Objects.equals(dateCreation, operation.dateCreation) && Objects.equals(comptePourOperation, operation.comptePourOperation);
    }

}
