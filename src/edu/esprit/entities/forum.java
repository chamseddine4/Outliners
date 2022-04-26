/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

/**
 *
 * @author Firas
 */
public class forum {
    
    private int id;
    private int user_id ;
    private String titre;
    private String contenu;

    
    
    //default constructor
    public forum() {
    }
    
    //with ids
    public forum(int id, int user_id, String titre, String contenu) {
        this.id = id;
        this.user_id = user_id;
        this.titre = titre;
        this.contenu = contenu;
    }
    //without ids
    public forum(String titre, String contenu) {
        this.titre = titre;
        this.contenu = contenu;
    }
 public forum(int id, String titre, String contenu) {
        this.id = id;
      
        this.titre = titre;
        this.contenu = contenu;
        }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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
        return "forum{" + "id=" + id + ", user_id=" + user_id + ", titre=" + titre + ", contenu=" + contenu + '}';
    }


   
   
            
}
