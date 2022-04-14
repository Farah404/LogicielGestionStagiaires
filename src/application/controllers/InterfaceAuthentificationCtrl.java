package application.controllers;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Desktop;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class InterfaceAuthentificationCtrl {

    private static final String INTERFACE_ADMINISTRATEUR = "/interfaces/InterfaceAdministrateur.fxml";
    private static final String INTERFACE_FORMATTEUR = "/interfaces/InterfaceFormatteur.fxml";
    private static final String A_PROPOS = "/application.interfaces/InterfacePropos.fxml";
    String adLogin = "admin";
    String adMdp = "1234";
    String fmtLogin = "formateur";
    String fmtMdp = "1234";

    @FXML
    private TextField nomUtilisateurTxtField;
    @FXML
    private Button connexionBtn;
    @FXML
    private RadioButton formatteurRadioBtn;
    @FXML
    private RadioButton administrateurRadioBtn;
    @FXML
    private PasswordField mdpPassField;
    @FXML
    private Hyperlink mdpOublieBtn;
    @FXML
    private Hyperlink creationCompteBtn;
    @FXML
    private Button quitterBtn;
    @FXML
    private ImageView goToIsikaWebsite;
    @FXML
    private ToggleGroup fa;
    @FXML
    private Button propos;

    // BOUTTON CONNEXION//
    @FXML
    private void connexionButtonAction(ActionEvent e) throws IOException {
	// METHODE QUI PERMET DE CHOISIR UN SEUL RADIOBUTTON//
	formatteurRadioBtn.setToggleGroup(fa);
	administrateurRadioBtn.setToggleGroup(fa);
	// ACCES FORMATEUR//
	if (formatteurRadioBtn.isSelected()) {
	    if (nomUtilisateurTxtField.getText().equals(fmtLogin) && mdpPassField.getText().equals(fmtMdp)) {
		try {
		    allerVersInterfaceFormateur();
		} catch (IOException e1) {
		    e1.printStackTrace();
		}
	    } else {
		try {
		    alerteConnexion();
		} catch (IOException e1) {
		    e1.printStackTrace();
		}
	    }
	    // ACCES ADMINISTRATEUR//
	} else if (administrateurRadioBtn.isSelected()) {
	    if (nomUtilisateurTxtField.getText().equals(adLogin) && mdpPassField.getText().equals(adMdp)) {
		try {
		    allerVersInterfaceAdmin();
		} catch (IOException e1) {
		    e1.printStackTrace();
		}
	    } else {
		try {
		    alerteConnexion();
		} catch (IOException e1) {
		    e1.printStackTrace();
		}
	    }
	} else {
	    try {
		alerteConnexion();
	    } catch (IOException e1) {
		e1.printStackTrace();
	    }

	}
    }

    // METHODE POUR FERMER L'APPLICATION//
    @FXML
    public void closeWindow() {
	Platform.exit();
    }
    
public void setStage(Stage primaryStage) {

	}
    
    //METHODE POUR ALLER A LA FENETRE A PROPOS//
    @FXML
    private void AllerVersPropos() throws IOException {
	InterfaceAuthentificationCtrl controleur = new InterfaceAuthentificationCtrl();
	propos.getScene().getWindow();
	FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(A_PROPOS));
	loader.setController(controleur);
	Pane rootPane = loader.load();
	Scene scene = new Scene(rootPane, rootPane.getPrefWidth(), rootPane.getPrefHeight());
	Stage proposStage = new Stage();
	proposStage.setTitle("A Propos");
	proposStage.setScene(scene);
	proposStage.show();
	controleur.setStage(proposStage);
    }

    // METHODE POUR ALLER SUR LE SITE ISIKA//
    @FXML
    public void goToIsikaWebsite() throws IOException, URISyntaxException {
	Desktop d = Desktop.getDesktop();
	d.browse(new URI("https://projet-isika.com/"));
    }

    // METHODE POUR ALLER VERS INTERFACE FORMATEUR//
    public void allerVersInterfaceFormateur() throws IOException {
	Stage primaryStage = (Stage) connexionBtn.getScene().getWindow();
	BorderPane layoutInterfaceFormatteur = (BorderPane) FXMLLoader.load(getClass().getClassLoader().getResource(INTERFACE_FORMATTEUR));
	Scene sceneAdd = new Scene(layoutInterfaceFormatteur, 440, 700);
	primaryStage.setScene(sceneAdd);
    }

    // METHODE POUR ALLER VERS INTERFACE ADMINISTRATEUR//
    public void allerVersInterfaceAdmin() throws IOException {
	Stage primaryStage = (Stage) connexionBtn.getScene().getWindow();
	BorderPane layoutInterfaceFormatteur = (BorderPane) FXMLLoader.load(getClass().getClassLoader().getResource(INTERFACE_ADMINISTRATEUR));
	Scene sceneAdd = new Scene(layoutInterfaceFormatteur, 440, 700);
	primaryStage.setScene(sceneAdd);
    }

    // METHODE ALERTE//
    public void alerteConnexion() throws IOException {
	Alert alert = new Alert(AlertType.ERROR);
	alert.setTitle("Connexion Problem");
	alert.setHeaderText(null);
	alert.setContentText("Login et/ou mot de passe incorrectes");
	alert.showAndWait();
    }

}
