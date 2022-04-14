package application.java;


public class Stagiaire implements Comparable<Stagiaire> {

	public static final int TAILLE_NOM = 30;
	public static final int TAILLE_PRENOM = 30;
	public static final int TAILLE_DEPARTEMENT = 3;
	public static final int TAILLE_PROMOTION = 30;
	public static final int TAILLE_ANNEE = 4;
	public static final int TAILLE_STAGIAIRE = TAILLE_NOM + TAILLE_PRENOM + TAILLE_DEPARTEMENT + TAILLE_PROMOTION + TAILLE_ANNEE;
	public static final int TAILLE_STAGIAIRE_OCTETS = 2 * TAILLE_STAGIAIRE + 4 * 3;

private String nom;
private String prenom;
private String departement;
private String promotion;
private String annee;

public Stagiaire(String nom, String prenom, String departement, String promotion, String annee) {
	this.nom = nom;
	this.prenom = prenom;
	this.departement = departement;
	this.promotion = promotion;
	this.annee = annee;
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

public String getDepartement() {
	return departement;
}

public void setDepartement(String departement) {
	this.departement = departement;
}

public String getPromotion() {
	return promotion;
}

public void setPromotion(String promotion) {
	this.promotion = promotion;
}

public String getAnnee() {
	return annee;
}

public void setAnnee(String annee) {
	this.annee = annee;
}



@Override
public String toString() {
	return "Stagiaire [nom=" + nom + ", prenom=" + prenom + ", departement=" + departement + ", promotion=" + promotion + ", annee=" + annee
			+ "]";
}

@Override
public int compareTo(Stagiaire otherStagiaire) {
	int nb = this.getNom().compareTo(otherStagiaire.getNom());
	return nb;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if ((obj == null) || (getClass() != obj.getClass()))
		return false;
	Stagiaire other = (Stagiaire) obj;
	if (nom == null) {
		if(other.getNom() != null) {
			return false;
		}
	}else if (!nom.equals(other.nom)) {
		return false;
	}
	if (prenom == null) {
		if (other.prenom != null) {
			return false;
		}
	} else if (!prenom.equals(other.prenom)) {
		return false;
	}
	if (departement == null) {
		if (other.departement != null)
			return false;
	} else if (!departement.equals(other.departement))
		return false;
	if (promotion == null) {
		if (other.promotion != null)
			return false;
	} else if (!promotion.equals(other.promotion))
		return false;
	if (annee == null) {
		if (other.annee != null)
			return false;
	} else if (!annee.equals(other.annee))
		return false;
	return true;
}


}