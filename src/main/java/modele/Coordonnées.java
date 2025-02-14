package modele;

public class Coordonnées {
	private String nom;
	private String prenom;
	private String adresse1;
	private String adresse2;
	private String codePostal;
	private String ville;
	private String telephone;
	private String mail;
	private String moyenDePaiment;
	private boolean abonnement;

	public Coordonnées(String nom, String prenom, String adresse1, String adresse2, String codePostal, String ville,
			String telephone, String mail, String moyenDePaiment, boolean abonnement) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse1 = adresse1;
		this.adresse2 = adresse2;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
		this.mail = mail;
		this.moyenDePaiment = moyenDePaiment;
		this.abonnement = abonnement;
	}

	public String getNom() {
		return this.nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public String getAdresse1() {
		return this.adresse1;
	}

	public String getAdresse2() {
		return this.adresse2;
	}

	public String getCodePostal() {
		return this.codePostal;
	}

	public String getVille() {
		return this.ville;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public String getMail() {
		return this.mail;
	}

	public String getMoyenDePaiement() {
		return this.moyenDePaiment;
	}

	public boolean isAbonnement() {
		return this.abonnement;
	}

}
