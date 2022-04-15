package application.controllers;

import java.awt.MenuItem;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.swing.text.Document;

import application.java.ArbreStagiaire;
import application.java.Recherche;
import application.java.Stagiaire;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Phrase;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;

public class InterfaceAdministrateurCtrl implements Initializable {
    private static final String AJOUT_STAGIAIRE = "/application/interfaces/InterfaceAjoutStagiaire.fxml";
    private static final String MODIFIER_STAGIAIRE = "/application/interfaces/InterfaceModifierStagiaire.fxml";
    private static final String A_PROPOS = "/application/interfaces/InterfacePropos.fxml";
    private static final String AUTHENTIFICATION = "/application/interfaces/InterfaceAuthentification.fxml";
    private static final String DOCUMENT_PDF = "C:\\Users\\farah\\Desktop\\FormationIsika\\ProjetsEclipse\\LogicielGestionStagiaires\\ListeStagiaire.pdf";
    @FXML
    public TableColumn<Stagiaire, String> nomS;
    @FXML
    public TableColumn<Stagiaire, String> prenomS;
    @FXML
    public TableColumn<Stagiaire, String> dptS;
    @FXML
    public TableColumn<Stagiaire, String> promoS;
    @FXML
    public TableColumn<Stagiaire, String> anneeS;
    @FXML
    public TableView<Stagiaire> tblS;
    @FXML
    private TextField stgrTotal;
    @FXML
    private Button ajoutBtn;
    @FXML
    private Button modifBtn;
    @FXML
    private Button propos;
    @FXML
    private MenuItem decoBtn;
    @FXML
    private Button refreshBtn;
    @FXML
    private Button delBtn;
    
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
    
    static Stagiaire stagiaireMdf;


