package application.controllers;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;

public class InterfaceProposCtrl {
    
    @FXML
    private Hyperlink goToIsikaWebsite;

    @FXML
    private Hyperlink goToIsikaYoutube;

    @FXML
    private Hyperlink goToGithub;

    @FXML
    private Hyperlink whoDidThis;
    
    @FXML
    private ImageView goToIsikaWebsiteImg;
    
    
    
    // METHODE POUR ALLER SUR LE SITE ISIKA//
    @FXML
    public void goToIsikaWebsite() throws IOException, URISyntaxException {
	Desktop d = Desktop.getDesktop();
	d.browse(new URI("https://projet-isika.com/"));
    }
    
    // METHODE POUR ALLER SUR LA PAGE YOUTUBE ISIKA//
    @FXML
    public void goToIsikaYouTube() throws IOException, URISyntaxException {
	Desktop d = Desktop.getDesktop();
	d.browse(new URI("https://www.youtube.com/channel/UCyZGOAMaVNPITntX2HwbiSw/featured"));
    }
    
    // METHODE POUR ALLER SUR LA PAGE GIT HUB//
    @FXML
    public void goToGithub() throws IOException, URISyntaxException {
	Desktop d = Desktop.getDesktop();
	d.browse(new URI("https://github.com/Farah404/LogicielGestionStagiaires"));
    }
    
    // METHODE QUI A FAIT CE PROJET//
    public void propos() throws IOException {
	Alert alert = new Alert(AlertType.INFORMATION);
	alert.setTitle("Qui a fait ce projet?");
	alert.setHeaderText("FHF ANNUAIRE INFORMATISÉ");
	alert.setContentText("Projet 1 CDA17");
	alert.showAndWait();
    }

}

