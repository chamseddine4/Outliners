/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.gui;


import workshopjdbc.entities.SDF;
import workshopjdbc.utils.MyConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import workshopjdbc.services.ServiceSDF;
import static workshopjdbc.utils.MyConnection.ConnectDb;
import java.awt.Desktop;
import java.awt.Window;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Statement;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author hp
 */
public class Back_SDFController implements Initializable {
    
  


    @FXML
    private TableView<SDF> table_stade;
    @FXML
    private TableColumn<SDF, String> col_name;
    @FXML
    private TableColumn<SDF, String> col_last_name;
    @FXML
    private TableColumn<SDF, String> col_gender;
    @FXML
    private TableColumn<SDF, Integer> col_age;

    /**
     * Initializes the controller class.
     */       private PreparedStatement pst = null;

        private ObservableList<SDF> list = FXCollections.observableArrayList();
   private ObservableList<SDF> listM;
    @FXML
    private Button bts;
    @FXML
    private Button bts2;
    @FXML
    private Button bts11;
    @FXML
    private TextField search;
    @FXML
    private Button sbt;
    private TextField TFname;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
            try {
            Connection cnx =MyConnection.getInstance().getCnx();
            ResultSet rs = cnx.createStatement().executeQuery("SELECT * FROM sdf");
            while(rs.next()){
            list.add(new SDF(rs.getInt("id"),rs.getString("name"),rs.getString("lastname"),rs.getString("gender"),rs.getInt("age")));
            
            table_stade.setItems(list);
            table_stade.refresh();
            
        }
            } catch (SQLException ex) {
            Logger.getLogger(Back_SDFController.class.getName()).log(Level.SEVERE, null, ex);
        }
            try {
            AfficherStade();
        } catch (SQLException ex) {
            Logger.getLogger(ProfilSDFController.class.getName()).log(Level.SEVERE, null, ex);
        }
           
          Connection cnx =MyConnection.getInstance().getCnx();
              List<SDF> listz = null;

