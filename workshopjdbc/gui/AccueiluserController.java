/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import workshopjdbc.utils.MyConnection;

/**
 * FXML Controller class
 *
 * @author pfeis
 */
public class AccueiluserController  {

    
       private  Parent fxml ; 
       private  Stage stage ; 
       private Scene scene ; 
    @FXML
    private ImageView image1;
    @FXML
    private ImageView image11;
    
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
