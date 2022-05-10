/* BACKEND */
package workshopjdbc.gui;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import workshopjdbc.services.EvenementCRUD;
import workshopjdbc.utils.MyConnection;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
import workshopjdbc.entities.Evenement;











/**
 * FXML Controller class
 *
 * @author ASUS
 */




















public class EvenementController   implements Initializable {
    @FXML
    private TextField tfnom_e;
   
       private  Parent fxml ; 
       private  Stage stage ; 
       private Scene scene ; 
    @FXML
    private DatePicker tfdate_debut;
    @FXML
    private DatePicker tfdate_fin;
    @FXML
    private Button Btn_modifier_e;
    @FXML
    private Button Btn_ajouter_e;
    @FXML
    private Button Btn_supprimer_e;
    @FXML
    private TableView<Evenement> table_e;
    @FXML
    private TableColumn<Evenement, String> nom_e;
  
     int index=-1;
    @FXML
    private TableColumn<Evenement, Date> date_debut;
    @FXML
    private TableColumn<Evenement, Date> date_fin;
    public ObservableList<Evenement> data=FXCollections.observableArrayList();
    @FXML
    private Button Btn_vider_e;
    @FXML
   
   
    private TextField desc;
    @FXML
    private TableColumn<Evenement, String> type_e;
    @FXML
    private TableColumn<Evenement, String> des_e;
    @FXML
    private TextField typee;
    @FXML
    private TextField tsrearch;
    @FXML
    private Button pdf;

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
        Matcher m = p.matcher(tfnom_e.getText());
        if(m.find() && m.group().equals(tfnom_e.getText())){
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
  
      private boolean date_DF() {
          if(tfdate_debut.getValue().compareTo(tfdate_fin.getValue()) >0) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Type validé !");
                alert.setHeaderText(null);
                alert.setContentText("Attention la date de début doit  être inférieur à la date de fin !");
                alert.showAndWait();
                return false;
          }
          else 
          return true;

          
        
      }
    @FXML
      void getSelected(MouseEvent event){
     index=table_e.getSelectionModel().getSelectedIndex();
     if(index<=-1){
         return ;
     }
     tfnom_e.setText(nom_e.getCellData(index).toString());
     typee.setText(type_e.getCellData(index).toString());
     
     
     tfdate_debut.setValue(date_debut.getCellData(index).toLocalDate());
     tfdate_fin.setValue(date_fin.getCellData(index).toLocalDate());
desc.setText(des_e.getCellData(index).toString());
      

     }

      
     
     
    @FXML
    private void modifier_e(ActionEvent event) {
         if(nom_evalide()&& date_DF() ){
        String nom_ev=tfnom_e.getText();
        String type_ev=typee.getText();
        
        String des_ev=desc.getText();
        
        Date date_debut_ev = Date.valueOf(tfdate_debut.getValue());
        Date date_fin_ev =  Date.valueOf(tfdate_fin.getValue());
        Evenement e=new Evenement();
      e.setNom(nom_ev);
      e.setType_e(type_ev);
     
      
      e.setDate_debut(date_debut_ev);
      e.setDate_fin(date_fin_ev);
       e.setDescription(des_ev);
        EvenementCRUD ev=new EvenementCRUD();
        e=table_e.getSelectionModel().getSelectedItem();
            
        ev.modifier_evenement(e, nom_ev,type_ev, date_debut_ev, date_fin_ev,des_ev);
       // updateTable_e();
//        tfnom_e.clear();
//        
////        type_e.clear();
////        des_e.clear();
//        tfdate_debut.setValue(null);
//        tfdate_fin.setValue(null);  
   show();

         } }

    

    
    @FXML
    private void ajouter_e(ActionEvent event) {
         if(nom_evalide() && date_DF()){
        
        
       
        
        
        
        
        
        
         String nom_ev=tfnom_e.getText();
        String type_ev=typee.getText();
        
        String des_ev=desc.getText();
        
        Date date_debut_ev = Date.valueOf(tfdate_debut.getValue());
        Date date_fin_ev =  Date.valueOf(tfdate_fin.getValue());
        Evenement e=new Evenement();
      e.setNom(nom_ev);
      e.setType_e(type_ev);
      e.setDescription(des_ev);
      
      e.setDate_debut(date_debut_ev);
      e.setDate_fin(date_fin_ev);
        EvenementCRUD ev=new EvenementCRUD();
       
        
        
        
        
        Notifications notificationBuilder = Notifications.create()
                 .title("Information").text("evenement ajouter .").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
                 .position(Pos.BASELINE_LEFT)
                 .onAction(new EventHandler<ActionEvent>() 
                 {
                        public void handle(ActionEvent Event)
                        {
                            System.out.println("clicked on");
                        }
                });
         notificationBuilder.darkStyle();
         notificationBuilder.show();
        
        
        
        ev.ajouter_evenement(e);
       // updateTable_e();
           show();

      
         }}

