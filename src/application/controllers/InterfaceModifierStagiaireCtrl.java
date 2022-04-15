package application.controllers;

import java.io.IOException;
import java.util.Optional;

import application.java.Stagiaire;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class InterfaceModifierStagiaireCtrl {


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
    private Button validerBtn;

    @FXML
    private Button sprBtn;

    @FXML
    private Button quitterBtn;

    private Stagiaire stagiaireSpr;


    @FXML
    private void reset() {
	this.nomS.clear();
	this.prenomS.clear();
	this.dptS.clear();
	this.promoS.clear();
	this.anneeS.clear();
	System.out.println("all clear");
    }


    private void modifierStagiaire() throws IOException{
	Alert modifBtn = new Alert(AlertType.CONFIRMATION);
	modifBtn.setTitle("Modification du stagiaire selectionné");
	modifBtn.setHeaderText("Voulez-vous valider les modifications ?");
	Optional<ButtonType> option = modifBtn.showAndWait();

	if (option.get() == ButtonType.OK) {
	    String nomMdf = nomS.getText();
	    String prenomMdf = prenomS.getText();
	    String dptMdf = dptS.getText();
	    String promoMdf = promoS.getText();
	    String anneeMdf = anneeS.getText();

	    Stagiaire stModif = new Stagiaire(nomMdf, prenomMdf, dptMdf, promoMdf,anneeMdf);
	}
    }
}