/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pfeis
 */
public class InfoScreenController implements Initializable {

    @FXML
    private Button btnOk;
    @FXML
    private Label infoMessage;
    String message;

 @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            infoMessage.setText(message);
        });
    }

    @FXML
    void confirm(ActionEvent event) {
        Stage stage = (Stage) btnOk.getScene().getWindow();
        stage.close();
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
