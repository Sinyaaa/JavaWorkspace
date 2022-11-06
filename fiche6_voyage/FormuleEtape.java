import java.time.LocalDate;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class FormuleEtape extends Formule implements Collection<Etape> {
    protected int numEtape;
    protected String formuleEtapeName;
    protected double formuleEtapePrice;
    protected Etape[] tableEtape;

    public FormuleEtape(LocalDate dateDepart, int duree, String formuleEtapeName, double formuleEtapePrice) {
        super(dateDepart, duree);
        this.numEtape = numEtape;
        this.formuleEtapeName = formuleEtapeName;
        this.formuleEtapePrice = formuleEtapePrice;
    }
    @Override
    public Iterator<Etape> iterator() {
        return new IterateurEtape();
    }
    public class IterateurEtape implements Iterator<Etape> {
        protected int indice;
        protected boolean removeAutoriseIterateur;

        public IterateurEtape() {
        }

        @Override
        public boolean hasNext() {
            return indice<numEtape;
        }

        @Override
        public Etape next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Il n'y a plus d'Etape(s)");
            }
            removeAutoriseIterateur = true;
            return tableEtape[indice++];
        }

        @Override
        public void remove() {
            if (!removeAutoriseIterateur) {
                throw new IllegalStateException("La suppression n'est pas autorisé");
            }
            indice--;
            tableEtape[indice] = tableEtape[numEtape-1];
            tableEtape[numEtape-1] = null;
            numEtape--;
            removeAutoriseIterateur = false;

        }
        }
    }
    public double CalculerPrix(){
       return formuleEtapePrice;
    }

    private void agrandirTableRegistre() {
        int taille = this.tableEtape.length * 2;
        Etape[] newRegistre = new Etape[taille];
        for (int i = 0; i < tableEtape.length; i++) {
            newRegistre[i] = tableEtape[i];
        }
        this.tableEtape = newRegistre;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }


    @Override
    public Object[] toArray() {
        return tableEtape.clone();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("operation refusee");
    }


    public boolean add(Etape etape) {
        if (this.contains(etape)) {
            return false;
        }
        if (this.numEtape == this.tableEtape.length) {
            agrandirTableRegistre();
        }
        this.tableEtape[this.numEtape] = etape;
        this.numEtape++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (!(o instanceof Etape)) {
            throw new ClassCastException("L'objet doit etre de type" + "Etape");
        }
        for (int i = 0; i < numEtape; i++) {
            if (tableEtape[i].equals(o)) {
                tableEtape[i] = tableEtape[numEtape - 1];
                tableEtape[numEtape - 1] = null;
                numEtape--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("operation refusee");
    }

    @Override
    public boolean addAll(Collection<? extends Etape> c) {
        throw new UnsupportedOperationException("operation refusee");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("operation refusee");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("operation refusee");
    }

    @Override
    public void clear() {
        for (int i = 0; i < numEtape; i++) {
            tableEtape[i] = null;
        }
        numEtape = 0;
    }

}
