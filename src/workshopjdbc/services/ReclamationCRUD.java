/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package workshopjdbc.services;

import workshopjdbc.entities.reclamation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import workshopjdbc.utils.MyConnection;

/**
 *
 * @author ziedm
 */
public class ReclamationCRUD {
    Connection cnx2;
    
    public ReclamationCRUD() {
        cnx2 =MyConnection.getInstance().getCnx();
        
    }
    
     public void ajouterReclamation(){
        try {
            String requete ="INSERT INTO reclamation(titre,contenu)" + "VALUES('hello','message')";
            Statement st = cnx2.createStatement();  //objet ramener la requette vers sjbd w yekhou resultat;
        st.executeUpdate(requete); //mise a jours de base de donne 
            System.out.println("Reclamation ajouté avec succés");
        } catch (SQLException ex) {
            System.err.println("ex.getMessage()"); 
        }
        
    }
     
      public void ajouterReclamation2(reclamation F){
         int i;
         
        try {
            
             String requete2 ="INSERT INTO reclamation(titre,contenu,user_id,email)" + "VALUES(?,?,?,?)";
             PreparedStatement pst =cnx2.prepareStatement(requete2);
             pst.setString(1, F.getTitre());
             pst.setString(2, F.getContenu());
             pst.setInt(3, F.getUser().getId());
             pst.setString(4, F.getEmail());
          
            
            pst.executeUpdate();
            System.out.println("votre Reclamation est ajoutee");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
      
      
      
      
       public ObservableList<reclamation>afficherReclamation(){
       ObservableList<reclamation> myList = FXCollections.observableArrayList();
        try {
            
            String requete3 = "SELECT * FROM reclamation";
            Statement st = cnx2.createStatement();
           ResultSet rs = st.executeQuery(requete3);
           while(rs.next()){
               reclamation R = new reclamation();
               R.setId(rs.getInt("id"));
               R.setTitre(rs.getString("titre"));
               R.setContenu(rs.getString("contenu"));
             
               myList.add(R);
           }
           
           
           
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
        
        
   }  
      
       public void supprimerReclamation(reclamation p){
        try {
            String requete3 ="DELETE FROM reclamation WHERE id="+p.getId();
            PreparedStatement pst =cnx2.prepareStatement(requete3);
         
            
            pst.executeUpdate();
            System.out.println("votre reclamation est supprimee");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
      
      public void updateReclamation(int id ,String titre,String contenu){
        try {
            String requete4 =" UPDATE reclamation SET " + " titre = ?, contenu = ? WHERE id = ?";
            PreparedStatement pst =cnx2.prepareStatement(requete4);
                       pst.setInt(3, id);
                        pst.setString(1, titre);
                        pst.setString(2, contenu);
                      
            pst.executeUpdate();
            System.out.println("votre reclamation est modifiee");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
       
     public ObservableList<reclamation> Affichertout()  {
        ObservableList<reclamation> list = FXCollections.observableArrayList();
        String requete = "SELECT * FROM reclamation";
        try {
            PreparedStatement ps = cnx2.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

             list.add( new reclamation(rs.getInt("id"),rs.getString("titre"),rs.getString("contenu"),rs.getString("email")));
 }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    
    }

 
      
}
