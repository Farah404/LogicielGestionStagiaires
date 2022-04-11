package application.models;

public class Stagiaire {
    //attributes
    public String nom;
    public String prenom;
    public int departement;
    public String promotion;
    public int annee;

    //EmptyConstructor
    public Stagiaire() {
    }

    //Constructor using attibutes
    public Stagiaire(String nom, String prenom, int departement, String promotion, int annee) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.departement = departement;
	this.promotion = promotion;
	this.annee = annee;
    }

    //Getters and Setters
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

    public int getDepartement() {
	return departement;
    }

    public void setDepartement(int departement) {
	this.departement = departement;
    }

    public String getPromotion() {
	return promotion;
    }
    public void setPromotion(String promotion) {
	this.promotion = promotion;
    }

    public int getAnnee() {
	return annee;
    }
    public void setAnnee(int annee) {
	this.annee = annee;
    }

    @Override
    public String toString() {
	return "Stagiaire [nom=" + nom + ", prenom=" + prenom + ", departement=" + departement + ", promotion="
		+ promotion + ", annee=" + annee + "]";
    }




}