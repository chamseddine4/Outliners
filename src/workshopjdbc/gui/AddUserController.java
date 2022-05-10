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
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import workshopjdbc.entities.Utilisateur;
import workshopjdbc.services.ServiceUtilisateur;
import workshopjdbc.utils.Mail;

/**
 * FXML Controller class
 *
 * @author pfeis
 */
public class AddUserController implements Initializable {

    @FXML
    private TextArea taEmail;
    @FXML
    private TextField tfUsername;
    @FXML
    private TextField tfPassword;
    @FXML
    private Button buttonAdd;
    
      private Utilisateur user;

    Alert a = new Alert(Alert.AlertType.NONE);
   

  public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    ServiceUtilisateur ServiceUtilisateur = new ServiceUtilisateur();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Platform.runLater(() -> {
            if (user != null) {
                buttonAdd.setText("Update");
                taEmail.setText(user.getEmail());
                tfUsername.setText(user.getUsername());
                
                //tfPassword.setDisable(true);
            }
        });

    }

    @FXML
    void ajouter(ActionEvent event) throws SQLException {
        Utilisateur newUser = new Utilisateur(taEmail.getText(), tfPassword.getText(), tfUsername.getText());
        if (user == null) {
            if (taEmail.getText().isEmpty() || tfPassword.getText().isEmpty() || tfUsername.getText().isEmpty()) {
                a.setAlertType(Alert.AlertType.WARNING);
                a.setContentText("Some Fields Are Empty Please check ! ");
                a.show();
            } else {
                ServiceUtilisateur.add(newUser);
                Mail mailer = new Mail();
                mailer.sendEmail(newUser.getEmail(), "Account Successfuly Created !");
                openInfoScreen("Added new User successfully");
            }

        } else {
            if (taEmail.getText().isEmpty() || tfPassword.getText().isEmpty() || tfUsername.getText().isEmpty()) {
                a.setAlertType(Alert.AlertType.WARNING);
                a.setContentText("Some Fields Are Empty Please check ! ");
                a.show();
            } else {
                newUser.setId(user.getId());
                newUser.setPassword(user.getPassword());
                 newUser.setUsername(user.getUsername());
                
                ServiceUtilisateur.update(newUser);
                Mail mailer = new Mail();
                mailer.sendEmail(newUser.getEmail(), "Account Successfuly Updated !");

                openInfoScreen("User updated successfully");
            }

        }
    }

    void openInfoScreen(String message) {
        Parent root;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InfoScreen.fxml"));
            root = (Parent) fxmlLoader.load();
            InfoScreenController infoScreenController = fxmlLoader.<InfoScreenController>getController();
            infoScreenController.setMessage(message);
            Stage stage = new Stage();
            stage.setTitle("Confirmation");
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
