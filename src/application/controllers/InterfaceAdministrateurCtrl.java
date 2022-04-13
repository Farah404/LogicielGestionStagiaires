package application.controllers;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.LanceurProjet;
import application.java.Stagiaire;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class InterfaceAdministrateurCtrl implements Initializable{

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

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
	nomS.setCellValueFactory(new PropertyValueFactory<Stagiaire,String>("nomS"));
	prenomS.setCellValueFactory(new PropertyValueFactory<Stagiaire,String>("prenomS"));
	dptS.setCellValueFactory(new PropertyValueFactory<Stagiaire,String>("dptS"));
	promoS.setCellValueFactory(new PropertyValueFactory<Stagiaire,String>("promoS"));
	anneeS.setCellValueFactory(new PropertyValueFactory<Stagiaire,String>("anneeS"));
	tblS.setItems(LanceurProjet.listS);
    }

    @FXML
    private void handleMenuAddAction(ActionEvent e) throws IOException
    {
	Stage primaryStage = (Stage) tblS.getScene().getWindow();
	BorderPane layoutAddProduct = (BorderPane)FXMLLoader.load(getClass().getResource("InterfaceAjoutStagiaire.fxml"));
	Scene sceneList = new Scene(layoutAddProduct,500,700);
	primaryStage.setScene(sceneList);

    }




}
