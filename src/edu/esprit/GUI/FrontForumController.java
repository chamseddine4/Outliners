/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.GUI;




import edu.esprit.entities.forum;
import edu.esprit.entities.reply;

import edu.esprit.services.ForumCRUD;
import edu.esprit.services.ReplyCRUD;
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

import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class FrontForumController implements Initializable {
    private Parent fxml;
    private Stage stage;
    private Scene scene;
    private ListView<String> Lnom;
    private ListView<String> Lpub;
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
    private TableColumn<reply, Integer> id_rep;
    @FXML
    private TableView<reply> tableR;
    ObservableList<reply> replyList = FXCollections.observableArrayList() ;
    @FXML
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
    private TextField rech;
     

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
  
 

    private void reloadPub(ActionEvent event) {
        ForumCRUD ps = new ForumCRUD();
        String s = Lnom.getSelectionModel().getSelectedItem();
        System.out.println(s);

    }

    private void getPub(MouseEvent event) {
        ForumCRUD ps = new ForumCRUD();
        Lpub.getItems().clear();

        try {
            Erreur.setText("");
            System.out.println(Lnom.getSelectionModel().getSelectedItem());
            for (int i = 0; i < ps.CountUserPub(Integer.parseInt(Lnom.getSelectionModel().getSelectedItem())).size(); i++) {
                Lpub.getItems().add(ps.CountUserPub(Integer.parseInt(Lnom.getSelectionModel().getSelectedItem())).get(i).toString());
            }
        } catch (Exception e) {
            Erreur.setText("Choose an ID Please !!");
            Erreur.setTextFill(javafx.scene.paint.Color.web("RED"));

        }
        


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
            id_rep.setCellValueFactory(new PropertyValueFactory<>("id")) ; 
            idRating.setCellValueFactory(new PropertyValueFactory<>("rating")) ; 
            idRep.setCellValueFactory(new PropertyValueFactory<>("contenu")) ; 
          
             
        }
        
        
      
        
        
        
        
        
        tableR.setItems(replyList) ; searchEven();
}

    @FXML
      private void ajouterReply(ActionEvent event) {
         StringBuilder errors = new StringBuilder();
             ReplyCRUD f2 = new ReplyCRUD();
             forum k = new forum();
             reply s = new reply();
        
             if (messNumber.getText().isEmpty()) {
                Erreur.setText("merci d'entrer num message");
                 }
               // else   if (messNumber.getText().isEmpty()) {
               // Erreur.setText("merci d'entrer rating");}
             else   if (tfRating.getText().isEmpty()) {
                Erreur.setText("merci d'entrer rating");
            } else if (tfreply.getText().isEmpty()) {
                Erreur.setText(" merci d'entrer votre reply");
            } 
             else {
            reply f = new reply(Integer.parseInt(messNumber.getText()),Integer.parseInt(tfRating.getText()),(tfreply.getText()));
            ReplyCRUD P = new ReplyCRUD ();
            P.ajouterReply2(f);
            
            Alert a = new Alert(Alert.AlertType.INFORMATION,"votre reply est bien ajoutee <3 ",ButtonType.CLOSE);
            a.show();
            
            }
}
      
      
      public void searchEven(){
       
ReplyCRUD eve = new ReplyCRUD();
         ObservableList <reply> l = eve.afficherReply();        
         try{
        
          tableR.setItems(l);
          FilteredList<reply> f = new FilteredList<>(l, b -> true);
          rech.textProperty().addListener((ObservableValue<? extends String> observable, String olValue, String newValue)->{
             f.setPredicate(new Predicate<reply>() {
                 public boolean test(reply person) {
                     if(newValue == null|| newValue.isEmpty()){
                         return true;
                     }
                     String lowerCaseFilter= newValue.toLowerCase();
                     
                     if(String.valueOf(person.getRating()).toLowerCase().contains(lowerCaseFilter)){
                         return true;
                     }
                     else if(String.valueOf(person.getContenu()).indexOf(lowerCaseFilter)!=-1)
                         return true;
                     else
                         return false;
                 }

             
             });
             });
         SortedList<reply> sortedData = new SortedList<>(f);
         sortedData.comparatorProperty().bind(tableR.comparatorProperty());
         tableR.setItems(sortedData);

         }catch(Exception e){
             System.out.println(e.getMessage());
                 }  
       
    
   
     }
}
  

 



 


