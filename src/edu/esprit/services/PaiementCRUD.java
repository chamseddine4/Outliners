/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import edu.esprit.entities.paiement;
import edu.esprit.entities.participation_public;
import edu.esprit.utils.Myconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ziedm
 */
public class PaiementCRUD {
    
    
      Connection cnx2;

    public PaiementCRUD() {
        cnx2 =Myconnection.getInstance().getCnx();
        
    }
    
   public void ajouterPaiement(){
        try {
            String requete ="INSERT INTO paiement (nom_sur_carte,num_carte,mois_exp,annee_exp,cvv)" + "VALUES('zied',888899991,'mai',2023,555)";
            Statement st = cnx2.createStatement();  //objet ramener la requette vers sjbd w yekhou resultat;
        st.executeUpdate(requete); //mise a jours de base de donne 
            System.out.println("Paiement ajouté avec succés");
        } catch (SQLException ex) {
            System.err.println("ex.getMessage()"); 
        }
        
} 
     public void ajouterPaiement2(paiement F){
        try {
            String requete2 ="INSERT INTO paiement(nom_sur_carte,num_carte,mois_exp,annee_exp,cvv)" + "VALUES(?,?,?,?,?)";
            PreparedStatement pst =cnx2.prepareStatement(requete2);
            pst.setString(1, F.getNomSurCarte());
            pst.setInt(2,F.getNumCarte());
            pst.setString(3, F.getMoisExp());
            pst.setInt(4,F.getAnneeExp());
            pst.setInt(5,F.getCvv());
            
            pst.executeUpdate();
            System.out.println("votre Paiement est ajoutee");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
     public ObservableList<paiement>afficherPaiement(){
       ObservableList<paiement> myList = FXCollections.observableArrayList();
        try {
            
            String requete3 = "SELECT * FROM paiement";
            Statement st = cnx2.createStatement();
           ResultSet rs = st.executeQuery(requete3);
           while(rs.next()){
               paiement F = new paiement();
               F.setId(rs.getInt(1));
               F.setNomSurCarte(rs.getString("nom_sur_carte"));
               F.setNumCarte(rs.getInt("num_carte"));
               F.setMoisExp(rs.getString("mois_exp"));
               F.setAnneeExp(rs.getInt("annee_exp"));
               F.setCvv(rs.getInt("cvv"));
               myList.add(F);
           }
           
           
           
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
        
        
   }  
   public void supprimerPaiement(int num_carte){
        try {
            String requete3 ="DELETE FROM paiement WHERE num_carte=?";
            PreparedStatement pst =cnx2.prepareStatement(requete3);
          pst.setInt(1,23344566);
            
            pst.executeUpdate();
            System.out.println("Paiement est supprimee");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
   public void updatePaiement(int id ,String nom_sur_carte,int num_carte,String mois_exp,int annee_exp,int cvv){
        try {
            String requete4 =" UPDATE paiement SET " + " nom_sur_carte = ?, num_carte = ?,mois_exp=?, annee_exp=?, cvv=? WHERE id = ?";
            PreparedStatement pst =cnx2.prepareStatement(requete4);
                       pst.setInt(6, id);
                        pst.setString(1, nom_sur_carte);
                        pst.setInt(2, num_carte);
                        pst.setString(3, mois_exp);
                        pst.setInt(4, annee_exp);
                        pst.setInt(5, cvv);
                        
            pst.executeUpdate();
            System.out.println("Paiement est modifiee");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
   
   
     public ObservableList<paiement> Affichertout()  {
        ObservableList<paiement> list = FXCollections.observableArrayList();
        String requete = "SELECT * FROM paiement";
        try {
            PreparedStatement ps = cnx2.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

             list.add( new paiement(rs.getInt("id"),rs.getString("nom_sur_carte"),rs.getInt("num_carte"),rs.getString("mois_exp"),rs.getInt("annee_exp"),rs.getInt("cvv")));
 }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    
    }
    
   
   
   
}
