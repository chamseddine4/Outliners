/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

/**
 *
 * @author Zied
 */
public class participation_public {
    
    private int id;
  
    private int donation;


    public participation_public() {
    }

    public participation_public(int id, int donation) {
        this.id = id;
        this.donation = donation;
      
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
        return "Participation{" + "id=" + id + ", donation=" + donation + '}';
    }

   

    
   
            
}
