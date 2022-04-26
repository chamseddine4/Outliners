/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.GUI;

import edu.esprit.entities.forum;
import edu.esprit.services.ForumCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author FIRAS
 */
public class AjouterMController implements Initializable {
       private Parent fxml;
    private Stage stage;
    private Scene scene;


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
                       Notifications notificationBuilder = Notifications.create ( )
                               .title("good").text("message envoyé avec succès ").graphic( null ).hideAfter( javafx.util.Duration.seconds(5))
 .position(Pos.TOP_LEFT) 
.onAction(new EventHandler<ActionEvent>(){ 
public void handle(ActionEvent event )
{
 System.out.println(" clicked ON");
   } } ) ; 
notificationBuilder.darkStyle(); 
notificationBuilder.show();
            
          
            }
   
    }
    
   


@FXML
    private void reply(ActionEvent event) {
        
          try {
            fxml = FXMLLoader.load(getClass().getResource("ajouterReply.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AjouterMController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxml);
        stage.setScene(scene);
        stage.show();
    
        
        
    }
    
@FXML
    private void mess(ActionEvent event) {
        
          try {
            fxml = FXMLLoader.load(getClass().getResource("frontForum.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AjouterMController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxml);
        stage.setScene(scene);
        stage.show();
    
        
        
    }


}








