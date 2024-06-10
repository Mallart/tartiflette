package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modele.Coordonnées;

public class TestCoordonnées {

	private Coordonnées CoordonnéesExemple;
	private Coordonnées MemeCoordonnées;

	@Before
	public void setUp() throws Exception {
		this.CoordonnéesExemple = new Coordonnées("Dupont", "Jean", "9 rue des lauriers", "6 rue caussade", "31000",
				"Toulouse", "0602068913", "jean.dupont@gmail.fr", "Paypal", false);
		this.MemeCoordonnées = new Coordonnées("Dupont", "Jean", "9 rue des lauriers", "6 rue caussade", "31000",
				"Toulouse", "0602068913", "jean.dupont@gmail.fr", "Paypal", false);
	}

	@After
	public void tearDown() throws Exception {
		this.CoordonnéesExemple = null;
		this.MemeCoordonnées = null;
	}

	@Test
	public void testNom() {
		assertEquals(this.CoordonnéesExemple.getNom(), "Dupont");
	}

	@Test
	public void testNomNonNul() {
		assertNotNull(this.CoordonnéesExemple.getNom());
	}

	@Test
	public void testPrénom() {
		assertEquals(this.CoordonnéesExemple.getNom(), "Dupont");
	}

	@Test
	public void testPrénomNonNul() {
		assertNotNull(this.CoordonnéesExemple.getPrenom());
	}

	@Test
	public void testAdresse1() {
		assertEquals(this.CoordonnéesExemple.getAdresse1(), "9 rue des lauriers");
	}

	@Test
	public void testAdresse1NonNulle() {
		assertNotNull(this.CoordonnéesExemple.getAdresse1());
	}

	@Test
	public void testAdresse2() {
		assertEquals(this.CoordonnéesExemple.getAdresse2(), "6 rue caussade");
	}

	@Test
	public void testAdresse2NonNulle() {
		assertNotNull(this.CoordonnéesExemple.getAdresse2());
	}

	@Test
	public void testCodePostal() {
		assertEquals(this.CoordonnéesExemple.getCodePostal(), "31000");
	}

	@Test
	public void testCodePostalNonNulle() {
		assertNotNull(this.CoordonnéesExemple.getCodePostal());
	}

	@Test
	public void testVille() {
		assertEquals(this.CoordonnéesExemple.getVille(), "Toulouse");
	}

	@Test
	public void testVilleNonNulle() {
		assertNotNull(this.CoordonnéesExemple.getVille());
	}

	@Test
	public void testTelephone() {
		assertEquals(this.CoordonnéesExemple.getTelephone(), "0602068913");
	}

	@Test
	public void testTelephoneNonNul() {
		assertNotNull(this.CoordonnéesExemple.getTelephone());
	}

	@Test
	public void testMail() {
		assertEquals(this.CoordonnéesExemple.getMail(), "jean.dupont@gmail.fr");
	}

	@Test
	public void testMailNonNul() {
		assertNotNull(this.CoordonnéesExemple.getMail());
	}

	@Test
	public void testMoyenDePaiement() {
		assertEquals(this.CoordonnéesExemple.getMoyenDePaiement(), "Paypal");
	}

	@Test
	public void testMoyenDePaiementNonNul() {
		assertNotNull(this.CoordonnéesExemple.getMoyenDePaiement());
	}

	@Test
	public void testChoixAbonnement() {
		assertEquals(this.CoordonnéesExemple.isAbonnement(), false);
	}

	@Test
	public void testChoixAbonnementNonNul() {
		assertNotNull(this.CoordonnéesExemple.isAbonnement());
	}

	@Test
	public void testMemeCoordonnées() {
		assertEquals(this.CoordonnéesExemple.getNom(), this.MemeCoordonnées.getNom());
		assertEquals(this.CoordonnéesExemple.getPrenom(), this.MemeCoordonnées.getPrenom());
		assertEquals(this.CoordonnéesExemple.getAdresse1(), this.MemeCoordonnées.getAdresse1());
		assertEquals(this.CoordonnéesExemple.getAdresse2(), this.MemeCoordonnées.getAdresse2());
		assertEquals(this.CoordonnéesExemple.getCodePostal(), this.MemeCoordonnées.getCodePostal());
		assertEquals(this.CoordonnéesExemple.getVille(), this.MemeCoordonnées.getVille());
		assertEquals(this.CoordonnéesExemple.getTelephone(), this.MemeCoordonnées.getTelephone());
		assertEquals(this.CoordonnéesExemple.getMail(), this.MemeCoordonnées.getMail());
		assertEquals(this.CoordonnéesExemple.getMoyenDePaiement(), this.MemeCoordonnées.getMoyenDePaiement());
		assertEquals(this.CoordonnéesExemple.isAbonnement(), this.MemeCoordonnées.isAbonnement());
	}

	@Test
	public void testCoordonnéesDifférentes() {
		Coordonnées DifférentesCoordonnées = new Coordonnées("Durand", "Paul", "10 rue des fleurs", "8 rue du moulin",
				"32000", "Bordeaux", "0703068914", "paul.durand@gmail.fr", "Credit Card", true);
		assertFalse(this.CoordonnéesExemple.equals(DifférentesCoordonnées));
		assertFalse(this.CoordonnéesExemple.equals(DifférentesCoordonnées));
	}
}
