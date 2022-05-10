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
public class reclamation {
    
    private int id;
    private String titre;
    private String contenu;
    String Email;
    Utilisateur user;

    public reclamation(int id, String titre, String contenu, Utilisateur user, String Email) {
        this.id = id;
        this.titre = titre;
        this.contenu = contenu;
        
        this.user = user;
        this.Email = Email;
    }
      public reclamation( String titre, String contenu, Utilisateur user, String Email) {
        
        this.titre = titre;
        this.contenu = contenu;
        
        this.user = user;
        this.Email = Email;
    }

    public reclamation(int id, String titre, String contenu, String Email) {
        this.id = id;
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

    public reclamation(String titre, String contenu, Utilisateur user) {
        this.titre = titre;
        this.contenu = contenu;
        this.user = user;
    }

    public reclamation(int id, String titre, String contenu, Utilisateur user) {
        this.id = id;
        this.titre = titre;
        this.contenu = contenu;
        this.user = user;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public reclamation() {
    }

    public reclamation(int id, String titre, String contenu) {
        this.id = id;
        this.titre = titre;
        this.contenu = contenu;
    }

    public reclamation(String titre, String contenu) {
        this.titre = titre;
        this.contenu = contenu;
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
        return "reclamation{" + "id=" + id + ", titre=" + titre + ", contenu=" + contenu + ", Email=" + Email + ", user=" + user + '}';
    }

 
 
    
    
}
