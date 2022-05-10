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
public class forum {
    
    private int id;
    private String titre;
    private String contenu;

       String Email;
    Utilisateur user;
    
    //default constructor
    public forum() {
    }
    
    //with ids
    public forum(int id, String titre, String contenu) {
        this.id = id;
        this.titre = titre;
        this.contenu = contenu;
    }
    //without ids
    public forum(String titre, String contenu) {
        this.titre = titre;
        this.contenu = contenu;
    }

    public forum(int id, String titre, String contenu, Utilisateur user, String Email) {
        this.id = id;
        this.titre = titre;
        this.contenu = contenu;
          this.user = user;
        this.Email = Email;
      
    }

    public forum(String titre, String contenu, Utilisateur user, String Email) {
        this.titre = titre;
        this.contenu = contenu;
         this.user = user;
        this.Email = Email;
       
    }

    public forum(int id, String titre, String contenu, String Email) {
        this.id = id;
        this.titre = titre;
        this.contenu = contenu;
        this.Email = Email;
    }

    public forum(String titre, String contenu, String Email) {
        this.titre = titre;
        this.contenu = contenu;
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
    
    
 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    @Override
    public String toString() {
        return "forum{" + "id=" + id + ", titre=" + titre + ", contenu=" + contenu + ", Email=" + Email + ", user=" + user + '}';
    }

 

   
   
            
}
