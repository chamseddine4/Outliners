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
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import workshopjdbc.entities.Utilisateur;
import workshopjdbc.services.ServiceUtilisateur;
import workshopjdbc.utils.MyConnection;

/**
 * FXML Controller class
 *
 * @author pfeis
 */
public class ForgotPassController implements Initializable {

     @FXML
    private TextField Emaile;
         @FXML
    private TextField Question;
           @FXML
    private TextField Answer;
             @FXML
    private TextField newpass;
   
    @FXML
    private Button save;
    @FXML
    private Button back;
    @FXML
    private Button Search;  
    @FXML
    private Button inscribtn;
    @FXML
    private Button btnlogin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     @FXML
    private void back(ActionEvent event) throws IOException {
        Stage stage= new Stage();
    stage.setTitle("Login");
    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Signin.fxml"))));
    stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node) event.getSource()).getScene().getWindow());
        stage.show();

    }
     @FXML
    private void Search(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {

      
        int numtel = Integer.parseInt(Emaile.getText()) ;
        
        System.out.println(numtel);
                System.out.println("heloooooo");
        String Numberr = Emaile.getText();
        ServiceUtilisateur us = new ServiceUtilisateur();
        Utilisateur U = new Utilisateur();
         Connection cnx = MyConnection.getInstance().getCnx();
        
        if(Emaile.getText().isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR,"les Numero est vides!", ButtonType.OK);
           a.showAndWait();
        }else if(us.isValidPhoneNumber(Numberr)!=true){
           Alert a=new Alert(Alert.AlertType.ERROR,"Verifyer Votre Numero", ButtonType.OK);
           a.showAndWait();
            Emaile.setText("");
            Question.setText("");
          
            Emaile.requestFocus();
       }else{
            U=us.getByIda(numtel);
            
        System.out.println(U);
        Question.setText(U.getSecurityq());
            
            
        }       
       
        
    }  
     @FXML
      private void openSignup(ActionEvent event) throws IOException {
          Stage stage= new Stage();
    stage.setTitle("Inscription");
    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Signup.fxml"))));
    stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node) event.getSource()).getScene().getWindow());
        stage.show();
    }  
     
      
      @FXML
        private void save(ActionEvent event) throws IOException {
              ServiceUtilisateur us = new ServiceUtilisateur();
      
         int numtel = Integer.parseInt(Emaile.getText()) ;
        String Questions=Question.getText();
        String Answers =Answer.getText();
        String pass =newpass.getText();
        if( Emaile.getText().isEmpty()|| Question.getText().isEmpty()|| Answer.getText().isEmpty()||newpass.getText().isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR,"les champs sont vides!", ButtonType.OK);
           a.showAndWait();
        }
        else if (!(us.isValidAnswe(numtel, Answers))){
             Alert a=new Alert(Alert.AlertType.ERROR,"Votre reponse est faux", ButtonType.OK);
           a.showAndWait();
           Answer.setText("");
           
          
            Answer.requestFocus();
            
        }
        else{
           
             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Comfirmation");
        alert.setHeaderText(null);
        alert.setContentText("Êtes-vous sûr de modifier ?");
        Optional<ButtonType> action = alert.showAndWait();
            System.out.println("User Updated");
             Utilisateur U = new Utilisateur();
            U=us.getByIda(numtel);
            U.setPassword(pass);
            System.out.println(U.getId());
            System.out.println(U.getPassword());
            us.modifier2(U.getId(),U);
            Stage stage= new Stage();
    stage.setTitle("Login");
    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Signin.fxml"))));
    stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node) event.getSource()).getScene().getWindow());
        stage.show();
            
        }
        
    }  
    
}
