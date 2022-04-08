package application.models;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Annuaire extends ArbreBinaire {


    private static final String STAGIAIRES_DON="src/application/STAGIARES.DON";
    private ArbreBinaire<Stagiaire> arbre;
    private List<Stagiaire> listeStagiaires;

    public void lectureFichierTxt (String fileName) {
	arbre =new ArbreBinaire<Stagiaire>();

	try {

	    File file = new File(fileName);
	    FileInputStream fis = new FileInputStream(file);
	    Scanner scanner = new Scanner(fis);
	    while(scanner.hasNextLine()) {

		String nom = scanner.nextLine();
		String prenom = scanner.nextLine();
		int departement = Integer.parseInt(scanner.nextLine());
		String promotion = scanner.nextLine();
		int annee = Integer.parseInt(scanner.nextLine());
		scanner.nextLine();
		
		String ligneAvecSeparateur = nom + "*" + prenom + "*" + departement + "*" + promotion + "*" + annee;
		Stagiaire stagiaire = importStagiaire(ligneAvecSeparateur);
	    }
	    scanner.close();
	}
	catch (IOException e){
		e.printStackTrace();
    }
	listeStagiaires = get
}


