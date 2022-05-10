/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.gui;


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
import workshopjdbc.entities.Utilisateur;
import workshopjdbc.entities.forum;
import workshopjdbc.services.ForumCRUD;
import workshopjdbc.services.ServiceUtilisateur;
import workshopjdbc.utils.SharedData;

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
    private Label Erreur;
    @FXML
    private ImageView image1;
        
     
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
                
                
                SharedData da= new SharedData();
                Utilisateur u1 = new Utilisateur();
                ServiceUtilisateur l1 = new ServiceUtilisateur();
                u1=l1.getByidd(da.CurrentUseId);
                
            forum f = new forum(tfTITRE.getText(),(tfMESSAGE.getText()),u1,u1.getEmail());
            ForumCRUD P = new ForumCRUD ();
            P.ajouterMessage2(f);
                       Notifications notificationBuilder = Notifications.create ( )
                               .title("good").text("message envoyé avec succès ").graphic( null ).hideAfter( javafx.util.Duration.seconds(5))
                               .position(Pos.TOP_LEFT) 
                               .onAction(new EventHandler<ActionEvent>(){ 
                           public void handle(ActionEvent event ){
                               System.out.println(" clicked ON");
                                    } } ) ; 
                              notificationBuilder.darkStyle(); 
                              notificationBuilder.show();
            
             try {
            fxml = FXMLLoader.load(getClass().getResource("frontForum.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(workshopjdbc.gui.AjouterParticipationPublicController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxml);
        stage.setScene(scene);
        stage.show();
            }
   
    }
    
   


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

    
    
    
     @FXML
    public void logout(ActionEvent event) throws IOException {
        try {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Signin.fxml"));

                    fxml = loader.load();
                  
                } catch (IOException ex) {
                    Logger.getLogger(SigninController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(fxml);
                stage.setScene(scene);
                stage.show();
        
            
            
        } 
    
    
       @FXML
        public void profil(ActionEvent event) throws IOException {
        try {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Profil.fxml"));

                    fxml = loader.load();
                  
                } catch (IOException ex) {
                    Logger.getLogger(SigninController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(fxml);
                stage.setScene(scene);
                stage.show();
        
            
         
        } 
        
        
        
            
       @FXML
        public void reclamation(ActionEvent event) throws IOException {
        try {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterReclamation.fxml"));

                    fxml = loader.load();
                  
                } catch (IOException ex) {
                    Logger.getLogger(SigninController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(fxml);
                stage.setScene(scene);
                stage.show();
        
            
            
        } 
        
        
                  
       @FXML
        public void prive (ActionEvent event) throws IOException {
        try {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("AjoutParticipationPrive.fxml"));

                    fxml = loader.load();
                  
                } catch (IOException ex) {
                    Logger.getLogger(SigninController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(fxml);
                stage.setScene(scene);
                stage.show();
        
            
            
        } 
        
                  
       @FXML
        public void ppublic (ActionEvent event) throws IOException {
        try {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterParticipationPublic.fxml"));

                    fxml = loader.load();
                  
                } catch (IOException ex) {
                    Logger.getLogger(SigninController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(fxml);
                stage.setScene(scene);
                stage.show();
        
            
            
        } 
        
        
                         
       @FXML
        public void profilSDF (ActionEvent event) throws IOException {
        try {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("profilSDF.fxml"));

                    fxml = loader.load();
                  
                } catch (IOException ex) {
                    Logger.getLogger(SigninController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(fxml);
                stage.setScene(scene);
                stage.show();
        
            
            
        } 
        
        
              @FXML
        public void Forum (ActionEvent event) throws IOException {
        try {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("frontForum.fxml"));

                    fxml = loader.load();
                  
                } catch (IOException ex) {
                    Logger.getLogger(SigninController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(fxml);
                stage.setScene(scene);
                stage.show();
        
            
            
        } 
        

}








