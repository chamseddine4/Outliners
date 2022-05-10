/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.gui;


import static workshopjdbc.gui.ProfilSDFController.showAlert;
import workshopjdbc.entities.SDF;
import workshopjdbc.services.IServicee;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import java.sql.SQLException;
import javafx.scene.control.ButtonType;
import workshopjdbc.services.ServiceSDF;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author hp
 */
public class ModifiersdfController implements Initializable {

    @FXML
    private Label Erreur;
    @FXML
    private Button bta;
    @FXML
    private TextField TFname;
    @FXML
    private TextField TFlastname;
    @FXML
    private ComboBox TFgender;
    @FXML
    private Spinner<Integer> TFage;
    @FXML
    private ImageView TFimage;


    /**
     * Initializes the controller class.
     */
            SDF sdf;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         SpinnerValueFactory<Integer>valueFactory=new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100);
        valueFactory.setValue(1);
TFage.setValueFactory(valueFactory);
        TFgender.getItems().addAll("male","female");
      
    }    
       private boolean controleDeSaisi() {  

        if (TFname.getText().isEmpty() || TFlastname.getText().isEmpty() || TFgender.getSelectionModel().isEmpty()
                ) {
            showAlert(Alert.AlertType.ERROR, "Données erronés", "Verifier les données", "Veuillez bien remplir tous les champs !");
            return false;
        } else {

            if (!Pattern.matches("[A-z]*", TFname.getText())) {
                showAlert(Alert.AlertType.ERROR, "Données erronés", "Verifier les données", "le nom doit etre une chaine de caracteres ! ");
                TFname.requestFocus();
                TFname.selectEnd();
                return false;}
                if (!Pattern.matches("[A-z]*", TFlastname.getText())) {
                showAlert(Alert.AlertType.ERROR, "Données erronés", "Verifier les données", "last name doit etre une chaine de caracteres ! ");
                TFname.requestFocus();
                TFname.selectEnd();
                return false;
                
            }
                  
                                
            }

    return true;}
       
    
    void saveData(SDF s) {
this.sdf=s;
this.TFname.setText(sdf.getName());
        this.TFlastname.setText(sdf.getLast_name());
        this.TFgender.setValue(sdf.getGender());
      this.TFage.getValue();
        
      
}
      private Parent fxml;
         private Stage stage;
    private Scene scene;
    @FXML
    private void setdata(ActionEvent event)throws SQLException {
        try { 
         if(controleDeSaisi())
            sdf.setName(this.TFname.getText());
        sdf.setLast_name(this.TFlastname.getText());
        sdf.setGender((String) this.TFgender.getValue());
        sdf.setAge(TFage.getValue());
        ServiceSDF n=new ServiceSDF();
        n.modifier(sdf);
          Alert a = new Alert(Alert.AlertType.INFORMATION, "SDF added !", ButtonType.OK);
                a.showAndWait();
                fxml = FXMLLoader.load(getClass().getResource("back_SDF.fxml")); } catch (IOException ex) {
            Logger.getLogger(Back_SDFController.class.getName()).log(Level.SEVERE, null, ex);
        }  stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxml);
        stage.setScene(scene);
        stage.show();}
        //////////////////////////
        @FXML
    private void selectgender(ActionEvent event) {
    }

    @FXML
    private void image(ActionEvent event) {
    }
   
    }
         
    

  

   

   
