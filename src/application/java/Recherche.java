package application.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Recherche {
	
	private static String attributeType01;
	private static String attributeType02;

//******************* Création de la liste complète des stagiaire  *******************
	
	/**
	 * Méthode de création de la liste complète des stagiaires présent dans l'arbre
	 * @param ArbreStagiaire : arbre
	 * @return List<Stagiaire> : listInfixe
	 */
	public static List<Stagiaire> parcoursStagiaire(ArbreStagiaire arbre){
		Noeud racine = arbre.getRacine();
		List<Stagiaire> listStagiaire = new ArrayList<Stagiaire>();
		return parcoursStagiaire(racine, listStagiaire);
	}
	
	private static List<Stagiaire> parcoursStagiaire(Noeud r, List<Stagiaire> listInfixe){
		if(r == null) return listInfixe;
		
		parcoursStagiaire(r.getGauche(), listInfixe);
		listInfixe.add(r.getStagiaire());
		parcoursStagiaire(r.getDroit(), listInfixe);
		
		return listInfixe;
	}
	
//******************* Métthode pour le choix du type de recherhche  *******************
	
	/**
	 * 
	 * @param attributeType
	 * @return
	 */
	private static int keyValue(String attributeType) {
		
		if(attributeType.equalsIgnoreCase("nom")) {
			return 1;
		}
		else if(attributeType.equalsIgnoreCase("anneeEntree")) {
			return 2;
		}
		else if(attributeType.equalsIgnoreCase("promo")) {
			return 3;
		}
		else if(attributeType.equalsIgnoreCase("departement")) {
			return 4;
		}
		else {
			return 0;
		}
	}

//	************************ Méthodes de recherche par département  ************************
	
	/**
	 * 
	 * @param cle
	 * @return List<Stagiaire> : listRechDep
	 */
	public static List<Stagiaire> chercherDepartement(String cle, ArbreStagiaire arbre) {
		List<Stagiaire> listRechDep = new ArrayList<>();
		return chercherDepartement(cle, arbre.getRacine(),listRechDep);
	}
	
	/**
	 * 
	 * @param cle
	 * @param r
	 * @param listResult
	 * @return
	 */
	private static List<Stagiaire> chercherDepartement(String cle, Noeud r, List<Stagiaire> listResult) {
		if (r == null){
			return listResult;
		}
		chercherDepartement(cle, r.getGauche(), listResult);
		if (cle.compareTo(r.getStagiaire().getDepartement()) == 0){
			listResult.add(r.getStagiaire());
//			System.out.println(r.getStagiaire() + " ");
		}
		chercherDepartement(cle, r.getDroit(), listResult);
		return listResult;
	}
//************************ Méthodes de recherche par nom ************************
	
	/**
	 * 
	 * @param cle
	 * @param arbre
	 * @return
	 */
	public static List<Stagiaire> chercherNom(String cle, ArbreStagiaire arbre) {
		List<Stagiaire> listRechNom = new ArrayList<>();
		return chercherNom(cle, arbre.getRacine(), listRechNom);
	}
	
	/**
	 * 
	 * @param cle
	 * @param r
	 * @param listResult
	 * @return
	 */
	private static List<Stagiaire> chercherNom(String cle, Noeud r, List<Stagiaire> listResult) {
		if (r == null){
			return listResult;
		}
		chercherNom(cle, r.getGauche(), listResult);
		if (cle.compareTo(r.getStagiaire().getNom()) == 0){
			listResult.add(r.getStagiaire());
//			System.out.println(r.getStagiaire() + " ");
		}
//		System.out.println(r.getStagiaire().getDepartement() + " ");
		chercherNom(cle, r.getDroit(), listResult);
		return listResult;
	}
//************************ Méthodes de recherche par année d'entrée ************************
	/**
	 * 
	 * @param cle
	 * @param arbre
	 * @return
	 */
	public static List<Stagiaire> chercherAnneeEntree(String cle, ArbreStagiaire arbre) {
		List<Stagiaire> listRechAnnee = new ArrayList<>();
		return chercherAnneeEntree(cle, arbre.getRacine(), listRechAnnee);
	}
	
	/**
	 * 
	 * @param cle
	 * @param r
	 * @param listResult
	 * @return
	 */
	private static List<Stagiaire> chercherAnneeEntree(String cle, Noeud r, List<Stagiaire> listResult) {
		if (r == null){
			return listResult;
		}
		chercherAnneeEntree(cle, r.getGauche(), listResult);
		if (cle.compareTo(r.getStagiaire().getAnnee()) == 0){
			listResult.add(r.getStagiaire());
//			System.out.println(r.getStagiaire() + " ");
		}
//		System.out.println(r.getStagiaire().getDepartement() + " ");
		chercherAnneeEntree(cle, r.getDroit(), listResult);
		return listResult;
	}
//************************ Méthodes de recherche par promotion spécifique  ************************
	
	/**
	 * 
	 * @param cle
	 * @param arbre
	 * @return
	 */
	public static List<Stagiaire> chercherPromotion(String cle, ArbreStagiaire arbre) {
		List<Stagiaire> listRechPromo = new ArrayList<>();
		return chercherPromotion(cle, arbre.getRacine(), listRechPromo);
	}
	
	/**
	 * 
	 * @param cle
	 * @param r
	 * @param listResult
	 * @return
	 */
	private static List<Stagiaire> chercherPromotion(String cle, Noeud r, List<Stagiaire> listResult) {
		if (r == null){
			return listResult;
		}
		chercherPromotion(cle, r.getGauche(), listResult);
		if (cle.compareTo(r.getStagiaire().getPromotion()) == 0 ){
			listResult.add(r.getStagiaire());
//			System.out.println(r.getStagiaire() + " ");
		}
		chercherPromotion(cle, r.getDroit(), listResult);
		return listResult;
	}
	
//************************ Méthodes de recherche par promotion générale ************************
	
	/**
	 * 
	 * @param cle
	 * @param arbre
	 * @return
	 */
	public static List<Stagiaire> chercherPromotionFull(String cle, ArbreStagiaire arbre) {
		List<Stagiaire> listRechPromo = new ArrayList<>();
		return chercherPromotionFull(cle, arbre.getRacine(), listRechPromo);
	}
	
	/**
	 * 
	 * @param cle
	 * @param r
	 * @param listResult
	 * @return
	 */
	private static List<Stagiaire> chercherPromotionFull(String cle, Noeud r, List<Stagiaire> listResult) {
		if (r == null){
			return listResult;
		}
		chercherPromotionFull(cle, r.getGauche(), listResult);
		if (cle.compareTo(r.getStagiaire().getPromotion()) == -3 ){ 
			listResult.add(r.getStagiaire());
//			System.out.println(r.getStagiaire() + " ");
		}
		chercherPromotionFull(cle, r.getDroit(), listResult);
		return listResult;
	}
//************************ Méthodes de recherche parmot clé ************************
	
	/**
	 * 
	 * @param cle
	 * @param type
	 * @param arbre
	 * @return
	 */
	public static List<Stagiaire> chercherCle(String cle, String type, ArbreStagiaire arbre) {
		attributeType01 = type;
		int key = keyValue(attributeType01);
		List<Stagiaire> listRech = new ArrayList<>();
		return chercherCle(cle, key, arbre, listRech);
	}
	
	/**
	 * 
	 * @param cle
	 * @param key
	 * @param arbre
	 * @param listResult
	 * @return
	 */
	private static List<Stagiaire> chercherCle(String cle, int key, ArbreStagiaire arbre, List<Stagiaire> listResult) {
		switch (key) {
		case 1:
			listResult = chercherNom(cle, arbre);
			break;
		case 2:
			listResult = chercherAnneeEntree(cle, arbre);
			break;
		case 3:
			listResult = chercherPromotion(cle, arbre);
			break;
		case 4:
			listResult = chercherDepartement(cle, arbre);
			break;
		default:
			listResult = new ArrayList<Stagiaire>();
			break;
		}
		return listResult;
	}
	
//************************ Méthodes de recherche avec multicritère (2 mots clé)  ************************
	
	/**
	 * 
	 * @param cle1
	 * @param type1
	 * @param cle2
	 * @param type2
	 * @param arbre
	 * @return
	 */
	public static List<Stagiaire> chercherMultiCle(String cle1, String type1, String cle2, String type2, 
			ArbreStagiaire arbre) { 
		attributeType01 = type1;
		attributeType02 = type2;
		int key1 = keyValue(attributeType01);
		int key2 = keyValue(attributeType02);
		List<Stagiaire> listRechMulti = new ArrayList<>();
		return chercherMultiCle(cle1, key1, cle2, key2, arbre, listRechMulti);
	}
	
	/**
	 * Creer un ficher temporaire ou stocker le miniArbre pour la creation de celui-ci
	 * @param cle1
	 * @param key1
	 * @param cle2
	 * @param key2
	 * @param arbre
	 * @param listResult
	 * @return
	 * @throws lecture fichier 
	 */
	private static List<Stagiaire> chercherMultiCle(String cle1, int key1, String cle2, int key2, 
			ArbreStagiaire arbre, List<Stagiaire> listResult) {
		List<Stagiaire> listInter = new ArrayList<Stagiaire>();
		switch (key1) {
		case 1:
			listInter = chercherNom(cle1, arbre);
			ArbreStagiaire miniArbreNom = new ArbreStagiaire();
			ajouterNoeudAll(listInter,miniArbreNom);
			switch (key2) {
				case 2:
					listResult = chercherAnneeEntree(cle2, miniArbreNom);
					break;
				case 3:
					listResult = chercherPromotion(cle2, miniArbreNom);			
					break;
				case 4:
					listResult = chercherDepartement(cle2, miniArbreNom);
					break;
				default:
					System.out.println("No Results founded");
					listResult = new ArrayList<Stagiaire>();
					break;
			}
			break;
		case 2:
			listInter = chercherAnneeEntree(cle1, arbre);
			ArbreStagiaire miniArbreAE = new ArbreStagiaire();
			ajouterNoeudAll(listInter, miniArbreAE);
			switch (key2) {
				case 1:
					listResult = chercherNom(cle2, miniArbreAE);
					break;
				case 3:
					listResult = chercherPromotion(cle2, miniArbreAE);
					break;
				case 4:
					listResult = chercherDepartement(cle2, miniArbreAE);
					break;
				default:
					System.out.println("No Results founded");
					listResult = new ArrayList<Stagiaire>();
					break;
			}	
			break;
		case 3:
			listInter = chercherPromotion(cle1, arbre);
			ArbreStagiaire miniArbrePromo = new ArbreStagiaire();
			ajouterNoeudAll(listInter,miniArbrePromo);
			System.out.println("Résultat");
			System.out.println(miniArbrePromo);
			switch (key2) {
				case 1:
					listResult = chercherNom(cle2, miniArbrePromo);
					break;
				case 2:
					listResult = chercherAnneeEntree(cle2, miniArbrePromo);			
					break;
				case 4:
					listResult = chercherDepartement(cle2, miniArbrePromo);
					break;
				default:
					System.out.println("No Results founded");
					listResult = new ArrayList<Stagiaire>();
					break;
			}
			break;
		case 4:
			listInter = chercherDepartement(cle1, arbre);
			ArbreStagiaire miniArbreDep = new ArbreStagiaire();
			ajouterNoeudAll(listInter, miniArbreDep);
			switch (key2) {
				case 1:
					listResult = chercherNom(cle2, miniArbreDep);
					break;
				case 2:
					listResult = chercherAnneeEntree(cle2, miniArbreDep);		
					break;
				case 3:
					listResult = chercherPromotion(cle2, miniArbreDep);
					break;
				default:
					System.out.println("No Results founded");
					listResult = new ArrayList<Stagiaire>();
					break;
			}
			break;
		default:
			System.out.println("No Results founded");
			listResult = new ArrayList<Stagiaire>();
			break;
		}
		return listResult;
	}

	//************************ Méthhode d'ajout pour la création de mini-arbre ************************
	
	/**
	 * 
	 * @param listStagiaire
	 * @param arbre
	 */
	public static void ajouterNoeudAll(List<Stagiaire> listStagiaire, ArbreStagiaire arbre) {
		for (Stagiaire stagiaire : listStagiaire) {
			ajouterNoeud(stagiaire, arbre);
		}
	}
	/**
	 * 
	 * @param x
	 * @param arbre
	 */
	public static void ajouterNoeud(Stagiaire x, ArbreStagiaire arbre) {
		if (arbre.getRacine() == null) {
			arbre.setRacine(new Noeud(x));
		}
		ajouterNoeud(x, arbre.getRacine());
	}
	
	/**
	 * 
	 * @param x
	 * @param courant
	 * @return
	 */
	private static Noeud ajouterNoeud(Stagiaire x, Noeud courant) {
		if(courant == null) {
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

	//************************ Méthode de création des sets ************************
	
	public static Set<String> getListePromo(ArbreStagiaire monArbre) {
		List<Stagiaire> stagiaires = parcoursStagiaire(monArbre);
		Set<String> listePromo = new HashSet<String>();
		for(Stagiaire stagiaire : stagiaires){
			listePromo.add(stagiaire.getPromotion());
		};
		return listePromo;
	}
	
	public static Set<String> getListeDepartement(ArbreStagiaire monArbre) {
		List<Stagiaire> stagiaires = parcoursStagiaire(monArbre);
		Set<String> listeDepartement = new HashSet<String>();
		for(Stagiaire stagiaire : stagiaires){
			listeDepartement.add(stagiaire.getDepartement());
		};
		return listeDepartement;
	}
	
	public static Set<String> getListeAnneeEntree(ArbreStagiaire monArbre) {
		List<Stagiaire> stagiaires = parcoursStagiaire(monArbre);
		Set<String> listeAnneeEntree = new HashSet<String>();
		for(Stagiaire stagiaire : stagiaires){
			listeAnneeEntree.add(stagiaire.getAnnee());
		};
		return listeAnneeEntree;
	}
}
