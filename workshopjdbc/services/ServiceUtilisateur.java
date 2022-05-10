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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import static java.sql.JDBCType.NULL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import static workshopjdbc.gui.SigninController.password;
import workshopjdbc.services.IService;
import workshopjdbc.utils.BCrypt;

/**
 *
 * @author Lenovo
 */


public class ServiceUtilisateur implements IService<Utilisateur> {

    PreparedStatement store;
    Utilisateur user = new Utilisateur();
    Connection cnx = MyConnection.getInstance().getCnx();
    boolean existe = false;
    
    
    
    
    
        @Override
         public void delete(int id) throws SQLException {
        
         String request = "DELETE FROM user where id=?";
         try {
            PreparedStatement pst = cnx.prepareStatement(request);
            pst.setInt(1, id);
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
         
        
         
         
         
      
public boolean SendMail(Utilisateur user,String code )
    {
        String password = "SAVEsave2022";
        String from,to,host,sub,content;
        from = "save.me.pidev@gmail.com";
        to =user.getEmail();
        host="localhost";
        if (code == "null")
        {
            sub="Bienvenue sur notre Plateforme";
            content="Bonjour Mr/Mme "+user.getUsername()+". Au nom de tous les membres du plateforme, je vous souhaite la bienvenue.";
            Properties properties = new Properties();
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");
            Session session=Session.getDefaultInstance(properties,new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication()
                        {
                            return new PasswordAuthentication(from,password);
                        }
                    }
            );
            try {
                MimeMessage m =new MimeMessage(session);
                m.setFrom(new InternetAddress(from));
                m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                m.setSubject(sub);
                m.setText(content);
                Transport.send(m);
                return true;

            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }else
        {
            sub="Réinitialisation du mot de passe de votre compte ";
            content="Bonjour"+user.getUsername()+".\n \n Avez-vous oublié votre mot de passe \n \n Taper ce code dans l'application =  " +code+" \n \n" +
                    "Si vous ne souhaitez pas changer votre mot de passe ou si vous ne l’avez pas demandé, veuillez ignorer et supprimer ce message. \n \n" +
                    "Cordialement,\n \n " +
                    "L’équipe PiDevers ";
            Properties properties = new Properties();
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");
            Session session=Session.getDefaultInstance(properties,new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication()
                        {
                            return new PasswordAuthentication(from,password);
                        }
                    }
            );
            try {
                MimeMessage m =new MimeMessage(session);
                m.setFrom(new InternetAddress(from));
                m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                m.setSubject(sub);
                m.setText(content);
                Transport.send(m);
                return true;

            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }

        return false;
    }
        

        
       public int modifieruser(Utilisateur t) {
        
        if(existeMailById(t)<1){
            
        
        
         String password= BCrypt.hashpw(t.getPassword(), BCrypt.gensalt());
         String query = "UPDATE user SET " +
                "username = '" + t.getUsername()+
                "', email= '" + t.getEmail()+
               
                "' where id="+t.getId();
         
         System.out.println(query);
        try {
            Statement ste = cnx.createStatement();
            ste.executeUpdate(query);
            System.out.println("User Updated Successfully ");
        } catch (SQLException e) {
               return 0;
        }
        return 1;
        }else{
            return 0;
        }

    }
       
        public int existeMailById(Utilisateur u)  {
       try{
           String req="SELECT COUNT(*) from user WHERE id <> "+ u.getId()+" and email ='" + u.getEmail() + "'";
        Statement s = cnx.createStatement();
        ResultSet rs = s.executeQuery(req);
        int size = 0;

        rs.next();

        size = rs.getInt(1);

        return size;}
       catch(Exception ex){
           System.out.println("error");
       }
       return 0;
       }

        
        
        
        
        
        
        
     public static boolean isValidPhoneNumber(String phone_number) {
        boolean isValid =  phone_number.matches("\\d{8}");
        System.out.println(phone_number+" : "+isValid);
        return isValid;
    }
     
     
     public  boolean isValidAnswe(int phone_number,String ans) {
        Utilisateur t = new Utilisateur();
        String l="";
        boolean res=false;
        
        try {
        
            String req = ("Select * from `user` WHERE num_tel = " + phone_number);
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req); 
            
            rs.next();               
                t.setId(rs.getInt("id"));
                t.setUsername(rs.getString("username"));
                t.setEmail(rs.getString("email"));
                t.setPassword(rs.getString("password"));
                t.setSecurityq(rs.getString("securityq"));
                t.setAnswer(rs.getString("answer"));
                t.setNumtel(rs.getInt("num_tel"));
                  l=t.getAnswer();
                  System.out.println(l);
                  
                  
                  if(l.equals(ans)){
                     
                      res =true;
                      return res;
                  }else{
                      
                       res =false;
                      return res;
                  }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return res;
    }
     
     
     
        public Utilisateur getByIda(int id) {
         Utilisateur t = new Utilisateur();
        
        try {
        
            String req = ("Select * from `user` WHERE num_tel = " + id);
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req); 
            System.err.println("before");
            
            rs.next();               
              
               
                t.setId(rs.getInt("id"));
                t.setUsername(rs.getString("username"));
                t.setEmail(rs.getString("email"));
                t.setPassword(rs.getString("password"));
                t.setSecurityq(rs.getString("securityq"));
                t.setAnswer(rs.getString("answer"));
                  t.setNumtel(rs.getInt("num_tel"));
                  t.setRoles("[\"ROLE_USER\"]");
               
                  System.err.println("qfterr");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return t;
    }
         
        
        
        
        public void modifier2(int id,Utilisateur r) {
                try {
                     String password= BCrypt.hashpw(r.getPassword(), BCrypt.gensalt());
                   String req = "UPDATE `user` SET `email` = '" + r.getEmail()
                    + "', `password` = '" + password
                    + "', `username` = '" + r.getUsername()
                  
                    + "', `num_tel` = '" + r.getNumtel()
                    + "', `roles` = '" + r.getRoles()
                    + "', `securityq` = '" + r.getSecurityq()
                    + "', `answer` = '" + r.getAnswer()
                    + "' WHERE `user`.`id` = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
          

            System.out.println("User Modifieé avec succées ");
            
        } catch (SQLException ex) {
         System.err.println(ex.getMessage());
        }
    }
    
        
     @Override
    public List<Utilisateur> findAll() throws SQLException {
         List<Utilisateur> myList = new ArrayList<>();
        String req = "SELECT * FROM user";
        Statement st;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Utilisateur e = new Utilisateur();
                e.setId(rs.getInt(1));
                e.setUsername(rs.getString(5));
                e.setEmail(rs.getString(2));
                 e.setPassword(rs.getString(4));
                 e.setRoles(rs.getString(3));
              
              
              
                myList.add(e);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServiceUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }

        return myList;
    }
    
    
    
    @Override
    public Utilisateur findById(int id) throws SQLException {
          Utilisateur user = new Utilisateur();
        String request = "SELECT * FROM user where id="+id;
        Statement st;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(request);
            while (rs.next()) {
                Utilisateur e = new Utilisateur();
                e.setId(rs.getInt(1));
                e.setUsername(rs.getString(5));
                e.setEmail(rs.getString(2));
                e.setPassword(rs.getString(4));
                 e.setRoles(rs.getString(3));
              
              
             
                user=e;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServiceUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }

        return user;
    }
    
    
   
    public void update(Utilisateur t) throws SQLException {
        PreparedStatement pre = cnx.prepareStatement("UPDATE `user` SET `email` = ?, `password` = ?, `username` = ?  WHERE `id` = ?");
       
        pre.setString(3, t.getUsername());
        pre.setString(1, t.getEmail());
        pre.setString(2, t.getPassword());
        pre.setInt(4, t.getId());
        pre.executeUpdate();
    }

    
    
    
    
    
    
    
    
    
    
    
    
        public String HashPass(String pass) {
        try {
            MessageDigest ms = MessageDigest.getInstance("MD5");

            ms.update(password.getBytes());

            byte[] resultByteArray = ms.digest();

            StringBuilder sb = new StringBuilder();

            for (byte b : resultByteArray) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return "";
    }

   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
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
       
        String query = "INSERT INTO `user` (`id`, `username`, `email`, `password`,  `roles`, `securityq`, `answer`,`num_tel`) VALUES (?, ?, ?, ?, ? , ? , ? , ? );";
        
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
                 ste.setString(6, utilisateur.getSecurityq());
                ste.setString(7, utilisateur.getAnswer());
          
               
                ste.setInt(8,utilisateur.getNumtel());

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
    
    
    
  
    public void add(Utilisateur t) throws SQLException {
        PreparedStatement pre =
                cnx.prepareStatement(
                        "INSERT INTO  `User` " +
                                "(`email`, `password`,`roles`, `username`) " +
                                "VALUES ( ?, ?,'{}', ?)"
                );
        pre.setString(1, t.getEmail());
        pre.setString(2, t.getPassword());
        pre.setString(3, t.getUsername());
  
        pre.executeUpdate();
    }
    
    public void updatex(Utilisateur t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    public List<Utilisateur> findAllx() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    public Utilisateur findByIdx(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Utilisateur> searchBy(String column, String query) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Utilisateur> sortBy(String column, boolean descending) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Utilisateur getByEmail(String  mail) {
         Utilisateur t = new Utilisateur();
         int idd=0;
        
        try {
        
            String req = ("Select id from User WHERE email = '" + mail+"'");
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req); 
            
            rs.next();  
            
                t.setId(rs.getInt("id"));
                t.setUsername(rs.getString("username"));
                t.setEmail(rs.getString("email"));
                t.setPassword(rs.getString("password"));
                t.setSecurityq(rs.getString("securityq"));
                t.setAnswer(rs.getString("answer"));
                  t.setNumtel(rs.getInt("num_tel"));
                  idd = t.getId();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return t;
    }
     public Utilisateur getByidd(int   id) {
         Utilisateur t = new Utilisateur();
         int idd=0;
        
        try {
        
            String req = ("Select * from User WHERE id = '" + id+"'");
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req); 
            
            rs.next();  
            
                t.setId(rs.getInt("id"));
                t.setUsername(rs.getString("username"));
                t.setEmail(rs.getString("email"));
                t.setPassword(rs.getString("password"));
                t.setSecurityq(rs.getString("securityq"));
                t.setAnswer(rs.getString("answer"));
                  t.setNumtel(rs.getInt("num_tel"));
                  idd = t.getId();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return t;
    }
    

}
