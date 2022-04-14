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
		//this.indexGauche = -1;
		//this.indexDroit = -1;
	}
	public Noeud(Stagiaire stagiaire, Noeud gauche, Noeud droit) {
		super();
		this.stagiaire = stagiaire;
		this.gauche = gauche;
		this.droit = droit;
	}
	/**
	 * Retourne le noeud Parent stagiaire
	 * @return the stagiaire
	 */
	public Stagiaire getStagiaire() {
		return stagiaire;
	}

	/**
	 * Retourne le noeud enfant gauche
	 * @return gauche
	 */
	public Noeud getGauche() {
		return gauche;
	}

	/**
	 * Retourne le noeud enfant droit
	 * @return
	 */
	public Noeud getDroit() {
		return droit;
	}

	/**
	 * Moodifie le noeud parent stagiaire
	 * @param stagiaire
	 */
	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}

	/**
	 * Modifie le noeud enfant gauche
	 * @param gauche
	 */
	public void setGauche(Noeud gauche) {
		this.gauche = gauche;
	}

	/**
	 * Modifie le noeud enfant droit
	 * @param droit
	 */
	public void setDroit(Noeud droit) {
		this.droit = droit;
	}

	/**
	 * Retourne l'index du noeud
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 *
	 * @param index
	 */
	public void setIndex(int index) {
		this.index = index;
	}
	@Override
	public String toString() {
		String retour = "id : " + this.index + " -- "+ stagiaire.toString() + "{";
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