       ServiceSDF ls = new ServiceSDF();
        try {
            listz = ls.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(Back_SDFController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(listz);
        table_stade.setItems(FXCollections.observableList(listz));
    }
    public void UpdateTable() throws SQLException{
            
          col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
          col_last_name.setCellValueFactory(new PropertyValueFactory<>("last_name"));
         col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        col_age.setCellValueFactory(new PropertyValueFactory<>("age"));
         listM = MyConnection.getDataSDF();
                 listM = MyConnection.getDataSDF();

        table_stade.setItems(listM);
        }
    public void AfficherStade() throws SQLException{
          col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
          col_last_name.setCellValueFactory(new PropertyValueFactory<>("last_name"));
         col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        col_age.setCellValueFactory(new PropertyValueFactory<>("age"));
               UpdateTable();

        table_stade.setItems(list);
        
        
        
    }
           private Parent fxml;
    private Stage stage;
    private Scene scene;
    private void Statis(ActionEvent event) throws IOException {
          
          /* try {
            fxml = FXMLLoader.load(getClass().getResource("Statis.fxml"));
            StatisController ap= new StatisController();
             stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxml);
        stage.setScene(scene);
        stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Back_SDFController.class.getName()).log(Level.SEVERE, null, ex);
        }
          */
           FXMLLoader loader = new FXMLLoader(getClass().getResource("Statis.fxml"));
                Parent root = loader.load();
                TFname.getScene().setRoot(root);

       
        
    }
   
        
            
        
    



    private SDF gettempSDF(TableColumn.CellEditEvent edittedcell) {
      
        SDF test = table_stade.getSelectionModel().getSelectedItem();
        return test;
    
    }
 
    @FXML
    private void SupprimerSDF(ActionEvent event)throws SQLException {
          TableColumn.CellEditEvent edittedcell = null;
        SDF x = gettempSDF(edittedcell);

        if (x != null) {

            int i = x.getId();
            ServiceSDF
                    cat = new ServiceSDF();

            int s = cat.supprimer(i);
            

            if (s == 1) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("SDF deleted");
                alert.showAndWait();
                UpdateTable();
               table_stade.refresh();
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Selection un champ SVP");
            alert.showAndWait();
        }
    }

    @FXML
    private void Modifier(ActionEvent event) throws   SQLException{
          try {
              {if (table_stade.getSelectionModel().getSelectedItem()!=null)
             fxml = FXMLLoader.load(getClass().getResource("modifiersdf.fxml"));
            
              // ModifiersdfController apc= new ModifiersdfController();
              //apc.saveData(table_stade.getSelectionModel().getSelectedItem());
             }
        } catch (IOException ex) {
            Logger.getLogger(AjouterMController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxml);
        stage.setScene(scene);
        stage.show();
        
    }
         
        
    
    

   
  private Stage primaryStage;
    @FXML
    private void imprimer(ActionEvent event) {
      
       
  
         System.out.println("To Printer!");
         PrinterJob job = PrinterJob.createPrinterJob();
           if(job != null){
    Window primaryStage = null;
           job.showPrintDialog(this.primaryStage); 
            
    Node root = this.table_stade;
           job.printPage(root);
           job.endJob();
    }
    }

    @FXML
    private void search(ActionEvent event)throws SQLException {
         Connection conn = ConnectDb();
      
        String value9 = search.getText();
      
            PreparedStatement ps = conn.prepareStatement("select * from sdf where name Like'"+value9+"'");
            
            ResultSet rs = ps.executeQuery();
          
           while (rs.next()){ 
               
              table_stade.refresh();
               AfficherStade();
              
          list.add(new SDF(rs.getInt("id"),rs.getString("name"),rs.getString("lastname"),rs.getString("gender"),rs.getInt("age")));
                 col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
         col_last_name.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        col_age.setCellValueFactory(new PropertyValueFactory<>("age"));
                     UpdateTable();

         table_stade.setItems(list);
           }
    
         
    }

    private void ajouter(ActionEvent event) {
          try {
            fxml = FXMLLoader.load(getClass().getResource("profilSDF.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AjouterMController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxml);
        stage.setScene(scene);
        stage.show();
        
    }


    private void calender(ActionEvent event) {
         try {
            fxml = FXMLLoader.load(getClass().getResource("calender.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AjouterMController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxml);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void admin21(ActionEvent event){
      /*  try { 
                 
              
                com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
                PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\hp\\Desktop\\paiement.pdf"));
                doc.open();
                PdfWriter.class.getInterfaces()
                
                doc.add(new Paragraph(" "));   
               doc.add(new Paragraph("liste des SDF : "));
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
            PdfPCell c = new PdfPCell(new Phrase("name"));
            c.setHorizontalAlignment(Element.ALIGN_CENTER);
            c.setBackgroundColor(BaseColor.GRAY);
            t.addCell(c);
          
            doc.add(t);
                  PdfPCell c6 = new PdfPCell(new Phrase("last name"));
            c.setHorizontalAlignment(Element.ALIGN_CENTER);
            c6.setBackgroundColor(BaseColor.GRAY);
            t.addCell(c6);
          
            doc.add(t);
            
                PdfPCell c7 = new PdfPCell(new Phrase("gender"));
            c7.setHorizontalAlignment(Element.ALIGN_CENTER);
            c7.setBackgroundColor(BaseColor.GRAY);
            t.addCell(c7);
          
            doc.add(t);
                PdfPCell c8 = new PdfPCell(new Phrase("age"));
            c8.setHorizontalAlignment(Element.ALIGN_CENTER);
            c8.setBackgroundColor(BaseColor.GRAY);
            t.addCell(c8);
          
            doc.add(t);
                
            
            
            
            
               Connection cnx =Myconnection.getInstance().getCnx();
            String query = "select * from sdf";
            Statement stmt = null;
            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            Paragraph p3 = null;
                PdfPTable table = new PdfPTable(5);
                 table.setWidthPercentage(100);
               while(rs.next()){ 
           
                 
            PdfPCell  c1 = new PdfPCell(new Phrase(rs.getString("name")));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setBackgroundColor(BaseColor.WHITE);
            table.addCell(c1);
                 PdfPCell  c2 = new PdfPCell(new Phrase(rs.getString("last_name")));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setBackgroundColor(BaseColor.WHITE);
            table.addCell(c2);
            PdfPCell  c3 = new PdfPCell(new Phrase(rs.getString("gender")));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setBackgroundColor(BaseColor.WHITE);
            table.addCell(c3);
            PdfPCell  c4 = new PdfPCell(new Phrase(rs.getString("age")));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setBackgroundColor(BaseColor.WHITE);
            table.addCell(c4);
           
            
             
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
                Desktop.getDesktop().open(new File("C:\\Users\\hp\\Desktop\\paiement.pdf"));
             } catch (Exception e) {
          System.err.print(e);
        }
  */
        
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
