package application.controllers;


import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import application.java.ArbreStagiaire;
import application.java.Recherche;
import application.java.Stagiaire;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class InterfaceModifierStagiaireCtrl implements Initializable {

    @FXML
    private TextField nomMdf;

    @FXML
    private TextField prenomMdf;

    @FXML
    private TextField dptMdf;

    @FXML
    private TextField promoMdf;

    @FXML
    private TextField anneeMdf;

    @FXML
    private Button validerBtn;

    static ArbreStagiaire monArbre = new ArbreStagiaire();
    ObservableList<Stagiaire> observableArrayList = FXCollections
	    .observableArrayList(Recherche.parcoursStagiaire(monArbre));

    public void initialize(URL location, ResourceBundle resources) {
	// PRE REMPLIR LES CHAMPS DE LA FENETRE MODIFICATION//
	nomMdf.setText(InterfaceAdministrateurCtrl.stg.getNom());
	prenomMdf.setText(InterfaceAdministrateurCtrl.stg.getPrenom());
	dptMdf.setText(InterfaceAdministrateurCtrl.stg.getPromotion());
	promoMdf.setText(InterfaceAdministrateurCtrl.stg.getDepartement());
	anneeMdf.setText(InterfaceAdministrateurCtrl.stg.getAnnee());
    
	validerBtn.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent event) {
		try {
		    modifierStagiaire();
		} catch (IOException e) {

		    e.printStackTrace();
		}

	    }

	});
    }

    String nomAncien = InterfaceAdministrateurCtrl.stg.getNom();
    String prenomAncien = InterfaceAdministrateurCtrl.stg.getPrenom();
    String dptAncien = InterfaceAdministrateurCtrl.stg.getPromotion();
    String promoAncien = InterfaceAdministrateurCtrl.stg.getDepartement();
    String anneeAncien = InterfaceAdministrateurCtrl.stg.getAnnee();
    Stagiaire ancienStagiaire = new Stagiaire(nomAncien, prenomAncien, dptAncien, promoAncien, anneeAncien);

    private void modifierStagiaire() throws IOException {
	String nomNouveau = nomMdf.getText();
	String prenomNouveau = prenomMdf.getText();
	String dptNouveau = dptMdf.getText();
	String promoNouveau = promoMdf.getText();
	String anneeNouveau = anneeMdf.getText();
	Stagiaire nouveauStagaire = new Stagiaire(nomNouveau, prenomNouveau, dptNouveau, promoNouveau, anneeNouveau);
	Alert modifAlerte = new Alert(AlertType.CONFIRMATION);
	modifAlerte.setTitle("Modification d'un stagiaire");
	modifAlerte.setHeaderText("Voulez-vous valider les modifications ?");
	Optional<ButtonType> option = modifAlerte.showAndWait();

	if (option.get() == ButtonType.OK) {
	    Alert confirmModif = new Alert(AlertType.CONFIRMATION);
	    confirmModif.setTitle("Modification d'un stagiaire");
	    confirmModif.setHeaderText("Les données du stagiaire selectionné ont bien été modifiées");
	    confirmModif.showAndWait();
	    monArbre.modifier(ancienStagiaire, nouveauStagaire);

	} else {

	}
    }
}