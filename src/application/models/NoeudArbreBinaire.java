package application.models;

public class NoeudArbreBinaire {

    // Attributs
    private Stagiaire stagiaire; // clé
    private NoeudArbreBinaire filsGauche;
    private NoeudArbreBinaire filsDroit;

    // Constructeurs
    public NoeudArbreBinaire(Stagiaire stagiaire) {
	this.stagiaire = stagiaire;
    }

    // Getters & Setters
    public Stagiaire getStagiaire() {
	return stagiaire;
    }

    public void setStagiaire(Stagiaire stagiaire) {
	this.stagiaire = stagiaire;
    }

    public NoeudArbreBinaire getFilsGauche() {
	return filsGauche;
    }

    public void setFilsGauche(NoeudArbreBinaire filsGauche) {
	this.filsGauche = filsGauche;
    }

    public NoeudArbreBinaire getFilsDroit() {
	return filsDroit;
    }

    public void setFilsDroit(NoeudArbreBinaire filsDroit) {
	this.filsDroit = filsDroit;
    }

    public String toString() {
	// GND
	String resultat = "";
	if (this.filsGauche != null) {
	    resultat += this.filsGauche.toString(); //G
	}

	resultat += this.stagiaire; //N

	if (this.filsDroit != null) {
	    resultat += this.filsDroit.toString(); //D
	}
	return resultat;
    }


    //Méthode AJouter Stagiaire
    public void ajouterStagiaire(Stagiaire stagiaireAjouter) {

	if (this.stagiaire == null) {
	    this.stagiaire = stagiaireAjouter;

	} else {

	    if (this.stagiaire.getNom().compareTo(stagiaireAjouter.getNom()) > 0) { // je pars à gauche

		if (this.filsGauche == null) {
		    this.filsGauche = new NoeudArbreBinaire(stagiaireAjouter);
		} else {
		    this.filsGauche.ajouterStagiaire(stagiaireAjouter);
		}

	    } else if (this.stagiaire.getNom().compareTo(stagiaireAjouter.getNom()) < 0) { // je pars à droite
		if (this.filsDroit == null) {
		    this.filsDroit = new NoeudArbreBinaire(stagiaireAjouter);
		} else {
		    this.filsDroit.ajouterStagiaire(stagiaireAjouter);
		}
	    }

	}

    }
    
    //Méthode recherche par nom
    public String rechercherNom(String NomRechercher) {

	String resultat = "";

	if (this.stagiaire.getNom().equals(NomRechercher)) {
	    resultat = this.stagiaire.toString();
	} else if (this.stagiaire.getNom().compareTo(NomRechercher) > 0){ // je pars à gauche
	    if (this.filsGauche == null) {
		return resultat;
	    }else {
		resultat = this.filsGauche.rechercherNom(NomRechercher);
	    }
	} else { // je pars à droite
	    if (this.filsDroit == null) {
		return resultat;
	    }else {
		resultat = this.filsDroit.rechercherNom(NomRechercher);
	    }
	}

	return resultat;
    }

    //Méthode recherche par département
    public String rechercherDpt(String DptRechercher) {

	String resultat = "";

	if (this.stagiaire.getDepartement().equals(DptRechercher)) {
	    resultat = this.stagiaire.toString();
	} else if (this.stagiaire.getDepartement().compareTo(DptRechercher) > 0){ // je pars à gauche
	    if (this.filsGauche == null) {
		return resultat;
	    }else {
		resultat = this.filsGauche.rechercherDpt(DptRechercher);
	    }
	} else { // je pars à droite
	    if (this.filsDroit == null) {
		return resultat;
	    }else {
		resultat = this.filsDroit.rechercherDpt(DptRechercher);
	    }
	}

	return resultat;
    }
    
    

}