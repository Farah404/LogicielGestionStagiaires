package application.java;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

import java.util.Scanner;

public class LanceurAnnuaire {
    public static void main(String[] args) {

	String nom;
	String prenom;
	String departement;
	String promotion;
	String annee;
	NoeudArbreBinaire annuaire = new NoeudArbreBinaire(null);
	
	Scanner saisi = new Scanner(System.in);


	try {

	    FileReader fr = new FileReader(
		    "C:\\Users\\farah\\Desktop\\FormationIsika\\ProjetsEclipse\\LogicielGestionStagiaires\\STAGIAIRES.DON");
	    BufferedReader br = new BufferedReader(fr);
	    RandomAccessFile raf = new RandomAccessFile(
		    "C:\\Users\\\\farah\\Desktop\\FormationIsika\\ProjetsEclipse\\LogicielGestionStagiaires\\ANNUAIRE.BIN",
		    "rw");

	    while (br.ready()) {
		nom = br.readLine();
		prenom = br.readLine();
		departement = br.readLine();
		promotion = br.readLine();
		annee = br.readLine();
		br.readLine();
		Stagiaire stagiaire = new Stagiaire(nom, prenom, departement, promotion, annee);
		annuaire.ajouterStagiaire(stagiaire);
		raf.writeChars(stagiaire.getStagiaireLong());
		raf.writeInt(-1);
		raf.writeInt(-1);
		raf.writeInt(-1);

	    }
	    br.close();
	    fr.close();

	    // System.out.println(annuaire);
	    // List<Stagiaire>stagiaire = new ArrayList<>();
	    // System.out.println(annuaire.recherchernomStagiaire("Haritiana Ando",
	    // stagiaire));
	    
	    
	    raf.seek(0);
	    for (int i = 0; i < raf.length() / Stagiaire.TAILLE_STAGIAIRE_OCTETS; i++) {
		String nom2 = "";
		String prenom2 = "";
		String departement2 = "";
		String promotion2 = "";
		String annee2 = "";
		for (int j = 0; j < Stagiaire.TAILLE_NOM; j++) {
		    nom2 += raf.readChar();
		}
		for (int j = 0; j < Stagiaire.TAILLE_PRENOM; j++) {
		    prenom2 += raf.readChar();
		}
		for (int j = 0; j < Stagiaire.TAILLE_DEPARTEMENT; j++) {
		    departement2 += raf.readChar();
		}
		for (int j = 0; j < Stagiaire.TAILLE_PROMOTION; j++) {
		    promotion2 += raf.readChar();
		}
		for (int j = 0; j < Stagiaire.TAILLE_ANNEE; j++) {
		    annee2 += raf.readChar();
		}
		
		
		System.out.println(Stagiaire.TAILLE_STAGIAIRE);
		System.out.println((nom2 + prenom2 + departement2 + promotion2).length());
		System.out.println(Stagiaire.TAILLE_STAGIAIRE_OCTETS);
		System.out.println(nom2 + "\t" + nom2.trim());
		System.out.println(prenom2 + "\t" + prenom2.trim());
		System.out.println(departement2 + "\t" + departement2.trim());
		System.out.println(promotion2 + "\t" + promotion2.trim());
		System.out.println(annee2 + "\t" + annee2.trim());
		System.out.println(raf.readInt());
		System.out.println(raf.readInt());
		System.out.println(raf.readInt());
		System.out.println(raf.length());
		System.out.println(raf.length() / Stagiaire.TAILLE_STAGIAIRE_OCTETS);
	    }

	    raf.close();

	    System.out.println(annuaire.nombreStagiaires(annuaire));
	} catch (FileNotFoundException e) {
	    System.out.println("le chemin n'est pas le bon");
	    e.printStackTrace();
	} catch (IOException e) {
	    System.out.println("j'ai un pb avec un fichier");
	    e.printStackTrace();
	}
    }
}
