package application.models;



public class NoeudArbreBinaire {
    // Attributs
    Stagiaire stagiaire; // clé
    NoeudArbreBinaire filsGauche;
    NoeudArbreBinaire filsDroit;

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

    // Méthode AJouter Stagiaire
    public void ajouterStagiaire(Stagiaire stagiaireAjouter) {
	if (this.stagiaire == null) {
	    this.stagiaire = stagiaireAjouter;
	    racine = this;
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
    


    // Méthode recherche par nom
    public String rechercherNom(String NomRechercher) {
	String resultat = "";
	if (this.stagiaire.getNom().equals(NomRechercher)) {
	    resultat = this.stagiaire.toString();
	} else if (this.stagiaire.getNom().compareTo(NomRechercher) > 0) { // je pars à gauche
	    if (this.filsGauche == null) {
		return resultat;
	    } else {
		resultat = this.filsGauche.rechercherNom(NomRechercher);
	    }
	} else { // je pars à droite
	    if (this.filsDroit == null) {
		return resultat;
	    } else {
		resultat = this.filsDroit.rechercherNom(NomRechercher);
	    }
	}
	return resultat;
    }

    // Méthode recherche par département
    public String rechercherDpt(String DptRechercher) {
	String resultat = "";
	if (this.stagiaire.getDepartement().equals(DptRechercher)) {
	    resultat = this.stagiaire.toString();
	} else if (this.stagiaire.getDepartement().compareTo(DptRechercher) > 0) { // je pars à gauche
	    if (this.filsGauche == null) {
		return resultat;
	    } else {
		resultat = this.filsGauche.rechercherDpt(DptRechercher);
	    }
	} else { // je pars à droite
	    if (this.filsDroit == null) {
		return resultat;
	    } else {
		resultat = this.filsDroit.rechercherDpt(DptRechercher);
	    }
	}
	return resultat;
    }

    // Méthode recherche par prenom
    public String rechercherPrenom(String PrenomRechercher) {
	String resultat = "";
	if (this.stagiaire.getPrenom().equals(PrenomRechercher)) {
	    resultat = this.stagiaire.toString();
	} else if (this.stagiaire.getPrenom().compareTo(PrenomRechercher) > 0) { // je pars à gauche
	    if (this.filsGauche == null) {
		return resultat;
	    } else {
		resultat = this.filsGauche.rechercherPrenom(PrenomRechercher);
	    }
	} else { // je pars à droite
	    if (this.filsDroit == null) {
		return resultat;
	    } else {
		resultat = this.filsDroit.rechercherNom(PrenomRechercher);
	    }
	}
	return resultat;
    }

    // Méthode recherche par Annee
    public String rechercherAnnee(String AnneeRechercher) {
	String resultat = "";
	if (this.stagiaire.getAnnee().equals(AnneeRechercher)) {
	    resultat = this.stagiaire.toString();
	} else if (this.stagiaire.getAnnee().compareTo(AnneeRechercher) > 0) { // je pars à gauche
	    if (this.filsGauche == null) {
		return resultat;
	    } else {
		resultat = this.filsGauche.rechercherAnnee(AnneeRechercher);
	    }
	} else { // je pars à droite
	    if (this.filsDroit == null) {
		return resultat;
	    } else {
		resultat = this.filsDroit.rechercherAnnee(AnneeRechercher);
	    }
	}
	return resultat;
    }

    // Méthode recherche par promotion
    public String rechercherPromo(String PromoRechercher) {
	String resultat = "";
	if (this.stagiaire.getPromotion().equals(PromoRechercher)) {
	    resultat = this.stagiaire.toString();
	} else if (this.stagiaire.getPromotion().compareTo(PromoRechercher) > 0) { // je pars à gauche
	    if (this.filsGauche == null) {
		return resultat;
	    } else {
		resultat = this.filsGauche.rechercherPromo(PromoRechercher);
	    }
	} else { // je pars à droite
	    if (this.filsDroit == null) {
		return resultat;
	    } else {
		resultat = this.filsDroit.rechercherPromo(PromoRechercher);
	    }
	}
	return resultat;
    }

    // attribu
    private static NoeudArbreBinaire racine = null;

    // Getters & Setters
    public static NoeudArbreBinaire getRacine() {
	return racine;
    }

    public void setRacine(NoeudArbreBinaire racine) {
	this.racine = racine;
    }

    // Méthode Supression
    public void supprimerStagiaire(String stagiaireASupprimer) {

	if (stagiaireASupprimer == null) {
	    throw new NullPointerException();
	}
	racine = supprimerValeur(stagiaireASupprimer, racine);
    }

    // Supprimer un stagiaire en le recherchant à partir d'un noeud
    private NoeudArbreBinaire supprimerValeur(String stagiaireASupprimer, NoeudArbreBinaire s) {
	if (s == null) {
	    return s;
	}
	int test = stagiaireASupprimer.compareToIgnoreCase(s.getStagiaire().getNom());
	if (test == 0) {

	    return supprimerRacine(s);
	} else if (test < 0) {
	    s.setFilsGauche(supprimerValeur(stagiaireASupprimer, s.getFilsGauche()));
	} else {
	    s.setFilsDroit(supprimerValeur(stagiaireASupprimer, s.getFilsDroit()));
	}

	return s;
    }

    private NoeudArbreBinaire supprimerRacine(NoeudArbreBinaire s) {
	if (s.getFilsGauche() == null) {// 1er cas : Le noeud à supprimer n'a pas de fils gauche, alors on supprime le
	    // noeud et on retourne le fils droit
	    return s.getFilsDroit();
	}
	if (s.getFilsDroit() == null) { // 2ème cas : Le noeud à supprimer n'a pas de fils droit alors on supprime le
	    // noeud et on retourne le fils gauche
	    return s.getFilsGauche();
	}
	// 3ème cas : Le noeud à supprimer a un fils gauche et un fils droit, on
	// recherche alors le noeud le plus à gauche, qui a donc la plus petite valeur
	// de son sous-arbre droit, pour mettre cette valeur dans le noeud contenant
	// celle à supprimer et qui sera donc écrasée
	// on supprime ensuite ce noeud dont la valeur vient d'être copiée
	NoeudArbreBinaire feuille = dernierDescendant(s.getFilsGauche());
	s.setStagiaire(feuille.getStagiaire());
	s.setFilsGauche(supprimerValeur(feuille.getStagiaire().getNom(), s.getFilsGauche()));
	return s;
    }

    // Méthode permettant de déterminer le dernier descendant d'un noeud
    private NoeudArbreBinaire dernierDescendant(NoeudArbreBinaire s) {
	if (s.getFilsDroit() == null) {
	    return s;
	}
	return dernierDescendant(s.getFilsDroit());
    }

    @Override
    public String toString() {
	String resultat = "" + "\n";
	if (this.getFilsGauche() != null) {
	    resultat += this.getFilsGauche().toString() + "\n";
	}
	resultat += this.getStagiaire();
	if (this.getFilsDroit() != null) {
	    resultat += this.getFilsDroit().toString() + "\n";
	}
	return resultat;
    }


}