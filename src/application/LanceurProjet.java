package application;
import application.java.ArbreStagiaire;
import application.java.Recherche;
import application.java.Stagiaire;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;



public class LanceurProjet extends Application {
    private static final String AJOUT_STAGIAIRE = "/application/interfaces/InterfaceAjoutStagiaire.fxml";
    private static final String MODIFIER_STAGIAIRE = "/application/interfaces/InterfaceModifierStagiaire.fxml";
    private static final String AUTHENTIFICATION = "/application/interfaces/InterfaceAuthentification.fxml";
    private static final String INTERFACE_ADMINISTRATEUR = "/application/interfaces/InterfaceAdministrateur.fxml";
    private static final String INTERFACE_FORMATTEUR = "/application/interfaces/InterfaceFormatteur.fxml";
    private static final String A_PROPOS = "/application/interfaces/InterfacePropos.fxml";
    private static final String STYLE_SHEET = "/application/style/style.css";
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource(INTERFACE_ADMINISTRATEUR));
			Scene scene = new Scene(root, root.getPrefWidth(), root.getPrefHeight());
			scene.getStylesheets().add(getClass().getResource(STYLE_SHEET).toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("Annuaire Informatisé par FHF");
			primaryStage.getIcons().add(new Image("C:\\Users\\farah\\Desktop\\FormationIsika\\ProjetsEclipse\\LogicielGestionStagiaires\\iconeTel.jpg"));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
}
}