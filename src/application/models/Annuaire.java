package application.models;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Annuaire {
    public static void main(String[] args) {

	String nom;
	String prenom;
	String departement;
	String promotion;
	String annee;
	NoeudArbreBinaire annuaire = new NoeudArbreBinaire(null);	
	Scanner saisi = new Scanner(System.in);
	String dptStagiaire;

	try {

	    FileReader fr = new FileReader("C:\\Users\\farah\\Desktop\\FormationIsika\\ProjetsEclipse\\ISIKA_CDA17_Projet1\\src\\application\\STAGIAIRES.DON");
	    BufferedReader br = new BufferedReader(fr);

	    while(br.ready()) {
		nom = br.readLine();
		prenom = br.readLine();
		departement = br.readLine();
		promotion = br.readLine();
		annee = br.readLine();
		br.readLine();
		Stagiaire stagiaire = new Stagiaire(nom, prenom, departement, promotion, annee);
		annuaire.ajouterStagiaire(stagiaire);
	    }
	    br.close();
	    fr.close();

	    System.out.println(annuaire);

	} catch (FileNotFoundException e) {
	    System.out.println("le chemin n'est pas le bon");
	    e.printStackTrace();
	} catch (IOException e) {
	    System.out.println("j'ai un pb avec un fichier");
	    e.printStackTrace();
	}
    }


}
