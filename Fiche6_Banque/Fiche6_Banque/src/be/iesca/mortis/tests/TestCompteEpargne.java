package be.iesca.mortis.tests;
/*
 * Introduction à l'Orienté Objet : solution fiche 2
 */

import be.iesca.mortis.domaine.Client;
import be.iesca.mortis.domaine.CompteCourant;
import be.iesca.mortis.domaine.CompteEnBanque;
import be.iesca.mortis.domaine.CompteEpargne;
import junit.framework.TestCase;


public class TestCompteEpargne extends TestCase {

	private CompteEpargne compteTest;
	
	private final static String NUMERO = "000-123456-789";	
	
	protected void setUp() throws Exception {
		// Vous pouvez ecrire ici du code qui sera execute avant chacune des methodes de test
		this.compteTest = new CompteEpargne(TestCompteEpargne.NUMERO);
		
	}

	protected void tearDown() throws Exception {
		// Vous pouvez Ã©crire ici du code qui sera execute apres chacune des methodes de test
		// ici c'est inutile.
	}

	public void testConstructeur() {
		assertNotNull(this.compteTest);
		assertTrue(this.compteTest instanceof CompteEpargne);
		assertTrue(this.compteTest instanceof CompteEnBanque);
	}

	public void testConstructGetNumero() {
		String resultat = this.compteTest.getNumero();
		assertEquals(TestCompteEpargne.NUMERO, resultat);
	}

	public void testConstructGetSolde() {
		double resultat = this.compteTest.getSolde();
		assertEquals(0.0, resultat);
	}

	public void testConstructGetDecouvertMax() {
		double resultat = this.compteTest.getDecouvertMax();
		assertEquals(0.0, resultat);
	}

	public void testConstructIsCloture() {
		assertFalse(this.compteTest.isCloture());
	}

	public void testCloturerIsCloture() {
		try	{
			this.compteTest.cloturer();
			assertTrue(this.compteTest.isCloture());
		}catch (Exception e){
			fail("Aucune raison de lancer une exception quand on cloture un compte ouvert");
		}
		
	}
	/* et si je cloture mon compte deux fois ? */
	public void testCloturerDeuxFois() {
		try	{
			this.compteTest.cloturer();
			this.compteTest.cloturer();
			fail("On ne peut pas cloturer deux fois le meme compte");
		}catch (Exception e){
			assertTrue(true); // ceci signifie qu'il faut passer par ici pour reussir le test
			
		}
	}

	public void testDeposerGetSoldeOk() {
		double montant = 100.0;
		try	{
			this.compteTest.deposer(montant);
			double solde = this.compteTest.getSolde();
			assertEquals(montant, solde);
		}catch (Exception e){
			fail("Aucune raison de lancer une exception quand on depose un montant normal sur un compte");
			
		}
	}
	
	/* et si je vire un nombre negatif ? */
	public void testDeposerNegatif() {
		double montant = -100.0;
		try	{
			this.compteTest.deposer(montant);
			fail("On ne peut pas deposer un montant negatif sur un compte");
		}catch (Exception e){
			assertTrue(true);
			
		}
	}
	
	/* et si je depose un montant positif sur un compte cloture ?*/
	public void testDeposerApresCloture() {
		double montant = 100.0;
		try	{
			this.compteTest.cloturer();
			this.compteTest.deposer(montant);
			fail("On ne peut pas deposer un montant sur un compte cloture");
		}catch (Exception e){
			assertTrue(true);
			
		}
	}	
	

	public void testRetirerApresDepotOk() {
		double montantDepot = 100.0;
		double montantRetrait = 50.0;
		try		{
			this.compteTest.deposer(montantDepot);
			this.compteTest.retirer(montantRetrait);
			assertTrue(true);
		}catch (Exception e){
			fail("Aucune raison de lancer une exception si je retre moins que le solde restant");
			
		}
	}
	/* et si je retire plus que le solde restant */
	public void testRetirerPlusQueSolde(){
		double montantDepot = 100.0;
		double montantRetrait = 100.1;
		try		{
			this.compteTest.deposer(montantDepot);
			this.compteTest.retirer(montantRetrait);
			fail("On ne peut pas retirer plus que le solde restant sur un compte epargne");
		}catch (Exception e)		{
			assertTrue(true);			
		}
	}
	
	/* et si je retire sur un compte cloture ? */
	public void testRetraitApresCloture(){
		double montantDepot = 100.0;
		double montantRetrait = 50.0;
		try{
			this.compteTest.deposer(montantDepot);
			this.compteTest.cloturer();
			this.compteTest.retirer(montantRetrait);
			fail("On ne peut pas retirer apres la cloture d'un compte");
		}catch (Exception e){
			assertTrue(true);			
		}		
	}
	
