package application.java;

public class Personnel {

    private String id;
    private String nom;
    private String prenom;
    private String mdp;

    public Personnel() {
	super();
    }

    public Personnel(String id, String nom, String prenom, String mdp) {
	super();
	this.id = nom + "_" + prenom;
	this.nom = nom;
	this.prenom = prenom;
	this.mdp = mdp;
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getNom() {
	return nom;
    }

    public void setNom(String nom) {
	this.nom = nom;
    }

    public String getPrenom() {
	return prenom;
    }

    public void setPrenom(String prenom) {
	this.prenom = prenom;
    }

    public String getMdp() {
	return mdp;
    }

    public void setMdp(String mdp) {
	this.mdp = mdp;
    }

    public static boolean creerCompte(String nom, String prenom, String mdp, String mdpConfirme) {
	boolean result;
	if (mdp.length() != mdpConfirme.length()) {
	    System.out.println("Les mots de passe sont différents");
	    result = false;
	} else {

	    if (mdp.equals(mdpConfirme)) {
		System.out.println("le compte est créé");
		result = true;
	    } else {
		System.out.println("Les mots de passe sont différents");
		result = false;
	    }

	}

	System.out.println("Nom: " + nom);
	System.out.println("Prenom: " + prenom);
	System.out.println("Mot de passe : " + mdp);

	return result;
    }

    public void connexion(String NomUtilisateur, String motDePasse) {
	System.out.println("Nom de l'utilisateur:  " + NomUtilisateur);
	System.out.println("Mot de passe:  " + motDePasse);
    }

    public void deconnexion() {

    }

    @Override
    public String toString() {

	return this.nom + "," + this.prenom + "," + this.id + "," + this.mdp;
    }

}
