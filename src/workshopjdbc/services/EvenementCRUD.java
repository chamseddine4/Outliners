/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.services;


import workshopjdbc.utils.MyConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import workshopjdbc.entities.Evenement;

/**
 *
 * @author ASUS
 */



    







public class EvenementCRUD {
    Connection cnx2;

    public EvenementCRUD() {
        cnx2 =MyConnection.getInstance().getCnx();
        
    }


    public void ajouter_evenement(Evenement e) {
        try {
            String requete1 = "INSERT INTO evenements(nom,type_e,date_debut,date_fin,description) VALUES (?,?,?,?,?)";
           PreparedStatement pst =cnx2.prepareStatement(requete1);
            pst.setString(1, e.getNom());
            pst.setString(2, e.getType_e());
            
            pst.setDate(3, e.getDate_debut());
            pst.setDate(4, e.getDate_fin());
            pst.setString(5, e.getDescription());
            pst.executeUpdate();
            System.out.println("Evenement ajouté !");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    

    public ObservableList<Evenement> listerEvenements() {
        ObservableList<Evenement> myList = FXCollections.observableArrayList();
        try {

            String requete2 = "Select * FROM evenements";
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(requete2);
            while (rs.next()) {
                Evenement eve = new Evenement();
                eve.setId(rs.getInt("id"));
                eve.setNom(rs.getString("nom"));
                eve.setType_e(rs.getString("type_e"));
               
                eve.setDate_debut(rs.getDate("date_debut"));
                eve.setDate_fin(rs.getDate("date_fin"));
                eve.setDescription(rs.getString("description"));
                myList.add(eve);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return myList;
    }

    public void supprimer_evenement(Evenement E) {

        try {
            String requete3 = "DELETE FROM evenements WHERE id=" + E.getId();
            PreparedStatement st =cnx2.prepareStatement(requete3);
            st.executeUpdate(requete3);
             System.out.println("Evenement supprimé !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void modifier_evenement(Evenement e, String nom, String type_e, Date date_debut, Date date_fin, String description) {
        try {

            String requete4 = " UPDATE  evenements SET nom = ? , type_e=?, date_debut=? ,date_fin=?, description=? WHERE id =" + e.getId();
           PreparedStatement pst =cnx2.prepareStatement(requete4);
            pst.setString(1, nom);
            pst.setString(2, type_e);
          
            pst.setDate(3, date_debut);
            pst.setDate(4, date_fin);
            pst.setString(5, description);
            pst.executeUpdate();
            System.out.println("Evenement modifié !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }



}
