/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import workshopjdbc.entities.Utilisateur;
import workshopjdbc.services.ServiceUtilisateur;
import workshopjdbc.utils.MyConnection;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class SignupController {

    
    @FXML
    private TextField UsernameTF;
    @FXML
    private TextField EmailTF;
    @FXML
    private TextField PasswordTF;
    
       @FXML
    private Label Erreur;
       
    private  Parent fxml ; 
    private  Stage stage ; 
    private Scene scene ; 


    /**
     * Initializes the controller class.
     */
       Connection cnx = MyConnection.getInstance().getCnx();
    private Label ErrorLabel;
    @FXML
    private ImageView image;

    
    

    

    @FXML
    public  void AjoutUser(ActionEvent event) throws SQLException, IOException {
        StringBuilder errors = new StringBuilder();
        
         ServiceUtilisateur ss = new ServiceUtilisateur();
        
        try {
            if (UsernameTF.getText().isEmpty()) {
                Erreur.setText("Username is oblig ");
            } else if (EmailTF.getText().isEmpty()) {
                Erreur.setText("email  is oblig ");
            } 
            
            else if (PasswordTF.getText().isEmpty()) {
                Erreur.setText("mot de passe  is oblig ");
            } 
            else {
                Utilisateur p = new Utilisateur (0,UsernameTF.getText(), EmailTF.getText() , PasswordTF.getText(),"");
                ss.ajouter(p);
                Erreur.setText("");
            }

        } catch (Exception e) {

        }
        
    

     
          Utilisateur utilisateur = new Utilisateur();
            ServiceUtilisateur nu = new ServiceUtilisateur();
                utilisateur.setUsername(UsernameTF.getText());
                utilisateur.setEmail(EmailTF.getText());
                utilisateur.setPassword(PasswordTF.getText());
                utilisateur.setRoles("[\"ROLE_USER\"]");
              
                
                if(nu.signup(utilisateur)==0){
                       FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/Signup.fxml"));
           Parent root = (Parent) loader.load();
           Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           stage.setUserData(utilisateur);
           // SignUp2Controller signUp2Controller=loader.getController();
           //   signUp2Controller.returnUser(LoginTextField1.getText());
           //  signUp2Controller.show(LoginTextField1.getText());
           Scene scene = new Scene(root);
           stage.setScene(scene);
           stage.show();
                }
                  
            
      }
     

    @FXML
    public void back(ActionEvent event) throws IOException {
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

  


  

    }
    

