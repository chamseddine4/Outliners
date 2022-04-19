/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.gui;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import workshopjdbc.services.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author pfeis
 */
public class ProfilController implements Initializable {

    @FXML
    private ImageView image1;
    @FXML
    private ImageView image11;
    private ServiceUtilisateur  ServiceUtilisateur ;
   
    @FXML
    private TextField TFemail;
        @FXML
    private Button Desactiver;
     private TextField email;
    private TextField username ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   //  this.ServiceUtilisateur =  new ServiceUtilisateur(); 
   //  TFemail.setText(email);
    //    System.out.println(email);
    }  
    
  // public void inisialiseEmail(String email){
  //  this.ServiceUtilisateur = new ServiceUtilisateur();    
   // this.email= email;
    
   
    
    //}
    
    
    
    
    
    
   
}
