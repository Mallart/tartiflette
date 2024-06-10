package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modele.Article;
import modele.Fromage;

public class TestArticle {

	private Article articleTest;
	private Fromage fromageTest;
	private Fromage fromageTest2;

	@Before
	public void setUp() throws Exception {
		this.fromageTest = new Fromage("Abondance");
		this.fromageTest2 = new Fromage("Coulommiers");
		this.articleTest = new Article(this.fromageTest, "DDD", 5.52F);
	}

	@After
	public void tearDown() throws Exception {
		this.articleTest = null;
		this.fromageTest = null;
		this.fromageTest2 = null;
	}

	@Test
	public void testFromage() {
		assertEquals(this.fromageTest, this.articleTest.getFromage());
	}

	@Test
	public void testClé() {
		assertEquals("DDD", this.articleTest.getClé());
	}

	@Test
	public void testCléNonNulle() {
		assertNotNull(this.articleTest.getClé());
	}

	@Test
	public void testPrixTTC() {
		assertEquals(0.0F, this.articleTest.getPrixTTC(), 5.52F);
	}

	@Test
	public void testPrixTTCNonNul() {
		assertNotNull(this.articleTest.getPrixTTC());
	}

	@Test
	public void testQuantitéEnStockInitiale() {
		assertEquals(0, this.articleTest.getQuantitéEnStock());
	}

	@Test
	public void testSetQuantitéEnStock() {
		this.articleTest.setQuantitéEnStock(10);
		assertEquals(10, this.articleTest.getQuantitéEnStock());
	}

	@Test
	public void testToString() {
		String expected = "Abondance, DDD, Prix TTC : 5.52 €";
		assertEquals(expected, this.articleTest.toString());
	}

	@Test
	public void testToStringAvecStock() {
		String expected = "Abondance, DDD, Prix TTC : 5.52 €, Quantité en stock : 0";
		assertEquals(expected, this.articleTest.toStringAvecStock());
	}

	@Test
	public void testCléDifférente() {
		Article autreExemple = new Article(this.fromageTest, "AAA", 1.0F);
		assertFalse(this.articleTest.equals(autreExemple));
	}

	@Test
	public void testFromageDifférent() {
		Article autreExemple = new Article(this.fromageTest2, "DDD", 1.0F);
		assertFalse(this.articleTest.equals(autreExemple));
	}
}
