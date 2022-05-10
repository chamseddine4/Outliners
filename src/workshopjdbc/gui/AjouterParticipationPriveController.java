/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.gui;
import workshopjdbc.entities.participation_prive;

import workshopjdbc.services.PriveCRUD;
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
import workshopjdbc.entities.Utilisateur;
import workshopjdbc.services.ServiceUtilisateur;
import workshopjdbc.utils.SharedData;

/**
 * FXML Controller class
 *
 * @author ziedm
 */
public class AjouterParticipationPriveController implements Initializable {

    
    private Parent fxml;
    private Stage stage;
    private Scene scene;
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
                
                 SharedData da= new SharedData();
                Utilisateur u1 = new Utilisateur();
                ServiceUtilisateur l1 = new ServiceUtilisateur();
                u1=l1.getByidd(da.CurrentUseId);
        
            participation_prive PP = new participation_prive(Integer.parseInt(tfNumerotelephone.getText()), Integer.parseInt(tfNbrcharge.getText()),u1,u1.getEmail());
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
    
     @FXML
    private void public2(ActionEvent event) {
        
          try {
            fxml = FXMLLoader.load(getClass().getResource("AjouterParticipationPublic.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AjouterParticipationPriveController.class.getName()).log(Level.SEVERE, null, ex);
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
