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
public class reply {
    
    private int id;
    private int rating;
    private String contenu;


    public reply() {
    }

    public reply(int id, int rating, String contenu) {
        this.id = id;
        this.rating = rating;
        this.contenu = contenu;

    
    

    
   
      
    }

    public reply(int rating, String contenu) {
        this.rating = rating;
        this.contenu = contenu;
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
        return "reply{" + " rating=" + rating + ", contenu=" + contenu + '}';
    }
 }