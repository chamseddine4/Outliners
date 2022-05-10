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
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static javax.swing.UIManager.getString;
import workshopjdbc.entities.forum;
import workshopjdbc.utils.MyConnection;

/**
 *
 * @author Firas
 */
public class ForumCRUD  {
Connection cnx2;

    public ForumCRUD() {
        cnx2 =MyConnection.getInstance().getCnx();
        
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
         int i;
        try {
            
            String requete2 ="INSERT INTO forum(titre,contenu,user_id,email)" + "VALUES(?,?,?,?)";
            PreparedStatement pst =cnx2.prepareStatement(requete2);
            pst.setString(1,badwords( F.getTitre()));
            pst.setString(2,badwords(F.getContenu()));
            pst.setInt(3, F.getUser().getId());
            pst.setString(4, F.getEmail());
          
            
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
                F.setId(rs.getInt("user_id"));
               F.setTitre(rs.getString("titre"));
               F.setContenu(rs.getString("contenu"));
             
               myList.add(F);
           }
           
           
           
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
        
        
   }  
  
       public void supprimerMessage(forum p){
        try {
            String requete3 ="DELETE FROM forum WHERE id="+p.getId();
            PreparedStatement pst =cnx2.prepareStatement(requete3);
         
            
            pst.executeUpdate();
            System.out.println("votre message est supprimee");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
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

             list.add( new forum(rs.getInt("id"),rs.getString("titre"),rs.getString("contenu"),rs.getString("email")));
 }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    
    }
   
   
   public List<String> trieSelonUsers() {
        List<String> test = new ArrayList<>();
        List<String> L = new ArrayList<>();
        Set<String> dataIdUser = new TreeSet<>((a, b) -> a.compareTo(b));
        int id_user = 0;
        String query = "SELECT * FROM `forum` ";
        String nomP = "";
        try {
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                dataIdUser.add(rs.getString("user_id "));
                test = dataIdUser.stream()
                        .collect(Collectors.toList());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        for (int i = 0; i < test.size(); i++) {
            id_user = Integer.parseInt(test.get(i));
            String queryy = "SELECT  `contenu` FROM `forum` WHERE id=" + id_user;
       
            try {
                Statement st = cnx2.createStatement();
                ResultSet rs = st.executeQuery(queryy);
            
             
                while (rs.next()) {
                    System.out.println(nomP +   "\n" + " Comments = " + rs.getInt(1));
                    L.add(rs.getString(1) + "\n" + "\n");
                    System.out.println("---------------------------------------------------------------");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return L;
    }
   
   
    
 
    
    
    
    
     public List<String> iduser() {
             List<String> test = new ArrayList<>();
        List<String> L = new ArrayList<>();
        Set<String> dataIdUser = new TreeSet<>((a, b) -> a.compareTo(b));
        int id_user = 0;
        String query = "SELECT * FROM `forum` ";
        String nomP = "";
        try {
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                dataIdUser.add(rs.getString("user_id"));
                test = dataIdUser.stream()
                        .collect(Collectors.toList());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        for (int i = 0; i < test.size(); i++) {
            id_user = Integer.parseInt(test.get(i));
            String queryyy = "SELECT  `username` FROM `user` WHERE id=" + id_user;
            try {
                Statement st1 = cnx2.createStatement();
                ResultSet rs1 = st1.executeQuery(queryyy);
                while (rs1.next()) {
                    nomP = "ツ " + rs1.getString(1) + " ツ " + "\n" + "\n";
                    L.add(nomP);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println(dataIdUser);
        return test;
     }
     
     
     
      public List<String> CountUserPub(int user_id) {
        String query = "SELECT `contenu`,`user_id` FROM `forum` WHERE id=" + user_id;
        String query1 = "SELECT  `username` FROM `user` WHERE id=" + user_id;
        List<String> data = new ArrayList<>();
        long Tot = 0;
        String nom_u = "";
        try {
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                data.add(rs.getInt("id")+rs.getString("contenu"));
            }
            Tot = data.stream().count();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Statement st1 = cnx2.createStatement();
            ResultSet rs1 = st1.executeQuery(query1);
            rs1.first();
            nom_u = rs1.getString(1) ;

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("L'utilisateur D'ID = " + user_id + " et Son NOM&PRENOM = " + nom_u + " a publier " + Tot + " messages");
        return data;
    }
     
      public forum getById(int id) {
        forum p = new forum() ;
        try {
            String req = "Select * from forum WHERE id = '"+id+"'";
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){ 
                p.setId(rs.getInt(1));
              
                p.setTitre(rs.getString("titre")); 
                p.setContenu(rs.getString("contenu"));
               
                
              
           
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return p ;
    }
   
      
      
      
      public String badwords(String reply){
        
        String result = reply;
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
      
     /// les discussion avec plus de commentaires
    public List<forum> afficherForumStat() {

        List<forum> mylist = new ArrayList<>();
        try {

            String req3 = "Select forum.titre,count() as nb group by id order by count() desc";
                    
            PreparedStatement ps = cnx2.prepareStatement(req3);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                forum d = new forum();
                d.setTitre(rs.getString("titre"));
                d.setContenu(rs.getString("contenu"));
                
                mylist.add(d);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return mylist;
    }
    }
      
      
      