    @FXML
    private void supprimer_e(ActionEvent event) {
         EvenementCRUD eve = new EvenementCRUD();
              Evenement e= new Evenement();   
              e= table_e.getSelectionModel().getSelectedItem();
              eve.supprimer_evenement(e);
          //  updateTable_e();
             show();

             
    }
    
    
    
    

    
    
    
    
    
    
       public void show(){
           EvenementCRUD ev = new EvenementCRUD();
            ObservableList<Evenement> list = ev.listerEvenements();
            
         
                nom_e.setCellValueFactory(new PropertyValueFactory<Evenement,String>("nom")); 
               type_e.setCellValueFactory(new PropertyValueFactory<Evenement,String>("type_e"));
                  des_e.setCellValueFactory(new PropertyValueFactory<Evenement,String>("description"));
               date_debut.setCellValueFactory(new PropertyValueFactory<Evenement,Date>("date_debut"));
               date_fin.setCellValueFactory(new PropertyValueFactory<Evenement,Date>("date_fin"));
                 table_e.setItems(list);
             //    updateTable_e();
                searchEven(); 
                
    }
        public void searchEven(){
       
EvenementCRUD eve = new EvenementCRUD();
         ObservableList <Evenement> l = eve.listerEvenements();        
         try{
        
          table_e.setItems(l);
          FilteredList<Evenement> f = new FilteredList<>(l, b -> true);
          tsrearch.textProperty().addListener((ObservableValue<? extends String> observable, String olValue, String newValue)->{
             f.setPredicate(new Predicate<Evenement>() {
                 public boolean test(Evenement person) {
                     if(newValue == null|| newValue.isEmpty()){
                         return true;
                     }
                     String lowerCaseFilter= newValue.toLowerCase();
                     
                     if(person.getNom().toLowerCase().contains(lowerCaseFilter)){
                         return true;
                     }
                     else if(String.valueOf(person.getType_e()).indexOf(lowerCaseFilter)!=-1)
                         return true;
                     else
                         return false;
                 }

             
             });
             });
         SortedList<Evenement> sortedData = new SortedList<>(f);
         sortedData.comparatorProperty().bind(table_e.comparatorProperty());
         table_e.setItems(sortedData);

         }catch(Exception e){
             System.out.println(e.getMessage());
             
         }  
       
         
     }

