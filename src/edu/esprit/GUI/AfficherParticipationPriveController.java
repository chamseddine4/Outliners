/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

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
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author ziedm
 */
public class AfficherParticipationPriveController implements Initializable {

    private Parent fxml;
    private Stage stage;
    private Scene scene;
    
    @FXML
    private TextField textNumerotelephone;
    @FXML
    private TextField textNbrcharge;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    public void setTextNumerotelephone (String message){
        this.textNumerotelephone.setText(message);
    }
    
     public void setTextNbrcharge (String message){
        this.textNbrcharge.setText(message);
    }
     
     @FXML
    private void retourr(ActionEvent event) {
        
          try {
            fxml = FXMLLoader.load(getClass().getResource("AjoutParticipationPrive.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AfficherParticipationPriveController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxml);
        stage.setScene(scene);
        stage.show();
      
    } 
    
    
    @FXML
    private void retourr2(ActionEvent event) {
        
          try {
            fxml = FXMLLoader.load(getClass().getResource("AjouterParticipationPublic.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AfficherParticipationPriveController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxml);
        stage.setScene(scene);
        stage.show();
      
    } 
     
     
}
