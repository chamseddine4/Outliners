/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.entities;

import java.util.Objects;

/**
 *
 * @author Lenovo
 */
public class Utilisateur {


    
    
    int id,numtel;
    private String username,email,password,roles;
    public String getEmail;
     String securityq, answer;
     
         public Utilisateur(String securityq, String answer) {
        this.securityq = securityq;
        this.answer = answer;
    }
   

    public Utilisateur(int id, String username, String email, String password, String roles ) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
        this.roles = roles;
    }

    public Utilisateur(int id, int numtel, String username, String email, String securityq, String answer) {
        this.id = id;
        this.numtel = numtel;
        this.username = username;
        this.email = email;
        this.securityq = securityq;
        this.answer = answer;
    }


    public Utilisateur(int numtel, String username, String email, String password, String getEmail, String securityq, String answer) {
        this.numtel = numtel;
        this.username = username;
        this.email = email;
        this.password = password;
        this.getEmail = getEmail;
        this.securityq = securityq;
        this.answer = answer;
    }

    public Utilisateur(int id, int numtel, String username, String email, String password, String getEmail, String securityq, String answer) {
        this.id = id;
        this.numtel = numtel;
        this.username = username;
        this.email = email;
        this.password = password;
        this.getEmail = getEmail;
        this.securityq = securityq;
        this.answer = answer;
    }

    public Utilisateur(int numtel, String username, String email, String password, String roles, String getEmail, String securityq, String answer) {
        this.numtel = numtel;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.getEmail = getEmail;
        this.securityq = securityq;
        this.answer = answer;
    }

    public Utilisateur(int id, int numtel, String username, String email, String password, String roles, String getEmail, String securityq, String answer) {
        this.id = id;
        this.numtel = numtel;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.getEmail = getEmail;
        this.securityq = securityq;
        this.answer = answer;
    }

    public Utilisateur(String username, String email, String password, String roles) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.roles = roles;
    }

    public Utilisateur() {
        
    }
   public Utilisateur (String username, String email, String password) {
         this.username = username;
         this.email = email;
         this.password = password;
      
      
    }

   

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

 
    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumtel() {
        return numtel;
    }

    public void setNumtel(int numtel) {
        this.numtel = numtel;
    }

    public String getSecurityq() {
        return securityq;
    }

    public void setSecurityq(String securityq) {
        this.securityq = securityq;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

  
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", numtel=" + numtel + ", username=" + username + ", email=" + email + ", password=" + password + ", roles=" + roles + ", getEmail=" + getEmail + ", securityq=" + securityq + ", answer=" + answer + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Utilisateur other = (Utilisateur) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.numtel != other.numtel) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.roles, other.roles)) {
            return false;
        }
        if (!Objects.equals(this.getEmail, other.getEmail)) {
            return false;
        }
        if (!Objects.equals(this.securityq, other.securityq)) {
            return false;
        }
        if (!Objects.equals(this.answer, other.answer)) {
            return false;
        }
        return true;
    }


  



    
}
