package application.java;

public class Noeud {

    private Stagiaire stagiaire;
    private Noeud gauche;
    private Noeud droit;
    private int index;

    public Noeud() {
    }

    public Noeud(Stagiaire stagiaire) {
	super();
	this.stagiaire = stagiaire;
	this.gauche = null;
	this.droit = null;
    }

    public Noeud(Stagiaire stagiaire, int index) {
	super();
	this.stagiaire = stagiaire;
	this.gauche = null;
	this.droit = null;
	this.index = index;
    }

    public Noeud(Stagiaire stagiaire, Noeud gauche, Noeud droit) {
	super();
	this.stagiaire = stagiaire;
	this.gauche = gauche;
	this.droit = droit;
    }

    // NOEUD PARENT STAGIAIRE//
    public Stagiaire getStagiaire() {
	return stagiaire;
    }

    // NOEUD FILS GAUCHE//
    public Noeud getGauche() {
	return gauche;
    }

    // NOEUD FILS DROIT//
    public Noeud getDroit() {
	return droit;
    }

    // MODIFICATION NOEUD STAGIAIRE PARENT//
    public void setStagiaire(Stagiaire stagiaire) {
	this.stagiaire = stagiaire;
    }

    // MODIFICATION NOEUD FILS GAUCHE//
    public void setGauche(Noeud gauche) {
	this.gauche = gauche;
    }

    // MODIFICATION NOEUD FILS DROIT//
    public void setDroit(Noeud droit) {
	this.droit = droit;
    }

    public int getIndex() {
	return index;
    }

    public void setIndex(int index) {
	this.index = index;
    }

    @Override
    public String toString() {
	String retour = "id : " + this.index + " -- " + stagiaire.toString() + "{";
	if (gauche != null) {
	    retour += "gauche : " + gauche.toString() + "/";
	}
	if (droit != null) {
	    retour += "droit : " + droit.toString();
	}
	retour += "}";
	return retour;
    }
}
