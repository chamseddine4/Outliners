/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.gui;




import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.Rating;
import workshopjdbc.entities.Utilisateur;
import workshopjdbc.entities.forum;
import workshopjdbc.entities.reply;
import workshopjdbc.services.ForumCRUD;
import workshopjdbc.services.ReplyCRUD;
import workshopjdbc.services.ServiceUtilisateur;
import workshopjdbc.utils.SharedData;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class FrontForumController implements Initializable {
    private Parent fxml;
    private Stage stage;
    private Scene scene;
   
    @FXML
    private Label Erreur;
    @FXML
  private TableColumn<forum, Integer> idID;
    @FXML
    private TableColumn<forum, Integer> idTitre;
    @FXML
    private TableColumn<forum, Integer> idMessage;
    @FXML
    private TableColumn<reply, Integer> idRep;
    @FXML
    private TableColumn<reply, Integer> idRating;
    @FXML
    private TableView<forum> tableM;
    @FXML
    private TableView<reply> tableR;
    ObservableList<reply> replyList = FXCollections.observableArrayList() ;
    private TextField tfRating;
    @FXML
    private TextArea tfreply;
    
    @FXML
    private TextField messNumber;
    @FXML
    private ImageView image;
    @FXML
    private ImageView image2;
    @FXML
    private Rating rating;
     
 Notifications no;
    String erreur;
    @FXML
    private ImageView image21;
    @FXML
    private ImageView image211;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      

    ForumCRUD fc = new ForumCRUD();
    
        idID.setCellValueFactory(new PropertyValueFactory<>("id"));
        idTitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        idMessage.setCellValueFactory(new PropertyValueFactory<>("contenu"));
         tableM.getItems().clear();
        tableM.setItems(fc.Affichertout());
         
    }
       public void refrech2() {
        
       
         ReplyCRUD rp = new ReplyCRUD();
     
        idRating.setCellValueFactory(new PropertyValueFactory<>("rating"));
        idRep.setCellValueFactory(new PropertyValueFactory<>("contenu"));
        
        tableR.getItems().clear();
        tableR.setItems(rp.Affichertout2());
    }


    
     @FXML
    private void from(ActionEvent event) {
        
          try {
            fxml = FXMLLoader.load(getClass().getResource("AjouterM.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AjouterMController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxml);
        stage.setScene(scene);
        stage.show();
    
        
        
    }
     @FXML
    private void rating(ActionEvent event) {
        
          try {
            fxml = FXMLLoader.load(getClass().getResource("rechercheRating.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AjouterMController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxml);
        stage.setScene(scene);
        stage.show();
    
        
        
    }
 



  

    @FXML
    private void enforumClick(MouseEvent event) {
         
        replyList.clear();
        
        forum p = tableM.getSelectionModel().getSelectedItem() ; 

ReplyCRUD sp = new ReplyCRUD();  
        List<reply> list = new ArrayList<>();
        list = sp.getReplys(p.getId());
        for (reply r : list) {
          
             
            replyList.add(r) ; 
          
            idRating.setCellValueFactory(new PropertyValueFactory<>("rating")) ; 
            idRep.setCellValueFactory(new PropertyValueFactory<>("contenu")) ; 
          
             
        }
         
        tableR.setItems(replyList) ; 
}
    

    @FXML
      private void ajouterReply(ActionEvent event) {
          ReplyCRUD as=new ReplyCRUD();
         int p = JOptionPane.showConfirmDialog(null,"Do you really want to Add","Add",JOptionPane.YES_NO_OPTION);
 if(p==0){
        
       StringBuilder errors=new StringBuilder();
        if (messNumber.getText().isEmpty()) {
                Erreur.setText("⚠ merci d'entrer num message  ");
                 }

        try {
            Integer.parseInt(messNumber.getText());
        } catch (NumberFormatException e) {
            Erreur.setText("le num de message juste un nombre ");
        }
          if (tfreply.getText().isEmpty()) {
                Erreur.setText("⚠ merci d'entrer votre reply ");
            } 
        else{
              
               SharedData da= new SharedData();
                Utilisateur u1 = new Utilisateur();
                ServiceUtilisateur l1 = new ServiceUtilisateur();
                u1=l1.getByidd(da.CurrentUseId);
              
              
            reply a =new reply();
             reply r = new reply( (Integer.parseInt(messNumber.getText()))    ,(tfreply.getText()),u1,u1.getEmail());
            a.setRating((int) rating.getRating());
            System.out.println("rating given by user:" + rating.getRating());
            a.setAd(Integer.parseInt(messNumber.getText()));
            a.setContenu(tfreply.getText());
             
          

    
            as.ajouterReply2(a);

            no = Notifications.create()
                    .title("Reply ajouteé ")
                    .text(erreur)
                    .graphic(null)
                    .position(Pos.TOP_CENTER)
                    .hideAfter(Duration.seconds(6));
            no.showInformation();
        }
      
        
 }
}

    
      
       @FXML
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
  

 



 


