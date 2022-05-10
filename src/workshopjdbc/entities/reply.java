/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.entities;

/**
 *
 * @author Firas
 */
public class reply {
    
    private int id;
  
      private int ad;
        private int rating;
    private String contenu;
    
       String Email;
    Utilisateur user;


    public reply() {
    }

    public reply(int id,int ad, int rating, String contenu){
        this.id = id;
         this.ad = ad;
        this.rating = rating;
        this.contenu = contenu;
                }

    public reply(int ad,int rating,  String contenu) {
        this.rating = rating;
        this.ad = ad;
        this.contenu = contenu;
    }

    public reply(int id, int ad, int rating, String contenu, Utilisateur user, String Email) {
        this.id = id;
        this.ad = ad;
        this.rating = rating;
        this.contenu = contenu;
         this.user = user;
        this.Email = Email;
       
    }

    public reply(int ad, int rating, String contenu , Utilisateur user, String Email) {
        this.ad = ad;
        this.rating = rating;
        this.contenu = contenu;
          this.user = user;
        this.Email = Email;
      
    }

    public reply(int rating, String contenu, String Email) {
        this.rating = rating;
        this.contenu = contenu;
        this.Email = Email;
    }

    public reply(int rating, String contenu, Utilisateur user, String Email) {
        this.rating = rating;
        this.contenu = contenu;
          this.user = user;
        this.Email = Email;
      
    }

    public reply(int id, int rating, String contenu, String Email) {
        this.id = id;
        this.rating = rating;
        this.contenu = contenu;
        this.Email = Email;
    }

    
    
    
    public reply(String contenu) {
        this.contenu = contenu;
    }
     public reply(int ad) {
        this.ad = ad;
    }
    

    public reply(int rating, String contenu) {
        this.rating = rating;
        this.contenu = contenu;
    }

    public int getAd() {
        return ad;
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

    public void setAd(int ad) {
        this.ad = ad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    @Override
    public String toString() {
        return "reply{" + "id=" + id + ", ad=" + ad + ", rating=" + rating + ", contenu=" + contenu + ", Email=" + Email + ", user=" + user + '}';
    }

 
 }