package application.controllers;

import java.io.IOException;

import application.java.ArbreStagiaire;
import application.java.Recherche;
import application.java.Stagiaire;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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
    @FXML
    private Button quitterBtn;

    static ArbreStagiaire monArbre = new ArbreStagiaire();
    ObservableList<Stagiaire> observableArrayList =  FXCollections.observableArrayList(Recherche.parcoursStagiaire(monArbre));
    protected void ajouterNewStagiaire() throws IOException {
	String erreurs = validerSaisie();
	if (erreurs.isEmpty()) {
	    String nom = nomS.getText();
	    String prenom = prenomS.getText();
	    String departement = dptS.getText();
	    String promotion = promoS.getText();
	    String annee = anneeS.getText();
	    Stagiaire stagiaireAjouter = new Stagiaire(nom,prenom,departement,promotion,annee);

	} else {
	    Alert alert = new Alert(AlertType.ERROR);
	    alert.setHeaderText("Erreurs de saisie : ");
	    alert.setContentText(erreurs);
	    alert.show();
	}
    }

    private String validerSaisie() {
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
	    errorsBuilder.append("La promotion du stagiaire doit être renseigné\n");
	}

	String annee = anneeS.getText();
	if (annee == null || annee.trim().isEmpty()) {
	    errorsBuilder.append("L'année d'inscription doit être renseignée\n");
	}
	return errorsBuilder.toString();
    }

	@FXML
	public void reset() {
		this.nomS.clear();
		this.prenomS.clear();
		this.dptS.clear();
		this.promoS.clear();
		this.anneeS.clear();
	}

	    @FXML
	    private void handleRetourAction(ActionEvent e) throws IOException
	    {
		Stage primaryStage = (Stage) quitterBtn.getScene().getWindow();
		BorderPane layoutAddProduct = (BorderPane)FXMLLoader.load(getClass().getResource("InterfaceAdministrateur.fxml"));
		Scene sceneList = new Scene(layoutAddProduct,500,700);
		primaryStage.setScene(sceneList);

	    }
}
