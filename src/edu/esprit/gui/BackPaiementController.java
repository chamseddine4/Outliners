/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.paiement;
import edu.esprit.services.PaiementCRUD;
import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ziedm
 */
public class BackPaiementController implements Initializable {

    
    private Parent fxml;
    private Stage stage;
    private Scene scene;
    
    @FXML
    private TableView<paiement> tablePaiement;
    @FXML
    private TableColumn<paiement, Integer> idIdpaie;
    @FXML
    private TableColumn<paiement, String> idNompaie;
    @FXML
    private TableColumn<paiement, Integer> idNumpaie;
    @FXML
    private TableColumn<paiement, String> idMoispaie;
    @FXML
    private TableColumn<paiement, Integer> idAnneepaie;
    @FXML
    private TableColumn<paiement, Integer> idCVVpaie;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         tablePaiement.setEditable(true);
        refrech();
        
    }    
    
     @FXML
    private void Public(ActionEvent event) {
        
          try {
            fxml = FXMLLoader.load(getClass().getResource("backPublic.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(BackPaiementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxml);
        stage.setScene(scene);
        stage.show();
    
        
        
    }
    
       
     @FXML
    private void Prive(ActionEvent event) {
        
          try {
            fxml = FXMLLoader.load(getClass().getResource("back.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(BackPaiementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxml);
        stage.setScene(scene);
        stage.show();
    
        
        
    }
    
    
     public void refrech() {
        
        PaiementCRUD pa = new PaiementCRUD();
        idIdpaie.setCellValueFactory(new PropertyValueFactory<>("id"));
        idNompaie.setCellValueFactory(new PropertyValueFactory<>("nom_sur_carte"));
        idNumpaie.setCellValueFactory(new PropertyValueFactory<>("num_carte"));
        idMoispaie.setCellValueFactory(new PropertyValueFactory<>("mois_exp"));
        idAnneepaie.setCellValueFactory(new PropertyValueFactory<>("annee_exp"));
        idCVVpaie.setCellValueFactory(new PropertyValueFactory<>("cvv"));
        
        
        tablePaiement.getItems().clear();
        tablePaiement.setItems(pa.Affichertout());
    }
    
}
