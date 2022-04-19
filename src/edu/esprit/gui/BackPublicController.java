/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.participation_public;
import edu.esprit.services.ParticipationCRUD;
import edu.esprit.services.PriveCRUD;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ziedm
 */
public class BackPublicController implements Initializable {

    @FXML
    private TableColumn<participation_public, Integer> idId;
    @FXML
    private TableColumn<participation_public, Integer> idDon;
    @FXML
    private TableView<participation_public> tablePublic;

    
    private ParticipationCRUD pu;
    
     private  Parent fxml ; 
       private  Stage stage ; 
       private Scene scene ; 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
        tablePublic.setEditable(true);
        refrech();
        
    }    
    @FXML
    public void back5(ActionEvent event) throws IOException {
        try {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("backPaiement.fxml"));

                    fxml = loader.load();
                  
                } catch (IOException ex) {
                    Logger.getLogger(BackPublicController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(fxml);
                stage.setScene(scene);
                stage.show();
   
        } 
    
        @FXML
    public void privee(ActionEvent event) throws IOException {
        try {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("back.fxml"));

                    fxml = loader.load();
                  
                } catch (IOException ex) {
                    Logger.getLogger(BackPublicController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(fxml);
                stage.setScene(scene);
                stage.show();
   
        } 
    
    
     public void refrech() {
        
        ParticipationCRUD pu = new ParticipationCRUD();
        idId.setCellValueFactory(new PropertyValueFactory<>("id"));
        idDon.setCellValueFactory(new PropertyValueFactory<>("donation"));
   
      
        
        tablePublic.getItems().clear();
        tablePublic.setItems(pu.Affichertout());
    }
    
}
