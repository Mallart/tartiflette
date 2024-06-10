package tests;

import modele.Article;
import modele.Fromage;
import modele.Panier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class TestPanier 
{
	private Panier panier;
	private Fromage fromage;
	private Article article;
	
	private static final int QUANTITE_ARTICLES_TEST = 100;
	private static final float PRIX_TRANSPORT = 20.f;
	
	@Before
	public void setUp()
	{
		panier = new Panier();
		fromage = new Fromage("frometon");
		article = new Article(fromage, "", 2.f);
		article.setQuantitéEnStock(QUANTITE_ARTICLES_TEST);
	}
	
	@After
	public void tearUp()
	{
		panier = null;
		fromage = null;
		article = null;
	}
	
	@Test
	public void panierVide()
	{
		assertEquals(panier.getTaillePanier(), 0);
	}
	
	@Test
	public void ajoutPanier()
	{
		panier.ajouterArticlePanier(article, 1);
		assertEquals(1, panier.getTaillePanier());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void ajoutPanierPlusQueQuantité()
	{
		panier.ajouterArticlePanier(article, QUANTITE_ARTICLES_TEST + 1);
	}
	
	@Test
	public void recupArticle()
	{
		panier.ajouterArticlePanier(article, 1);
		assertEquals(panier.getArticle(0), article);
	}
	
	@Test
	public void prixPanier()
	{
		panier.ajouterArticlePanier(article, 2);
		assertTrue(panier.prixTotalPanier() == article.getPrixTTC() * 2);
	}
	
	@Test
	public void prixPanierTransportGratuit()
	{
		panier.ajouterArticlePanier(article, QUANTITE_ARTICLES_TEST);
		assertTrue(panier.totalPanier(PRIX_TRANSPORT) == (QUANTITE_ARTICLES_TEST) * 2.f);
	}
	
	@Test
	public void prixPanierTransport()
	{
		panier.ajouterArticlePanier(article, 10);
		assertTrue(panier.totalPanier(PRIX_TRANSPORT) == 10 * 2.f + PRIX_TRANSPORT);
	}
	
	@Test
	public void viderPanier()
	{
		panier.ajouterArticlePanier(article, 10);
		panier.viderPanier();
		assertEquals(panier.getTaillePanier(), 0);
	}
	
	@Test
	public void taillePainer()
	{
		panier.ajouterArticlePanier(article, 10);
		assertEquals(panier.getTaillePanier(), 10);
	}
	
	@Test
	public void sansFraisDePort()
	{
		panier.ajouterArticlePanier(article, QUANTITE_ARTICLES_TEST);
		assertTrue(panier.totalPanier(PRIX_TRANSPORT) == QUANTITE_ARTICLES_TEST * 2.f);	
	}
	
	@Test
	public void nbOccurences()
	{
		panier.ajouterArticlePanier(article, QUANTITE_ARTICLES_TEST);
		assertEquals(QUANTITE_ARTICLES_TEST, panier.nombreOccurencesArticle(article));
	}
	
	@Test
	public void nbStaticOccurences()
	{
		List<Article> articles = new LinkedList<Article>();
		for(int i = 0; i < QUANTITE_ARTICLES_TEST; ++i)
			articles.add(article);
		assertEquals(Panier.nombreOccurencesArticle(articles, article), QUANTITE_ARTICLES_TEST);
	}
	
	@Test 
	public void supprDoublons()
	{
		Article article2 = new Article(new Fromage("leerdameer"), "", 3.f);
		article2.setQuantitéEnStock(QUANTITE_ARTICLES_TEST);
		panier.ajouterArticlePanier(article, 10);
		panier.ajouterArticlePanier(article2, 10);
		assertEquals(2, panier.getPanierSansDoublon().size());
	}
}
