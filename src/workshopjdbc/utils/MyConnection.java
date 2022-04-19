/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public class MyConnection {

 
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

}
