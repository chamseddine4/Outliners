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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
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
public class SignupController implements Initializable {

    
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

       private Utilisateur user;
    @FXML
    private TextField textFieldconfirmpwd;
    @FXML
    private TextField tfNum;
         @FXML
       private ChoiceBox<String> ISecurty;
       private String[] choix = {"In what city were you born?", "What is the name of your favorite pet?", "What is your mother's maiden name?","What high school did you attend?","What was your favorite food as a child?"};
       
    @FXML
    private TextField Ianswer;
    
        public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }
      /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ISecurty.getItems().addAll(choix);
    }    
 
    
    
      private boolean validateEmail(){
        Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9.]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher m = p.matcher(EmailTF.getText());
        
        if(m.find() && m.group().equals(EmailTF.getText())){
            return true; 
            
        } else {
            Alert alert= new Alert(AlertType.WARNING);
            
            alert.setTitle("Validate Email");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter Valid Email");
            alert.showAndWait();
            
            
            return false;
            
        }
        
        
    }

    @FXML
    public  void AjoutUser(ActionEvent event) throws SQLException, IOException {
        
        String username = UsernameTF.getText();
        String email = EmailTF.getText();
        String password = PasswordTF.getText();
        String confirmPass = textFieldconfirmpwd.getText();
         int numtel = Integer.parseInt(tfNum.getText()) ;
         String qes=ISecurty.getValue();
         String ans=Ianswer.getText();
        
    
        StringBuilder errors = new StringBuilder();
        
         ServiceUtilisateur ss = new ServiceUtilisateur();

    
        
           if (UsernameTF.getText().trim().isEmpty()|| EmailTF.getText().trim().isEmpty() || PasswordTF.getText().trim().isEmpty() || UsernameTF.getText().length() < 4 || PasswordTF.getText().length() < 8 || PasswordTF.equals(confirmPass)==false  ||tfNum.getText().trim().isEmpty()||ISecurty.getValue().trim().isEmpty()||Ianswer.getText().trim().isEmpty() ) {
          
               if (username.trim().isEmpty()) {
                errors.append("*A username is required \n");
            } else if (username.length() < 4) {
                errors.append("*Your username must contain at least 4 characters \n");
            }

            if (email.trim().isEmpty()) {
                errors.append("*An email is required \n");
            }
            
            
            if (password.trim().isEmpty()) {
                errors.append("*A password is required \n");
            } else if (password.length() < 8 || password.equals(confirmPass)==false) {
                if (password.length() < 8) {
                    errors.append("*Your password must contain at least 8 characters \n");
                } else if (password.equals(confirmPass)==false) {
                    errors.append("*Passwords does not match  \n");
                }
            }
            
            
             if (errors.length() > 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Registration Failed");
            alert.setContentText(errors.toString());
            alert.showAndWait();

                       } else {
                 
                 
                Utilisateur utilisateur = new Utilisateur();
                ServiceUtilisateur nu = new ServiceUtilisateur();
                utilisateur.setUsername(UsernameTF.getText());
                utilisateur.setNumtel(numtel);
                utilisateur.setSecurityq(qes);
                utilisateur.setAnswer(ans);
                     
                if(validateEmail() ){
                    
                utilisateur.setEmail(EmailTF.getText());}
                utilisateur.setPassword(PasswordTF.getText());
                utilisateur.setRoles("[\"ROLE_USER\"]");
              
                
                if(nu.signup(utilisateur)==0 && nu.SendMail(utilisateur ,"null")){
                    
                 
                       FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/Signin.fxml"));
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
      }
     


            
        } 

    @FXML
    private void back(ActionEvent event) {
        
        
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
    

