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
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author FIRAS
 */
public class BackMessageController implements Initializable {

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
}
