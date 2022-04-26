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
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import javafx.scene.control.ButtonType;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author FIRAS
 */
public class BackMessageController implements Initializable {
     private Parent fxml;
    private Stage stage;
    private Scene scene;


    @FXML
    private TableView<forum> tableM;
    @FXML
    private TableColumn<forum, Integer> idID;
    @FXML
    private TableColumn<forum, String> idTitre;
    @FXML
    private TableColumn<forum, String> idMessage;

    private ForumCRUD fc ;
    
    
    
    @FXML
    private TableView<reply> tableR;
    @FXML
    private TableColumn<reply, Integer> idRep;
    @FXML
    private TableColumn<reply, Integer> idRating;
    @FXML
    private TableColumn<reply, String> idReply;
    
    private ReplyCRUD rp ;
    @FXML
    private Label mod;

    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tableM.setEditable(true);
      refrech();
        tableR.setEditable(true);
        
        refrech2();
    }    
    
    
    
    
    public void refrech() {
        
        ForumCRUD fc = new ForumCRUD();
        idID.setCellValueFactory(new PropertyValueFactory<>("id"));
        idTitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        idMessage.setCellValueFactory(new PropertyValueFactory<>("contenu"));
         tableM.getItems().clear();
        tableM.setItems(fc.Affichertout());
        
    }
     public void refrech2() {
        
       
         ReplyCRUD rp = new ReplyCRUD();
      idRep.setCellValueFactory(new PropertyValueFactory<>("id"));
        idRating.setCellValueFactory(new PropertyValueFactory<>("rating"));
        idReply.setCellValueFactory(new PropertyValueFactory<>("contenu"));
        
        tableR.getItems().clear();
        tableR.setItems(rp.Affichertout2());
    }
          @FXML
    private void message(ActionEvent event) {
        
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
    private void dell(ActionEvent event) {
        
         ForumCRUD pa = new ForumCRUD();
        forum p = new forum();
        
        p=tableM.getSelectionModel().getSelectedItem();
        pa.supprimerMessage(p);
        
        refrech();
        
    }
    
    
    @FXML
    private void dell1(ActionEvent event) {
        
         ReplyCRUD rr = new ReplyCRUD();
        reply r = new reply();
        
        r=tableR.getSelectionModel().getSelectedItem();
        rr.supprimerMessager(r);
        
        refrech2();
        
    }
 
 
     }
    
    

