package application.models;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Annuaire {
    
    private static List<Stagiaire> listeStagiaires;

    
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

	    FileReader fr = new FileReader("C:\\Users\\farah\\Desktop\\FormationIsika\\ProjetsEclipse\\LogicielGestionStagiaires\\STAGIAIRES.DON");
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

	    //	    System.out.println(annuaire);
	    //	    annuaire.supprimerStagiaire("Mehdi");
	    //	    System.out.println(annuaire.rechercherNom("ZAMOUN"));
	    //	    System.out.println(annuaire.rechercherPrenom("Pascale"));
	    //	    System.out.println(annuaire.rechercherDpt("93"));
	    //	    System.out.println(annuaire.rechercherPromo("ATOD"));
	    //	    System.out.println(annuaire.rechercherAnnee("2008"));


	} catch (FileNotFoundException e) {
	    System.out.println("le chemin n'est pas le bon");
	    e.printStackTrace();
	} catch (IOException e) {
	    System.out.println("j'ai un pb avec un fichier");
	    e.printStackTrace();
	}

	listeStagiaires = getListStagiaireDansArbreBinaire();
	System.out.println(listeStagiaires.toString());
    }

    private static void getElementsArbreBinaire(List<Stagiaire> elements, NoeudArbreBinaire noeud) {
	if(noeud.filsGauche != null) {
	    getElementsArbreBinaire(elements, noeud.filsGauche);
	}
	if(noeud.filsDroit != null ) {
	    getElementsArbreBinaire(elements, noeud.filsDroit);
	}
	elements.add(noeud.stagiaire);
    }

    //RECUPERER LA LISTE DANS L4ARBRE BINAIRE
    public static List<Stagiaire> getListStagiaireDansArbreBinaire() {
	List<Stagiaire> stagiaires = new ArrayList<>();
	getElementsArbreBinaire(stagiaires, NoeudArbreBinaire.getRacine());
	return stagiaires;
    }

    //METTRE TOUTES LES PROMOS DANS UN CHOICE BOX
    public Set<String> getAllPromos() {
	return listeStagiaires.stream()
		.map(stagiaire -> stagiaire.getPromotion())
		.sorted()
		.collect(Collectors.toSet());
    }

    //METTRE TOUS LES DPT DANS UN CHOICE BOX
    public Set<String> getAllDep() {
	return listeStagiaires.stream()
		.map(stagiaire -> stagiaire.getDepartement())
		.sorted()
		.collect(Collectors.toSet());
    }
}
