/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

/**
 *
 * @author Dhia
 */
public class Personne {
    
    private int id;
    private String nom;
    private String adress;
    private int num_tel;
    private String email;

    public Personne() {
    }

    public Personne(int id, String nom, String adress, int num_tel, String email) {
        this.id = id;
        this.nom = nom;
        this.adress = adress;
        this.num_tel = num_tel;
        this.email = email;
    }
    
    

    
    public Personne(String nom, String adress, int num_tel, String email) {
        this.nom = nom;
        this.adress = adress;
         this.num_tel = num_tel;
        this.email = email;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Fournisseur{" + "id=" + id + ", nom=" + nom + ", adress=" + adress + ", num_tel=" + num_tel + ", email=" + email + '}';
    }

   
            
}
