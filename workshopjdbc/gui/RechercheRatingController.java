/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.gui;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import workshopjdbc.entities.reply;
import workshopjdbc.services.ReplyCRUD;

/**
 * FXML Controller class
 *
 * @author FIRAS
 */
public class RechercheRatingController implements Initializable {
      private Parent fxml;
    private Stage stage;
    private Scene scene;
     @FXML
    private TableView<reply> tableR;
    @FXML
    private TableColumn<reply, Integer> idRating;
    @FXML
    private TableColumn<reply, String> idReply;
    @FXML
    private TextField rech;
    @FXML
    private ImageView image;
    @FXML
    private ImageView image1;

 ReplyCRUD rs = new ReplyCRUD();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
         tableR.setEditable(true);
        
        refrech2();
       
              
    }    
    
     public void refrech2() {
        
       
         ReplyCRUD rp = new ReplyCRUD();
     
        idRating.setCellValueFactory(new PropertyValueFactory<>("rating"));
        idReply.setCellValueFactory(new PropertyValueFactory<>("contenu"));
        
        tableR.getItems().clear();
        tableR.setItems(rp.Affichertout2());
        searchEven();
    }
     
     
     
     
       public void searchEven(){
       
ReplyCRUD eve = new ReplyCRUD();
         ObservableList <reply> l = eve.afficherReply();        
         try{
        
          tableR.setItems(l);
          FilteredList<reply> f = new FilteredList<>(l, b -> true);
          rech.textProperty().addListener((ObservableValue<? extends String> observable, String olValue, String newValue)->{
             f.setPredicate(new Predicate<reply>() {
                 public boolean test(reply rep) {
                     if(newValue == null|| newValue.isEmpty()){
                         return true;
                     }
                     String lowerCaseFilter= newValue.toLowerCase();
                     
                     if(String.valueOf(rep.getRating()).toLowerCase().contains(lowerCaseFilter)){
                         return true;
                     }
                     else if(String.valueOf(rep.getContenu()).indexOf(lowerCaseFilter)!=-1)
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
       
       
          @FXML
    private void back(ActionEvent event) {
        
          try {
            fxml = FXMLLoader.load(getClass().getResource("frontForum.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AjouterMController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxml);
        stage.setScene(scene);
        stage.show();
    
        
        
    }
 
 
    
    
    }    

    

