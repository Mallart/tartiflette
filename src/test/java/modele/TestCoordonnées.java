package modele;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class TestCoordonnées {

	private Coordonnées CoordonnéesExemple;

	@Before
	public void setUp() throws Exception {
		this.CoordonnéesExemple = new Coordonnées("Dupont", "Jean", "9 rue des lauriers", "6 rue caussade", "31000",
				"Toulouse", "0602068913", "jean.dupont@gmail.fr", "Paypal", false);
	}

	@Test
	public void testNom() {
		assertNotNull(this.CoordonnéesExemple.getNom());
	}

	@Test
	public void testPrénom() {
		assertNotNull(this.CoordonnéesExemple.getPrenom());
	}

	@Test
	public void testAdresse1() {
		assertNotNull(this.CoordonnéesExemple.getAdresse1());
	}

	@Test
	public void testAdresse2() {
		assertNotNull(this.CoordonnéesExemple.getAdresse2());
	}

	@Test
	public void testNomCodePostal() {
		assertNotNull(this.CoordonnéesExemple.getCodePostal());
	}

	@Test
	public void testVille() {
		assertNotNull(this.CoordonnéesExemple.getVille());
	}

	@Test
	public void testTelephone() {
		assertNotNull(this.CoordonnéesExemple.getTelephone());
	}

	@Test
	public void testMail() {
		assertNotNull(this.CoordonnéesExemple.getMail());
	}

	@Test
	public void testMoyenDePaiement() {
		assertNotNull(this.CoordonnéesExemple.getMoyenDePaiement());
	}

	@Test
	public void testChoixAbonnement() {
		assertNotNull(this.CoordonnéesExemple.isAbonnement());
	}

}
