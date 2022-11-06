import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;

public class PortefeuilleCartesBancaires implements Collection<CarteBancaire> {

        protected static final int TAILLE_INI_REGISTRE = 100;
        protected int nbTotalCartes = 0;
        protected CarteBancaire[] TableCarteBancaire;
        protected int numCarteBancaire;


        private void agrandirRegistre() {
                int taille = this.TableCarteBancaire.length + 1;
                CarteBancaire[] listTemp = new CarteBancaire[taille];
                for (int i = 0; i < this.numCarteBancaire ; i++ ) {
                        listTemp[i] = this.TableCarteBancaire[i];
                }
                this.TableCarteBancaire = listTemp;
        }

        @Override
        public boolean add(CarteBancaire carteBancaire) {
                if (this.contains(carteBancaire)) {
                        return false;
                }
                if ( this.numCarteBancaire == this.TableCarteBancaire.length ) {
                        agrandirRegistre();
                }
                this.numCarteBancaire++;
                this.TableCarteBancaire[ this.numCarteBancaire-1 ] = carteBancaire;
                return true;
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

        @NotNull
        @Override
        public Iterator<CarteBancaire> iterator() {
                return null;
        }

        @NotNull
        @Override
        public Object[] toArray() {
                return new Object[0];
        }

        @NotNull
        @Override
        public <T> T[] toArray(@NotNull T[] a) {
                return null;
        }

        @Override
        public boolean remove(Object o) {
                return false;
        }

        @Override
        public boolean containsAll(@NotNull Collection<?> c) {
                return false;
        }

        @Override
        public boolean addAll(@NotNull Collection<? extends CarteBancaire> c) {
                return false;
        }

        @Override
        public boolean removeAll(@NotNull Collection<?> c) {
                return false;
        }

        @Override
        public boolean retainAll(@NotNull Collection<?> c) {
                return false;
        }

        @Override
        public void clear() {

        }
}
