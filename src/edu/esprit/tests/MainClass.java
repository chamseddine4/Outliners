/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tests;

import edu.esprit.entities.Personne;

import edu.esprit.services.PersonneCRUD;

import edu.esprit.utils.Myconnection;

/**
 *
 * @author Dhia
 */
public class MainClass {
    public static void main(String[] args) {
       Myconnection mc = Myconnection.getInstance();
       
       PersonneCRUD pcd = new PersonneCRUD();
   Personne F2= new Personne("chams","kk",123,"chams");
 //  pcd.ajouterPersonne2(F2);
   //pcd.supprimerPersonne("chams");
     pcd.updatePersonne(57, "pp", "z",12,"aa");
       System.out.println(pcd.afficherPersonne());
      
     
       
       
       
    }
}
 