	/* et si je retire un nombre negatif */
	public void testRetraitNegatif(){
		double montantDepot = 100.0;
		double montantRetrait = -50.0;
		try{
			this.compteTest.deposer(montantDepot);
			this.compteTest.retirer(montantRetrait);
			fail("On ne peut pas retirer un nombre negatif");
		}catch (Exception e){
			assertTrue(true);			
		}		
	}
	
	
	public void testVirementOk(){
		// preparation des donnees de tests
		Client bill = new Client("Bocquet", "Bill", "952 rue jissante","01/01/1970","Nexxus One");
		CompteCourant compteCourant;
		try {
			compteCourant = new CompteCourant("999-42424242-07", 500.0);
			bill.setCompteEpargne(this.compteTest);
			bill.setCompteCourant(compteCourant);
			double montantVirement = 100.0;
			this.compteTest.deposer(montantVirement);
			this.compteTest.effectuerVirement(bill, compteCourant, montantVirement);
			assertEquals(0.0, this.compteTest.getSolde());
			assertEquals(montantVirement, compteCourant.getSolde());
		}catch (Exception e){
			fail(); // On n'est pas obligÃ© de definir un message d'erreur
		}
		
	}
	
	public void testVirementVersUnCompteNonAutorise(){
		try{
		// preparation des donnees de tests
		Client bill = new Client("Bocquet", "Bill", "952 rue jissante","01/01/1970","Nexxus One");
		CompteCourant autreCompte = new CompteCourant("999-42424242-07", 500.0);
		bill.setCompteEpargne(this.compteTest);
		double montantVirement = 100.0;
		

			this.compteTest.deposer(montantVirement);
			this.compteTest.effectuerVirement(bill, autreCompte, montantVirement);
			fail("On ne peut virer que vers son propre compte courant");
		}catch (Exception e){
			assertTrue(true);
		}
		
	}
	
	public void testVirementSuperieurAuSoldeRestant(){
		try{
		// preparation des donnees de tests
		Client bill = new Client("Bocquet", "Bill", "952 rue jissante","01/01/1970","Nexxus One");
		CompteCourant compteCourant = new CompteCourant("999-42424242-07", 500.0);
		bill.setCompteCourant(compteCourant);
		bill.setCompteEpargne(this.compteTest);
		double montantVirement = 100.0;
		
			this.compteTest.effectuerVirement(bill, compteCourant, montantVirement);
			fail("On ne peut pas virer plus que le solde restant");
		}catch (Exception e){
			assertTrue(true);
		}
		
	}
	
	public void testVirementDepuisUnCompteDontOnNEstPasTitulaire(){
		try{
		// preparation des donnees de tests
		Client bill = new Client("Bocquet", "Bill", "952 rue jissante","01/01/1970","Nexxus One");
		CompteCourant compteCourant = new CompteCourant("999-42424242-07", 500.0);
		bill.setCompteCourant(compteCourant);
		double montantVirement = 100.0;
		
			this.compteTest.deposer(montantVirement);
			this.compteTest.effectuerVirement(bill, compteCourant, montantVirement);
			fail("On ne peut pas virer depuis un compte dont on n'est pas titulaire");
		}catch (Exception e){
			assertTrue(true);
		}
		
	}
	
	public void testVirementDepuisUnCompteCloture(){
		try{
		// preparation des donnees de tests
		Client bill = new Client("Bocquet", "Bill", "952 rue jissante","01/01/1970","Nexxus One");
		CompteCourant compteCourant = new CompteCourant("999-42424242-07", 500.0);
		bill.setCompteCourant(compteCourant);
		bill.setCompteEpargne(this.compteTest);
		double montantVirement = 100.0;
		
			this.compteTest.deposer(montantVirement);
			this.compteTest.cloturer();
			this.compteTest.effectuerVirement(bill, compteCourant, montantVirement);
			fail("On ne peut pas virer depuis un compte cloture");
		}catch (Exception e){
			assertTrue(true);
		}
		
	}
	
	public void testVirementVersUnCompteCloture(){
		try{
		// preparation des donnees de tests
		Client bill = new Client("Bocquet", "Bill", "952 rue jissante","01/01/1970","Nexxus One");
		CompteCourant compteCourant = new CompteCourant("999-42424242-07", 500.0);
		bill.setCompteCourant(compteCourant);
		bill.setCompteEpargne(this.compteTest);
		double montantVirement = 100.0;
		
			this.compteTest.deposer(montantVirement);
			compteCourant.cloturer();
			this.compteTest.effectuerVirement(bill, compteCourant, montantVirement);
			fail("On ne peut pas virer vers un compte cloture");
		}catch (Exception e){
			assertTrue(true);
		}
		
	}
	

}
