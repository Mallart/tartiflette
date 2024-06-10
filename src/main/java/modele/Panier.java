package modele;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Panier {
	public static final float PRIX_OFFRE_LIVRAISON = 120.f;
	private List<Article> articlePanier;

	public Panier() {
		this.articlePanier = new LinkedList<Article>();
	}
	
	public float prixTotalPanier()
	{
		float sum = 0.f;
		for(Article article : this.articlePanier)
			sum += article.getPrixTTC();
		return sum;
	}
	
	public int nombreOccurencesArticle(Article article)
	{
		int occurences = 0;
		for(Article _article : this.articlePanier)
			if(article.equals(_article))
				occurences++;
		return occurences;
	}
	
	public static int nombreOccurencesArticle(List<Article> panier, Article article)
	{
		int occurences = 0;
		for(Article _article : panier)
			if(article.equals(_article))
				occurences++;
		return occurences;
	}
	
	public List<Article> getPanierSansDoublon()
	{
		List<Article> panier = new LinkedList<Article>();
		for(Article _article : this.articlePanier)
			if(Panier.nombreOccurencesArticle(panier, _article) == 0)
				panier.add(_article);
		return panier;
	}
	
	public float prixTotalArticle(Article article) {
		return article.getQuantitéEnStock() * article.getPrixTTC();
	}
	
	public void ajouterArticlePanier(Article article, int quantite) {
		if((article.getQuantitéEnStock() - quantite)>0) {
			for(int i = 0; i < quantite; i++)
				articlePanier.add(article);
			article.setQuantitéEnStock(article.getQuantitéEnStock() - quantite);
		}
	}
	
	public float totalSansFraisDePort() {
		float sommes = 0;
		for(Article art: articlePanier) {
			sommes += art.getPrixTTC();	
		}
		return sommes;
	}
	
	public float totalPanier(float fraisDePort) {
		float prix = totalSansFraisDePort();
		if (prix >= PRIX_OFFRE_LIVRAISON) {
			return prix;
		} else {
			return prix + fraisDePort;
		}
	}
	
	public void viderPanier() {
		articlePanier.clear();
	}
	
	public Article getArticle(int index)
	{
		return articlePanier.get(index);
	}
	
	public int getTaillePanier()
	{
		return articlePanier.size();
	}
	
}
