/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import edu.esprit.entities.forum;
import edu.esprit.utils.Myconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Firas
 */
public class ForumCRUD {
Connection cnx2;

    public ForumCRUD() {
        cnx2 =Myconnection.getInstance().getCnx();
        
    }

    public ForumCRUD(String text, String text0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void ajouterMessage(){
        try {
            String requete ="INSERT INTO forum(titre,contenu)" + "VALUES('hello','message')";
            Statement st = cnx2.createStatement();  //objet ramener la requette vers sjbd w yekhou resultat;
        st.executeUpdate(requete); //mise a jours de base de donne 
            System.out.println("Message ajouté avec succés");
        } catch (SQLException ex) {
            System.err.println("ex.getMessage()"); 
        }
        
    }
     public void ajouterMessage2(forum F){
        try {
            String requete2 ="INSERT INTO forum(titre,contenu)" + "VALUES(?,?)";
            PreparedStatement pst =cnx2.prepareStatement(requete2);
            pst.setString(1, F.getTitre());
            pst.setString(2, F.getContenu());
          
            
            pst.executeUpdate();
            System.out.println("votre Message est ajoutee");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
   public ObservableList<forum>afficherMessage(){
       ObservableList<forum> myList = FXCollections.observableArrayList();
        try {
            
            String requete3 = "SELECT * FROM forum";
            Statement st = cnx2.createStatement();
           ResultSet rs = st.executeQuery(requete3);
           while(rs.next()){
               forum F = new forum();
               F.setId(rs.getInt("id"));
               F.setTitre(rs.getString("titre"));
               F.setContenu(rs.getString("contenu"));
             
               myList.add(F);
           }
           
           
           
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
        
        
   }  
  
        public int supprimerMessage(int id) throws SQLException {

        int i = 0;
        try {
            Statement ste = cnx2.createStatement();
            String sql = "DELETE FROM `forum` WHERE id=" + id;
            i = ste.executeUpdate(sql);
             System.out.println("votre Message est supprimé");
        } catch (SQLException ex) {
            Logger.getLogger(ForumCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
   public void updateMessage(int id ,String titre,String contenu){
        try {
            String requete4 =" UPDATE forum SET " + " titre = ?, contenu = ? WHERE id = ?";
            PreparedStatement pst =cnx2.prepareStatement(requete4);
                       pst.setInt(3, id);
                        pst.setString(1, titre);
                        pst.setString(2, contenu);
                      
            pst.executeUpdate();
            System.out.println("votre Message est modifiee");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
   
   public ObservableList<forum> Affichertout()  {
        ObservableList<forum> list = FXCollections.observableArrayList();
        String requete = "SELECT * FROM forum";
        try {
            PreparedStatement ps = cnx2.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

             list.add( new forum(rs.getInt("id"),rs.getString("titre"),rs.getString("contenu")));
 }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    
    }
    }
     
     

