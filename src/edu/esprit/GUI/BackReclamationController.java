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
import edu.esprit.entities.reclamation;


import edu.esprit.services.ReclamationCRUD;
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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ziedm
 */
public class BackReclamationController implements Initializable {

    @FXML
    private TableColumn<reclamation, Integer> idColRec;
    @FXML
    private TableColumn<reclamation, String> titreColRec;
    @FXML
    private TableColumn<reclamation, String> contenuColRec;
    @FXML
    private TableView<reclamation> tableRec;
    
    
    private ReclamationCRUD pp ;
    
    
     private  Parent fxml ; 
       private  Stage stage ; 
       private Scene scene ; 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
          tableRec.setEditable(true);
        refrech();
        
    }    
    
    
     public void refrech() {
        
        ReclamationCRUD pp = new ReclamationCRUD();
        idColRec.setCellValueFactory(new PropertyValueFactory<>("id"));
        titreColRec.setCellValueFactory(new PropertyValueFactory<>("titre"));
        contenuColRec.setCellValueFactory(new PropertyValueFactory<>("contenu"));
        tableRec.getItems().clear();
        tableRec.setItems(pp.Affichertout());
       
    }
     
     @FXML
    private void deleteRec(ActionEvent event) {
        ReclamationCRUD pa = new ReclamationCRUD();
        reclamation p = new reclamation();
        
        p=tableRec.getSelectionModel().getSelectedItem();
        pa.supprimerReclamation(p);
        
        refrech();
        
        
    }
    
    
    @FXML
     private void pdfRec(ActionEvent event) throws IOException {
       
    try { 
                 
              
                com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
                PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\ziedm\\Desktop\\reclamation.pdf"));
                doc.open();
                
                
                doc.add(new Paragraph(" "));   
               doc.add(new Paragraph("liste des Reclamations : "));
               doc.add(new Paragraph(" "));
                
                
//                 Paragraph p =new Paragraph();
//                p.add("liste de produit");
//              
//                
//                 
//                
//                
//             doc.add(p);
             
                 PdfPTable t = new PdfPTable(2);
                 t.setWidthPercentage(100);
            PdfPCell c = new PdfPCell(new Phrase("Titre"));
            c.setHorizontalAlignment(Element.ALIGN_CENTER);
            c.setBackgroundColor(BaseColor.GRAY);
            t.addCell(c);
          
            doc.add(t);
                  PdfPCell c6 = new PdfPCell(new Phrase("Contenu"));
            c.setHorizontalAlignment(Element.ALIGN_CENTER);
            c6.setBackgroundColor(BaseColor.GRAY);
            t.addCell(c6);
          
            doc.add(t);
            
              
            
            
              Connection cnx =Myconnection.getInstance().getCnx();
            String query = "select * from reclamation";
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
                Desktop.getDesktop().open(new File("C:\\Users\\ziedm\\Desktop\\reclamation.pdf"));
             } catch (Exception e) {
          System.err.print(e);
        }
  
    
    
    
    }
}
