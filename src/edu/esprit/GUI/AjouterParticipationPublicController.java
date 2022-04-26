/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.participation_prive;
import edu.esprit.entities.participation_public;
import edu.esprit.services.ParticipationCRUD;
import edu.esprit.services.PriveCRUD;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ziedm
 */
public class AjouterParticipationPublicController implements Initializable {

    @FXML
    private TextField tfDonation;

    @FXML
     private Label Erreur;
    private Parent fxml;
    private Stage stage;
    private Scene scene;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    @FXML
    public void ajouterParticipation2(ActionEvent event) {
    
        StringBuilder errors = new StringBuilder();
        
         PriveCRUD ss = new PriveCRUD();
             
        
       
             if (tfDonation.getText().isEmpty()) {
                Erreur.setText("Donation est obligatoire ");
            } else {
             
        
        
            participation_public PPU = new participation_public(Integer.parseInt(tfDonation.getText()));
            ParticipationCRUD PU = new ParticipationCRUD ();
            PU.ajouterParticipation2(PPU);
    
            Alert a = new Alert(Alert.AlertType.INFORMATION,"Participation Public ajouter avec succées",ButtonType.CLOSE);
            a.show();
    
            
            try {
            fxml = FXMLLoader.load(getClass().getResource("Paiement.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AjouterParticipationPublicController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxml);
        stage.setScene(scene);
        stage.show();
    
}
    }
    
    
       @FXML
    private void retour2(ActionEvent event) {
        
          try {
            fxml = FXMLLoader.load(getClass().getResource("AjoutParticipationPrive.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AjouterParticipationPublicController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxml);
        stage.setScene(scene);
        stage.show();
      
    } 

}
