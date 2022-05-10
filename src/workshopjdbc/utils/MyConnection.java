/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.utils;

import workshopjdbc.entities.SDF;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import workshopjdbc.entities.Utilisateur;

/**
 *
 * @author Lenovo
 */
public class MyConnection {
    
    
    public static Utilisateur userconnected=new Utilisateur();
 
    public String url = "jdbc:mysql://localhost:3306/moeataz";
    public String user = "root";
    public String pwd = "";

    private Connection cnx;

    private static MyConnection connect;

    private MyConnection() {
        try {
            cnx = DriverManager.getConnection(url, user, pwd);
            System.out.println("Connected Successfully");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    
     public static MyConnection getInstance(){
        if(connect == null)
            connect = new MyConnection();
        return connect;
    }
    public Connection getCnx(){
        return cnx;
    }

       public static ObservableList<SDF> getDataSDF(){
        Connection conn = ConnectDb();
        ObservableList<SDF> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from sdf");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){   
                list.add(new SDF(rs.getInt("id"),rs.getString("name"),rs.getString("lastname"),rs.getString("gender"),rs.getInt("age")));              
            }
        } catch (Exception e) {
        }
        return list;
    }
       public static Connection ConnectDb(){
        try {
            
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/moeataz","root","");
           // JOptionPane.showMessageDialog(null, "Connection Established");
           
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
}
