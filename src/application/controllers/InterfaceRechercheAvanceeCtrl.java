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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class InterfaceRechercheAvanceeCtrl implements Initializable {
    private static final String A_PROPOS = "/application/interfaces/InterfacePropos.fxml";
    private static final String AUTHENTIFICATION = "/application/interfaces/InterfaceAuthentification.fxml";
    private static final String DOCUMENT_PDF = "C:\\Users\\farah\\Desktop\\FormationIsika\\ProjetsEclipse\\LogicielGestionStagiaires\\ListeStagiaire.pdf";
    private static final String MANUEL_PDF = "C:\\Users\\farah\\Desktop\\FormationIsika\\ProjetsEclipse\\LogicielGestionStagiaires\\Manuel\\Manuel.pdf";

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
    private Button chercherBtn;
    @FXML
    private TextField critere;
    @FXML
    private TextField nomStgr;
    @FXML
    private TextField dptStgr;
    @FXML
    private TextField anneeStgr;


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

    }
    
    
 //RECHERCHE AVANCEE//
 	@FXML
 	public void rechercheAvancee() throws IOException{
 		String keyword = dptStgr.getText();
 		String Keyword3 = nomStgr.getText().toUpperCase();
 		String Keyword2 = anneeStgr.getText();
 		if ((keyword.equals("")) && (Keyword2.equals("")) && (Keyword3.equals(""))) {
 			tblS.setItems(observableArrayList);
 		} else {
 			ObservableList<Stagiaire> filteredData = FXCollections.observableArrayList();
 			for (Stagiaire stg : observableArrayList) {
 				if ((stg.getDepartement().contains(keyword))) {
 					if (stg.getAnnee().contains(Keyword2)) {
 						if (stg.getNom().contains(Keyword3)) {
 						filteredData.add(stg);
 				}
 						
 					}	
 				tblS.setItems(filteredData);
 			}
 				
 			}
 		}
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
	proposStage.setTitle("A propos");
	proposStage.setScene(scene);
	proposStage.show();
    }

    // METHODE POUR SE DECONNECTER//
    @FXML
    private void deconnexion() throws IOException {
	Stage proposStage = (Stage) chercherBtn.getScene().getWindow();
	FXMLLoader loader = new FXMLLoader(getClass().getResource(AUTHENTIFICATION));
	Pane rootPane = (Pane) loader.load();
	Scene scene = new Scene(rootPane, rootPane.getPrefWidth(), rootPane.getPrefHeight());
	proposStage.setTitle("Annuaire Informatisé par FHF");
	proposStage.setScene(scene);
	proposStage.show();
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
    
    //RECHERCHE MULTICRITERE//

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
