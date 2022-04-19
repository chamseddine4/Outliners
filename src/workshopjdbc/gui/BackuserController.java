/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.gui;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import workshopjdbc.entities.Utilisateur;
import workshopjdbc.services.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author pfeis
 */
public class BackuserController implements Initializable {

    @FXML
    private TableView<Utilisateur> tabluser;
    @FXML
    private TableColumn<Utilisateur,String> usernameCol;
    @FXML
    private TableColumn<Utilisateur, String > emailCol;
    @FXML
    private TableColumn<Utilisateur, String> passwordCol;
    @FXML
    private TableColumn<Utilisateur, String > roleCol;
    private ServiceUtilisateur SU ; 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      tabluser.setEditable(true);
        refrech();
    }   
    
    public void refrech() {
        
        ServiceUtilisateur SU = new ServiceUtilisateur();
      
        usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        passwordCol.setCellValueFactory(new PropertyValueFactory<>("password"));
        roleCol.setCellValueFactory(new PropertyValueFactory<>("roles"));
        
        tabluser.getItems().clear();
        tabluser.setItems(SU.Affichertout());
    }
    
    
    
    
}
