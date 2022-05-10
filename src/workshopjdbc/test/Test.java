/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.test;

import java.sql.SQLException;
import workshopjdbc.entities.Utilisateur;
import workshopjdbc.services.ServiceUtilisateur;

/**
 *
 * @author pfeis
 */
public class Test {
    public static void main(String[] args)throws SQLException{
        ServiceUtilisateur s1 = new ServiceUtilisateur();
        Utilisateur u1 = new Utilisateur();
        String mail="admin@admin.tn";
        u1=s1.getByEmail(mail);
        System.out.println(u1);
        
        
    }
    
}
