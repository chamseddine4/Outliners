/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import workshopjdbc.entities.Utilisateur;
import workshopjdbc.services.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author pfeis
 */
public class ConfirmDeleteUserController  {
    
    private Utilisateur user;
    private ServiceUtilisateur userService = new ServiceUtilisateur();
   
    

    @FXML
    private Button btnDelete;
    @FXML
    private Button btnReturn;

 @FXML
    void returnToPrevious(ActionEvent event) {
        
        Parent root;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FindUserById.fxml"));
            root = (Parent)fxmlLoader.load();
            FindUserByIdController findByIdController = fxmlLoader.<FindUserByIdController>getController();
            findByIdController.setUser(user);
            Stage stage = new Stage();
            stage.setTitle("Courses infos");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        closeWindow(btnReturn);
    }
    
    
     @FXML
      void deleteCourse(ActionEvent event) throws SQLException {
        userService.delete(user.getId());
        closeWindow(btnDelete);
    }


   

    void closeWindow(Button btn){
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }
    
}
