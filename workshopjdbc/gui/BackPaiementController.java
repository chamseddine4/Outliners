/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.gui;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.qrcode.BitMatrix;
import com.itextpdf.text.pdf.qrcode.QRCodeWriter;
import com.itextpdf.text.pdf.qrcode.WriterException;
import workshopjdbc.entities.paiement;
import java.awt.Color;
import workshopjdbc.services.PaiementCRUD;
import java.sql.Connection;
import java.awt.Desktop;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import workshopjdbc.utils.MyConnection;

/**
 * FXML Controller class
 *
 * @author ziedm
 */
public class BackPaiementController implements Initializable {

    
    private Parent fxml;
    private Stage stage;
    private Scene scene;
    
    @FXML
    private TableView<paiement> tablePaiement;
    @FXML
    private TableColumn<paiement, String> idNompaie;
    @FXML
    private TableColumn<paiement, Integer> idNumpaie;
    @FXML
    private TableColumn<paiement, String> idMoispaie;
    @FXML
    private TableColumn<paiement, Integer> idAnneepaie;
    @FXML
    private TableColumn<paiement, Integer> idCVVpaie;
int index =-1;
    @FXML
    private TableColumn<paiement, Integer> idID;
    
    ObservableList<String> ss = FXCollections.observableArrayList();
    
    PaiementCRUD rt = new PaiementCRUD() ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         tablePaiement.setEditable(true);
        refrech();
        
        
      
       
        
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
    
     public void refrech() {
        
         
        PaiementCRUD pa = new PaiementCRUD();
        
        ObservableList<paiement> list = pa.Affichertout();
        
        idID.setCellValueFactory(new PropertyValueFactory<>("id"));
        idNompaie.setCellValueFactory(new PropertyValueFactory<>("nomSurCarte"));
        idNumpaie.setCellValueFactory(new PropertyValueFactory<>("numCarte"));
        idMoispaie.setCellValueFactory(new PropertyValueFactory<>("moisExp"));
        idAnneepaie.setCellValueFactory(new PropertyValueFactory<>("anneeExp"));
        idCVVpaie.setCellValueFactory(new PropertyValueFactory<>("cvv"));
        
        
        tablePaiement.setItems(list);
    }



    
    
        @FXML
    private void dell(ActionEvent event) {
        PaiementCRUD pa = new PaiementCRUD();
        paiement p = new paiement();
        
        p=tablePaiement.getSelectionModel().getSelectedItem();
        pa.supprimerPaiement(p);
        
        refrech();
        
        
    }
      
    
    
     @FXML
    private void pdf2(ActionEvent event) throws IOException {
       
    try { 
                 
              
                com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
                PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\ziedm\\Desktop\\paiement.pdf"));
                doc.open();
                
                
                doc.add(new Paragraph(" "));   
               doc.add(new Paragraph("liste des Paiement : "));
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
            PdfPCell c = new PdfPCell(new Phrase("Nom Sur Carte"));
            c.setHorizontalAlignment(Element.ALIGN_CENTER);
            c.setBackgroundColor(BaseColor.GRAY);
            t.addCell(c);
          
            doc.add(t);
                  PdfPCell c6 = new PdfPCell(new Phrase("Numéro Carte"));
            c.setHorizontalAlignment(Element.ALIGN_CENTER);
            c6.setBackgroundColor(BaseColor.GRAY);
            t.addCell(c6);
          
            doc.add(t);
            
                PdfPCell c7 = new PdfPCell(new Phrase("Mois Exp"));
            c7.setHorizontalAlignment(Element.ALIGN_CENTER);
            c7.setBackgroundColor(BaseColor.GRAY);
            t.addCell(c7);
          
            doc.add(t);
                PdfPCell c8 = new PdfPCell(new Phrase("Année Exp"));
            c8.setHorizontalAlignment(Element.ALIGN_CENTER);
            c8.setBackgroundColor(BaseColor.GRAY);
            t.addCell(c8);
          
            doc.add(t);
                PdfPCell c9 = new PdfPCell(new Phrase("Cvv"));
            c9.setHorizontalAlignment(Element.ALIGN_CENTER);
            c9.setBackgroundColor(BaseColor.GRAY);
            t.addCell(c9);
          
            doc.add(t);
            
            
            
            
               Connection cnx =MyConnection.getInstance().getCnx();
            String query = "select * from paiement";
            Statement stmt = null;
            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            Paragraph p3 = null;
                PdfPTable table = new PdfPTable(5);
                 table.setWidthPercentage(100);
               while(rs.next()){ 
           
                 
            PdfPCell  c1 = new PdfPCell(new Phrase(rs.getString("nom_sur_carte")));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setBackgroundColor(BaseColor.WHITE);
            table.addCell(c1);
                 PdfPCell  c2 = new PdfPCell(new Phrase(rs.getString("num_carte")));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setBackgroundColor(BaseColor.WHITE);
            table.addCell(c2);
            PdfPCell  c3 = new PdfPCell(new Phrase(rs.getString("mois_exp")));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setBackgroundColor(BaseColor.WHITE);
            table.addCell(c3);
            PdfPCell  c4 = new PdfPCell(new Phrase(rs.getString("annee_exp")));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setBackgroundColor(BaseColor.WHITE);
            table.addCell(c4);
            PdfPCell  c5 = new PdfPCell(new Phrase(rs.getString("cvv")));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setBackgroundColor(BaseColor.WHITE);
            table.addCell(c5);
            
             
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
                Desktop.getDesktop().open(new File("C:\\Users\\ziedm\\Desktop\\paiement.pdf"));
             } catch (Exception e) {
          System.err.print(e);
        }
  
    
    
    
}








}