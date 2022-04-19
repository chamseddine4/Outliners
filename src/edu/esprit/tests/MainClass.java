/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tests;


import edu.esprit.entities.paiement;
import edu.esprit.entities.participation_prive;
import edu.esprit.entities.participation_public;
import edu.esprit.services.PaiementCRUD;
import edu.esprit.services.ParticipationCRUD;


import edu.esprit.services.PriveCRUD;

import edu.esprit.utils.Myconnection;

/**
 *
 * @author Zied
 */
public class MainClass {
    public static void main(String[] args) {
       Myconnection mc = Myconnection.getInstance();
      
       //Participation Public
       
       
      ParticipationCRUD pcd = new ParticipationCRUD();
 //  participation_public F2= new participation_public(300);
 // pcd.ajouterParticipation2(F2);
  // pcd.supprimerParticipation(300);
  //  pcd.updateParticipation(2,12);
  //    System.out.println(pcd.afficherParticipation());
      
       //Participation Prive
       
       
      PriveCRUD pcd1 = new PriveCRUD();
    //  participation_prive F3= new participation_prive(31,333333333,20);
 // pcd1.ajouterPrive2(F3);
 //  pcd1.supprimerPrive(20688495);
 //   pcd1.updatePrive(3,20688495,12);
//       System.out.println(pcd1.afficherPrive());
      
       //Paiement
     
      PaiementCRUD pcd2 = new PaiementCRUD();
    // paiement F4= new paiement("zied",888899991,"mai",2023,555);
     //  pcd2.ajouterPaiement2(F4);
  // pcd2.supprimerPaiement(23344566);
  // pcd2.updatePaiement(3,"zied",555566661,"september",2026,444);
    //  System.out.println(pcd2.afficherPaiement());
       
       
    }
    
    
    
}
 