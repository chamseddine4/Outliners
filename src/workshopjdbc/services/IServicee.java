/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.services;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author hp
 * @param <S>
 */
public interface IServicee<S> {
    public void ajouter(S p)throws SQLException;
    public int supprimer(int id)throws SQLException;
    public void modifier(S p)throws SQLException;
    public List<S> getAll()throws SQLException;

}
