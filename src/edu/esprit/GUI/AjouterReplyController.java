/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.GUI;

import edu.esprit.entities.reply;
import edu.esprit.services.ReplyCRUD;
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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author FIRAS
 */
public class AjouterReplyController implements Initializable {
    private Parent fxml;
    private Stage stage;
    private Scene scene;

    @FXML
    private TextField tfRating;
    @FXML
    private TextArea tfreply;
     @FXML
    private Label Erreur;
    @FXML
    private ImageView image;

     /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
      @FXML
    private void ajouterReply(ActionEvent event) {
         StringBuilder errors = new StringBuilder();
             ReplyCRUD f2 = new ReplyCRUD();
        
             if (tfRating.getText().isEmpty()) {
                Erreur.setText("merci d'entrer rating");
            } else if (tfreply.getText().isEmpty()) {
                Erreur.setText(" merci d'entrer votre reply");
            } 
             else {
            reply f = new reply(Integer.parseInt(tfRating.getText()),(tfreply.getText()));
            ReplyCRUD P = new ReplyCRUD ();
            P.ajouterReply2(f);
            
            Alert a = new Alert(Alert.AlertType.INFORMATION,"votre reply est bien ajoutee <3 ",ButtonType.CLOSE);
            a.show();
            }
     }
    
    @FXML
    private void admin(ActionEvent event) {
        
          try {
            fxml = FXMLLoader.load(getClass().getResource("backMessage.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AjouterMController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxml);
        stage.setScene(scene);
        stage.show();
    
        
        
    }
    
}
    