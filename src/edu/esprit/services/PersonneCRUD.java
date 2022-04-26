/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import edu.esprit.entities.Personne;
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
 * @author Dhia
 */
public class PersonneCRUD {
Connection cnx2;

    public PersonneCRUD() {
        cnx2 =Myconnection.getInstance().getCnx();
        
    }
    
    public void ajouterPersonne(){
        try {
            String requete ="INSERT INTO Personne(nom,adress,num_tel,email)" + "VALUES('dhia','elair',1,'k')";
            Statement st = cnx2.createStatement();  //objet ramener la requette vers sjbd w yekhou resultat;
        st.executeUpdate(requete); //mise a jours de base de donne 
            System.out.println("Personne ajouté avec succés");
        } catch (SQLException ex) {
            System.err.println("ex.getMessage()"); 
        }
        
    }
     public void ajouterPersonne2(Personne F){
        try {
            String requete2 ="INSERT INTO Personne(nom,adress,num_tel,email)" + "VALUES(?,?,?,?)";
            PreparedStatement pst =cnx2.prepareStatement(requete2);
            pst.setString(1, F.getNom());
            pst.setString(2, F.getAdress());
            pst.setInt(3,F.getNum_tel());
            pst.setString(4,F.getEmail());
            
            pst.executeUpdate();
            System.out.println("votre Personne est ajoutee");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
   public ObservableList<Personne>afficherPersonne(){
       ObservableList<Personne> myList = FXCollections.observableArrayList();
        try {
            
            String requete3 = "SELECT * FROM Personne";
            Statement st = cnx2.createStatement();
           ResultSet rs = st.executeQuery(requete3);
           while(rs.next()){
               Personne F = new Personne();
               F.setId(rs.getInt(1));
               F.setNom(rs.getString("nom"));
               F.setAdress(rs.getString("adress"));
               F.setNum_tel(rs.getInt("num_tel"));
               F.setEmail(rs.getString("email"));
               myList.add(F);
           }
           
           
           
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
        
        
   }  
   public void supprimerPersonne(String nom){
        try {
            String requete3 ="DELETE FROM Personne WHERE nom=?";
            PreparedStatement pst =cnx2.prepareStatement(requete3);
          pst.setString(1,"chams");
            
            pst.executeUpdate();
            System.out.println("votre Personne est supprimee");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
   public void updatePersonne(int id ,String nom,String adress,int num_tel,String email){
        try {
            String requete4 =" UPDATE Personne SET " + " nom = ?, adress = ?,num_tel=?, email=? WHERE id = ?";
            PreparedStatement pst =cnx2.prepareStatement(requete4);
                       pst.setInt(5, id);
                        pst.setString(1, nom);
                        pst.setString(2, adress);
                        pst.setInt(3, num_tel);
                        pst.setString(4, email);
                        
            pst.executeUpdate();
            System.out.println("votre Personne est modifiee");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
   
   
    }
     
     

