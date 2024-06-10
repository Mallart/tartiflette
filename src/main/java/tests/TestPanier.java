package tests;

import modele.Article;
import modele.Fromage;
import modele.Panier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertThrows;

import java.util.List;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class TestPanier 
{
	private Panier panier;
	private Fromage fromage;
	private Article article;
	
	@Before
	public void setUp()
	{
		panier = new Panier();
		fromage = new Fromage("frometon");
		article = new Article(fromage, "", 2.f);
		article.setQuantitéEnStock(2);
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
		panier.ajouterArticlePanier(article, 2);
		assertEquals(2, panier.getTaillePanier());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void ajoutPanierPlusQueQuantité()
	{
		assertThrows()
	}
}
