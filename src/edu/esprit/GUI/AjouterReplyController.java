/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.GUI;

import edu.esprit.entities.reply;
import edu.esprit.services.ReplyCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author FIRAS
 */
public class AjouterReplyController implements Initializable {

    @FXML
    private TextField tfRating;
    @FXML
    private TextArea tfreply;
     @FXML
    private Label Erreur;

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
}
    