/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.services;



import workshopjdbc.utils.MyConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import workshopjdbc.entities.category;

/**
 *
 * @author Dhia
 */
public class categoryCRUD {
     Connection cnx2;

    public categoryCRUD() {
      cnx2 =MyConnection.getInstance().getCnx();
        
    }


    public void ajouter_category(category c) {
        try {
            String requete1 = "INSERT INTO category(nom) VALUES (?)";
           PreparedStatement pst =cnx2.prepareStatement(requete1);
            pst.setString(1, c.getNom());
          
            pst.executeUpdate();
            System.out.println("Category ajouté !");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    


    public ObservableList<category> listercategory() {
        ObservableList<category> myList = FXCollections.observableArrayList();
        try {

            String requete2 = "Select * FROM category";
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(requete2);
            while (rs.next()) {
                category eve = new category();
                eve.setId(rs.getInt("id"));
                eve.setNom(rs.getString("nom"));
              
             
                myList.add(eve);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return myList;
    }

    public void supprimer_category(category c) {

        try {
            String requete3 = "DELETE FROM category WHERE id=" + c.getId();
            PreparedStatement st =cnx2.prepareStatement(requete3);
            st.executeUpdate(requete3);
             System.out.println("category supprimé !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void modifier_category(category c, String nom) {
        try {

            String requete4 = " UPDATE  category SET nom = ?  WHERE id =" + c.getId();
            PreparedStatement pst =cnx2.prepareStatement(requete4);
            pst.setString(1, nom);
           
            pst.executeUpdate();
            System.out.println("category modifié !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
