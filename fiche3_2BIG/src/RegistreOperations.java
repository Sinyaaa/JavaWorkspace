import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RegistreOperations implements Collection<Operation> {

    private static final int TAILLE_INI_REGISTRE = 100;
    private static final int AUGMENTATION_REGISTRE = 50;

    private Operation[] tableOperations;
    private int numOperation;

    public RegistreOperations() {
        super();
        this.tableOperations = new Operation [ TAILLE_INI_REGISTRE ];
        this.numOperation = 0;
    }



    @Override
    public boolean add(Operation operation) {
        if ( this.contains(operation) ) {
            return false;
        }
        if ( this.numOperation == this.tableOperations.length ) {
            agrandirTableRegistre();
        }
        this.numOperation++;
        operation.setNumero(this.numOperation);
        this.tableOperations[ this.numOperation-1 ] = operation;
        return true;
    }

    private void agrandirTableRegistre() {
        int taille = this.tableOperations.length + AUGMENTATION_REGISTRE;
        Operation[] histTemp = new Operation[ taille ];
        for (int i = 0; i < this.numOperation ; i++ ) {
            histTemp[i] = this.tableOperations[i];
        }
        this.tableOperations = histTemp;
    }

    public String toString() {
        if ( this.numOperation == 0 ) return "Historique vide";
        String resultat = "";
        for ( int i=0 ; i<this.numOperation; i++ ) {
            resultat += this.tableOperations[i] + "\n";
        }
        return resultat;
    }

    @Override
    public Iterator<Operation> iterator() {
        return new IterateurOperation();
    }

    class IterateurOperation implements Iterator<Operation>{
        private int indice = 0;
        private boolean removeAutorisé = false;

        @Override
        public boolean hasNext() {
            return indice<numOperation;
        }

        @Override
        public Operation next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Il n'y a plus d'opération");
            }
            removeAutorisé = true;
            return tableOperations[indice++];
        }

        @Override
        public void remove() {
            if (!removeAutorisé) {
                throw new IllegalStateException("La suppression n'est pas autorisé");
            }
            indice--;
            tableOperations[indice] = tableOperations[numOperation-1];
            tableOperations[numOperation-1] = null;
            numOperation--;
            removeAutorisé = false;

        }
    }

    @Override
    public boolean contains(Object o) {
        if ( o == null) {
            throw new NullPointerException("reference==null ");
        }
        if ( !(o instanceof Operation)) {
            throw new ClassCastException("L'objet doit etre de type"
                    + "operation");
        }
        for ( int i=0 ; i<this.numOperation; i++ ) {
            if ( this.tableOperations[i].equals(o)) return true;
        }
        return false;
    }

    @Override
    public int size() {
        return numOperation;
    }

    @Override
    public boolean isEmpty() {
        return numOperation == 0;
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Les retraits ne sont pas autorises dans l'historique" + " des operations");
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Les retraits ne sont pas autorises dans l'historique" + " des operations");
    }

    @Override
    public boolean containsAll( Collection<?> c) {
        throw new UnsupportedOperationException("op�ration refus�e");
    }

    @Override
    public boolean addAll( Collection<? extends Operation> c) {
        throw new UnsupportedOperationException("op�ration refus�e");
    }

    @Override
    public boolean removeAll( Collection<?> c) {
        throw new UnsupportedOperationException("Les retraits ne sont pas autorises dans l'historique" + " des operations");
    }

    @Override
    public boolean retainAll( Collection<?> c) {
        throw new UnsupportedOperationException("op�ration refus�e");
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("op�ration refus�e");
    }


    @Override
    public <T> T[] toArray( T[] a) {
        throw new UnsupportedOperationException("op�ration refus�e");
    }

}
