import java.time.LocalDate;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class FormuleEtape extends Formule{
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
    return super.toString();
    }


}
