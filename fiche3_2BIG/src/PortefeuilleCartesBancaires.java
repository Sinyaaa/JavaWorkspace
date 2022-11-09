import org.jetbrains.annotations.NotNull;

import javax.sound.sampled.Port;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PortefeuilleCartesBancaires implements Collection<CarteBancaire> {

        protected static final int TAILLE_INI_REGISTRE = 100;
        protected int nbTotalCartes = 0;
        protected CarteBancaire[] PorteFeuilleCartes;

        public PortefeuilleCartesBancaires() {
                this.PorteFeuilleCartes = new CarteBancaire[TAILLE_INI_REGISTRE];
                this.nbTotalCartes = 0;
        }

        private void agrandirRegistre() {
                int taille = this.PorteFeuilleCartes.length + 1;
                CarteBancaire[] newPorteFeuille = new CarteBancaire[taille];
                for (int i = 0; i < this.PorteFeuilleCartes.length; i++) {
                        newPorteFeuille[i] = this.PorteFeuilleCartes[i];
                }
                this.PorteFeuilleCartes = newPorteFeuille;
        }

        @Override
        public boolean add(CarteBancaire carteBancaire) {
                if (this.contains(carteBancaire)) {
                        return false;
                }
                if ( this.nbTotalCartes == this.PorteFeuilleCartes.length ) {
                        agrandirRegistre();
                }

                this.PorteFeuilleCartes[this.nbTotalCartes] = carteBancaire;
                this.nbTotalCartes++;
                return true;
        }

        @Override
        public int size() {
                return this.nbTotalCartes;
        }

        @Override
        public boolean isEmpty() {
                return nbTotalCartes == 0;
        }

        @Override
        public boolean contains(Object o) {
                if (o == null) {
                        throw new NullPointerException("reference==null ");
                }
                if (!(o instanceof CarteBancaire)) {
                        throw new ClassCastException("L'objet doit etre de type" + "Carte Bancaire");
                }
                for (int i = 0; i < nbTotalCartes; i++) {
                        CarteBancaire carteBancaire = PorteFeuilleCartes[i];
                        if (carteBancaire.equals(o))
                                return true;
                }
                return false;
        }

        @NotNull
        @Override
        public Iterator<CarteBancaire> iterator() {
                return new IterateurCarteBancaire();
        }

        class IterateurCarteBancaire implements Iterator<CarteBancaire>{

                protected int indice = 0;
                protected boolean removeAutorise = false;

                @Override
                public boolean hasNext() {
                        return indice<nbTotalCartes;
                }

                @Override
                public CarteBancaire next() {
                        if (!hasNext()) {
                                throw new NoSuchElementException("Il n'y a plus de Cartes");
                        }
                        removeAutorise = true;
                        return PorteFeuilleCartes[indice++];
                }

                @Override
                public void remove() {
                        if (!removeAutorise) {
                                throw new IllegalStateException("La suppression n'est pas autorisé");
                        }
                        indice--;
                        PorteFeuilleCartes[indice] = PorteFeuilleCartes[nbTotalCartes-1];
                        PorteFeuilleCartes[nbTotalCartes-1] = null;
                        nbTotalCartes--;
                        removeAutorise = false;
                }
        }


        @NotNull
        @Override
        public Object[] toArray() {
                return PorteFeuilleCartes.clone();
        }

        @NotNull
        @Override
        public <T> T[] toArray(@NotNull T[] a) {
                throw new UnsupportedOperationException("operation refusee");

        }

        @Override
        public boolean remove(Object o) {
                if (!(o instanceof CarteBancaire)) {
                        throw new ClassCastException("L'objet doit etre de type" + "Carte Bancaire");
                }
                for (int i = 0; i < nbTotalCartes; i++) {
                        if (PorteFeuilleCartes[i].equals(o)) {
                                PorteFeuilleCartes[i] = PorteFeuilleCartes[nbTotalCartes - 1];
                                PorteFeuilleCartes[nbTotalCartes - 1] = null;
                                nbTotalCartes--;
                                return true;
                        }
                }
                return false;
        }

        @Override
        public boolean containsAll(@NotNull Collection<?> c) {
                throw new UnsupportedOperationException("operation refusee");

        }

        @Override
        public boolean addAll(@NotNull Collection<? extends CarteBancaire> c) {
                throw new UnsupportedOperationException("operation refusee");

        }

        @Override
        public boolean removeAll(@NotNull Collection<?> c) {
                throw new UnsupportedOperationException("operation refusee");

        }

        @Override
        public boolean retainAll(@NotNull Collection<?> c) {
                throw new UnsupportedOperationException("operation refusee");

        }

        @Override
        public void clear() {
                for (int i = 0; i < nbTotalCartes; i++) {
                        PorteFeuilleCartes[i] = null;
                }
                nbTotalCartes = 0;
        }
}
