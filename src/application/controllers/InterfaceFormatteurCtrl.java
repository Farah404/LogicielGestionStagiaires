package application.controllers;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import application.java.ArbreStagiaire;
import application.java.Noeud;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class InterfaceFormatteurCtrl implements Initializable {
    private static final String A_PROPOS = "/application/interfaces/InterfacePropos.fxml";
    private static final String AUTHENTIFICATION = "/application/interfaces/InterfaceAuthentification.fxml";
    private static final String DOCUMENT_PDF = "C:\\Users\\farah\\Desktop\\FormationIsika\\ProjetsEclipse\\LogicielGestionStagiaires\\ListeStagiaire.pdf";
    private static final String MANUEL_PDF = "C:\\Users\\farah\\Desktop\\FormationIsika\\ProjetsEclipse\\LogicielGestionStagiaires\\Manuel\\Manuel.pdf";
    private static final String RECHERCHE_AVANCEE = "/application/interfaces/InterfaceRechercheAvancee.fxml";

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
    private Button delBtn;
    @FXML
    private TextField critere;
    @FXML
    private TextField nomStgr;
    @FXML
    private TextField prenomStgr;
    @FXML
    private TextField dptStgr;
    @FXML
    private TextField promoStgr;
    @FXML
    private TextField anneeStgr;

    @FXML
    private Button refresh;

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

	critere.textProperty().addListener((obs, oldText, newText) -> {
	    rechercheSimple();
	});

	tblS.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
	    if (newVal != null) {
		nomStgr.setText(newVal.getNom());
		prenomStgr.setText(newVal.getPrenom());
		dptStgr.setText(newVal.getDepartement());
		promoStgr.setText(newVal.getPromotion());
		anneeStgr.setText(newVal.getAnnee());
	    }
	});

    }

    // METHODE ACCES LIMITE//
    @FXML
    private void handleMenuEditAction(ActionEvent e) throws IOException {
	Alert alert = new Alert(AlertType.ERROR);
	alert.setTitle("Accès Interdit");
	alert.setHeaderText(null);
	alert.setContentText("Cette fonctionnalité est seulement accessible pour les administrateurs");
	alert.showAndWait();
    }

    // METHODE AJOUTER STAGIAIRE//
    public void ajouterStagiaire() throws IOException {
	String erreurs = validerSaisie();
	if (erreurs.isEmpty()) {
	    String nom = nomStgr.getText();
	    String prenom = prenomStgr.getText();
	    String departement = dptStgr.getText();
	    String promotion = promoStgr.getText();
	    String annee = anneeStgr.getText();
	    Stagiaire S = new Stagiaire(nom, prenom, departement, promotion, annee);
	    monArbre.ajouter(S);
	    tblS.getItems().add(S);

	    Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Ajout de stagiaire");
	    alert.setHeaderText(null);
	    alert.setContentText("Le stagiaire a bien été ajouté à la liste");
	    alert.showAndWait();
	    this.nomStgr.clear();
	    this.prenomStgr.clear();
	    this.dptStgr.clear();
	    this.promoStgr.clear();
	    this.anneeStgr.clear();
	} else {
	    Alert alert = new Alert(AlertType.ERROR);
	    alert.setHeaderText("Erreurs de saisie : ");
	    alert.setContentText(erreurs);
	    alert.show();
	}
    }

    public String validerSaisie() {
	StringBuilder errorsBuilder = new StringBuilder();
	String nom = nomStgr.getText();
	if (nom == null || nom.trim().isEmpty()) {
	    errorsBuilder.append("Le nom du stagiaire doit être renseigné\n");
	}
	String prenom = prenomStgr.getText();
	if (prenom.trim().isEmpty()) {
	    errorsBuilder.append("Le prénom du stagiaire doit être renseigné\n");
	}
	String departement = dptStgr.getText();
	if (departement.trim().isEmpty()) {
	    errorsBuilder.append("Le département du stagiaire doit être renseigné\n");
	}
	String promotion = promoStgr.getText();
	if (promotion.trim().isEmpty()) {
	    errorsBuilder.append("La promotion du stagiaire doit être renseignée\n");
	}
	String annee = anneeStgr.getText();
	if (annee == null || annee.trim().isEmpty()) {
	    errorsBuilder.append("L'année d'inscription doit être renseignée\n");
	}
	return errorsBuilder.toString();
    }
    
    public void rechercheSimple() {
	String keyword = critere.getText().toUpperCase();
	if (keyword.equals("")) {
	    tblS.setItems(observableArrayList);
	} else {
	    ObservableList<Stagiaire> filteredData = FXCollections.observableArrayList();
	    for (Stagiaire stg : observableArrayList) {
		if (stg.getNom().contains(keyword) || stg.getAnnee().contains(keyword)
			|| stg.getDepartement().contains(keyword))
		    filteredData.add(stg);
	    }
	    tblS.setItems(filteredData);
	}
    }

    // METHODE POUR ALLER A LA FENETRE A RECHERCHE AVANCEE//
    @FXML
    private void AllerVersRechercheAvancee() throws IOException {
	FXMLLoader loader = new FXMLLoader(getClass().getResource(RECHERCHE_AVANCEE));
	Pane rootPane = (Pane) loader.load();
	Scene scene = new Scene(rootPane, rootPane.getPrefWidth(), rootPane.getPrefHeight());
	Stage rechercheStage = new Stage();
	rechercheStage.setTitle("Recherche multi-critères");
	rechercheStage.setScene(scene);
	rechercheStage.show();
    }
    // METHODE POUR FERMER L'APPLICATION//
    @FXML
    public void closeWindow() {
	Platform.exit();
    }

    // METHODE POUR ALLER A LA FENETRE A PROPOS//
    @FXML
    private void AllerVersPropos() throws IOException {
	FXMLLoader loader = new FXMLLoader(getClass().getResource(A_PROPOS));
	Pane rootPane = (Pane) loader.load();
	Scene scene = new Scene(rootPane, rootPane.getPrefWidth(), rootPane.getPrefHeight());
	Stage proposStage = new Stage();
	proposStage.setTitle("A Propos");
	proposStage.setScene(scene);
	proposStage.show();
    }


    // METHODE POUR SE DECONNECTER//
    @FXML
    private void deconnexion() throws IOException {
	Stage decoStage = (Stage) ajoutBtn.getScene().getWindow();
	FXMLLoader loader = new FXMLLoader(getClass().getResource(AUTHENTIFICATION));
	Pane rootPane = (Pane) loader.load();
	Scene scene = new Scene(rootPane, rootPane.getPrefWidth(), rootPane.getPrefHeight());
	decoStage.setTitle("Annuaire Informatisé par FHF");
	decoStage.setScene(scene);
	decoStage.show();
	decoStage.getIcons().add(new Image(
		    "C:\\Users\\farah\\Desktop\\FormationIsika\\ProjetsEclipse\\LogicielGestionStagiaires\\iconeTel.jpg"));
    }

    // IMPRIMER LA LISTE EN PDF//
    public void imprimerPdf() throws IOException, DocumentException {
	pdf(Recherche.parcoursStagiaire(monArbre));
	Alert alert = new Alert(AlertType.INFORMATION);
	alert.setTitle("Document PDF");
	alert.setHeaderText(null);
	alert.setContentText("La liste des stagiaire en format PDF est prêt à être imprimée");
	alert.showAndWait();
    }



    // METHODE POUR OUVRIR LE MANUEL D'UTILISATION//
    public void ouvrirManuelPdf() {
	try {
	    File manuelPdfFile = new File(MANUEL_PDF);
	    if (manuelPdfFile.exists()) {
		Desktop.isDesktopSupported();
		Desktop.getDesktop().open(manuelPdfFile);
	    } else {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("PDF 404");
		alert.setContentText("Le manuel PDF n'existe pas");
		alert.showAndWait();
	    }
	} catch (Exception ex) {

	}
    }

    // METHODE POUR IMPRIMER LA LISTE SOUS FORMAT PDF//
    private void pdf(List<Stagiaire> list) throws FileNotFoundException, DocumentException {
	FileOutputStream fos = new FileOutputStream(new File(DOCUMENT_PDF));
	Document doc = new Document();
	PdfWriter.getInstance((com.itextpdf.text.Document) doc, fos);
	doc.open();
	doc.add(new Phrase("Liste des stagiaires\n"));
	doc.add(new Phrase(
		"***********************************************************************************" + "\n"));
	doc.add(new Phrase("Liste générée le " + LocalDate.now() + "\n"));
	doc.add(new Phrase(
		"***********************************************************************************" + "\n"));
	doc.add(new Phrase("Nombre de stagiaires : " + Recherche.parcoursStagiaire(monArbre).size() + "\n"));
	doc.add(new Phrase("***********************************************************************************"));
	PdfPTable table = new PdfPTable(5);
	PdfPCell cell1 = new PdfPCell(new Phrase("Nom"));
	PdfPCell cell2 = new PdfPCell(new Phrase("Prenom"));
	PdfPCell cell3 = new PdfPCell(new Phrase("Departement"));
	PdfPCell cell4 = new PdfPCell(new Phrase("Promotion"));
	PdfPCell cell5 = new PdfPCell(new Phrase("Année"));

	table.addCell(cell1);
	table.addCell(cell2);
	table.addCell(cell3);
	table.addCell(cell4);
	table.addCell(cell5);

	table.setWidthPercentage(100);

	for (Stagiaire stagiaireTemp : list) {
	    table.addCell(new Phrase(stagiaireTemp.getNom()));
	    table.addCell(new Phrase(stagiaireTemp.getPrenom()));
	    table.addCell(new Phrase(stagiaireTemp.getDepartement()));
	    table.addCell(new Phrase(stagiaireTemp.getPromotion()));
	    table.addCell(new Phrase(stagiaireTemp.getAnnee()));
	}
	doc.add(table);
	doc.close();
    }

}
