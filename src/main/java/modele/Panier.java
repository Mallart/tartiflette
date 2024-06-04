package modele;
import java.util.ArrayList;
import java.util.List;

public class Panier {
	private List<Fromages> fromagePanier;

	public Panier() {
		this.fromagePanier = new ArrayList<Fromages>();
	}
	
	public void ajouterFromagePanier(Fromages fromage) {
		fromagePanier.add(fromage);
	}
	
	public Fromages getFromageDePanier(int i){
		return fromagePanier[i];
	}
	
	public void viderPanier() {
		fromagePanier.clear();
	}
	
	
}
