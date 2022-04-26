/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import edu.esprit.entities.paiement;
import edu.esprit.entities.participation_public;
import edu.esprit.services.PaiementCRUD;
import edu.esprit.services.ParticipationCRUD;
import edu.esprit.services.PriveCRUD;
import edu.esprit.utils.Myconnection;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.text.Document;

/**
 * FXML Controller class
 *
 * @author ziedm
 */
public class BackPublicController implements Initializable {

    @FXML
    private TableColumn<participation_public, Integer> idId;
    @FXML
    private TableColumn<participation_public, Integer> idDon;
    @FXML
    private TableView<participation_public> tablePublic;

    
    private ParticipationCRUD pu;
    
     private  Parent fxml ; 
       private  Stage stage ; 
       private Scene scene ; 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
        tablePublic.setEditable(true);
        refrech();
        
    }    
    @FXML
    public void back5(ActionEvent event) throws IOException {
        try {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("backPaiement.fxml"));

                    fxml = loader.load();
                  
                } catch (IOException ex) {
                    Logger.getLogger(BackPublicController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(fxml);
                stage.setScene(scene);
                stage.show();
   
        } 
    
        @FXML
    public void privee(ActionEvent event) throws IOException {
        try {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("back.fxml"));

                    fxml = loader.load();
                  
                } catch (IOException ex) {
                    Logger.getLogger(BackPublicController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(fxml);
                stage.setScene(scene);
                stage.show();
   
        } 
    
    
     public void refrech() {
        
        ParticipationCRUD pu = new ParticipationCRUD();
        idId.setCellValueFactory(new PropertyValueFactory<>("id"));
        idDon.setCellValueFactory(new PropertyValueFactory<>("donation"));
   
      
        
        tablePublic.getItems().clear();
        tablePublic.setItems(pu.Affichertout());
    }

    @FXML
    private void del(ActionEvent event) {
        
         ParticipationCRUD pa = new ParticipationCRUD();
        participation_public p = new participation_public();
        
        p=tablePublic.getSelectionModel().getSelectedItem();
        pa.supprimerParticipation(p);
        
        refrech();
        
    }
    
    
     @FXML
    private void pdf(ActionEvent event) throws IOException {
       
    try { 
                 
              
                com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
                PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\FIRAS\\Desktop\\public.pdf"));
                doc.open();
                
                
                doc.add(new Paragraph(" "));   
               doc.add(new Paragraph("liste des public : "));
               doc.add(new Paragraph(" "));
                
                
//                 Paragraph p =new Paragraph();
//                p.add("liste de produit");
//              
//                
//                 
//                
//                
//             doc.add(p);
             
                 PdfPTable t = new PdfPTable(1);
                 t.setWidthPercentage(100);
            PdfPCell c = new PdfPCell(new Phrase("donation"));
            c.setHorizontalAlignment(Element.ALIGN_CENTER);
            c.setBackgroundColor(BaseColor.GRAY);
            t.addCell(c);
            
            
            
            doc.add(t);
               
            
              Connection cnx =Myconnection.getInstance().getCnx();
            String query = "select * from participation_public";
            Statement stmt = null;
            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            Paragraph p3 = null;
                PdfPTable table = new PdfPTable(1);
                 table.setWidthPercentage(100);
               while(rs.next()){ 
           
                 
            PdfPCell  c1 = new PdfPCell(new Phrase(rs.getString("donation")));
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
                Desktop.getDesktop().open(new File("C:\\Users\\FIRAS\\Desktop\\public.pdf"));
             } catch (Exception e) {
          System.err.print(e);
        }
  
    
    }
    
    
    
    
    
    
    
    
    
    
}
