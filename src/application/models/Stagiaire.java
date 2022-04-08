package application.models;

public class Stagiaire {
    //attributes
    private String nom;
    private String prenom;
    private String departement;
    private String promotion;
    private int annee;

    //EmptyConstructor
    public Stagiaire() {
    }

    //Constructor using attibutes
    public Stagiaire(String nom, String prenom, String departement, String promotion, int annee) {
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

    public int getAnnee() {
	return annee;
    }
    public void setAnnee(int annee) {
	this.annee = annee;
    }




}