/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.paiement;
import edu.esprit.entities.participation_prive;
import edu.esprit.services.PaiementCRUD;
import edu.esprit.services.PriveCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    @FXML
    private TextField rech;
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
        numeroCol.setCellValueFactory(new PropertyValueFactory<>("numeroTel"));
        nbrCol.setCellValueFactory(new PropertyValueFactory<>("nbrPrisecharge"));
      
        table.getItems().clear();
        table.setItems(pp.Affichertout());
        searchEven();
    }

    @FXML
    private void delete(ActionEvent event) {
        PriveCRUD pa = new PriveCRUD();
        participation_prive p = new participation_prive();
        
        p=table.getSelectionModel().getSelectedItem();
        pa.supprimerPrive(p);
        
        refrech();
        
        
    }
    
     public void searchEven(){
       
PriveCRUD eve = new PriveCRUD();
         ObservableList <participation_prive> l = eve.Affichertout();        
         try{
        
          table.setItems(l);
          FilteredList<participation_prive> f = new FilteredList<>(l, b -> true);
          rech.textProperty().addListener((ObservableValue<? extends String> observable, String olValue, String newValue)->{
             f.setPredicate(new Predicate<participation_prive>() {
                 public boolean test(participation_prive person) {
                     if(newValue == null|| newValue.isEmpty()){
                         return true;
                     }
                     String lowerCaseFilter= newValue.toLowerCase();
                     
                     if(String.valueOf(person.getNbrPrisecharge()).toLowerCase().contains(lowerCaseFilter)){
                         return true;
                     }
                     else if(String.valueOf(person.getNumeroTel()).indexOf(lowerCaseFilter)!=-1)
                         return true;
                     else
                         return false;
                 }

             
             });
             });
         SortedList<participation_prive> sortedData = new SortedList<>(f);
         sortedData.comparatorProperty().bind(table.comparatorProperty());
         table.setItems(sortedData);

         }catch(Exception e){
             System.out.println(e.getMessage());
                 }  
       
    
   
     }

    
    
}
