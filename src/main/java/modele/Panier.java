package modele;
import java.util.ArrayList;
import java.util.List;

public class Panier {
	private List<Article> articlePanier;

	public Panier() {
		this.articlePanier = new ArrayList<Article>();
	}
	
	public float prixTotalArticle(Article artcile) {
		return artcile.getQuantitéEnStock() * artcile.getPrixTTC();
	}
	
	public int quantiteArticle(Article article) {
		return article.getQuantitéEnStock();
	}
	
	public float prixArticle(Article article) {
		return article.getPrixTTC();
	}
	
	public void ajouterArticlePanier(Article article) {
		articlePanier.add(article);
	}
	
	
	
	
}