    @FXML
    private void vider_e(ActionEvent event) {
          tfnom_e.clear();
        
        desc.clear();
        typee.clear();
        tfdate_debut.setValue(null);
        tfdate_fin.setValue(null);  
    }
    
    
    
//     public void searchEven(){
//       
//
//         ObservableList <Evenement> l = eve.listerEvenements();        
//         try{
//        
//          table_e.setItems(l);
//          FilteredList<Evenement> f = new FilteredList<>(l, b -> true);
//          tsrearch.textProperty().addListener((ObservableValue<? extends String> observable, String olValue, String newValue)->{
//             f.setPredicate(new Predicate<Evenement>() {
//                 public boolean test(Evenement person) {
//                     if(newValue == null|| newValue.isEmpty()){
//                         return true;
//                     }
//                     String lowerCaseFilter= newValue.toLowerCase();
//                     
//                     if(person.getNom().toLowerCase().contains(lowerCaseFilter)){
//                         return true;
//                     }
//                     else if(String.valueOf(person.getId()).indexOf(lowerCaseFilter)!=-1)
//                         return true;
//                     else
//                         return false;
//                 }
//
//             
//             });
//             });
//         SortedList<Evenement> sortedData = new SortedList<>(f);
//         sortedData.comparatorProperty().bind(table_e.comparatorProperty());
//         table_e.setItems(sortedData);
//
//         }catch(Exception e){
//             System.out.println(e.getMessage());
//             
//         }  
//       
//         
//     }
    
    
    
    
//      public void transferMessage(String loc ) {
//       
//       label.setText(loc);
//   }

   

//    @FXML
//    private void GoToMap(ActionEvent event) {
//         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//     
//        showMap(stage);
//        
//    }

