package application.java;

import java.util.List;

public class NoeudArbreBinaire {
    // Attributs
    Stagiaire stagiaire; // cl�
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

    // M�thode AJouter Stagiaire
    public void ajouterStagiaire(Stagiaire stagiaireAjouter) {
	if (this.stagiaire == null) {
	    this.stagiaire = stagiaireAjouter;
	    racine = this;
	} else {
	    if (this.stagiaire.getNom().compareTo(stagiaireAjouter.getNom()) > 0) { // je pars � gauche
		if (this.filsGauche == null) {
		    this.filsGauche = new NoeudArbreBinaire(stagiaireAjouter);
		} else {
		    this.filsGauche.ajouterStagiaire(stagiaireAjouter);
		}
	    } else if (this.stagiaire.getNom().compareTo(stagiaireAjouter.getNom()) < 0) { // je pars � droite
		if (this.filsDroit == null) {
		    this.filsDroit = new NoeudArbreBinaire(stagiaireAjouter);
		} else {
		    this.filsDroit.ajouterStagiaire(stagiaireAjouter);
		}
	    }
	}
    }

    // M�thode recherche par nom
    public List<Stagiaire> recherchernomStagiaire(String nomStagiaire, List<Stagiaire> stagiaires) {

	if (this.filsGauche != null) {
	    stagiaires = this.filsGauche.recherchernomStagiaire(nomStagiaire, stagiaires);

	}
	if ((this.stagiaire.getPrenom().equals(nomStagiaire))) {
	    stagiaires.add(this.getStagiaire());
	}
	if (this.filsDroit != null) { // je pars � droite
	    stagiaires = this.filsDroit.recherchernomStagiaire(nomStagiaire, stagiaires);
	}
	return stagiaires;
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

    // M�thode Supression
    public void supprimerStagiaire(String stagiaireASupprimer) {

	if (stagiaireASupprimer == null) {
	    throw new NullPointerException();
	}
	racine = supprimerValeur(stagiaireASupprimer, racine);
    }

    // Supprimer un stagiaire en le recherchant � partir d'un noeud
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
	if (s.getFilsGauche() == null) {// 1er cas : Le noeud � supprimer n'a pas de fils gauche, alors on supprime le
	    // noeud et on retourne le fils droit
	    return s.getFilsDroit();
	}
	if (s.getFilsDroit() == null) { // 2�me cas : Le noeud � supprimer n'a pas de fils droit alors on supprime le
	    // noeud et on retourne le fils gauche
	    return s.getFilsGauche();
	}
	// 3�me cas : Le noeud � supprimer a un fils gauche et un fils droit, on
	// recherche alors le noeud le plus � gauche, qui a donc la plus petite valeur
	// de son sous-arbre droit, pour mettre cette valeur dans le noeud contenant
	// celle � supprimer et qui sera donc �cras�e
	// on supprime ensuite ce noeud dont la valeur vient d'�tre copi�e
	NoeudArbreBinaire feuille = dernierDescendant(s.getFilsGauche());
	s.setStagiaire(feuille.getStagiaire());
	s.setFilsGauche(supprimerValeur(feuille.getStagiaire().getNom(), s.getFilsGauche()));
	return s;
    }

    // M�thode permettant de d�terminer le dernier descendant d'un noeud
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
    
    public int nombreStagiaires(NoeudArbreBinaire noeud) {
	if (noeud == null)
		return 0;
	else
		return nombreStagiaires(noeud.filsGauche) + 1 + nombreStagiaires(noeud.filsDroit);
}


}