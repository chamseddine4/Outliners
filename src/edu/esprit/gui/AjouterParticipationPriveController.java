/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.participation_prive;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ziedm
 */
public class AjouterParticipationPriveController implements Initializable {

    @FXML
    private TextField tfNbrcharge;
    @FXML
    private TextField tfNumerotelephone;

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
    private void ajouterParticipation2(ActionEvent event) {
        
        
        StringBuilder errors = new StringBuilder();
        
         PriveCRUD ss = new PriveCRUD();
             
        
        try {
             if (tfNumerotelephone.getText().isEmpty()) {
                Erreur.setText("Numéro de Télephone est obligatoire ");
            } else if (tfNbrcharge.getText().isEmpty()) {
                Erreur.setText(" Nombre Prise en charge est obligatoire");
            } 
             else {
            participation_prive PP = new participation_prive(Integer.parseInt(tfNumerotelephone.getText()), Integer.parseInt(tfNbrcharge.getText()));
            PriveCRUD P = new PriveCRUD ();
            P.ajouterPrive2(PP);
            
            Alert a = new Alert(Alert.AlertType.INFORMATION,"Participation Privé ajouter avec succées",ButtonType.CLOSE);
            a.show();
            
            
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherParticipationPrive.fxml"));
            Parent root = loader.load();
            
             tfNbrcharge.getScene().setRoot(root);
             AfficherParticipationPriveController apc = loader.getController();   
            
             apc.setTextNumerotelephone(""+PP.getNumeroTel());
             apc.setTextNbrcharge(""+PP.getNbrPrisecharge());
            }
             
        } catch (IOException ex) {
            Logger.getLogger(AjouterParticipationPriveController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    

}
