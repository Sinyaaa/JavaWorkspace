import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Exercice1 {
    public static void main(String[] args) {


        Personne p1 = new Personne("Delsinne", "Benjamin");
        Personne p2 = new Personne("Castin", "Matteo");
        Personne p3 = new Personne("Assabban", "Yassin");
        List<Personne> listPersonne = new ArrayList<Personne>();

        listPersonne.add(p1);
        listPersonne.add(p2);
        listPersonne.add(p3);

        System.out.println(listPersonne);

    }
}
