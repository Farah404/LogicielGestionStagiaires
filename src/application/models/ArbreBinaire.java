package application.models;

public class ArbreBinaire <E extends Comparable<E> >{

    public static class Noeud <T>{

	public T valeur;
	public Noeud <T> gauche;
	public Noeud <T> droit;

	public Noeud(T t) {
	    this.valeur = t;
	    this.gauche = null;
	    this.droit = null;
	}
	@Override
	public String toString() {
	    return "Noeud [valeur=" + valeur + ", gauche=" + gauche + ", droit=" + droit + "]";
	}
    }

    private Noeud<E> racine = null;

    public Noeud<E> getRacine() {
	return racine;
    }

    public void ajouterNoeud(E element) {

	Noeud<E> courant = racine;
	if (racine == null) racine = new Noeud<E>(element);
	else {

	    boolean ok = false;
	    while(!ok) {
		int test = element.compareTo(courant.valeur);

		if(test < 0) {
		    if(courant.gauche == null) {

			courant.gauche = new Noeud<E> (element);

			ok = true;
		    }

		    else {

			courant = courant.gauche;
		    }
		} 
		else {
		    ok = true;
		}
	    } 
	} 
    } 

    public void parcoursInfixe(Noeud<E> n) {
	if (n != null) {

	    parcoursInfixe(n.gauche);
	    System.out.println(n.valeur + " ; ");

	    parcoursInfixe(n.droit);
	}
    }   

    public Noeud<E> rechercherRecursif(Noeud<E> noeud, E element) {
	if (noeud == null) return null;
	if (element.compareTo(noeud.valeur) == 0) return noeud; 
	if (element.compareTo(noeud.valeur) > 0) return rechercherRecursif(noeud.droit, element);
	else return rechercherRecursif(noeud.gauche, element);
    }
    public E rechercher(Noeud<E> noeud, E element) {
	Noeud<E> n = rechercherRecursif(noeud, element);
	if (n!=null) return n.valeur;
	return null;
    } 

    public Noeud<E> supprimer(Noeud<E> courant, E element) {
	Noeud<E> result = courant;

	int test = element.compareTo(courant.valeur);

	if (test == 0) {

	    if (courant.gauche == null) {
		result = courant.droit;
	    }
	    else if (courant.droit == null) {
		result = courant.gauche;
	    }
	    else {

		courant.valeur = plusPetiteValeurDuSousArbre(courant.droit);

		courant.droit = supprimer(courant.droit, courant.valeur);
	    }
	}
	else if(test < 0) {

	    courant.gauche = supprimer(courant.gauche, element);
	}
	else {

	    courant.droit = supprimer(courant.droit, element);
	}
	return result;
    }

    private E plusPetiteValeurDuSousArbre(Noeud<E> courant) {
	if(courant == null) throw new NullPointerException();
	if(courant.gauche == null) return courant.valeur;
	return plusPetiteValeurDuSousArbre(courant.gauche);
    }

    public void supprimer(E element) {

	if (element == null) throw new NullPointerException();

	racine = supprimer(racine, element);
    }


}







