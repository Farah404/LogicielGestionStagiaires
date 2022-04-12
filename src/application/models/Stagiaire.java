package application.models;

import java.util.Set;
import java.util.stream.Collectors;

public class Stagiaire implements Comparable<Stagiaire> {

public static final int TAILLE_NOM = 30;
public static final int TAILLE_PRENOM = 30;
public static final int TAILLE_DEPARTEMENT = 3;
public static final int TAILLE_PROMOTION = 20;
public static final int TAILLE_ANNEE = 4;
public static final int TAILLE_STAGIAIRE_OCTETS = 2 * TAILLE_NOM + 2 * TAILLE_PRENOM + 2 * TAILLE_DEPARTEMENT + 2 * TAILLE_PROMOTION + 2 * TAILLE_ANNEE;

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

public String getAttributLong(String attribut, int TAILLE_ATTRIBUT) {
	String attributLong = attribut;
	for(int i = attribut.length(); i < TAILLE_ATTRIBUT; i++) {
		attributLong += " ";
	}
	return attributLong;
}

@Override
public String toString() {
	return "Stagiaire [nom=" + nom + ", prenom=" + prenom + ", departement=" + departement + ", promotion=" + promotion + ", annee=" + annee
			+ "]";
}

@Override
public int compareTo(Stagiaire o) {
    // TODO Auto-generated method stub
    return 0;
}


}