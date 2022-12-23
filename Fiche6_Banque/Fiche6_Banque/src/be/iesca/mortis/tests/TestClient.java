package be.iesca.mortis.tests;
import be.iesca.mortis.domaine.Client;
import be.iesca.mortis.domaine.CompteCourant;
import be.iesca.mortis.domaine.CompteEnBanque;
import be.iesca.mortis.domaine.CompteEpargne;
import junit.framework.TestCase;


public class TestClient extends TestCase {

	private Client bill;
	
	private final static String NOM = "Bocquet";
	private final static String PRENOM = "Bill";	
	private final static String ADRESSE = "42 rue Pestre";
	private final static String DATE_NAISSANCE = "01/01/2038";
	private final static String TELEPHONE = "0444/12.34.56";
	
	
	protected void setUp() throws Exception {
		// Vous pouvez ecrire ici du code qui sera execute avant chacune des methodes de test
		this.bill = new Client(TestClient.NOM, TestClient.PRENOM, TestClient.ADRESSE,TestClient.DATE_NAISSANCE,TestClient.TELEPHONE );
		
	}

	protected void tearDown() throws Exception {
		// Vous pouvez écrire ici du code qui sera execute apres chacune des methodes de test
		// ici c'est inutile.
	}

	public void testClient() {
		assertNotNull(this.bill);
		assertTrue("bill n'a pas ete construit par le constructeur...", this.bill instanceof Client);
	}

	public void testConstructGetAdresse() {
		String resultat = this.bill.getAdresse();
		assertEquals(TestClient.ADRESSE, resultat);
		// Essayez avec assertSame, quelle est la difference a votre avis ?
		//assertSame(ClientTest.ADDRESSE, resultat);
	}

	public void testSetGetAdresse() {
		String nouvelleAdresse = "79, rue Tilante";
		this.bill.setAdresse(nouvelleAdresse);
		String resultat = this.bill.getAdresse();
		assertEquals(nouvelleAdresse, resultat);
		// Essayez avec assertSame, quelle est la difference a votre avis ?
		//assertSame(nouvelleAdresse, resultat);
	}

	public void testConstructGetNumTel() {
		String resultat = this.bill.getNumTel();
		assertEquals(TestClient.TELEPHONE, resultat);
		// Essayez avec assertSame, quelle est la difference a votre avis ?
		//assertSame(ClientTest.TELEPHONE, resultat);
	}

	public void testSetGetNumTel() {
		String nouveauTel = "0111/99.88.77";
		this.bill.setNumTel(nouveauTel);
		String resultat = this.bill.getNumTel();
		assertEquals(nouveauTel, resultat);
		// Essayez avec assertSame, quelle est la difference a votre avis ?
		//assertSame(nouveauTel, resultat);
	}

	public void testConstructGetCompteCourant() {
		CompteEnBanque resultat = this.bill.getCompteCourant();
		assertNull(resultat);
	}

	public void testSetGetCompteCourant() {
		CompteCourant compte=null;
		try {
			compte = new CompteCourant("testCourant", 0);
			this.bill.setCompteCourant(compte);
			CompteEnBanque resultat = this.bill.getCompteCourant();
			assertEquals(compte, resultat);
			// Essayez avec assertSame, quelle est la difference a votre avis ?
			//assertSame(compte, resultat);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testConstructGetCompteEpargne() {
		CompteEnBanque resultat = this.bill.getCompteEpargne();
		assertNull(resultat);
	}

	public void testSetGetCompteEpargne() {
		CompteEpargne compte = new CompteEpargne("testEpargne");
		this.bill.setCompteEpargne(compte);
		CompteEnBanque resultat = this.bill.getCompteEpargne();
		assertEquals(compte, resultat);
		// Essayez avec assertSame, quelle est la difference a votre avis ?
		//assertSame(compte, resultat);
	}

	public void testConstructGetNom() {
		String resultat = this.bill.getNom();
		assertEquals(TestClient.NOM, resultat);
		// Essayez avec assertSame, quelle est la difference a votre avis ?
		//assertSame(ClientTest.NOM, resultat);
	}

	public void testConstructGetPrenom() {
		String resultat = this.bill.getPrenom();
		assertEquals(TestClient.PRENOM, resultat);
		// Essayez avec assertSame, quelle est la difference a votre avis ?
		//assertSame(ClientTest.PRENOM, resultat);
	}

	public void testGetDateNaissance() {
		String resultat = this.bill.getDateNaissance();
		assertEquals(TestClient.DATE_NAISSANCE, resultat);
		// Essayez avec assertSame, quelle est la difference a votre avis ?
		//assertSame(ClientTest.DATE_NAISSANCE, resultat);
	}

}
