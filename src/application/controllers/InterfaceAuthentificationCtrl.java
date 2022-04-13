package application.controllers;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class InterfaceAuthentificationCtrl {

    private static final String INTERFACE_ADMINISTRATEUR = "InterfaceAdministrateur.fxml";
    private static final String INTERFACE_FORMATEUR = "InterfaceFormatteur.fxml";
    private static final String CREATION_COMPTE = "InterfaceCreationCompte.fxml";
    private static final String MDP_OUBLIE = "InterfaceMdpOublie.fxml";
    String adLogin = "admin";
    String adMdp = "1234";
    String fmtLogin = "formatteur";
    String fmtMdp = "1234";

    @FXML
    private RadioButton formatteurRadioBtn;
    @FXML
    private RadioButton administrateurRadioBtn;
    @FXML
    private TextField nomUtilisateurTxtField;
    @FXML
    private PasswordField mdpPassField;
    @FXML
    private Button mdpOublieBtn;
    @FXML
    private Button creationCompteBtn;
    @FXML
    private Button connexionBtn;
    @FXML
    private Button quitterBtn;
    @FXML
    private ToggleGroup fa;

    @FXML
    private void connexionButtonAction(ActionEvent e) throws IOException {
	formatteurRadioBtn.setToggleGroup(fa);
	administrateurRadioBtn.setToggleGroup(fa);
	formatteurRadioBtn.setSelected(true);

	if (formatteurRadioBtn.isSelected()) {
	    if (nomUtilisateurTxtField.getText().equals(fmtLogin) && mdpPassField.getText().equals(fmtMdp)) {
		Stage primaryStage = (Stage) connexionBtn.getScene().getWindow();
		BorderPane layoutAddProduct = (BorderPane) FXMLLoader
			.load(getClass().getResource(INTERFACE_FORMATEUR));
		Scene sceneAdd = new Scene(layoutAddProduct, 440, 700);
		primaryStage.setScene(sceneAdd);
	    } else {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Connexion Problem");
		alert.setHeaderText(null);
		alert.setContentText("Login et/ou mot de passe incorrectes");
		alert.showAndWait();

	    }
	} else if (administrateurRadioBtn.isSelected()) {
	    if (nomUtilisateurTxtField.getText().equals(adLogin) && mdpPassField.getText().equals(adMdp)) {
		Stage primaryStage = (Stage) connexionBtn.getScene().getWindow();
		BorderPane layoutAddProduct = (BorderPane) FXMLLoader
			.load(getClass().getResource(INTERFACE_ADMINISTRATEUR));
		Scene sceneAdd = new Scene(layoutAddProduct, 440, 700);
		primaryStage.setScene(sceneAdd);
	    } else {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Connexion Problem");
		alert.setHeaderText(null);
		alert.setContentText("Login et/ou mot de passe incorrectes");
		alert.showAndWait();
	    }
	} else {
	    Alert alert = new Alert(AlertType.ERROR);
	    alert.setTitle("Connexion Problem");
	    alert.setHeaderText(null);
	    alert.setContentText("Login et/ou mot de passe incorrectes");
	    alert.showAndWait();

	}
    }

    @FXML
    private void mdpOublieButtonAction(ActionEvent e) throws IOException {
	Stage primaryStage = (Stage) mdpOublieBtn.getScene().getWindow();
	BorderPane layoutAddProduct = (BorderPane) FXMLLoader.load(getClass().getResource(MDP_OUBLIE));
	Scene sceneAdd = new Scene(layoutAddProduct, 440, 700);
	primaryStage.setScene(sceneAdd);
    }

    @FXML
    private void creationCompteButtonAction(ActionEvent e) throws IOException {
	Stage primaryStage = (Stage) creationCompteBtn.getScene().getWindow();
	BorderPane layoutAddProduct = (BorderPane) FXMLLoader.load(getClass().getResource(CREATION_COMPTE));
	Scene sceneAdd = new Scene(layoutAddProduct, 440, 700);
	primaryStage.setScene(sceneAdd);
    }

    @FXML
    public void closeWindow() {
	Platform.exit();
    }
}
