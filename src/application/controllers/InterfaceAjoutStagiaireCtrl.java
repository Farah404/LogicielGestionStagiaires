package application.controllers;

import java.io.IOException;

import application.java.ArbreStagiaire;
import application.java.Recherche;
import application.java.Stagiaire;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class InterfaceAjoutStagiaireCtrl {

    @FXML
    private TextField nomS;
    @FXML
    private TextField prenomS;
    @FXML
    private TextField dptS;
    @FXML
    private TextField promoS;
    @FXML
    private TextField anneeS;
    @FXML
    private Button addBtn;
    @FXML
    private Button reinitBtn;
    

    static ArbreStagiaire monArbre = new ArbreStagiaire();
    ObservableList<Stagiaire> observableArrayList = FXCollections.observableArrayList(Recherche.parcoursStagiaire(monArbre));
    
    // Ajouter stagiaire
    @FXML
    public void ajouterNouveauStagiaire() throws IOException {
	String erreurs = validerSaisie();
	if (erreurs.isEmpty()) {
	    String nom = nomS.getText();
	    String prenom = prenomS.getText();
	    String departement = dptS.getText();
	    String promotion = promoS.getText();
	    String annee = anneeS.getText();
	    Stagiaire S = new Stagiaire(nom, prenom, departement, promotion, annee);
	    monArbre.ajouter(S);

	    Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Ajout de stagiaire");
	    alert.setHeaderText(null);
	    alert.setContentText("Le stagiaire a bien été ajouté à la liste");
	    alert.showAndWait();

	    this.nomS.clear();
	    this.prenomS.clear();
	    this.dptS.clear();
	    this.promoS.clear();
	    this.anneeS.clear();
	} else {
	    Alert alert = new Alert(AlertType.ERROR);
	    alert.setHeaderText("Erreurs de saisie : ");
	    alert.setContentText(erreurs);
	    alert.show();
	}
    }

    public String validerSaisie() {
	StringBuilder errorsBuilder = new StringBuilder();
	String nom = nomS.getText();
	if (nom == null || nom.trim().isEmpty()) {
	    errorsBuilder.append("Le nom du stagiaire doit être renseigné\n");
	}
	String prenom = prenomS.getText();
	if (prenom.trim().isEmpty()) {
	    errorsBuilder.append("Le prénom du stagiaire doit être renseigné\n");
	}
	String departement = dptS.getText();
	if (departement.trim().isEmpty()) {
	    errorsBuilder.append("Le département du stagiaire doit être renseigné\n");
	}
	String promotion = promoS.getText();
	if (promotion.trim().isEmpty()) {
	    errorsBuilder.append("La promotion du stagiaire doit être renseignée\n");
	}
	String annee = anneeS.getText();
	if (annee == null || annee.trim().isEmpty()) {
	    errorsBuilder.append("L'année d'inscription doit être renseignée\n");
	}
	return errorsBuilder.toString();
    }
    
    public void supprimerStagiaire() throws IOException {
	
    }
    
    
}