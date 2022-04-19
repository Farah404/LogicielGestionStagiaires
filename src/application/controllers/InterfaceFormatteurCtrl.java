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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class InterfaceFormatteurCtrl implements Initializable {
    private static final String AJOUT_STAGIAIRE = "/application/interfaces/InterfaceAjoutStagiaire.fxml";
    private static final String A_PROPOS = "/application/interfaces/InterfacePropos.fxml";
    private static final String AUTHENTIFICATION = "/application/interfaces/InterfaceAuthentification.fxml";
    private static final String DOCUMENT_PDF = "C:\\Users\\farah\\Desktop\\FormationIsika\\ProjetsEclipse\\LogicielGestionStagiaires\\ListeStagiaire.pdf";
    private static final String MANUEL_PDF = "C:\\Users\\farah\\Desktop\\FormationIsika\\ProjetsEclipse\\LogicielGestionStagiaires\\Manuel\\Manuel.pdf";

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
    private TextField stgrTotal;
    @FXML
    private ToggleGroup nda;
    @FXML
    private RadioButton nomRadioBtn;
    @FXML
    private RadioButton dptRadioBtn;
    @FXML
    private RadioButton anneeRadioBtn;
    @FXML
    private TextField critere;
    @FXML
    private Button refresh;
    
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
	
	stgrTotal.setText(String.valueOf(Recherche.parcoursStagiaire(monArbre).size()));
    }

    //METHODE ACCES LIMITE//
    @FXML
    private void handleMenuEditAction(ActionEvent e) throws IOException {
	Alert alert = new Alert(AlertType.ERROR);
	alert.setTitle("Accès Interdit");
	alert.setHeaderText(null);
	alert.setContentText("Cette fonctionnalité est seulement accessible pour les administrateurs");
	alert.showAndWait();
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


    // METHODE POUR FERMER L'APPLICATION//
    @FXML
    public void closeWindow() {
	Platform.exit();
    }

    // METHODE POUR ALLER A LA FENETRE A PROPOS//
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

    // METHODE POUR ALLER A LA FENETRE A PROPOS//
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

    // METHODE DE RECHERCHE//
    // PAR NOM//
    public static List<Stagiaire> chercherNom(String cle, ArbreStagiaire arbre) {
	List<Stagiaire> listRechNom = new ArrayList<>();
	return chercherNom(cle, arbre.getRacine(), listRechNom);
    }

    private static List<Stagiaire> chercherNom(String cle, Noeud r, List<Stagiaire> listResult) {
	if (r == null) {
	    return listResult;
	}
	chercherNom(cle, r.getGauche(), listResult);
	if (cle.compareTo(r.getStagiaire().getNom()) == 0) {
	    listResult.add(r.getStagiaire());
	}
	chercherNom(cle, r.getDroit(), listResult);
	return listResult;
    }

    // PAR DEPARTEMENT//
    public static List<Stagiaire> chercherDepartement(String cle, ArbreStagiaire arbre) {
	List<Stagiaire> listRechDep = new ArrayList<>();
	return chercherDepartement(cle, arbre.getRacine(), listRechDep);
    }

    private static List<Stagiaire> chercherDepartement(String cle, Noeud r, List<Stagiaire> listResult) {
	if (r == null) {
	    return listResult;
	}
	chercherDepartement(cle, r.getGauche(), listResult);
	if (cle.compareTo(r.getStagiaire().getDepartement()) == 0) {
	    listResult.add(r.getStagiaire());
	}
	chercherDepartement(cle, r.getDroit(), listResult);
	return listResult;
    }

    // PAR ANNEE//
    public static List<Stagiaire> chercherAnnee(String cle, ArbreStagiaire arbre) {
	List<Stagiaire> listRechAnnee = new ArrayList<>();
	return chercherAnnee(cle, arbre.getRacine(), listRechAnnee);
    }

    private static List<Stagiaire> chercherAnnee(String cle, Noeud r, List<Stagiaire> listResult) {
	if (r == null) {
	    return listResult;
	}
	chercherAnnee(cle, r.getGauche(), listResult);
	if (cle.compareTo(r.getStagiaire().getAnnee()) == 0) {
	    listResult.add(r.getStagiaire());

	}

	chercherAnnee(cle, r.getDroit(), listResult);
	return listResult;
    }

    @FXML
    static List<Stagiaire> listRech = new ArrayList<>();
    
    
    
    public void rechercheSimple() throws IOException {
	nomRadioBtn.setToggleGroup(nda);
   	dptRadioBtn.setToggleGroup(nda);
   	anneeRadioBtn.setToggleGroup(nda);
	// RECHERCHE PAR NOM//
	if (nomRadioBtn.isSelected()) {
	    String nomChercher = critere.getText().toUpperCase();
	    listRech = chercherNom(nomChercher, monArbre);
	    tblS.getItems().clear();
	    tblS.getItems().addAll(listRech); 
	}
	// RECHERCHE PAR DEPARTEMENT//
	if (dptRadioBtn.isSelected()) {
	    String dptChercher = critere.getText();
	    listRech = chercherDepartement(dptChercher, monArbre);
	    tblS.getItems().clear();
	    tblS.getItems().addAll(listRech);
	}
	// RECHERCHE PAR ANNEE//
	if (anneeRadioBtn.isSelected()) {
	    String anneechercher = critere.getText();;
	    listRech = chercherAnnee(anneechercher, monArbre);
	    tblS.getItems().clear();
	    tblS.getItems().addAll(listRech);
	}

    }
    
    @FXML
    public void refresh() throws IOException {
	tblS.getItems().clear();
	tblS.getItems().addAll(Recherche.parcoursStagiaire(monArbre)); 
    }
    
    
    //METHODE POUR OUVRIR LE MANUEL D'UTILISATION//
    public void ouvrirManuelPdf() {
	try {
	    File manuelPdfFile = new File(MANUEL_PDF);
	    if (manuelPdfFile.exists()) {
		Desktop.isDesktopSupported();
		Desktop.getDesktop().open(manuelPdfFile);
	    }else {	
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("PDF 404");
		alert.setContentText("Le manuel PDF n'existe pas");
		alert.showAndWait();
	    }
	} catch (Exception ex) {

	}
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
