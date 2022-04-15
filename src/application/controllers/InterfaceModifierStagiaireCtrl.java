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
    private Button quitterBtn;
    
    static ArbreStagiaire monArbre = new ArbreStagiaire();
    ObservableList<Stagiaire> observableArrayList = FXCollections.observableArrayList(Recherche.parcoursStagiaire(monArbre));

    public InterfaceAdministrateurCtrl interfaceMdfStgr;

    public InterfaceModifierStagiaireCtrl() {
    }

    public InterfaceModifierStagiaireCtrl(InterfaceAdministrateurCtrl interfaceMdfStgr) {
	this.interfaceMdfStgr = interfaceMdfStgr;
    }

    public InterfaceAdministrateurCtrl getInterfaceMdfStgr() {
	return interfaceMdfStgr;
    }


    @FXML
    public void modifierStagaire() throws IOException {
	//PRE REMPLIR LES CHAMPS DE LA FENETRE MODIFICATION//
	String nom = getInterfaceMdfStgr().txtFieldModificationNom();
	String prenom = getInterfaceMdfStgr().txtFieldModificationPrenom();
	String dpt = getInterfaceMdfStgr().txtFieldModificationDepartement();
	String promo = getInterfaceMdfStgr().txtFieldModificationPromotion();
	String annee = getInterfaceMdfStgr().txtFieldModificationAnnee();
	nomS.setText(nom);
	prenomS.setText(prenom);
	dptS.setText(dpt);
	promoS.setText(promo);
	anneeS.setText(annee);

	//CREATION DU NOUVEAU STAGIARE//
	String nomNouveau = nomS.getText();
	String prenomNouveau = prenomS.getText();
	String dptNouveau = dptS.getText();
	String promoNouveau = promoS.getText();
	String anneeNouveau = anneeS.getText();
	
	//DECLARATION DE L'ANCIEN ET DU NOUVEAU STAGIAIRE//
	Stagiaire ancienStagiaire = new Stagiaire(nom,prenom,dpt,promo,annee);
	Stagiaire nouveauStagaire = new Stagiaire(nomNouveau,prenomNouveau,dptNouveau,promoNouveau,anneeNouveau);
	
	//SUPPRESSION DE L'ANCIEN STAGAIRE ET AJOUT DU NOUVEAU//
	monArbre.modifier(ancienStagiaire,nouveauStagaire);

    }
 


}