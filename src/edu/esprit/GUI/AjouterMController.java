/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.GUI;

import edu.esprit.entities.forum;
import edu.esprit.services.ForumCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author FIRAS
 */
public class AjouterMController implements Initializable {

    @FXML
    private TextField tfTITRE;
    @FXML
    private TextArea tfMESSAGE;
    @FXML
    private ImageView image;
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
    private void ajouterMessage(ActionEvent event) {
        StringBuilder errors = new StringBuilder();
        
         ForumCRUD f2 = new ForumCRUD();
   
             if (tfTITRE.getText().isEmpty()) {
                Erreur.setText("merci d'entrer un titre");
            } else if (tfMESSAGE.getText().isEmpty()) {
                Erreur.setText(" merci d'entrer un un message");
            } 
             else {
            forum f = new forum(tfTITRE.getText(),(tfMESSAGE.getText()));
            ForumCRUD P = new ForumCRUD ();
            P.ajouterMessage2(f);
            
            Alert a = new Alert(Alert.AlertType.INFORMATION,"votre message est bien ajoutee <3 ",ButtonType.CLOSE);
            a.show();
            }
    }}

