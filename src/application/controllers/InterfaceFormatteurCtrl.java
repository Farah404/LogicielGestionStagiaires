package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.LanceurProjet;
import application.java.Stagiaire;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class InterfaceFormatteurCtrl implements Initializable {

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
    private TextField nomCherhcer;
    @FXML
    private TextField dptCherhcer;
    @FXML
    private TextField promoCherhcer;
    @FXML
    private TextField anneeCherhcer;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
	nomS.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("nomS"));
	prenomS.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("prenomS"));
	dptS.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("dptS"));
	promoS.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("promoS"));
	anneeS.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("anneeS"));
	tblS.setItems(LanceurProjet.listS);
    }

    @FXML
    private void handleMenuAddAction(ActionEvent e) throws IOException {
	Stage primaryStage = (Stage) tblS.getScene().getWindow();
	BorderPane layoutAjoutStagiaire = (BorderPane) FXMLLoader
		.load(getClass().getResource("InterfaceAjoutStagiaire.fxml"));
	Scene sceneList = new Scene(layoutAjoutStagiaire, 500, 700);
	primaryStage.setScene(sceneList);

    }

    @FXML
    private void handleMenuEditAction(ActionEvent e) throws IOException {
	Alert alert = new Alert(AlertType.ERROR);
	alert.setTitle("Accès Interdit");
	alert.setHeaderText(null);
	alert.setContentText("Cette fonctionnalité est seulement accessible pour les administrateurs");
	alert.showAndWait();
    }

    @FXML
    public void closeWindow() {
	Platform.exit();
    }

}
