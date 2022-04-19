/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.paiement;
import edu.esprit.entities.participation_prive;
import edu.esprit.services.PaiementCRUD;
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
public class PaiementController implements Initializable {

    private Parent fxml;
    private Stage stage;
    private Scene scene;
    
    @FXML
    private TextField tfNomcarte;
    @FXML
    private TextField tfNumerocarte;
    @FXML
    private TextField tfMoisexp;
    @FXML
    private TextField tfAnneeexp;
    @FXML
    private TextField tfCvv;

    @FXML
    private Label Erreur;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    @FXML
    private void ajouterPaiement2(ActionEvent event) {
      
        StringBuilder errors = new StringBuilder();
        
         PriveCRUD ss = new PriveCRUD();
             
        
    
             if (tfNomcarte.getText().isEmpty()) {
                Erreur.setText("Nom de carte est obligatoire ");
            } else if (tfNumerocarte.getText().isEmpty()) {
                Erreur.setText(" Numéro de carte est obligatoire");
            } else if (tfMoisexp.getText().isEmpty()) {
                Erreur.setText(" Mois d'expiration est obligatoire");
            } else if (tfAnneeexp.getText().isEmpty()) {
                Erreur.setText(" Année d'expiration est obligatoire");
            } else if (tfCvv.getText().isEmpty()) {
                Erreur.setText(" CVV est obligatoire");
            } 
             else {
        
        String nom_sur_carte = tfNomcarte.getText();
        int num_carte = Integer.parseInt(tfNumerocarte.getText());
        String mois_exp = tfMoisexp.getText();
        int annee_exp = Integer.parseInt(tfAnneeexp.getText());
        int cvv = Integer.parseInt(tfCvv.getText());
        
        paiement P = new paiement (nom_sur_carte,num_carte,mois_exp,annee_exp,cvv);
        
        
         PaiementCRUD Pa = new PaiementCRUD ();
            Pa.ajouterPaiement2(P);
            
            Alert a = new Alert(Alert.AlertType.INFORMATION,"Paiement ajouter avec succées",ButtonType.CLOSE);
            a.show();
    
            }
    }
            

    @FXML
    private void retour(ActionEvent event) {
        
          try {
            fxml = FXMLLoader.load(getClass().getResource("AjouterParticipationPublic.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AjouterParticipationPublicController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxml);
        stage.setScene(scene);
        stage.show();
    
        
        
    }
    
    
     @FXML
    private void admin(ActionEvent event) {
        
          try {
            fxml = FXMLLoader.load(getClass().getResource("backPaiement.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AjouterParticipationPublicController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxml);
        stage.setScene(scene);
        stage.show();
    
        
        
    }
}