/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.services;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import workshopjdbc.entities.SDF;
import java.sql.Connection;
import workshopjdbc.utils.MyConnection;

/**
 *
 * @author hp
 */
public class ServiceSDF implements IServicee<SDF> {
    private MyConnection ds = MyConnection.getInstance();
     private Connection conn;

    public void ajouter(SDF p)throws SQLException {
        
        String req = "INSERT INTO `sdf` (`name`, `lastname`, `gender`, `age`) VALUES ('"+p.getName()+"', '"+p.getLast_name()+"', '"+p.getGender()+"', '"+p.getAge()+"')";
            Statement st = ds.getCnx().createStatement();
        st.executeUpdate(req);
        
    }
    
    public void ajouter2(SDF p)throws SQLException {
        
           String req = "INSERT INTO `sdf` (`name`, `lastname`, `gender`, `age`) VALUES (?,?)";
        PreparedStatement st = ds.getCnx().prepareStatement(req);
        st.setString(1, p.getName());
        st.setString(2, p.getLast_name());
        st.setString(3, p.getGender());
        st.setInt(4, p.getAge());

            st.executeUpdate();

       
    }

    public int supprimer(int id)throws SQLException {
        
            String req = "DELETE FROM `sdf` WHERE id = " + id;
             Statement st = ds.getCnx().createStatement();
        st.executeUpdate(req);
        return 1;
    }

    public void modifier(SDF p)throws SQLException{
      
         
        String req = "UPDATE `sdf` SET `name` = '"+p.getName()+"', `lastname` = '"+p.getLast_name()+"', `gender` = '"+p.getGender()+"', `age` = '"+p.getAge()+"' WHERE `sdf`.`id` = "+p.getId();
            Statement st = ds.getCnx().createStatement();
        st.executeUpdate(req);
        
        
    }

    
    public List<SDF> getAll() throws SQLException{
        List<SDF> list = new ArrayList<>();
     
            String req = "Select * from sdf";
            Statement st = ds.getCnx().createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                SDF p = new SDF(rs.getString("name"),rs.getString("lastname"),rs.getString("gender"),rs.getInt("age"));
                list.add(p);
            }
        
        

        return list;
    }
           public int getNbfemale() throws Exception{
        String sql="SELECT COUNT(*) FROM sdf where gender='female'";
        ResultSet rs;
        int countIdRec=0;
        try {
            PreparedStatement st= conn.prepareStatement(sql);
			ResultSet res= st.executeQuery(); 
                        while(res.next()) {
                           countIdRec= res.getInt(1);
                        }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return countIdRec;
    }
            public int getNbmale() {
        String sql="SELECT COUNT(*) FROM sdf where gender='male'";
        ResultSet rs;
        int countIdRec=0;
        try {
            PreparedStatement st= conn.prepareStatement(sql);
			ResultSet res= st.executeQuery(); 
                        while(res.next()) {
                           countIdRec= res.getInt(1);
                        }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return countIdRec;
    }
}
