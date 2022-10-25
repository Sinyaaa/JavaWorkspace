package ex2;

/**
 * POO 2 : exercice sur les �num�rations
 * @author Olivier Legrand
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


@TestMethodOrder(OrderAnnotation.class)
public class TestCommande {
    // la commande doit �tre statique car chaque test tourne avec une nouvelle instance de TestCommande
    private static Commande commande = new CommandeImpl();

    @Test
    @Order(0)
    public void testCreation() {
        try {
            assertEquals(EtatCommande.CREEE, commande.getEtatCommande());
            assertEquals(0, commande.montantTotalCommande(), 0.01);
            assertEquals(0, commande.montantTotalPaye(), 0.01);
            assertEquals(0, commande.soldeAPayer(), 0.01);
        } catch (IllegalStateException ex) {
            fail("Il aurait du accepter la creation\n" + ex.getMessage());
        }
    }

    @Test
    @Order(1)
    public void testEtatCree() {
        try {
            commande.cloturer();
            fail("Il aurait du refuser de cl�turer car la commande est dans l'�tat CREE");
        } catch (IllegalStateException ex) {
            // ok, il a refus� de cl�turer
        }
        try {
            commande.livrer();
            fail("Il aurait du refuser de livrer car la commande est dans l'�tat CREE");
        } catch (IllegalStateException ex) {
            // ok, il a refus� de cl�turer
        }
    }

    @Test
    @Order(2)
    public void testAjouter1() {
        try {
            Article article1 = new Article("article 1", 5);
            commande.ajouterArticle(article1, 10);
            assertEquals(50, commande.montantTotalCommande(), 0.01);
            assertEquals(0, commande.montantTotalPaye(), 0.01);
            assertEquals(50, commande.soldeAPayer(), 0.01);
            assertEquals(EtatCommande.EN_PREPARATION, commande.getEtatCommande());
        } catch (IllegalStateException ex) {
            fail("Il aurait du accepter l'ajout\n" + ex.getMessage());
        }
    }

    @Test
    @Order(3)
    public void testAjouter2() {
        try {
            Article article2 = new Article("article 2", 2);
            commande.ajouterArticle(article2, 3);
            assertEquals(56, commande.montantTotalCommande(), 0.01);
            assertEquals(0, commande.montantTotalPaye(), 0.01);
            assertEquals(56, commande.soldeAPayer(), 0.01);
            assertEquals(EtatCommande.EN_PREPARATION, commande.getEtatCommande());
        } catch (IllegalStateException ex) {
            fail("Il aurait du accepter l'ajout\n" + ex.getMessage());
        }
    }

    @Test
    @Order(4)
    public void testAjouter3() {
        try {
            Article article2 = new Article("article 2", 2);
            commande.ajouterArticle(article2, 7);
            assertEquals(70, commande.montantTotalCommande(), 0.01);
            assertEquals(0, commande.montantTotalPaye(), 0.01);
            assertEquals(70, commande.soldeAPayer(), 0.01);
            assertEquals(EtatCommande.EN_PREPARATION, commande.getEtatCommande());
        } catch (IllegalStateException ex) {
            fail("Il aurait du accepter l'ajout\n" + ex.getMessage());
        }
    }

    @Test
    @Order(5)
    public void testEtatEnPreparation() {
        try {
            commande.livrer();
            fail("Il aurait du refuser de livrer car la commande est dans l'�tat EN_PREPARATION");
        } catch (IllegalStateException ex) {
            // ok, il a refus� de cl�turer
        }
    }

    @Test
    @Order(6)
    public void testEtatEncaissementPaiement() {
        try {
            commande.encaisserPaiement(30);
            assertEquals(70, commande.montantTotalCommande(), 0.01);
            assertEquals(30, commande.montantTotalPaye(), 0.01);
            assertEquals(40, commande.soldeAPayer(), 0.01);
            assertEquals(EtatCommande.EN_PREPARATION, commande.getEtatCommande());
        } catch (IllegalStateException ex) {
            fail("Il aurait du accepter l'encaissement\n" + ex.getMessage());
        }
    }

    @Test
    @Order(7)
    public void testCloturer() {
        try {
            commande.cloturer();
            assertEquals(EtatCommande.PRETE, commande.getEtatCommande());
        } catch (IllegalStateException ex) {
            fail("Il aurait du accepter de cloturer\n" + ex.getMessage());
        }
    }

    @Test
    @Order(8)
    public void testEtatPrete() {
        try {
            Article article2 = new Article("article 2", 2);
            commande.ajouterArticle(article2, 7);
            fail("Il aurait du refuser l'ajout car la commande est dans l'�tat PRETE");
        } catch (IllegalStateException ex) {
            // ok, il a refus� l'ajout
        }
        try {
            commande.cloturer();
            fail("Il aurait du refuser de cl�turer car la commande est d�j� cl�tur�e");
        } catch (IllegalStateException ex) {
            // ok, il a refus� de cl�turer
        }
        try {
            commande.livrer();
            fail("Il aurait du refuser de livrer car la commande n'est pas sold�e");
        } catch (IllegalStateException ex) {
            // ok, il a refus� de livrer
        }
        assertEquals(EtatCommande.PRETE, commande.getEtatCommande());
    }

    @Test
    @Order(9)
    public void testEtatEncaissementPaiement2() {
        try {
            commande.encaisserPaiement(40);
            assertEquals(70, commande.montantTotalCommande(), 0.01);
            assertEquals(70, commande.montantTotalPaye(), 0.01);
            assertEquals(0, commande.soldeAPayer(), 0.01);
            assertEquals(EtatCommande.PRETE, commande.getEtatCommande());
        } catch (IllegalStateException ex) {
            fail("Il aurait du accepter l'encaissement\n" + ex.getMessage());
        }
    }

    @Test
    @Order(10)
    public void testLivrer() {
        try {
            commande.livrer();
            ;
            assertEquals(70, commande.montantTotalCommande(), 0.01);
            assertEquals(70, commande.montantTotalPaye(), 0.01);
            assertEquals(0, commande.soldeAPayer(), 0.01);
            assertEquals(EtatCommande.LIVREE, commande.getEtatCommande());
        } catch (IllegalStateException ex) {
            fail("Il aurait du accepter la livraison\n" + ex.getMessage());
        }
    }

    @Test
    @Order(11)
    public void testEtatLivree() {
        try {
            Article article2 = new Article("article 2", 2);
            commande.ajouterArticle(article2, 7);
            fail("Il aurait du refuser l'ajout car la commande est dans l'�tat LIVREE");
        } catch (IllegalStateException ex) {
            // ok, il a refus� l'ajout
        }
        try {
            commande.cloturer();
            fail("Il aurait du refuser de cl�turer car la commande est dans l'�tat LIVREE");
        } catch (IllegalStateException ex) {
            // ok, il a refus� de cl�turer
        }
        try {
            commande.livrer();
            fail("Il aurait du refuser de livrer car la commande est d�j� livr�e");
        } catch (IllegalStateException ex) {
            // ok, il a refus� de livrer
        }
        assertEquals(EtatCommande.LIVREE, commande.getEtatCommande());
    }

}
