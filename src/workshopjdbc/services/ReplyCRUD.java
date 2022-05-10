/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.services;

import static com.sun.javafx.util.Utils.contains;

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
import workshopjdbc.entities.forum;
import workshopjdbc.entities.reply;
import workshopjdbc.utils.MyConnection;

/**
 *
 * @author Firas
 */
public class ReplyCRUD {
Connection cnx2;

    public ReplyCRUD() {
        cnx2 =MyConnection.getInstance().getCnx();
        
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
            String requete2 ="INSERT INTO reply(ad,rating,contenu)" + "VALUES(?,?,?)";
            PreparedStatement pst =cnx2.prepareStatement(requete2);
             pst.setInt(1, R.getAd());
            pst.setInt(2, R.getRating());
            

            pst.setString(3,badwords( R.getContenu()));
          
            
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
   public void supprimerMessager(reply r){
        try {
            String requete3 ="DELETE FROM reply WHERE id="+r.getId();
            PreparedStatement pst =cnx2.prepareStatement(requete3);
         
            
            pst.executeUpdate();
            System.out.println("votre reply est supprimee");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
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

             list.add(new reply(rs.getInt(1),rs.getInt(2) ,rs.getInt(4), rs.getString("contenu") ));
 }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    
    }
         public List<reply> getReplys(int id) {
        List<reply> list = new ArrayList<>();
        try {
            String req = "Select * from reply WHERE ad = '"+id+"'";
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                ForumCRUD sp = new ForumCRUD();  
                
                forum p = new forum(); 
                p = sp.getById(rs.getInt("ad")) ; 
                
                reply a = new reply(rs.getInt(1),rs.getInt(2) ,rs.getInt(4), rs.getString("contenu") );
                list.add(a);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
         
         
      public String badwords(String forum){
        
        String result = forum;
        String[] badwords = {"tuer","sang","con","merde","vomir","conne","putain"};
        
        for(String word : badwords){
            //System.out.println(result);
            if(contains(result,word)){
                 result=result.replace(word,"****");
                //break;
            }
            //System.out.println(result);
        }
        return result;
    }
           public List<reply> sortByRating(){
         List<reply> replys=Affichertout2();
         List<reply> resultat=replys.stream().sorted(Comparator.comparing(reply::getRating)).collect(Collectors.toList());
         return resultat;
     }
           
           
public void statistique(){
  
     try {
            
            String requete3="select count(*) , rating from 'reply'  group by rating";
            Statement st = MyConnection.getInstance().getCnx().createStatement();
             ResultSet rs=st.executeQuery(requete3);
           
             while (rs.next()){
                 System.out.println("rating : " +rs.getString(1));
            
             }
            
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
}
    }
     
     

