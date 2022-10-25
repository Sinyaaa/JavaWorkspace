package ex2;

public class Util {
    public static void checkObject(Object o) {
        if (o == null)
            throw new NullPointerException("L'objet ne peut pas �tre null");
    }

    public static void checkString(String s) {
        checkObject(s);
        if (s.isEmpty())
            throw new IllegalArgumentException("La cha�ne ne peut pas �tre vide");
    }

    public static void checkNumerique(String s) {
        checkString(s);
        try {
            Long.parseLong(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("La cha�ne doit �tre un nombre valide");
        }
    }

    public static void checkPositive(double nombre) {
        if (nombre <= 0)
            throw new IllegalArgumentException("La valeur ne peut pas �tre n�gative ou nulle");

    }
}