    @FXML
    private void pdf(ActionEvent event) throws IOException {
       
    try { 
                 
              
                Document doc = new Document();
                PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\ziedm\\Desktop\\ev.pdf"));
                doc.open();
                
                
                doc.add(new Paragraph(" "));
               doc.add(new Paragraph("liste des evenements : "));
               doc.add(new Paragraph(" "));
                
                
//                 Paragraph p =new Paragraph();
//                p.add("liste de produit");
//              
//                
//                 
//                
//                
//             doc.add(p);
             
                 PdfPTable t = new PdfPTable(5);
                 t.setWidthPercentage(100);
            PdfPCell c = new PdfPCell(new Phrase("nom"));
            c.setHorizontalAlignment(Element.ALIGN_CENTER);
            c.setBackgroundColor(BaseColor.GRAY);
            t.addCell(c);
             c = new PdfPCell(new Phrase("type_e"));
             c.setHorizontalAlignment(Element.ALIGN_CENTER);
            c.setBackgroundColor(BaseColor.GRAY);
            t.addCell(c);
              c = new PdfPCell(new Phrase("date_debut"));
              c.setHorizontalAlignment(Element.ALIGN_CENTER);
            c.setBackgroundColor(BaseColor.GRAY);
            t.addCell(c);
              c = new PdfPCell(new Phrase("date_fin"));
              c.setHorizontalAlignment(Element.ALIGN_CENTER);
            c.setBackgroundColor(BaseColor.GRAY);
            t.addCell(c);
             c = new PdfPCell(new Phrase("description"));
              c.setHorizontalAlignment(Element.ALIGN_CENTER);
            c.setBackgroundColor(BaseColor.GRAY);
            t.addCell(c);
            
            
            doc.add(t);
               
            
            Connection cnx =MyConnection.getInstance().getCnx();
            String query = "select * from evenements";
            Statement stmt = null;
            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            Paragraph p3 = null;
                PdfPTable table = new PdfPTable(5);
                 table.setWidthPercentage(100);
               while(rs.next()){ 
           
                 
            PdfPCell  c1 = new PdfPCell(new Phrase(rs.getString("nom")));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setBackgroundColor(BaseColor.WHITE);
            table.addCell(c1);
                 
             c1 = new PdfPCell(new Phrase(rs.getString("type_e")));
             c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setBackgroundColor(BaseColor.WHITE);
            table.addCell(c1);
                 
             c1 = new PdfPCell(new Phrase(rs.getString("date_debut")));
             c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setBackgroundColor(BaseColor.WHITE);
            table.addCell(c1);
             c1 = new PdfPCell(new Phrase(rs.getString("date_fin")));
             c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setBackgroundColor(BaseColor.WHITE);
            table.addCell(c1);
            
             c1 = new PdfPCell(new Phrase(rs.getString("description")));
             c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setBackgroundColor(BaseColor.WHITE);
            table.addCell(c1);
             
               }
               
         // table.setHeaderRows(1);
//         ObservableList<Produit> list = (ObservableList<Produit>) ps.afficherProduit();
 //  colids.setCellValueFactory(new PropertyValueFactory<Produit,Integer>("id"));
//      colprix.setCellValueFactory(new PropertyValueFactory<Produit,Integer>("prix"));
//      colquan.setCellValueFactory(new PropertyValueFactory<Produit,Integer>("quantite"));
//      date_exp.setCellValueFactory(new PropertyValueFactory<Produit,Date>("date_exp"));
//      coltype.setCellValueFactory(new PropertyValueFactory<Produit,String>("type"));
//     
//        tab_s.setItems(list);
       
//        table.addCell("");
//   table.addCell("1.1");
//             table.addCell("1.2");
//               table.addCell("2.1");
//                table.addCell("2.2");
//                 table.addCell("2.3");
                doc.add(table);
                
                doc.close();
                Desktop.getDesktop().open(new File("C:\\Users\\ziedm\\Desktop\\ev.pdf"));
             } catch (Exception e) {
          System.err.print(e);
        }
  
    
    }
    
  
       
       
      @FXML
    public void admin (ActionEvent event) throws IOException {
        try {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Accueiladmin.fxml"));

                    fxml = loader.load();
                  
                } catch (IOException ex) {
                    Logger.getLogger(SigninController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(fxml);
                stage.setScene(scene);
                stage.show();
    }
       
       @FXML
    public void user(ActionEvent event) throws IOException {
        try {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Backuser.fxml"));

                    fxml = loader.load();
                  
                } catch (IOException ex) {
                    Logger.getLogger(SigninController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(fxml);
                stage.setScene(scene);
                stage.show();
        
            
            
        } 
    
    private void back5 (ActionEvent event) throws IOException {
        
           try {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Signin.fxml"));

                    fxml = loader.load();
                  
                } catch (IOException ex) {
                    Logger.getLogger(SigninController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(fxml);
                stage.setScene(scene);
                stage.show();
    
    }
    
    
 
            
                
       @FXML
    private void reclamation (ActionEvent event) throws IOException {
        
           try {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("backReclamation.fxml"));

                    fxml = loader.load();
                  
                } catch (IOException ex) {
                    Logger.getLogger(SigninController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(fxml);
                stage.setScene(scene);
                stage.show();
    
    }
    
    
                    
       @FXML
    private void profilSDF (ActionEvent event) throws IOException {
        
           try {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("back_SDF.fxml"));

                    fxml = loader.load();
                  
                } catch (IOException ex) {
                    Logger.getLogger(SigninController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(fxml);
                stage.setScene(scene);
                stage.show();
    
    }
 
    
    
           @FXML
    private void ppublic (ActionEvent event) throws IOException {
        
           try {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("backPublic.fxml"));

                    fxml = loader.load();
                  
                } catch (IOException ex) {
                    Logger.getLogger(SigninController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(fxml);
                stage.setScene(scene);
                stage.show();
    
    }
    
    
       
           @FXML
    private void prive (ActionEvent event) throws IOException {
        
           try {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("back.fxml"));

                    fxml = loader.load();
                  
                } catch (IOException ex) {
                    Logger.getLogger(SigninController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(fxml);
                stage.setScene(scene);
                stage.show();
    
    }
    
          
           @FXML
    private void Evenement (ActionEvent event) throws IOException {
        
           try {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Evenement.fxml"));

                    fxml = loader.load();
                  
                } catch (IOException ex) {
                    Logger.getLogger(SigninController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(fxml);
                stage.setScene(scene);
                stage.show();
    
    }
    
               @FXML
    private void forum (ActionEvent event) throws IOException {
        
           try {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("backMessage.fxml"));

                    fxml = loader.load();
                  
                } catch (IOException ex) {
                    Logger.getLogger(SigninController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(fxml);
                stage.setScene(scene);
                stage.show();
    
    }
    
    
}
