/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import edu.esprit.entities.reply;
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
public class ReplyCRUD {
Connection cnx2;

    public ReplyCRUD() {
        cnx2 =Myconnection.getInstance().getCnx();
        
    }
    
    public void ajouterReply(){
        try {
            String requete ="INSERT INTO reply(rating,contenu)" + "VALUES('hello','message')";
            Statement st = cnx2.createStatement();  //objet ramener la requette vers sjbd w yekhou resultat;
        st.executeUpdate(requete); //mise a jours de base de donne 
            System.out.println("Reply ajouté avec succés");
        } catch (SQLException ex) {
            System.err.println("ex.getReply()"); 
        }
        
    }
     public void ajouterReply2(reply R){
        try {
            String requete2 ="INSERT INTO reply(rating,contenu)" + "VALUES(?,?)";
            PreparedStatement pst =cnx2.prepareStatement(requete2);
            pst.setInt(1, R.getRating());
            pst.setString(2, R.getContenu());
          
            
            pst.executeUpdate();
            System.out.println("votre Reply est ajoutee");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
   public ObservableList<reply>afficherReply(){
       ObservableList<reply> myList = FXCollections.observableArrayList();
        try {
            
            String requete3 = "SELECT * FROM reply";
            Statement st = cnx2.createStatement();
           ResultSet rs = st.executeQuery(requete3);
           while(rs.next()){
               reply F = new reply();
               F.setId(rs.getInt(1));
               F.setRating(rs.getInt("rating"));
               F.setContenu(rs.getString("contenu"));
             
               myList.add(F);
           }
           
           
           
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
        
        
   }  
   public int supprimerReply(int id) throws SQLException {

        int i = 0;
        try {
            Statement ste = cnx2.createStatement();
            String sql = "DELETE FROM `reply` WHERE id=" + id;
            i = ste.executeUpdate(sql);
             System.out.println("votre reply est supprimé");
        } catch (SQLException ex) {
            Logger.getLogger(ReplyCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
   public void updateReply(int id ,int rating,String contenu){
        try {
            String requete4 =" UPDATE forum SET " + " rating = ?, contenu = ? WHERE id = ?";
            PreparedStatement pst =cnx2.prepareStatement(requete4);
                    
                        pst.setInt(1, rating);
                        pst.setString(2, contenu);
                           pst.setInt(3, id);
                      
            pst.executeUpdate();
            System.out.println("votre reply est modifiee");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
   
   
   
    public ObservableList<reply> Affichertout2()  {
        ObservableList<reply> list = FXCollections.observableArrayList();
        String requete = "SELECT * FROM reply";
        try {
            PreparedStatement ps = cnx2.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

             list.add( new reply(rs.getInt("id"),rs.getInt("rating"),rs.getString("contenu")));
 }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    
    }
    }
     
     

