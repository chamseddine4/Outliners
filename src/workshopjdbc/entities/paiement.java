/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.entities;

import workshopjdbc.entities.Utilisateur;

/**
 *
 * @author ziedm
 */
public class paiement {
    
    private int id;

    private String nom_sur_carte;
    
    private int num_carte ;
    
    private String mois_exp;
    
    private int annee_exp;
    
    private int cvv ;
  



    public paiement() {
    }

    public paiement(int id, String nom_sur_carte, int num_carte, String mois_exp, int annee_exp, int cvv) {
        this.id = id;
        this.nom_sur_carte = nom_sur_carte;
        this.num_carte = num_carte;
        this.mois_exp = mois_exp;
        this.annee_exp = annee_exp;
        this.cvv = cvv;
    }

    public paiement(String nom_sur_carte, int num_carte, String mois_exp, int annee_exp, int cvv) {
        this.nom_sur_carte = nom_sur_carte;
        this.num_carte = num_carte;
        this.mois_exp = mois_exp;
        this.annee_exp = annee_exp;
        this.cvv = cvv;
    }



    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomSurCarte() {
        return nom_sur_carte;
    }

    public void setNomSurCarte(String nom_sur_carte) {
        this.nom_sur_carte = nom_sur_carte;
    }

    public int getNumCarte() {
        return num_carte;
    }

    public void setNumCarte(int num_carte) {
        this.num_carte = num_carte;
    }

    public String getMoisExp() {
        return mois_exp;
    }

    public void setMoisExp(String mois_exp) {
        this.mois_exp = mois_exp;
    }

    public int getAnneeExp() {
        return annee_exp;
    }

    public void setAnneeExp(int annee_exp) {
        this.annee_exp = annee_exp;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    @Override
    public String toString() {
        return "paiement{" + "id=" + id + ", nom_sur_carte=" + nom_sur_carte + ", num_carte=" + num_carte + ", mois_exp=" + mois_exp + ", annee_exp=" + annee_exp + ", cvv=" + cvv + '}';
    }


    
    
    
}
