package application.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ArbreStagiaire {

    static final int NOM = 25;
    static final int PRENOM = 20;
    static final int DEPARTEMENT = 3;
    static final int PROMO = 15;
    static final int ANNEE_ENTREE = 4;
    static final String PATH_FILE_BIN = "C:\\Users\\farah\\Desktop\\FormationIsika\\ProjetsEclipse\\LogicielGestionStagiaires\\stagiaires.bin";
    static final String PATH_FILE_DON = "C:\\Users\\farah\\Desktop\\FormationIsika\\ProjetsEclipse\\LogicielGestionStagiaires\\STAGIAIRES.DON";
    private Noeud racine;
    private static RandomAccessFile raf;

    public ArbreStagiaire() {
	creationFichierBinaire();
    }

    // METHODES GETTERS ET SETTERS//

    public Noeud getRacine() {
	return racine;
    }

    public void setRacine(Noeud racine) {
	this.racine = racine;
    }

    // METHODE POUR ACCEDER AU FICHIER DON ET CREER FICHIER BIN//

    public void creationFichierBinaire() {
	File monFichierBin = new File(PATH_FILE_BIN);
	File monFichierDon = new File(PATH_FILE_DON);
	if (monFichierBin.exists()) {
	    try {
		raf = new RandomAccessFile(PATH_FILE_BIN, "rw");
	    } catch (FileNotFoundException e) {
		e.printStackTrace();
	    }
	    ArbreFichierBin();
	} else if (monFichierDon.exists()) {
	    try {
		raf = new RandomAccessFile(PATH_FILE_BIN, "rw");
	    } catch (FileNotFoundException e) {
		e.printStackTrace();
	    }
	    LectureDon(monFichierDon);
	}

    }

    // CREATION DE L'ARBRE BINAIRE A PARTIR DU FICHIER DON//
    private void LectureDon(File monFichier) {
	String nom = "", prenom = "", departement = "", promotion = "", annee = "";
	try {
	    FileReader fr = new FileReader(monFichier);
	    BufferedReader br = new BufferedReader(fr);
	    while (br.ready()) {
		nom = br.readLine();
		prenom = br.readLine();
		departement = br.readLine();
		promotion = br.readLine();
		annee = br.readLine();
		br.readLine();
		this.ajouter(new Stagiaire(nom, prenom, departement, promotion, annee));
	    }
	    br.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    private void ArbreFichierBin() {
	this.setRacine(new Noeud(lectureStagiaire(0), 0));
	this.ArbreFichierBin(racine);
    }

    private Noeud ArbreFichierBin(Noeud courant) {
	if (lectureIndexFilsG(courant.getIndex()) != -1) {
	    courant.setGauche(this.ArbreFichierBin(new Noeud(lectureStagiaire(lectureIndexFilsG(courant.getIndex())),
		    lectureIndexFilsG(courant.getIndex()))));
	}
	if (lectureIndexFilsD(courant.getIndex()) != -1) {
	    courant.setDroit(this.ArbreFichierBin(new Noeud(lectureStagiaire(lectureIndexFilsD(courant.getIndex())),
		    lectureIndexFilsD(courant.getIndex()))));
	}
	return courant;
    }

    // METHODE LECTURE ET ECRITURE DANS LE FICHIER BINAIRE//

    private static Noeud ecritureNoeudFichier(Stagiaire x, int indexPere) {
	int index = 0;
	try {
	    if (indexPere != -1) {
		if (x.compareTo(lectureStagiaire(indexPere)) < 0) {
		    raf.seek((indexPere * 142) + 134);
		} else {
		    raf.seek((indexPere * 142) + 138);
		}
		index = (int) raf.length() / 142;
		raf.writeInt(index);
		raf.seek(raf.length());
	    } else
		raf.seek(0); // si indexPere = -1, la racine change
	    raf.writeChars(x.getNom());
	    for (int i = x.getNom().length(); i < 25; i++) {
		raf.writeChars("*");
	    }
	    raf.writeChars(x.getPrenom());
	    for (int i = x.getPrenom().length(); i < 20; i++) {
		raf.writeChars("*");
	    }
	    raf.writeChars(x.getDepartement());
	    for (int i = x.getDepartement().length(); i < 3; i++) {
		raf.writeChars("*");
	    }
	    raf.writeChars(x.getPromotion());
	    for (int i = x.getPromotion().length(); i < 15; i++) {
		raf.writeChars("*");
	    }
	    raf.writeChars(x.getAnnee());
	    for (int i = x.getAnnee().length(); i < 4; i++) {
		raf.writeChars("*");
	    }
	    raf.writeInt(-1);
	    raf.writeInt(-1);
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return new Noeud(x, index);
    }

    private static Stagiaire lectureStagiaire(int index) {
	Stagiaire stagiaireTemporaire = new Stagiaire("", "", "", "", "");
	String motTemporaire = "";
	try {
	    raf.seek(index * 142);
	    for (int i = 0; i < 25; i++) {
		motTemporaire += raf.readChar();
	    }
	    stagiaireTemporaire.setNom(motTemporaire.replace("*", ""));
	    motTemporaire = "";
	    for (int i = 0; i < 20; i++) {
		motTemporaire += raf.readChar();
	    }
	    stagiaireTemporaire.setPrenom(motTemporaire.replace("*", ""));
	    motTemporaire = "";
	    for (int i = 0; i < 3; i++) {
		motTemporaire += raf.readChar();
	    }
	    stagiaireTemporaire.setDepartement(motTemporaire.replace("*", ""));
	    motTemporaire = "";
	    for (int i = 0; i < 15; i++) {
		motTemporaire += raf.readChar();
	    }
	    stagiaireTemporaire.setPromotion(motTemporaire.replace("*", ""));
	    motTemporaire = "";
	    for (int i = 0; i < 4; i++) {
		motTemporaire += raf.readChar();
	    }
	    stagiaireTemporaire.setAnnee(motTemporaire.replace("*", ""));
	    motTemporaire = "";
	    raf.readInt();
	    raf.readInt();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return stagiaireTemporaire;
    }

    private int lectureIndexFilsG(int index) {
	int retour = 0;
	try {
	    raf.seek((index * 142) + 134);
	    retour = raf.readInt();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return retour;
    }

    private int lectureIndexFilsD(int index) {
	int retour = 0;
	try {
	    raf.seek((index * 142) + 138);
	    retour = raf.readInt();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return retour;
    }

    private void ecrireIndexFilsG(int index, int nouveauIndex) {
	try {
	    raf.seek((index * 142) + 134);
	    raf.writeInt(nouveauIndex);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    private void ecrireIndexFilsD(int index, int nouveauIndex) {
	try {
	    raf.seek((index * 142) + 138);
	    raf.writeInt(nouveauIndex);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    private void nouvelleRacine(Stagiaire x, int filsG, int filsD) {
	ecritureNoeudFichier(x, -1);
	try {
	    raf.seek(134);
	    raf.writeInt(filsG);
	    raf.seek(138);
	    raf.writeInt(filsD);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    // METHODE POUR AJOUTER UN NOEUD DONC AJOUTER UN STAGIAIRE//

    public void ajouter(Stagiaire x) {
	if (this.racine == null) {
	    this.racine = ecritureNoeudFichier(x, -1);
	}
	ajouterNoeud(x, racine, -1);
    }

    private Noeud ajouterNoeud(Stagiaire x, Noeud courant, int indexPere) {
	if (courant == null) {
	    return ecritureNoeudFichier(x, indexPere);
	}
	if (x.compareTo(courant.getStagiaire()) < 0) {
	    courant.setGauche(this.ajouterNoeud(x, courant.getGauche(), courant.getIndex()));
	}
	if (x.compareTo(courant.getStagiaire()) > 0) {
	    courant.setDroit(ajouterNoeud(x, courant.getDroit(), courant.getIndex()));
	}
	return courant;
    }

    // METHODE POUR SUPPRIMER UN NOEUD DONC SUPPRIMER UN STAGIAIRE//

    public void supprimer(Stagiaire x) {
	Noeud racineAvant = new Noeud(this.racine.getStagiaire(), 0);
	this.racine = supprimerNoeud(x, this.racine);
	if (racineAvant != this.racine && this.racine != null) {
	    nouvelleRacine(this.racine.getStagiaire(), lectureIndexFilsG(this.racine.getIndex()),
		    lectureIndexFilsD(this.racine.getIndex()));
	    this.racine.setIndex(0);
	}
    }

    private Noeud supprimerNoeud(Stagiaire x, Noeud courant) {
	if (courant == null)
	    return courant;
	if (courant.getStagiaire().compareTo(x) == 0) {
	    return supprimerRacine(courant);
	} else if (courant.getStagiaire().compareTo(x) > 0) {
	    courant.setGauche(supprimerNoeud(x, courant.getGauche()));
	    if (courant.getGauche() == null)
		ecrireIndexFilsG(courant.getIndex(), -1);
	    else
		ecrireIndexFilsG(courant.getIndex(), courant.getGauche().getIndex());
	} else {
	    courant.setDroit(supprimerNoeud(x, courant.getDroit()));
	    if (courant.getDroit() == null)
		ecrireIndexFilsD(courant.getIndex(), -1);
	    else
		ecrireIndexFilsD(courant.getIndex(), courant.getDroit().getIndex());
	}
	return courant;
    }

    private Noeud supprimerRacine(Noeud courant) {
	if (courant.getGauche() == null && courant.getDroit() == null) {
	    return null;
	} else if (courant.getGauche() == null) {
	    ecrireIndexFilsD(courant.getIndex(), courant.getDroit().getIndex());
	    return courant.getDroit();
	} else if (courant.getDroit() == null) {
	    ecrireIndexFilsG(courant.getIndex(), courant.getGauche().getIndex());
	    return courant.getGauche();
	} else {
	    Noeud dernierDescendant = dernierDescendant(courant.getGauche());

	    courant.setStagiaire(dernierDescendant.getStagiaire());
	    courant.setIndex(dernierDescendant.getIndex());

	    if (courant.getIndex() != courant.getDroit().getIndex())
		ecrireIndexFilsD(courant.getIndex(), courant.getDroit().getIndex());
	    else
		ecrireIndexFilsD(courant.getIndex(), -1);
	    if (courant.getIndex() != courant.getGauche().getIndex())
		ecrireIndexFilsG(courant.getIndex(), courant.getGauche().getIndex());
	    else
		ecrireIndexFilsG(courant.getIndex(), -1);

	    courant.setGauche(supprimerNoeud(dernierDescendant.getStagiaire(), courant.getGauche()));
	}
	return courant;
    }

    private Noeud dernierDescendant(Noeud courant) {
	if (courant.getDroit() == null)
	    return courant;
	return dernierDescendant(courant.getDroit());
    }

    // METHODE POUR MODIFIER UN NOEUD DONC MODIFIER UN STAGIARE//

    public void modifierNom(Stagiaire stagiaire, String nouveauNom) {
	Stagiaire ancienStagiaire = stagiaire;
	stagiaire.setNom(nouveauNom);
	modifier(ancienStagiaire, stagiaire);
    }

    public void modifierPrenom(Stagiaire stagiaire, String nouveauPrenom) {
	Stagiaire ancienStagiaire = stagiaire;
	stagiaire.setPrenom(nouveauPrenom);
	modifier(ancienStagiaire, stagiaire);
    }

    public void modifierDepartement(Stagiaire stagiaire, String nouveauDepartement) {
	Stagiaire ancienStagiaire = stagiaire;
	stagiaire.setDepartement(nouveauDepartement);
	modifier(ancienStagiaire, stagiaire);
    }

    public void modifierPromo(Stagiaire stagiaire, String nouvellePromo) {
	Stagiaire ancienStagiaire = stagiaire;
	stagiaire.setPromotion(nouvellePromo);
	modifier(ancienStagiaire, stagiaire);
    }

    public void modifierAnneeEntree(Stagiaire stagiaire, String nouvelleAnneeEntree) {
	Stagiaire ancienStagiaire = stagiaire;
	stagiaire.setAnnee(nouvelleAnneeEntree);
	modifier(ancienStagiaire, stagiaire);
    }

    public void modifier(Stagiaire ancienStagiaire, Stagiaire nouveauStagiaire) {
	this.supprimer(ancienStagiaire);
	this.ajouter(nouveauStagiaire);
    }

    @Override
    public String toString() {
	return racine + " ";
    }
}
