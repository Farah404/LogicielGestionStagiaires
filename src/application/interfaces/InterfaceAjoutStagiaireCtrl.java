package application.interfaces;

import java.io.IOException;

import application.models.Stagiaire;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
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
    private Button validerBtn;
    @FXML
    private Button reinitBtn;
    @FXML
    private Button retourBtn;
	
    protected void ajouterNewStagiaire() throws IOException {
	String erreurs = validerSaisie();
	if (erreurs.isEmpty()) {
	    String nom = nomS.getText();
	    String prenom = prenomS.getText();
	    String departement = dptS.getText();
	    String promotion = promoS.getText();
	    String annee = anneeS.getText();
	    Stagiaire s = new Stagiaire(nomS.getText(),prenomS.getText(),dptS.getText(),promoS.getText(),anneeS.getText());

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
	    errorsBuilder.append("Le nom du stagiaire doit �tre renseign�\n");
	}

	String prenom = prenomS.getText();
	if (prenom.trim().isEmpty()) {
	    errorsBuilder.append("Le pr�nom du stagiaire doit �tre renseign�\n");
	}

	String departement = dptS.getText();
	if (departement.trim().isEmpty()) {
	    errorsBuilder.append("Le d�partement du stagiaire doit �tre renseign�\n");
	}

	String promotion = promoS.getText();
	if (promotion.trim().isEmpty()) {
	    errorsBuilder.append("La promotion du stagiaire doit �tre renseign�\n");
	}

	String annee = anneeS.getText();
	if (annee == null || annee.trim().isEmpty()) {
	    errorsBuilder.append("L'ann�e d'inscription doit �tre renseign�e\n");
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
		Stage primaryStage = (Stage) retourBtn.getScene().getWindow();
		BorderPane layoutAddProduct = (BorderPane)FXMLLoader.load(getClass().getResource("InterfaceAdministrateur.fxml"));
		Scene sceneList = new Scene(layoutAddProduct,500,700);
		primaryStage.setScene(sceneList);

	    }
}