/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.participation_prive;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ziedm
 */
public class BackController implements Initializable {

    @FXML
    private TableView<participation_prive> table;
    @FXML
    private TableColumn<participation_prive, Integer> idCol;
    @FXML
    private TableColumn<participation_prive, Integer> numeroCol;
    @FXML
    private TableColumn<participation_prive, Integer> nbrCol;

    
    private PriveCRUD pp ;
    
    
     private  Parent fxml ; 
       private  Stage stage ; 
       private Scene scene ; 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        table.setEditable(true);
        refrech();
        
        
    }    
 
    @FXML
    public void back2(ActionEvent event) throws IOException {
        try {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("BackPublic.fxml"));

                    fxml = loader.load();
                  
                } catch (IOException ex) {
                    Logger.getLogger(BackController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(fxml);
                stage.setScene(scene);
                stage.show();
        
            
            
        } 
    
    
    @FXML
    public void back3(ActionEvent event) throws IOException {
        try {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("backPaiement.fxml"));

                    fxml = loader.load();
                  
                } catch (IOException ex) {
                    Logger.getLogger(BackController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(fxml);
                stage.setScene(scene);
                stage.show();
   
        } 
    
    
    
    
    public void refrech() {
        
        PriveCRUD pp = new PriveCRUD();
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        numeroCol.setCellValueFactory(new PropertyValueFactory<>("numero_tel"));
        nbrCol.setCellValueFactory(new PropertyValueFactory<>("nbrPrisecharge"));
      
        
        table.getItems().clear();
        table.setItems(pp.Affichertout());
    }

    
    
}
