/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.gui;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;
import workshopjdbc.services.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author pfeis
 */
public class SigninController  {

    @FXML
    public TextField t1;
    @FXML
    public TextField t2;
   
    public static String email;
    public static String password;
    
    private  Parent fxml ; 
    private  Stage stage ; 
    private Scene scene ; 
    @FXML
    private ImageView image;


    /**
     * Initializes the controller class.
     */

 

    @FXML
    private void SeConnecter(ActionEvent event) throws IOException {
        email = t1.getText();
        password = t2.getText();
        ServiceUtilisateur sc = new ServiceUtilisateur();
        if (sc.verifPassword(email, password)) {
            
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerte");
            alert.setHeaderText(null);
            alert.setContentText("!!! welcome  !!!");
            alert.showAndWait();
            
            if (sc.checkRole(email).equals("USER")){
                
            try {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Accueiluser.fxml"));

                    fxml = loader.load();
                   // ProfilController cc = loader.getController();
                   // cc.inisialiseEmail(email);
                  
                } catch (IOException ex) {
                    Logger.getLogger(SigninController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(fxml);
                stage.setScene(scene);
                stage.show();
        
            }
            else {
                       try {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Accueiladmin.fxml"));

                    fxml = loader.load();
                //    ProfilController cc = loader.getController();
                 //   cc.inisialiseEmail(email);
                  
                } catch (IOException ex) {
                    Logger.getLogger(SigninController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(fxml);
                stage.setScene(scene);
                stage.show();
        
            }
                
            
                
                
            
        }  else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerte");
            alert.setHeaderText(null);
            alert.setContentText("!!! Verifiez Vos Coordonnees !!!");
            alert.showAndWait();
        }
    }

  

   



   
    
}