    static ArbreStagiaire monArbre = new ArbreStagiaire();
    ObservableList<Stagiaire> observableArrayList = FXCollections
	    .observableArrayList(Recherche.parcoursStagiaire(monArbre));

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
	nomS.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("nom"));
	prenomS.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("prenom"));
	dptS.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("departement"));
	promoS.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("promotion"));
	anneeS.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("annee"));
	tblS.setItems(observableArrayList);

	delBtn.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent event) {
		supprStagiaire();
	    }
	});

	modifBtn.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent event) {
		Stagiaire stgrMdf = tblS.getSelectionModel().getSelectedItem();
		if (stgrMdf != null) {

		    try {
			allerVersInterfaceModifierStagiaire(stgrMdf);
		    } catch (IOException e) {
			e.printStackTrace();
		    }
		}
	    }
	});
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

    // METHODE POUR ALLER VERS INTERFACE MODIFIER STAGIAIRE//
    public void allerVersInterfaceModifierStagiaire(Stagiaire stagaire) throws IOException {
	FXMLLoader loader = new FXMLLoader(getClass().getResource(MODIFIER_STAGIAIRE));
	Pane rootPane = (Pane) loader.load();
	Scene scene = new Scene(rootPane, rootPane.getPrefWidth(), rootPane.getPrefHeight());
	Stage modifStage = new Stage();
	modifStage.setTitle("Modifier le Stagiaire");
	modifStage.setScene(scene);
	modifStage.show();
    }

    // METHODE POUR FERMER L'APPLICATION//
    @FXML
    public void closeWindow() {
	Platform.exit();
    }

    // METHODE POUR ALLER A LA FENETRE A PROPOS//
    @FXML
    private void AllerVersPropos() throws IOException {
	Stage proposStage = (Stage) ajoutBtn.getScene().getWindow();
	// propos.getScene().getWindow();
	FXMLLoader loader = new FXMLLoader(getClass().getResource(A_PROPOS));
	Pane rootPane = (Pane) loader.load();
	Scene scene = new Scene(rootPane, rootPane.getPrefWidth(), rootPane.getPrefHeight());
	// Stage proposStage = new Stage();
	proposStage.setTitle("A Propos");
	proposStage.setScene(scene);
	proposStage.show();
    }

    // METHODE POUR SE DECONNECTER//
    @FXML
    private void deconnexion() throws IOException {
	Stage proposStage = (Stage) ajoutBtn.getScene().getWindow();
	// decoBtn.getScene().getWindow();
	FXMLLoader loader = new FXMLLoader(getClass().getResource(AUTHENTIFICATION));
	Pane rootPane = (Pane) loader.load();
	Scene scene = new Scene(rootPane, rootPane.getPrefWidth(), rootPane.getPrefHeight());
	// Stage proposStage = new Stage();
	proposStage.setTitle("Annuaire Informatisé par FHF");
	proposStage.setScene(scene);
	proposStage.show();
    }

    // METHODE POUR PRE REMPLIR LES CHAMPS DANS FENETRE MODIFICATION STAGIAIRE//
    public String txtFieldModificationNom() {
	stagiaireMdf= this.tblS.getSelectionModel().getSelectedItem();
	String nom = stagiaireMdf.getNom();
	return nom;
    }

    public String txtFieldModificationPrenom() {
	stagiaireMdf = this.tblS.getSelectionModel().getSelectedItem();
	String prenom = stagiaireMdf.getPrenom();
	return prenom;
    }

    public String txtFieldModificationDepartement() {
	stagiaireMdf = this.tblS.getSelectionModel().getSelectedItem();
	String departement = stagiaireMdf.getDepartement();
	return departement;
    }

    public String txtFieldModificationPromotion() {
	stagiaireMdf = this.tblS.getSelectionModel().getSelectedItem();
	String promotion = stagiaireMdf.getPromotion();
	return promotion;
    }

    public String txtFieldModificationAnnee() {
	stagiaireMdf = this.tblS.getSelectionModel().getSelectedItem();
	String annee = stagiaireMdf.getAnnee();
	return annee;
    }

    // METHODE SUPPRIMER STAGIAIRE//
    @FXML
    public void supprStagiaire() {
	Stagiaire stagiaire = tblS.getSelectionModel().getSelectedItem();
	if (stagiaire != null) {
	    Alert suppressionAlerte = new Alert(AlertType.CONFIRMATION);
	    suppressionAlerte.setTitle("Suppression d'un stagiaire");
	    suppressionAlerte.setHeaderText("Êtes-vous sûr de vouloir supprimer ce stagiaire ?");
	    Optional<ButtonType> option = suppressionAlerte.showAndWait();
	    if (option.get() == ButtonType.OK) {
		monArbre.supprimer(stagiaire);

	    } else {
	    }
	}
    }

    // METHODE POUR IMPRIMER LA LISTE SOUS FORMAT PDF//
    //    private void pdf(ObservableList<Stagiaire> stagiaires) throws FileNotFoundException {
    //	FileOutputStream fos = new FileOutputStream(new File(DOCUMENT_PDF));
    //	Document doc = new Document();
    //	PdfWriter.getInstance(doc, fos);
    //	doc.open();
    //	doc.add(new Phrase("Liste des stagiaires\n"));
    //	doc.add(new Phrase("Liste générée le " + LocalDate.now() + "\n"));
    //	doc.add(new Phrase("Nombre de stagiaires : " + Recherche.parcoursStagiaire(monArbre).size() + "\n"));
    //	doc.add(new Phrase("- - - - - - - - - - - - - - - - - - - - - - - -"));
    //	PdfPTable table = new PdfPTable(5);
    //	PdfPCell cell1 = new PdfPCell(new Phrase("NOM"));
    //	PdfPCell cell2 = new PdfPCell(new Phrase("PRENOM"));
    //	PdfPCell cell3 = new PdfPCell(new Phrase("DEPARTEMENT"));
    //	PdfPCell cell4 = new PdfPCell(new Phrase("PROMOTION"));
    //	PdfPCell cell5 = new PdfPCell(new Phrase("ANNEE"));
    //
    //	table.addCell(cell1);
    //	table.addCell(cell2);
    //	table.addCell(cell3);
    //	table.addCell(cell4);
    //	table.addCell(cell5);
    //
    //	table.setWidthPercentage(100);
    //
    //	for (Stagiaire stagiaireTemp : stagiaires) {
    //		table.addCell(new Phrase(stagiaireTemp.getNom()));
    //		table.addCell(new Phrase(stagiaireTemp.getPrenom()));
    //		table.addCell(new Phrase(stagiaireTemp.getDepartement()));
    //		table.addCell(new Phrase(stagiaireTemp.getPromotion()));
    //		table.addCell(new Phrase(stagiaireTemp.getAnnee()));
    //	}
    //	doc.add(table);
    //	doc.close();
    //}

}
