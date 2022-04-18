/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc;

import java.util.List;
import workshopjdbc.entities.Utilisateur;
import workshopjdbc.services.ServiceUtilisateur;

/**
 *
 * @author Lenovo
 */
public class WorkshopJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
Utilisateur u2 = new Utilisateur("chamsssss","chams@esprit.tn","chams123","[\"ROLE_USER\"]");
u2.setId(13);
    ServiceUtilisateur nu= new ServiceUtilisateur();
   
    //ajout
   // nu.ajouter(u2);  
    
    
    //afficher
   /*     List<Utilisateur> users= nu.afficher();
    
        for(Utilisateur user:users){
            System.out.println(user.toString());
        }
    
    */
   
   
   //update
 //  nu.modifier(u2);
  
  
  //delete
  //nu.supprimer(u2);
   
  //login
  if(nu.verifPassword("chams@esprit.tn", "chams123")){
      System.out.println("Ok");
  }else{
       System.out.println("Ko");
  }
  
  
    }
    
}
