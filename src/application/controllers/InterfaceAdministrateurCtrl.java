package application.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.java.ArbreStagiaire;
import application.java.Recherche;
import application.java.Stagiaire;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class InterfaceAdministrateurCtrl implements Initializable{
    static final String PATH_FILE_DON = "C:\\Users\\farah\\Desktop\\FormationIsika\\ProjetsEclipse\\LogicielGestionStagiaires\\STAGIAIRES.DON";
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

    static ArbreStagiaire monArbre = new ArbreStagiaire();
    ObservableList<Stagiaire> observableArrayList =  FXCollections.observableArrayList(Recherche.parcoursStagiaire(monArbre));
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
	nomS.setCellValueFactory(new PropertyValueFactory<Stagiaire,String>("nom"));
	prenomS.setCellValueFactory(new PropertyValueFactory<Stagiaire,String>("prenom"));
	dptS.setCellValueFactory(new PropertyValueFactory<Stagiaire,String>("departement"));
	promoS.setCellValueFactory(new PropertyValueFactory<Stagiaire,String>("promotion"));
	anneeS.setCellValueFactory(new PropertyValueFactory<Stagiaire,String>("annee"));
	tblS.setItems(observableArrayList);
    }
    




    }

