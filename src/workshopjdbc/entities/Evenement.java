/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.entities;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author ASUS
 */
public class Evenement {
    private  int id;
    private String nom;
    private String type_e;
   
    private Date date_debut;
    private Date date_fin;
  
     private String description;
   
    
    
   public Evenement(){}

    public Evenement(int id, String nom, String type_e, Date date_debut, Date date_fin, String description) {
        this.id = id;
        this.nom = nom;
        this.type_e = type_e;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.description = description;
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

    public String getType_e() {
        return type_e;
    }

    public void setType_e(String type_e) {
        this.type_e = type_e;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Evenement{" + "id=" + id + ", nom=" + nom + ", type_e=" + type_e + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", description=" + description + '}';
    }
   

    
  

}
