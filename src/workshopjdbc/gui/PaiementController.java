/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.gui;
import workshopjdbc.entities.paiement;

import workshopjdbc.services.PaiementCRUD;
import workshopjdbc.services.PriveCRUD;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.mail.MessagingException;
import org.controlsfx.control.Notifications;
import workshopjdbc.entities.Utilisateur;
import workshopjdbc.services.ServiceUtilisateur;
import workshopjdbc.utils.SharedData;

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

    private Label Erreur;
    @FXML
    private ImageView image1;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    @FXML
    private void ajouterPaiement2(ActionEvent event) throws MessagingException {
      
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
            
                Notifications notificationBuilder = Notifications.create ( )
                               .title("Vérification").text("Votre Participation ajouteé avec succès ").graphic( null ).hideAfter( javafx.util.Duration.seconds(5))
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