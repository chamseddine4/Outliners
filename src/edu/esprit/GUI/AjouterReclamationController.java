/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.reclamation;
import edu.esprit.services.ReclamationCRUD;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ziedm
 */
public class AjouterReclamationController implements Initializable {

    
     private Parent fxml;
    private Stage stage;
    private Scene scene;
     @FXML
    private Label Erreur;
    @FXML
    private TextField tfRec1;
    @FXML
    private TextArea tfRec2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
      @FXML
    private void ajouterReclamation(ActionEvent event) {
        StringBuilder errors = new StringBuilder();
        
         ReclamationCRUD f2 = new ReclamationCRUD();
      
                
             if (tfRec1.getText().isEmpty()) {
                Erreur.setText("merci d'entrer un titre");
            } else if (tfRec2.getText().isEmpty()) {
                Erreur.setText(" merci d'entrer le contenu ");
            } 
             else {
            reclamation r = new reclamation(tfRec1.getText(),(tfRec2.getText()));
            ReclamationCRUD P = new ReclamationCRUD ();
            P.ajouterReclamation2(r);
    
             Alert a = new Alert(Alert.AlertType.INFORMATION,"Reclamation ajouter avec succées",ButtonType.CLOSE);
            a.show();
            
            }}



     @FXML
    private void retour0(ActionEvent event) {
        
          try {
            fxml = FXMLLoader.load(getClass().getResource("backReclamation.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AjouterParticipationPublicController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxml);
        stage.setScene(scene);
        stage.show();
      
    } 



}
