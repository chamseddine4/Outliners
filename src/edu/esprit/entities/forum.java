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
    private String titre;
    private String contenu;


    public forum() {
    }

    public forum(int id, String titre, String contenu) {
        this.id = id;
        this.titre = titre;
        this.contenu = contenu;

    
    

    
   
      
    }

    public forum(String titre, String contenu) {
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
        return "Forum{" + " titre=" + titre + ", contenu=" + contenu + '}';
    }

   

   
   
            
}
