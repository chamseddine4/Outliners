/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.gui;

import com.github.plushaze.traynotification.notification.Notification;
import com.github.plushaze.traynotification.notification.Notifications;
import com.github.plushaze.traynotification.notification.TrayNotification;
import workshopjdbc.entities.SDF;
import workshopjdbc.services.ServiceSDF;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class ProfilSDFController implements Initializable {
  private  Parent fxml ; 
       private  Stage stage ; 
       private Scene scene ; 
    @FXML
    private Label Erreur;
    @FXML
    private Button bta;
    @FXML
    private TextField TFname;
    @FXML
    private TextField TFlastname;
    @FXML
    private ComboBox TFgender;
    @FXML
    private Spinner<Integer> TFage;
    @FXML
    private ImageView TFimage;
    @FXML
    private Button bta1;
    @FXML
    private ImageView image1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          SpinnerValueFactory<Integer>valueFactory=new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100);
        valueFactory.setValue(1);
TFage.setValueFactory(valueFactory);
        TFgender.getItems().addAll("male","female");
    }    

    @FXML
    private void AjouterSDF(ActionEvent event) throws SQLException, IOException{
   if(controleDeSaisi())
            try {
                ServiceSDF sp = new ServiceSDF();
                SDF p;
                p = new SDF(TFname.getText(), TFlastname.getText(),TFgender.getSelectionModel().getSelectedItem().toString(),TFage.getValue());
                sp.ajouter(p);
                Alert a = new Alert(Alert.AlertType.INFORMATION, "SDF added !", ButtonType.OK);
                a.showAndWait();
FXMLLoader loader = new FXMLLoader(getClass().getResource("back_SDF.fxml"));
                Parent root = loader.load();
                Notification();
                TFname.getScene().setRoot(root);
                
                
              
             

                                                
                
            } catch (SQLException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
                a.showAndWait();
                
     
            }
    }
private void Notification(){
        
        String title = "Saveme : merci pour votre aide";
        String message = "un nouveau profil a été ajouté avec succes ";
       
       
            Notification notification = Notifications.SUCCESS;

        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotification(notification);
        tray.showAndWait();  
        }
    @FXML
    private void selectgender(ActionEvent event) {
    }
final FileChooser fc =new FileChooser();
    @FXML
    private void image(ActionEvent event) {
              fc.setTitle("choose image");
fc.setInitialDirectory(new File(System.getProperty("user.home")));
fc.getExtensionFilters().clear();
fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("image files","*.png","*.jpg"));
File file=fc.showOpenDialog(null);
if(file!=null)
{TFimage.setImage(new Image(file.toURI().toString()));
//File selected=filec;
}
else{System.out.println("a file is invalid");

    }
    }
    private boolean controleDeSaisi() {  

        if (TFname.getText().isEmpty() || TFlastname.getText().isEmpty() || TFgender.getSelectionModel().isEmpty()
                ) {
            showAlert(Alert.AlertType.ERROR, "Données erronés", "Verifier les données", "Veuillez bien remplir tous les champs !");
            return false;
        } else {

            if (!Pattern.matches("[A-z]*", TFname.getText())) {
                showAlert(Alert.AlertType.ERROR, "Données erronés", "Verifier les données", "le nom doit etre une chaine de caracteres ! ");
                TFname.requestFocus();
                TFname.selectEnd();
                return false;}
                if (!Pattern.matches("[A-z]*", TFlastname.getText())) {
                showAlert(Alert.AlertType.ERROR, "Données erronés", "Verifier les données", "last name doit etre une chaine de caracteres ! ");
                TFname.requestFocus();
                TFname.selectEnd();
                return false;
                
            }
                  
                                
            }

    return true;}
     public static void showAlert(Alert.AlertType type, String title, String header, String text) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(text);
        alert.showAndWait();

    }

    private void stat(ActionEvent event) throws SQLException, IOException{
       
               
    }

    @FXML
    private void statis(ActionEvent event)throws IOException 
    { FXMLLoader loader = new FXMLLoader(getClass().getResource("Statis.fxml"));
                Parent root = loader.load();
                TFgender.getScene().setRoot(root);
                
              
    }
    
    
    
    
          
    private void admin(ActionEvent event) {
        
          try {
            fxml = FXMLLoader.load(getClass().getResource("backMessage.fxml"));
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

