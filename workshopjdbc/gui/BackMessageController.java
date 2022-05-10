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
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javafx.scene.control.ButtonType;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import workshopjdbc.entities.Utilisateur;
import workshopjdbc.entities.forum;
import workshopjdbc.entities.reply;
import workshopjdbc.services.ForumCRUD;
import workshopjdbc.services.ReplyCRUD;
import workshopjdbc.services.ServiceUtilisateur;
import workshopjdbc.utils.MyConnection;
import workshopjdbc.utils.SharedData;
/**
 * FXML Controller class
 *
 * @author FIRAS
 */
public class BackMessageController implements Initializable {
     private Parent fxml;
    private Stage stage;
    private Scene scene;


    @FXML
    private TableView<forum> tableM;
    @FXML
    private TableColumn<forum, String> idTitre;
    @FXML
    private TableColumn<forum, String> idMessage;

    private ForumCRUD fc ;
    
    
    
    @FXML
    private TableView<reply> tableR;
    @FXML
    private TableColumn<reply, Integer> idRating;
    @FXML
    private TableColumn<reply, String> idReply;
    
    private ReplyCRUD rp ;
    @FXML
    private Label mod;
    @FXML
    private TextField modifR;
    @FXML
    private TextField modifREP;

    ObservableList<String> ss = FXCollections.observableArrayList();
    
