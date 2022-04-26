/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;


import static edu.esprit.Services.SmsSender.send;
import edu.esprit.entities.participation_prive;
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
public class PriveCRUD {
    
    
    Connection cnx2;

    public PriveCRUD() {
        cnx2 =Myconnection.getInstance().getCnx();
        
    }
    
    public void ajouterPrive(){
        try {
            String requete ="INSERT INTO participation_prive (numero_tel,nbr_prisecharge)" + "VALUES(21666111,29)";
            Statement st = cnx2.createStatement();  //objet ramener la requette vers sjbd w yekhou resultat;
        st.executeUpdate(requete); //mise a jours de base de donne 
            System.out.println("Participation Prive ajouté avec succés");
        } catch (SQLException ex) {
            System.err.println("ex.getMessage()"); 
        }
        
}
     public void ajouterPrive2(participation_prive F){
        try {
            String requete2 ="INSERT INTO participation_prive(numero_tel,nbr_prisecharge)" + "VALUES(?,?)";
            PreparedStatement pst =cnx2.prepareStatement(requete2);
            pst.setInt(1,F.getId());
            pst.setInt(1,F.getNumeroTel());
            pst.setInt(2,F.getNbrPrisecharge());
            
            pst.executeUpdate();
            System.out.println("votre Participation prive est ajoutee");
            send (F);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public ObservableList<participation_prive>afficherPrive(){
       ObservableList<participation_prive> myList = FXCollections.observableArrayList();
        try {
            
            String requete3 = "SELECT * FROM participation_prive";
            Statement st = cnx2.createStatement();
           ResultSet rs = st.executeQuery(requete3);
           while(rs.next()){
               participation_prive F = new participation_prive();
               F.setId(rs.getInt(1));
                F.setNumeroTel(rs.getInt("numero_tel"));
               F.setNbrPrisecharge(rs.getInt("nbr_prisecharge"));
              
               myList.add(F);
           }
           
           
           
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
        
}
    
   public void supprimerPrive(participation_prive p){
        try {
            String requete3 ="DELETE FROM participation_prive WHERE id="+p.getId();
            PreparedStatement pst =cnx2.prepareStatement(requete3);
         
            
            pst.executeUpdate();
            System.out.println("votre Participation Prive est supprimee");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    } 
    
   public void updatePrive(int id ,int numero_tel,int nbr_prisecharge){
        try {
            String requete4 =" UPDATE participation_prive SET " + " numero_tel=?, nbr_prisecharge=? WHERE id = ?";
            PreparedStatement pst =cnx2.prepareStatement(requete4);
                       pst.setInt(3, id);
                       
                       pst.setInt(1, numero_tel);
                       pst.setInt(2, nbr_prisecharge);
                       
                        
            pst.executeUpdate();
            System.out.println("votre Participation Prive est modifiee");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
   
   
 
    public ObservableList<participation_prive> Affichertout()  {
        ObservableList<participation_prive> list = FXCollections.observableArrayList();
        String requete = "SELECT * FROM participation_prive";
        try {
            PreparedStatement ps = cnx2.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

             list.add( new participation_prive(rs.getInt("id"),rs.getInt("numero_tel"),rs.getInt("nbr_prisecharge")));
 }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    
    }
    
    
    
}