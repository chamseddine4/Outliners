/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.entities;

/**
 *
 * @author Lenovo
 */
public class Utilisateur {
    
    
    private int id; 
    private String username,email,password,roles;
    public String getEmail;
   

    public Utilisateur(int id, String username, String email, String password, String roles ) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
        this.roles = roles;
    }

    public Utilisateur(String username, String email, String password, String roles) {
           this.email = email;
        this.password = password;
        this.username = username;
        this.roles = roles;
    }

    public Utilisateur() {
        
    }


   

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

 


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "Utilisateur{" + "id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", roles=" + roles + '}';
    }


  



    
}
