/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

/**
 *
 * @author ziedm
 */
public class participation_prive {
    
    
     private int id;
  
    private int numero_tel ;
    
    private int nbrPrisecharge ;

    public participation_prive() {
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

    @Override
    public String toString() {
        return "prive{" + "id=" + id + ", numero_tel=" + numero_tel + ", nbrPrisecharge=" + nbrPrisecharge + '}';
    }
    
    
    
    
    
    
}
