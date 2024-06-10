package modele;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class TestPanier 
{
	private Panier panier;
	@Before
	public void setUp()
	{
		panier = new Panier();
	}
	
	@After
	public void tearUp()
	{
		panier = null;
	}
	
	@Test
	public void panierVide()
	{
		assertEquals(panier.getTaillePanier(), 0);
	}
	
	@Test
	public void ajoutPanier()
	{
		assertEquals(panier.getTaillePanier(), 1);
	}
}
