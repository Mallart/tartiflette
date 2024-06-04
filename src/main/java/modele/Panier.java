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
	
	public void ajouterArticlePanier(Article article) {
		articlePanier.add(article);
	}
	
	public float totalSansFraisDePort() {
		float sommes = 0;
		for(Article art: articlePanier) {
			return sommes += art.getPrixTTC();		
		}
		return sommes;
	}
	
	public float totalPanier(float fraisDePort) {
		return totalSansFraisDePort() + fraisDePort;
	}
	
	
	
}
