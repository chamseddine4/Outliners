/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.entities;

/**
 *
 * @author ziedm
 */
public class participation_prive {
    
    
     private int id;
  
    private int numero_tel ;
    
    private int nbrPrisecharge ;
    String Email;
    Utilisateur user;

    public participation_prive() {
    }

    public participation_prive(int id, int numero_tel, int nbrPrisecharge, Utilisateur user , String Email) {
        this.id = id;
        this.numero_tel = numero_tel;
        this.nbrPrisecharge = nbrPrisecharge;
         this.user = user;
        this.Email = Email;
       
    }

    public participation_prive(int id, int numero_tel, int nbrPrisecharge, String Email) {
        this.id = id;
        this.numero_tel = numero_tel;
        this.nbrPrisecharge = nbrPrisecharge;
        this.Email = Email;
    }

    public participation_prive(int numero_tel, int nbrPrisecharge, Utilisateur user, String Email) {
        this.numero_tel = numero_tel;
        this.nbrPrisecharge = nbrPrisecharge;
          this.user = user;
        this.Email = Email;
      
    }
    
    
    
    

    public participation_prive(int id, int numero_tel, int nbrPrisecharge) {
        this.id = id;
        this.numero_tel = numero_tel;
        this.nbrPrisecharge = nbrPrisecharge;
    }

    public participation_prive(int numero_tel, int nbrPrisecharge) {
        this.numero_tel = numero_tel;
        this.nbrPrisecharge = nbrPrisecharge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroTel() {
        return numero_tel;
    }

    public void setNumeroTel(int numero_tel) {
        this.numero_tel = numero_tel;
    }

    public int getNbrPrisecharge() {
        return nbrPrisecharge;
    }

    public void setNbrPrisecharge(int nbrPrisecharge) {
        this.nbrPrisecharge = nbrPrisecharge;
    }

    public int getNumero_tel() {
        return numero_tel;
    }

    public void setNumero_tel(int numero_tel) {
        this.numero_tel = numero_tel;
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

    @Override
    public String toString() {
        return "participation_prive{" + "id=" + id + ", numero_tel=" + numero_tel + ", nbrPrisecharge=" + nbrPrisecharge + ", Email=" + Email + ", user=" + user + '}';
    }

    
    
    
    
}
