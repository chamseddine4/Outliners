/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.gui;

import workshopjdbc.services.EvenementCRUD;
import workshopjdbc.services.categoryCRUD;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import workshopjdbc.entities.category;

/**
 * FXML Controller class
 *
 * @author Dhia
 */
public class CategoryController implements Initializable {

    @FXML
    private TableView<category> tab;
    @FXML
    private TableColumn<category, String> nom_c;
    @FXML
    private TextField nom_e;

    
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        show();
       
        // TODO
    }    
     private boolean nom_evalide(){
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(nom_e.getText());
        if(m.find() && m.group().equals(nom_e.getText())){
            return true;
        }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Type validé !");
                alert.setHeaderText(null);
                alert.setContentText("Veuillez entrer un nom validé !");
                alert.showAndWait();
           
            return false;            
        }
     }
  
        
        
   
      public void show(){
           categoryCRUD ev = new categoryCRUD();
            ObservableList<category> list = ev.listercategory();
            
         
                nom_c.setCellValueFactory(new PropertyValueFactory<category,String>("nom")); 
             
                 tab.setItems(list);
             //    updateTable_e();
            //    searchEven(); 
                
    }

    @FXML
    private void ajouter_e(ActionEvent event) {
        if (nom_evalide()){
            String nome=nom_e.getText();
       
        
     
        category e=new category();
      e.setNom(nome);
    
        categoryCRUD c =new categoryCRUD();
      c.ajouter_category(e);
      show();
    }}

    @FXML
    private void delll(ActionEvent event) {
        categoryCRUD eve = new categoryCRUD();
              category e= new category();   
              e= tab.getSelectionModel().getSelectedItem();
              eve.supprimer_category(e);
          //  updateTable_e();
             show();
    }

    @FXML
    private void modif(ActionEvent event) {
        if(nom_evalide()){
        
         
        String nom_ev=nom_e.getText();
        
        category e=new category();
      e.setNom(nom_ev);
   
       categoryCRUD ev = new categoryCRUD();
        e=tab.getSelectionModel().getSelectedItem();
            
        ev.modifier_category(e, nom_ev);
       // updateTable_e();
//        tfnom_e.clear();
//        
////        type_e.clear();
////        des_e.clear();
//        tfdate_debut.setValue(null);
//        tfdate_fin.setValue(null);  
   show();
        
        
        }
          }
    
    
    
    

     
    }    
    

