package modele;
import java.util.ArrayList;
import java.util.List;

public class Panier {
	private List<Article> articlePanier;

	public Panier() {
		this.articlePanier = new ArrayList<Article>();
	}
	
	public float prixTotalArticle(Article article) {
		return article.getQuantitéEnStock() * article.getPrixTTC();
	}
	
	public void ajouterArticlePanier(Article article, int quantite) {
		if((article.getQuantitéEnStock() - quantite)>0) {
			articlePanier.add(article);
			article.setQuantitéEnStock(article.getQuantitéEnStock() - quantite);
		}
	}
	
	public float totalSansFraisDePort() {
		float sommes = 0;
		for(Article art: articlePanier) {
			return sommes += art.getPrixTTC();		
		}
		return sommes;
	}
	
	public float totalPanier(float fraisDePort) {
		if (totalSansFraisDePort() >= 120) {
			return totalSansFraisDePort();
		}else {
			return totalSansFraisDePort() + fraisDePort;
		}
	}
	
	public void viderPanier() {
		articlePanier.clear();
	}
	
	public Article getArticle(int index)
	{
		return articlePanier.get(index);
	}
	
}
