package application.models;

public class NouvelUtilisateur {
    
    protected String email;
    protected String nom;
    protected String prenom;
    protected String mdp;
    protected String confirMdp;
    
    public NouvelUtilisateur() {
	super();
    }

    public NouvelUtilisateur(String email, String nom, String prenom, String mdp, String confirMdp) {
	super();
	this.email = email;
	this.nom = nom;
	this.prenom = prenom;
	this.mdp = mdp;
	this.confirMdp = confirMdp;
    }

    @Override
    public String toString() {
	return "NouvelUtilisateur [email=" + email + ", nom=" + nom + ", prenom=" + prenom + ", mdp=" + mdp
		+ ", confirMdp=" + confirMdp + "]";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getConfirMdp() {
        return confirMdp;
    }

    public void setConfirMdp(String confirMdp) {
        this.confirMdp = confirMdp;
    }
    

}
