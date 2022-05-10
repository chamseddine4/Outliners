/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.entities;

import workshopjdbc.entities.Utilisateur;

/**
 *
 * @author Zied
 */
public class participation_public {
    
    private int id;
  
    private int donation;
    String Email;
    Utilisateur user;


    public participation_public() {
    }

    public participation_public(int id, int donation) {
        this.id = id;
        this.donation = donation;
      
    }

    public participation_public(int id, int donation, String Email) {
        this.id = id;
        this.donation = donation;
        this.Email = Email;
    }

    public participation_public(int donation, String Email) {
        this.donation = donation;
        this.Email = Email;
    }

    public participation_public(int donation, Utilisateur user, String Email) {
        this.donation = donation;
        
        this.user = user;
        this.Email = Email;
    }

    public participation_public(int id, int donation, Utilisateur user, String Email) {
        this.id = id;
        this.donation = donation;
         this.user = user;
        this.Email = Email;
       
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }
    
    
    

    
    public participation_public( int donation) {
      
         this.donation = donation;
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDonation() {
        return donation;
    }

    public void setDonation(int donation) {
        this.donation = donation;
    }

    @Override
    public String toString() {
        return "participation_public{" + "id=" + id + ", donation=" + donation + ", Email=" + Email + ", user=" + user + '}';
    }

   

    
   
            
}
