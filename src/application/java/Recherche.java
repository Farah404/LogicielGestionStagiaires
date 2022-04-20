package application.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Recherche {

//CREATION DE LA LISTE DES STAGIAIRE//

    public static List<Stagiaire> parcoursStagiaire(ArbreStagiaire arbre) {
	Noeud racine = arbre.getRacine();
	List<Stagiaire> listStagiaire = new ArrayList<>();
	return parcoursStagiaire(racine, listStagiaire);
    }

    private static List<Stagiaire> parcoursStagiaire(Noeud r, List<Stagiaire> listInfixe) {
	if (r == null)
	    return listInfixe;

	parcoursStagiaire(r.getGauche(), listInfixe);
	listInfixe.add(r.getStagiaire());
	parcoursStagiaire(r.getDroit(), listInfixe);

	return listInfixe;
    }

//METHODE DE RECHERCHE PAR DEPARTEMENT//
    public static List<Stagiaire> chercherDepartement(String cle, ArbreStagiaire arbre) {
	List<Stagiaire> listRechDep = new ArrayList<>();
	return chercherDepartement(cle, arbre.getRacine(), listRechDep);
    }

    private static List<Stagiaire> chercherDepartement(String cle, Noeud r, List<Stagiaire> listResult) {
	if (r == null) {
	    return listResult;
	}
	chercherDepartement(cle, r.getGauche(), listResult);
	if (cle.compareTo(r.getStagiaire().getDepartement()) == 0) {
	    listResult.add(r.getStagiaire());
	}
	chercherDepartement(cle, r.getDroit(), listResult);
	return listResult;
    }

//METHODE DE RECHERCHE PAR NOM//
    public static List<Stagiaire> chercherNom(String cle, ArbreStagiaire arbre) {
	List<Stagiaire> listRechNom = new ArrayList<>();
	return chercherNom(cle, arbre.getRacine(), listRechNom);
    }

    private static List<Stagiaire> chercherNom(String cle, Noeud r, List<Stagiaire> listResult) {
	if (r == null) {
	    return listResult;
	}
	chercherNom(cle, r.getGauche(), listResult);
	if (cle.compareTo(r.getStagiaire().getNom()) == 0) {
	    listResult.add(r.getStagiaire());
	}
	chercherNom(cle, r.getDroit(), listResult);
	return listResult;

    }

//METHODE DE RECHERCHE PAR ANNEE//
    public static List<Stagiaire> chercherAnneeEntree(String cle, ArbreStagiaire arbre) {
	List<Stagiaire> listRechAnnee = new ArrayList<>();
	return chercherAnneeEntree(cle, arbre.getRacine(), listRechAnnee);
    }

    private static List<Stagiaire> chercherAnneeEntree(String cle, Noeud r, List<Stagiaire> listResult) {
	if (r == null) {
	    return listResult;
	}
	chercherAnneeEntree(cle, r.getGauche(), listResult);
	if (cle.compareTo(r.getStagiaire().getAnnee()) == 0) {
	    listResult.add(r.getStagiaire());
	}
	chercherAnneeEntree(cle, r.getDroit(), listResult);
	return listResult;
    }

//CREATION MINI ARBRE//

    public static void ajouterNoeudAll(List<Stagiaire> listStagiaire, ArbreStagiaire arbre) {
	for (Stagiaire stagiaire : listStagiaire) {
	    ajouterNoeud(stagiaire, arbre);
	}
    }

    public static void ajouterNoeud(Stagiaire x, ArbreStagiaire arbre) {
	if (arbre.getRacine() == null) {
	    arbre.setRacine(new Noeud(x));
	}
	ajouterNoeud(x, arbre.getRacine());
    }

    private static Noeud ajouterNoeud(Stagiaire x, Noeud courant) {
	if (courant == null) {
	    return new Noeud(x);
	}
	if (x.getNom().compareTo(courant.getStagiaire().getNom()) < 0) {
	    courant.setGauche(ajouterNoeud(x, courant.getGauche()));
	}
	if (x.getNom().compareTo(courant.getStagiaire().getNom()) > 0) {
	    courant.setDroit(ajouterNoeud(x, courant.getDroit()));
	}
	return courant;
    }
}
