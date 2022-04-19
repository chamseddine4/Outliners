/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.services;

import static java.awt.Event.INSERT;
import workshopjdbc.entities.Utilisateur;
import workshopjdbc.utils.MyConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.InputStream;
import java.sql.*;
import static java.sql.JDBCType.NULL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import static workshopjdbc.gui.SigninController.password;
import workshopjdbc.services.IService;
import workshopjdbc.utils.BCrypt;

/**
 *
 * @author Lenovo
 */


public class ServiceUtilisateur<s> implements IService<Utilisateur> {

    PreparedStatement store;
    Utilisateur user = new Utilisateur();
    Connection cnx = MyConnection.getInstance().getCnx();
    boolean existe = false;
    
     public int existe(Utilisateur u) throws SQLException {
        Statement s = cnx.createStatement();
        ResultSet rs = s.executeQuery("SELECT COUNT(*) from user WHERE email = '" + u.getEmail() + "'");
        int size = 0;
        rs.next();
        size = rs.getInt(1);
        return size;
    }

    public int existeMail(Utilisateur u)  {
       try{
        Statement s = cnx.createStatement();
        ResultSet rs = s.executeQuery("SELECT COUNT(*) from user WHERE email ='" + u.getEmail() + "'");
        int size = 0;

        rs.next();

        size = rs.getInt(1);

        return size;}
       catch(Exception ex){
           System.out.println("error");
       }
       return 0;
    }

    @Override
    public void ajouter(Utilisateur utilisateur)  {
       
        String query = "INSERT INTO `user` (`id`, `username`, `email`, `password`,  `roles`) VALUES (?, ?, ?, ?, ?);";
        int x;
            x = existeMail(utilisateur);
            
        
        if (x == 0) {
            try {
                String password= BCrypt.hashpw(utilisateur.getPassword(), BCrypt.gensalt());
                PreparedStatement ste = cnx.prepareStatement(query);
                ste.setInt(1, utilisateur.getId());
                ste.setString(2, utilisateur.getUsername());
                ste.setString(3, utilisateur.getEmail());
                ste.setString(4, password);
                ste.setString(5,"[\"ROLE_USER\"]");

               
                ste.executeUpdate();
                System.out.println("User Added Successfully");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("user already exists");
        }
        
    }

    public List<Utilisateur> afficher() {
        List<Utilisateur> users = new ArrayList<>();
        String query = "SELECT * FROM user";
        try {
            PreparedStatement ste = cnx.prepareStatement(query);
            ste.executeQuery();
            ResultSet rs = ste.executeQuery(query);
            while (rs.next()) {
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setId(rs.getInt("id"));
                utilisateur.setUsername(rs.getString("username"));
              
                utilisateur.setEmail(rs.getString("email"));
                utilisateur.setPassword(rs.getString("password"));
                utilisateur.setRoles(rs.getString("roles"));
              
                users.add(utilisateur);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }
    

    public void modifier(Utilisateur t) {
        
                        String password= BCrypt.hashpw(t.getPassword(), BCrypt.gensalt());
         String query = "UPDATE user SET " +
                "username = '" + t.getUsername()+
              
                "', email= '" + t.getEmail()+
                "', password = '" + password+
                "', roles = '" + t.getRoles()+
               
                "' where id="+t.getId();
         
         System.out.println(query);
        try {
            Statement ste = cnx.createStatement();
            ste.executeUpdate(query);
            System.out.println("User Updated Successfully ");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    

       @Override
    public void supprimer(Utilisateur utilisateur) {
        String query = "DELETE FROM user WHERE id = '" +utilisateur.getId()+ "'";
        try {
            Statement ste = cnx.createStatement();
            int deleted = ste.executeUpdate(query);
            System.out.println(deleted);
            if (deleted > 0)
                System.out.println("Deleted successfully");
            else
                System.out.println("Nothing deleted");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    
    
    
    public boolean verifPassword(String username, String password) {
        try {
            Statement ste = cnx.createStatement();
            
            ResultSet rs = ste.executeQuery("select e.* from user e where email='" + username +"'");
          
            while(rs.next()){
                String passBase=rs.getString("password");
                if(BCrypt.checkpw(password, passBase)){
                    return true;
                }else
                    return false;
             
            }
            
        } catch (SQLException sq) {
            return false;
        }
        return false;
    }
    
    public int signup(Utilisateur utilisateur) throws SQLException  {
       
        String query = "INSERT INTO `user` (`id`, `username`, `email`, `password`,  `roles`) VALUES (?, ?, ?, ?, ?);";
        
        ServiceUtilisateur us = new ServiceUtilisateur();
        
        int x;
            x = us.existe(utilisateur);
            
         int y = us.existeMail(utilisateur);
        
        if (x == 0) {
            if(y==0) {
                String password= BCrypt.hashpw(utilisateur.getPassword(), BCrypt.gensalt());
                PreparedStatement ste = cnx.prepareStatement(query);
                ste.setInt(1, utilisateur.getId());
                ste.setString(2, utilisateur.getUsername());
              
                ste.setString(3, utilisateur.getEmail());
                ste.setString(4, password);
                ste.setString(5,"[\"ROLE_USER\"]");

                ste.executeUpdate();
                System.out.println("User Added Successfully");
            return 0 ; 
            } else 
            {
                    return 1 ; 
                    
                    }
        }
            else {
                    return 2 ;
                    }
            
        
    }
    
    public String Login_Dispo(Utilisateur u) throws SQLException {
        Random rand = new Random(); //instance of random class
        int upperbound = 1000;
        int int_random = rand.nextInt(upperbound);
        String Newlogin=u.getEmail()+""+int_random;
        u.setEmail(Newlogin);
        while (existe(u)!=0)
        {
            int_random = rand.nextInt(upperbound);
            Newlogin=u.getEmail()+""+int_random;
        }
          return Newlogin;
    }
    
    
      public int getIdbymail(String mail) {
        try {
            PreparedStatement st = cnx.prepareStatement("select * from user where email=?");
            st.setString(1, mail);
            ResultSet rs = st.executeQuery();
            rs.beforeFirst();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }
      
      
      
    public String getRolebyId(int id) {
        try {
            PreparedStatement st = cnx.prepareStatement("select * from user where id=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.beforeFirst();
            if (rs.next()) {
                return rs.getString("roles");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";

    }

    
    
    
    public String checkRole(String email) {
        String default_return = "roles not found";
        try {
            String req;
            req = "select roles from user where email=?";
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, email);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                if (rs.getString("roles").equals("[\"ROLE_ADMIN\"]")) {

                    return "ADMIN";
                } else if (rs.getString("roles").equals("[\"ROLE_USER\"]")) {
                    System.out.println("third");
                    return "USER";

                }

            }

        } catch (SQLException ex) {
        }
        return default_return;
    }

    
    
    public boolean login(String email, String password) {

        try {
            PreparedStatement pt = cnx.prepareStatement("select * from user where email=? and password=?");
            pt.setString(1, email);
            pt.setString(2, password);
            ResultSet rs = pt.executeQuery();
            if (rs.isBeforeFirst()) {
                return true;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    
    
    
    
    
    public ObservableList<Utilisateur> Affichertout()  {
        ObservableList<Utilisateur> list = FXCollections.observableArrayList();
        String requete = "SELECT * FROM user";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

             list.add( new Utilisateur(rs.getString("username"),rs.getString("email"),rs.getString("password"),rs.getString("roles")));
 }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    
    }
    

}
