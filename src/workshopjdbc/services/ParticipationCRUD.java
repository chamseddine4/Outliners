/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.services;


import workshopjdbc.entities.participation_public;
import workshopjdbc.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Zied
 */
public class ParticipationCRUD {
Connection cnx2;

    public ParticipationCRUD() {
        cnx2 =MyConnection.getInstance().getCnx();
        
    }
    
    public void ajouterParticipation(){
        try {
            String requete ="INSERT INTO participation_public(donation)" + "VALUES(109)";
            Statement st = cnx2.createStatement();  //objet ramener la requette vers sjbd w yekhou resultat;
        st.executeUpdate(requete); //mise a jours de base de donne 
            System.out.println("Participation ajouté avec succés");
        } catch (SQLException ex) {
            System.err.println("ex.getMessage()"); 
        }
        
    }
    
    
     public void ajouterParticipation2(participation_public F){
        try {
            String requete2 ="INSERT INTO participation_public(donation,user_id,email)" + "VALUES(?,?,?)";
            PreparedStatement pst =cnx2.prepareStatement(requete2);
           
            pst.setInt(1,F.getDonation());
            pst.setInt(2, F.getUser().getId());
             pst.setString(3, F.getEmail());
            
            pst.executeUpdate();
            System.out.println("votre Participation est ajoutee");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
     
     
     
     
     
     
     
     
     
   public ObservableList<participation_public>afficherParticipation(){
       ObservableList<participation_public> myList = FXCollections.observableArrayList();
        try {
            
            String requete3 = "SELECT * FROM participation_public";
            Statement st = cnx2.createStatement();
           ResultSet rs = st.executeQuery(requete3);
           while(rs.next()){
               participation_public F = new participation_public();
               F.setId(rs.getInt(1));
             
               F.setDonation(rs.getInt("donation"));
           
               myList.add(F);
           }
           
           
           
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
        
        
   }  
   public void supprimerParticipation(participation_public p){
        try {
            String requete3 ="DELETE FROM participation_public WHERE id="+p.getId();
            PreparedStatement pst =cnx2.prepareStatement(requete3);
    
            
            pst.executeUpdate();
            System.out.println("votre Participation est supprimee");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
   public void updateParticipation(int id ,int donation){
        try {
            String requete4 =" UPDATE participation_public SET " + " donation=? WHERE id = ?";
            PreparedStatement pst =cnx2.prepareStatement(requete4);
                       pst.setInt(2, id);
                        
                        pst.setInt(1, donation);
                        
                        
            pst.executeUpdate();
            System.out.println("votre Participation est modifiee");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
   
   
    public ObservableList<participation_public> Affichertout()  {
        ObservableList<participation_public> list = FXCollections.observableArrayList();
        String requete = "SELECT * FROM participation_public";
        try {
            PreparedStatement ps = cnx2.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

             list.add( new participation_public(rs.getInt("id"),rs.getInt("donation"),rs.getString("email")));
 }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    
    }
    
   public List<participation_public> sortByDonation(){
         List<participation_public> replys=Affichertout();
         List<participation_public> resultat=replys.stream().sorted(Comparator.comparing(participation_public::getDonation)).collect(Collectors.toList());
         return resultat;
     }
   
    }