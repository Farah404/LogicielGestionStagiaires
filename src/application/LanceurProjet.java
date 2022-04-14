package application;
	
import application.java.Stagiaire;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;



public class LanceurProjet extends Application {
    public static ObservableList <Stagiaire> listS = FXCollections.observableArrayList();
    
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("interfaces/InterfaceAdministrateur.fxml"));
			Scene scene = new Scene(root, root.getPrefWidth(), root.getPrefHeight());
//			scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("Annuaire Informatis� par FHF");
			primaryStage.getIcons().add(new Image("C:\\Users\\farah\\Desktop\\FormationIsika\\ProjetsEclipse\\LogicielGestionStagiaires\\iconeTel.jpg"));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}