  private PreparedStatement pst = null ;
  Notifications no;
    String erreur;
    ObservableList<reply> data=FXCollections.observableArrayList();
    @FXML
    private ComboBox<String> combotri;
    @FXML
    private ImageView kr;
    @FXML
    private Button btntri;
    ReplyCRUD rt = new ReplyCRUD();
    @FXML
    private TableColumn<?, ?> EmailR;
    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {
        ss.add("Par Rating");
            
        
        // TODO
        combotri.setItems(ss);

    tableM.setEditable(true);
      refrech();
        tableR.setEditable(true);
        
        refrech2();
        
          try { 
            initialiserlist();
            
        } catch (SQLException ex)
 {
            Logger.getLogger(BackMessageController.class.getName()).log(Level.SEVERE, null, ex);
        }
         try {
             QrCode();
         } catch (WriterException ex) {
             Logger.getLogger(BackMessageController.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(BackMessageController.class.getName()).log(Level.SEVERE, null, ex);
         }
                try {
                    
                    initialiserlist();
                    
                    
                } catch (SQLException ex)
                    
                    
                {
                    Logger.getLogger(BackMessageController.class.getName()).log(Level.SEVERE, null, ex);
                }
             
    } 
    
      public void initialiserlist() throws SQLException{
             try {
            Connection cnx = MyConnection.getInstance().getCnx();
            ResultSet rs = cnx.createStatement().executeQuery("SELECT * FROM reply");
         
            } catch (SQLException ex) {
            Logger.getLogger(BackMessageController.class.getName()).log(Level.SEVERE, null, ex);
        }
      

    } 
   
    
    public void refrech() {
        
        
         SharedData da = new SharedData();
         ServiceUtilisateur s1 = new ServiceUtilisateur();
         Utilisateur u1 = new Utilisateur();
         u1=s1.getByidd(da.CurrentUseId);
        
        ForumCRUD fc = new ForumCRUD();
       
        idTitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        idMessage.setCellValueFactory(new PropertyValueFactory<>("contenu"));
        EmailR.setCellValueFactory(new PropertyValueFactory<>("email"));
         tableM.getItems().clear();
        tableM.setItems(fc.Affichertout());
        
    }
     public void refrech2() {
        
       
         ReplyCRUD rp = new ReplyCRUD();
   
        idRating.setCellValueFactory(new PropertyValueFactory<>("rating"));
        idReply.setCellValueFactory(new PropertyValueFactory<>("contenu"));
        
        tableR.getItems().clear();
        tableR.setItems(rp.Affichertout2());
    }
    private void message(ActionEvent event) {
        
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

   @FXML
    private void dell(ActionEvent event) {
        
         ForumCRUD pa = new ForumCRUD();
        forum p = new forum();
        
        p=tableM.getSelectionModel().getSelectedItem();
        pa.supprimerMessage(p);
        
        refrech();
        
    }
    
    
    @FXML
    private void dell1(ActionEvent event) {
        
         ReplyCRUD rr = new ReplyCRUD();
        reply r = new reply();
        
        r=tableR.getSelectionModel().getSelectedItem();
        rr.supprimerMessager(r);
        
        refrech2();
        
    }
public reply gettempReply(TableColumn.CellEditEvent edittedCell) {
      reply test = tableR.getSelectionModel().getSelectedItem();
       return test;
  }
    private void getSelected(javafx.scene.input.MouseEvent event) throws SQLException {
        
        int index = tableR.getSelectionModel().getSelectedIndex();
    if (index <= -1){
    
        return;
    }
    

 
           Connection cnx = MyConnection.getInstance().getCnx();
            
     //ResultSet rsd =null ;
    TableColumn.CellEditEvent edittedcell = null;
        reply r = gettempReply(edittedcell);
         //date to localdate
        
    modifR.setText(idRating.getCellData(index).toString());
    modifREP.setText(idReply.getCellData(index).toString());
 
 
   
    }
    private void modifierReply(ActionEvent event) throws SQLException {
    int p = JOptionPane.showConfirmDialog(null,"Do you really want to Modify","Modify",JOptionPane.YES_NO_OPTION);
 if(p==0){
        try {
            Connection cnx = MyConnection.getInstance().getCnx();
            String value0 = modifR.getText();
            String value1 = modifREP.getText();
          
            String sql = "update reply set contenu= '"+value1+"' where rating='"+value0+"' ";
            pst= cnx.prepareStatement(sql);
            pst.execute();
              
        
            no = Notifications.create()
                    .title("reply Modifier")
                   .text(erreur)
                  .graphic(null)
                   .position(Pos.TOP_CENTER)
                   .hideAfter(Duration.seconds(6));
            no.showInformation();
          
           
            data.clear();
           initialiserlist();
              refreshlist();
               tableR.refresh();
                   modifR.setText("");

    modifREP.setText("");
  
   
         
      } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    
            initialiserlist();
        
               refreshlist();
                tableR.refresh();

 } 
 
    }

    @FXML
    private void btntritrilist(ActionEvent event) {
        
        
         if (combotri.getValue().equals("Par Rating")) {
            ObservableList<reply> tri1 = FXCollections.observableArrayList();
            tri1 = FXCollections.observableArrayList(rt.sortByRating());
            tableR.setItems(tri1);
        }
    }
    
       public void refreshlist(){
        data.clear();
        data=FXCollections.observableArrayList(rp.Affichertout2());
        
          idRating.setCellValueFactory(new PropertyValueFactory<>("rating"));
          idReply.setCellValueFactory(new PropertyValueFactory<>("contenu"));

        tableR.setItems(data);
    }
        private void QrCode() throws WriterException, SQLException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        List<reply> reeply = rt.Affichertout2();
        String Bagage = String.valueOf(reeply);
        int width = 300;
        int height = 300;

        BufferedImage bufferedImage = null;
        BitMatrix bytMatrix = qrCodeWriter.encode(Bagage, BarcodeFormat.QR_CODE, width, height);
        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        bufferedImage.createGraphics();
        Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, width, height);
        graphics.setColor(Color.black);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (bytMatrix.get(i, j)) {
                    graphics.fillRect(i, j, 1, 1);
                }
            }
        }
        kr.setImage(SwingFXUtils.toFXImage(bufferedImage, null));
    }
        
        
        
        
        
        @FXML
    private void pdf2(ActionEvent event) throws IOException {
       
    try { 
                 
              
                com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
                PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\Public\\reclamation.pdf"));
                doc.open();
                
                
                doc.add(new Paragraph(" "));   
               doc.add(new Paragraph("liste des messages : "));
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
            PdfPCell c = new PdfPCell(new Phrase("titre de message"));
            c.setHorizontalAlignment(Element.ALIGN_CENTER);
            c.setBackgroundColor(BaseColor.GRAY);
            t.addCell(c);
          
            doc.add(t);
                  PdfPCell c6 = new PdfPCell(new Phrase("contenu de message"));
            c.setHorizontalAlignment(Element.ALIGN_CENTER);
            c6.setBackgroundColor(BaseColor.GRAY);
            t.addCell(c6);
         
            
            
               Connection cnx =MyConnection.getInstance().getCnx();
            String query = "select * from forum";
            Statement stmt = null;
            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            Paragraph p3 = null;
                PdfPTable table = new PdfPTable(2);
                 table.setWidthPercentage(100);
               while(rs.next()){ 
           
                 
            PdfPCell  c1 = new PdfPCell(new Phrase(rs.getString("titre")));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setBackgroundColor(BaseColor.WHITE);
            table.addCell(c1);
                 PdfPCell  c2 = new PdfPCell(new Phrase(rs.getString("contenu")));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setBackgroundColor(BaseColor.WHITE);
            table.addCell(c2);
          
             
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
                Desktop.getDesktop().open(new File("C:\\Users\\Public\\reclamation.pdf"));
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
    
    

