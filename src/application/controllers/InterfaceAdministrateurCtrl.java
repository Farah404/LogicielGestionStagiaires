package application.controllers;

import java.awt.MenuItem;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.java.ArbreStagiaire;
import application.java.Recherche;
import application.java.Stagiaire;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class InterfaceAdministrateurCtrl implements Initializable{
    private static final String AJOUT_STAGIAIRE = "/application/interfaces/InterfaceAjoutStagiaire.fxml";
    private static final String MODIFIER_STAGIAIRE = "/application/interfaces/InterfaceModifierStagiaire.fxml";
    private static final String A_PROPOS = "/application/interfaces/InterfacePropos.fxml";
    private static final String AUTHENTIFICATION = "/application/interfaces/InterfaceAuthentification.fxml";
    @FXML
    private TableColumn<Stagiaire, String> nomS;
    @FXML
    private TableColumn<Stagiaire, String> prenomS;
    @FXML
    private TableColumn<Stagiaire, String> dptS;
    @FXML
    private TableColumn<Stagiaire, String> promoS;
    @FXML
    private TableColumn<Stagiaire, String> anneeS;
    @FXML
    private TableView<Stagiaire> tblS;
    @FXML
    private Button ajoutBtn;
    @FXML
    private Button modifBtn;
    @FXML
    private Button propos;
    @FXML
    private MenuItem decoBtn;

    static ArbreStagiaire monArbre = new ArbreStagiaire();
    ObservableList<Stagiaire> observableArrayList =  FXCollections.observableArrayList(Recherche.parcoursStagiaire(monArbre));
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
	nomS.setCellValueFactory(new PropertyValueFactory<Stagiaire,String>("nom"));
	prenomS.setCellValueFactory(new PropertyValueFactory<Stagiaire,String>("prenom"));
	dptS.setCellValueFactory(new PropertyValueFactory<Stagiaire,String>("departement"));
	promoS.setCellValueFactory(new PropertyValueFactory<Stagiaire,String>("promotion"));
	anneeS.setCellValueFactory(new PropertyValueFactory<Stagiaire,String>("annee"));
	tblS.setItems(observableArrayList);
    }

    // METHODE POUR ALLER VERS INTERFACE AJOUTER STAGIAIRE//
    public void allerVersInterfaceAjoutStagiaire() throws IOException {
	ajoutBtn.getScene().getWindow();
	FXMLLoader loader = new FXMLLoader(getClass().getResource(AJOUT_STAGIAIRE));
	Pane rootPane = (Pane) loader.load();
	Scene scene = new Scene(rootPane, rootPane.getPrefWidth(), rootPane.getPrefHeight());
	Stage proposStage = new Stage();
	proposStage.setTitle("Ajouter un Stagiaire");
	proposStage.setScene(scene);
	proposStage.show();
    }
    
    // METHODE POUR ALLER VERS INTERFACE AJOUTER STAGIAIRE//
    public void allerVersInterfaceModifierStagiaire() throws IOException {
	modifBtn.getScene().getWindow();
	FXMLLoader loader = new FXMLLoader(getClass().getResource(MODIFIER_STAGIAIRE));
	Pane rootPane = (Pane) loader.load();
	Scene scene = new Scene(rootPane, rootPane.getPrefWidth(), rootPane.getPrefHeight());
	Stage proposStage = new Stage();
	proposStage.setTitle("Modifier le Stagiaire");
	proposStage.setScene(scene);
	proposStage.show();
    }

    // METHODE POUR FERMER L'APPLICATION//
    @FXML
    public void closeWindow() {
	Platform.exit();
    }

    //METHODE POUR ALLER A LA FENETRE A PROPOS//
    @FXML
    private void AllerVersPropos() throws IOException {
	Stage proposStage = (Stage) ajoutBtn.getScene().getWindow();
//	propos.getScene().getWindow();
	FXMLLoader loader = new FXMLLoader(getClass().getResource(A_PROPOS));
	Pane rootPane = (Pane) loader.load();
	Scene scene = new Scene(rootPane, rootPane.getPrefWidth(), rootPane.getPrefHeight());
//	Stage proposStage = new Stage();
	proposStage.setTitle("A Propos");
	proposStage.setScene(scene);
	proposStage.show();
    }
    
    //METHODE POUR ALLER A LA FENETRE A PROPOS//
    @FXML
    private void deconnexion() throws IOException {
	Stage proposStage = (Stage) ajoutBtn.getScene().getWindow();
//	decoBtn.getScene().getWindow();
	FXMLLoader loader = new FXMLLoader(getClass().getResource(AUTHENTIFICATION));
	Pane rootPane = (Pane) loader.load();
	Scene scene = new Scene(rootPane, rootPane.getPrefWidth(), rootPane.getPrefHeight());
//	Stage proposStage = new Stage();
	proposStage.setTitle("Annuaire Informatisé par FHF");
	proposStage.setScene(scene);
	proposStage.show();
    }

    //METHODE POUR PRE REMPLIR LES CHAMPS DANS FENETRE MODIFICATION STAGIAIRE//
    public String ChampsModificationNom() {
	Stagiaire stagiaireModif = this.tblS.getSelectionModel().getSelectedItem();
	String nom = stagiaireModif.getNom();
	return nom;
}

public String txtFieldModificationPrenom() {
	Stagiaire stgrMdf = this.tblS.getSelectionModel().getSelectedItem();
	String prenom = stgrMdf.getPrenom();
	return prenom;
}

public String txtFieldModificationDepartement() {
	Stagiaire stgrMdf = this.tblS.getSelectionModel().getSelectedItem();
	String departement = stgrMdf.getDepartement();
	return departement;
}

public String txtFieldModificationPromotion() {
	Stagiaire stgrMdf = this.tblS.getSelectionModel().getSelectedItem();
	String promotion = stgrMdf.getPromotion();
	return promotion;
}

public String txtFieldModificationAnnee() {
	Stagiaire stgrMdf = this.tblS.getSelectionModel().getSelectedItem();
	String annee = stgrMdf.getAnnee();
	return annee;
}

    }

